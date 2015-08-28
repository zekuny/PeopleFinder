import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class finderServlet
 */
@WebServlet("/finderServlet")
public class finderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
	private String table;
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public finderServlet() {
        super();
        table = "";
        try {
			conn = DBConnection.connectDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			ResultSet result = null;
			try {
				result = DBOperation.getPeopleByLastName(lastname, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			table = "";
			table += "<div class=\"container\">" + "<h2>Result</h2>" + "<table class=\"table table-condensed\">"
				    + "<thead>" + "<tr>" + "<th>ID</th>" + "<th>First Name</th>" + "<th>Last Name</th>" + "<th>Email Address</th>" + "</tr>"
				    +   "</thead>" + "<tbody>";	    
		    	try {
					while(result.next()){
						table += "<tr>";
						table += "<td><a href = \"detailsServlet?CustomerID=" + result.getString("CustomerID") + "\">" + result.getString("CustomerID") + "</a></td>";
						table += "<td>" + result.getString("firstname") + "</td>";
						table += "<td>" + result.getString("lastname") + "</td>";
						table += "<td>" + result.getString("emailaddress") + "</td>";
						table += "</tr>";
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
				table += "</tbody>" + "</table>" + "</div>";
				table += "<br/><br/>";		
		}else if(request.getParameter("companyname") != null && !request.getParameter("companyname").isEmpty()){			
			String companyname = request.getParameter("companyname");
			ResultSet result = null;
			try {
				result = DBOperation.getPeopleByLastName(companyname, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
			
			table = "";
			table += "<div class=\"container\">" + "<h2>Result</h2>" + "<table class=\"table table-condensed\">"
				    + "<thead>" + "<tr>" + "<th>ID</th>" + "<th>First Name</th>" + "<th>Last Name</th>" + "<th>Email Address</th>" + "</tr>"
				    +   "</thead>" + "<tbody>";	    
		    	try {
					while(result.next()){
						table += "<tr>";
						table += "<td><a href = \"detailsServlet?CustomerID=" + result.getString("CustomerID") + "\">" + result.getString("CustomerID") + "</a></td>";
						table += "<td>" + result.getString("firstname") + "</td>";
						table += "<td>" + result.getString("lastname") + "</td>";
						table += "<td>" + result.getString("emailaddress") + "</td>";
						table += "</tr>";
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
