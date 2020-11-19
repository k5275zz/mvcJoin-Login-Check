package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		System.out.println("RequestURI: " + RequestURI);
		System.out.println("contextPath: " + contextPath);
		System.out.println("command: " + command);

		ActionForward forward = null;
		Action action = null;

		if (command.equals("/LoginCheckAction.bo")) {
			action = new LoginCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // LoginCheckAction.bo end
		else if(command.equals("/JoinAction.bo")) {
			action = new JoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// JoinAction 끝
		else if(command.equals("/BoardListAction.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// BoardListAction 끝

		if (forward != null) {
			if (forward.isRedirect()) {
				// 1. redirect : 새로운 페이지에서는 request, response객체가 새롭게 생성된다. - 로그인,회원가입,글쓰기
				response.sendRedirect(forward.getPath());
			} else {
				// 2. dispatcher(forward) : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request, response
				// 객체를 공유. 리스트보기, 검색
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
