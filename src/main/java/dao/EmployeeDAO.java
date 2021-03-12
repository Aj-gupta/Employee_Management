package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Login;

public class EmployeeDAO {
	
	public static Login checkLoginDetails(String email, String password) throws SQLException {
		String statement = "select * from login where email ='"+email+"'and password='"+password+"'";
		PreparedStatement stmt = DatabaseConnectionFactory.getConnectionFactory().getConnection().prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();
		if(!rs.next()) {
			return null;
		}
		else {
			Login user = new Login();
			user.setEmail(rs.getString(2));
			user.setType(rs.getString(4));
			return user;
		}
	}
}
