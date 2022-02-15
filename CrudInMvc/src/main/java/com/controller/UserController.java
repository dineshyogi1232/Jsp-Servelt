package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.UserService;
import com.dao.UserServiceImpl;
import com.model.User;

/**
 *	Servlet implementation class UserController
 */

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *	@see	HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
	}

	/**
	 *	@see	HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *			response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 *	@see	HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *			response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		String action = request.getParameter("action");
		user.setFirstName(request.getParameter("firstname").trim());
		user.setEmail(request.getParameter("email").trim());
		user.setLastName(request.getParameter("lastname").trim());
		user.setPassword(request.getParameter("password").trim());
		UserService dbTransaction = new UserServiceImpl();

		if (action.equalsIgnoreCase("signup")) {
			int flag = dbTransaction.insertUserData(user);
			HttpSession session = request.getSession();
			if (flag == 1) {
				session.setAttribute("currentUser", user);
				response.sendRedirect("show.jsp");
			} else {
				response.sendRedirect("signup.jsp");
			}
		}
	}

}