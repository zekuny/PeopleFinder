import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class DBOperation {
	public static ResultSet getPeopleByLastName(String lastname, Connection conn) throws SQLException{
		String sql = "select * from customerspractice where lastname like '%" + lastname + "%'";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
	
	public static ResultSet getPeopleByCompanyName(String company, Connection conn) throws SQLException{
		String sql = "select * from customerspractice where company like '%" + company + "%'";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
	
	public static ResultSet getPeopleByCustomerID(String CustomerID, Connection conn) throws SQLException{
		String sql = "select cp.fullname, cp.title, cp.firstname, cp.lastname, cp.streetaddress, ci.cityname, s.statename, cp.zipcode, cp.emailaddress, cp.position, cp.company"
				+	" from customerspractice cp, cities ci, states s"
				+	" where cp.cityid = ci.cityid and cp.stateid = s.stateid and customerid = " + CustomerID;
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet result = preStatement.executeQuery();
		return result;
	}
}
