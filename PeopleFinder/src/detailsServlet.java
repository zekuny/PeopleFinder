// Import required java libraries
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Extend HttpServlet class
@WebServlet("/detailsServlet")
public class detailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String table;
	private static Connection conn = null;
	public void init() throws ServletException{
		// Do required initialization
		table = "";
		try {
			conn = DBConnection.connectDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		if(request.getParameter("CustomerID") != null && !request.getParameter("CustomerID").isEmpty()){	
			String CustomerID = request.getParameter("CustomerID");
			ResultSet result = null;
			try {
				result = DBOperation.getPeopleByCustomerID(CustomerID, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table = "";
			table += "<h1>Customer ID: " + CustomerID + "</h1>";
			// here we go!
			table += "<br><br>";
			try {
				if(result.next()){
					table += "<form class=\"form-horizontal\">" + 
				    "<div class=\"form-group\">" +
				        "<label class=\"col-xs-3 control-label\">Full Name</label>" +
				        "<div class=\"col-xs-8\">" +
				            "<label class=\"col-xs-8 control-label\">" + result.getString("fullname")+ "</label>" + 
				        "</div>" + 
				    "</div>" + 
	
				    "<div class=\"form-group\">" + 
				        "<label class=\"col-xs-3 control-label\">Title</label>" + 
				        "<div class=\"col-xs-8\">" + 
				            "<label class=\"col-xs-8 control-label\">" + result.getString("title")+ "</label>" + 
				        "</div>" + 
				    "</div>" + 
	
				    "<div class=\"form-group\">" + 
				        "<label class=\"col-xs-3 control-label\">Street Address</label>" + 
				        "<div class=\"col-xs-8\">" + 
				            "<label class=\"col-xs-8 control-label\">" + result.getString("streetaddress")+ "</label>" + 
				        "</div>" + 
				    "</div>" + 
	
				    "<div class=\"form-group\">" + 
				        "<label class=\"col-xs-3 control-label\">City Name</label>" + 
				        "<div class=\"col-xs-8\">" + 
				            "<label class=\"col-xs-8 control-label\">" + result.getString("cityname")+ "</label>" + 
				        "</div>" + 
				    "</div>" + 
	
				    "<div class=\"form-group\">" + 
				        "<label class=\"col-xs-3 control-label\">State Name</label>" + 
				        "<div class=\"col-xs-8\">" + 
				            "<label class=\"col-xs-8 control-label\">" + result.getString("statename")+ "</label>" + 
				        "</div>" + 
				    "</div>" + 
				        
				    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">ZipCode</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + result.getString("zipcode")+ "</label>" + 
			        "</div>" + 
			        "</div>" + 
			        
				    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">Email Address</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + result.getString("emailaddress")+ "</label>" + 
			        "</div>" + 
			        "</div>" + 
			        
				    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">Position</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + result.getString("position")+ "</label>" + 
			        "</div>" + 
			        "</div>" + 
			        
				    "<div class=\"form-group\">" + 
			        "<label class=\"col-xs-3 control-label\">Company</label>" + 
			        "<div class=\"col-xs-8\">" + 
			            "<label class=\"col-xs-8 control-label\">" + result.getString("company")+ "</label>" + 
			        "</div>" + 
			        "</div>" + 
			        "</form>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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