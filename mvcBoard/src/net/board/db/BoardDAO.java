package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자 DB연결
	
	public ArrayList<BoardBean> boardList() {
		String sql = "select * from mvcboard";
		ArrayList<BoardBean> list = new ArrayList<BoardBean>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setBno(rs.getInt("bno"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setWriter(rs.getString("subject"));
				bean.setWritedate(rs.getString("writedate"));
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
	
	
}
