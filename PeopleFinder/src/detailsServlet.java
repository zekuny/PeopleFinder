// Import required java libraries
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Customerspractice;
import DB.CustomerDB;

// Extend HttpServlet class
@WebServlet("/detailsServlet")
public class detailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String table; 
	public void init() throws ServletException{
		// Do required initialization
		table = "";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		if(request.getParameter("CustomerID") != null && !request.getParameter("CustomerID").isEmpty()){	
			String CustomerID = request.getParameter("CustomerID");
			int cid = Integer.parseInt(CustomerID);
			Customerspractice c = CustomerDB.getPeopleByID(cid);
			table = "";
			table += "<h1>Customer ID: " + CustomerID + "</h1>";
			// here we go!
			table += "<br><br>";
			if(c != null){
				table += "<form class=\"form-horizontal\">" + 
			    "<div class=\"form-group\">" +
			        "<label class=\"col-xs-3 control-label\">Full Name</label>" +
			        "<div class=\"col-xs-8\">" +
			            "<label class=\"col-xs-8 control-label\">" + c.getFullname() + "</label>" + 
			        "</div>" + 
			    "</div>" + 

			    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">Title</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + c.getTitle()+ "</label>" + 
			        "</div>" + 
			    "</div>" + 

			    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">Street Address</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + c.getStreetaddress() + "</label>" + 
			        "</div>" + 
			    "</div>" + 

			    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">City Name</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + c.getCityBean().getCityname() + "</label>" + 
			        "</div>" + 
			    "</div>" + 

			    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">State Name</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + c.getStateBean().getStatename() + "</label>" + 
			        "</div>" + 
			    "</div>" + 
			        
			    "<div class=\"form-group\">" + 
		        "<label class=\"col-xs-3 control-label\">ZipCode</label>" + 
		        "<div class=\"col-xs-8\">" + 
		            "<label class=\"col-xs-8 control-label\">" + c.getZipcode() + "</label>" + 
		        "</div>" + 
		        "</div>" + 
		        
			    "<div class=\"form-group\">" + 
		        "<label class=\"col-xs-3 control-label\">Email Address</label>" + 
		        "<div class=\"col-xs-8\">" + 
		            "<label class=\"col-xs-8 control-label\">" + c.getEmailaddress() + "</label>" + 
		        "</div>" + 
		        "</div>" + 
		        
			    "<div class=\"form-group\">" + 
		        "<label class=\"col-xs-3 control-label\">Position</label>" + 
		        "<div class=\"col-xs-8\">" + 
		            "<label class=\"col-xs-8 control-label\">" + c.getPosition() + "</label>" + 
		        "</div>" + 
		        "</div>" + 
		        
			    "<div class=\"form-group\">" + 
		        "<label class=\"col-xs-3 control-label\">Company</label>" + 
		        "<div class=\"col-xs-8\">" + 
		            "<label class=\"col-xs-8 control-label\">" + c.getCompany() + "</label>" + 
		        "</div>" + 
		        "</div>" + 
		        "</form>";
			}
		}
		request.setAttribute("table", table);
		getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}