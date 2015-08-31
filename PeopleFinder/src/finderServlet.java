import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.CustomerDB;
import model.Customerspractice;

/**
 * Servlet implementation class finderServlet
 */
@WebServlet("/finderServlet")
public class finderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String table;
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public finderServlet() {
        super();
        table = "";
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		if(request.getParameter("lastname") != null && !request.getParameter("lastname").isEmpty()){			
			String lastname = request.getParameter("lastname");
			ArrayList<Customerspractice> lists = new ArrayList<Customerspractice>(CustomerDB.getPeopleByLastName(lastname));
			
			table = "";
			table += "<div class=\"container\">" + "<h2>Result</h2>" + "<table class=\"table table-condensed\">"
				    + "<thead>" + "<tr>" + "<th>ID</th>" + "<th>First Name</th>" + "<th>Last Name</th>" + "<th>Email Address</th>" + "</tr>"
				    +   "</thead>" + "<tbody>";	    
					for(Customerspractice c : lists){
						table += "<tr>";
						table += "<td><a href = \"detailsServlet?CustomerID=" + c.getCustomerid() + "\">" + c.getCustomerid() + "</a></td>";
						table += "<td>" + c.getFirstname() + "</td>";
						table += "<td>" + c.getLastname() + "</td>";
						table += "<td>" + c.getEmailaddress() + "</td>";
						table += "</tr>";
					}
				table += "</tbody>" + "</table>" + "</div>";
				table += "<br/><br/>";		
		}else if(request.getParameter("companyname") != null && !request.getParameter("companyname").isEmpty()){			
			String companyname = request.getParameter("companyname");
			ArrayList<Customerspractice> lists = new ArrayList<Customerspractice>(CustomerDB.getPeopleByLastName(companyname));		
			
			table = "";
			table += "<div class=\"container\">" + "<h2>Result</h2>" + "<table class=\"table table-condensed\">"
				    + "<thead>" + "<tr>" + "<th>ID</th>" + "<th>First Name</th>" + "<th>Last Name</th>" + "<th>Email Address</th>" + "</tr>"
				    +   "</thead>" + "<tbody>";	    
				for(Customerspractice c : lists){
					table += "<tr>";
					table += "<td><a href = \"detailsServlet?CustomerID=" + c.getCustomerid() + "\">" + c.getCustomerid() + "</a></td>";
					table += "<td>" + c.getFirstname() + "</td>";
					table += "<td>" + c.getLastname() + "</td>";
					table += "<td>" + c.getEmailaddress() + "</td>";
					table += "</tr>";
					}
				table += "</tbody>" + "</table>" + "</div>";
				table += "<br/><br/>";		
		}
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
