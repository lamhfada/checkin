package fgo.ssr.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fgo.ssr.model.DateDAO;
import fgo.ssr.model.oneDay;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
/**
 * Servlet implementation class setDate
 */
@WebServlet(name = "sDate",urlPatterns = {"/theRollcall/sDate"})
public class setDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
    	
    	
    	RequestDispatcher view = null;
    	String name = request.getParameter("name").trim(); 
    	String checkdate = request.getParameter("checkdate");    
    	String checkin = request.getParameter("checkin");
    	Date today = new Date();    	
    	//確認欄位是否為空 是則跳回頁面並顯示通知
    	if (name.isEmpty()) {
    		request.setAttribute("errorMsgs", new String("請填上姓名"));
    		view = request.getRequestDispatcher("checkIn.jsp");
    		view.forward(request, response);
    	}
    	
		    			    	
		    	oneDay OD = new oneDay();
		    	OD.setName(name);
		    	OD.setDate(today);
		    	DateDAO dDAO = new DateDAO();    	
		    	
		    	if (!dDAO.Exist(name)) {
		    		request.setAttribute("errorMsgs", new String(name+"不在簽到名單上"));
		    		view = request.getRequestDispatcher("checkIn.jsp");
		    		view.forward(request, response);
		    	}else if(checkin != null){			    	
			    	try {
				    		dDAO.dateCheckIn(OD);
				    		view = request.getRequestDispatcher("checkIn.jsp");
				    		view.forward(request, response);
				    	}catch(Exception e) {
				    	    request.setAttribute("errorss", e.toString());
				    		request.setAttribute("Already", new String(name+"已簽到"));
				    		view = request.getRequestDispatcher("checkIn.jsp");
				    		view.forward(request, response);
				    	}
		    	}else	if(checkdate != null) {
			    		try {
			    			request.setAttribute("Allday", dDAO.getAllday(name));
			    			request.setAttribute("CKD", new Boolean(true));
			    			view = request.getRequestDispatcher("checkIn.jsp");
				    		view.forward(request, response);
			    		}catch(Exception e) {
			    			request.setAttribute("errorss", e.toString());
			    			view = request.getRequestDispatcher("checkIn.jsp");
				    		view.forward(request, response);
			    		}
		    		}
	    	}	    	
	  
    	
    
    	
    	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.requestProcess(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.requestProcess(request, response);
	}

}
