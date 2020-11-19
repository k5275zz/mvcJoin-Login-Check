package net.board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.LoginBean;
import net.board.db.LoginDAO;

public class LoginCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginDAO ldao = new LoginDAO();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		int logincheck= -2;
		HttpSession session = request.getSession();

		
		
		String id = request.getParameter("id"); // mvc_login페이지에서 입력된 id값
		String pw = request.getParameter("pw"); // mvc_login페이지에서 입력된 pw값
		
		ArrayList<LoginBean> list = ldao.loginCheck();
		request.setAttribute("loginlist", list);
		
		for(int i=0;i<list.size();i++) {
			LoginBean listbean = list.get(i);
			
			if(list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
				System.out.println("로그인 성공 !");
				logincheck = 1;
				session.setAttribute("userID", id);
				
			}else if(list.get(i).getId().equals(id)){
				System.out.println("비밀번호가 틀렸습니다.");
				logincheck = 0;
			}
			
			
		}
		//로그인 확인용 변수
		request.setAttribute("logincheck", logincheck);
		
		System.out.println(logincheck);
		forward.setRedirect(false);
		forward.setPath("mvc_index.jsp");
		
		return forward;
	}

}
