package com.mobile.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.MobileDao;
import com.mobile.dao.impl.MobileDaoImpl;
import com.mobile.domain.Mobile;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MobileDaoImpl mobileDao;
	
	public HomeController() {
		this.mobileDao=new MobileDaoImpl();
		// Do Nothing
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getServletPath();
		
		

		switch(action) {
		case "/new":
			ShowForm(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		case "/edit":
			editUser(request, response);
			break;
		case "/update":
			updatUser(request, response);
			break;
		default: 
			listUser(request, response);
			break;
		}
		
		
	}
	
	private void ShowForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		RequestDispatcher requestDis=request.getRequestDispatcher("home.jsp");
		requestDis.forward(request, response);
		
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int mobile_id =  Integer.parseInt(request.getParameter("mobile_id"));
		mobileDao.deleteMobile(mobile_id);
		response.sendRedirect("list");
	}
	

	private void editUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int mobile_id =  Integer.parseInt(request.getParameter("mobile_id"));
		Mobile mobileExist = mobileDao.findMobileById(mobile_id) ;
		RequestDispatcher requestDis=request.getRequestDispatcher("home.jsp");
		request.setAttribute("mobile", mobileExist);
		requestDis.forward(request, response);
	}
	
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		
		String reference = request.getParameter("reference");
		String brand = request.getParameter("brand");
		Float price = Float.parseFloat(request.getParameter("price"));
		Mobile mobile=new Mobile( reference, brand, price);
		mobileDao.addMobile(mobile);
		response.sendRedirect("list");
		
	}

	private void updatUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int mobile_id = Integer.parseInt(request.getParameter("mobile_id"));
		String reference = request.getParameter("reference");
		String brand = request.getParameter("brand");
		Float price = Float.parseFloat(request.getParameter("price"));
		Mobile mobile=new Mobile( reference, brand, price);
		mobileDao.updateMobile(mobile);
		response.sendRedirect("list");
		
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		List<Mobile> listMobile=mobileDao.findAllMobiles();
		request.setAttribute("listMobile", listMobile);
		
		RequestDispatcher requestDis=request.getRequestDispatcher("listMobile.jsp");
		
		requestDis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
