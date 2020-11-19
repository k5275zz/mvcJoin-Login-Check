package net.board.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public LoginDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자 DB연결
	
	public ArrayList<LoginBean> loginCheck() {
		String sql = "select * from user";
		ArrayList<LoginBean> list = new ArrayList<LoginBean>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LoginBean bean = new LoginBean();
				bean.setId(rs.getString("id"));
				bean.setPw(rs.getString("pw"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally { // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if (con != null) {
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(rs!=null){try{rs.close();}catch(Exception e){}}}
		}
		return list;
		
	}
	
	public void joinaction() {
		String sql="insert into user values(?,?,?)";
		// 빈정보 가지고 와서 sql문에 정보 넣기
		LoginBean bean = new LoginBean();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getEmail());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if (con != null) {
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(rs!=null){try{rs.close();}catch(Exception e){}}}
		}
	}
	
	
	
	
}
