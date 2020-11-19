package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.LoginBean;
import net.board.db.LoginDAO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginBean lbean = new LoginBean();
		LoginDAO ldao = new LoginDAO();
		ActionForward forward = new ActionForward();
		
		// 이전 페이지에서 정보를 가지고 와서 빈에 담아둔다.
		lbean.setId(request.getParameter("id"));
		lbean.setPw(request.getParameter("pw"));
		lbean.setEmail(request.getParameter("email"));
		// sql문 실행 lgoindao > sql문 작성
		ldao.joinaction();
		
		forward.setRedirect(true);
		forward.setPath("mvc_Login.jsp");
		
		return forward;
	}

}
