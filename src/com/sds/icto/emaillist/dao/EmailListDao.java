package com.sds.icto.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.emaillist.vo.EmailListVo;

public class EmailListDao {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		return conn;
	}
	
	public void delete(Long id) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		
		String sql =  "delete from email_list where no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		stmt.executeUpdate();
		
		if (stmt != null)stmt.close(); 
		if (conn != null)conn.close(); 
	}
	
	public void delete() throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		
		String sql =  "delete from email_list";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.executeUpdate();
		
		if (stmt != null)stmt.close(); 
		if (conn != null)conn.close(); 
	}
	
	public void insert(EmailListVo vo) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		
		String sql =  " insert into email_list values(email_list_no_seq.nextval, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, vo.getFirstName());
		stmt.setString(2, vo.getLastName());
		stmt.setString(3, vo.getEmail());
		stmt.executeUpdate();
					
		if (stmt != null)stmt.close(); 
		if (conn != null)conn.close(); 
	}
	
	public List<EmailListVo> fetchList() throws ClassNotFoundException, SQLException{
		List<EmailListVo> list = new ArrayList<EmailListVo>();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql =  "select * from email_list order by no desc";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			long no = rs.getLong(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			list.add(vo);
		}
		if (rs != null)rs.close();
		if (stmt != null)stmt.close(); 
		if (conn != null)conn.close(); 
		return list;
	}

}
