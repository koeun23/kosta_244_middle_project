package hye.myPage.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hye.myPage.dto.MyPageTempDTO;
import hye.myPage.dto.ResultDTO;
import hye.myPage.repository.MyPagePostRepository;
/**
 * Servlet implementation class MyPageWebServlet
 */

//내가 정의한 URL을 입력하면
//request.getRequestDispatcher 여기에 정의한 html로 이동시켜준다.
@WebServlet("/myPageTempSelectList")
public class MyPageTempSelectListWebServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public MyPageTempSelectListWebServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//		
//	}

	

	/**
	 * 나의 임시글 목록을 조회한다.
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ajax를 doPost로 호출한다. ");

		//ResultDTO란???? ajax 응답결과를 공통 보여주게 한다.
		ResultDTO<List<MyPageTempDTO>> resp = new ResultDTO<>();
		
		MyPagePostRepository repository =new MyPagePostRepository();

		try {
			//임시저장글 목록을 조회한다.
			List<MyPageTempDTO> list = repository.tempProjectList();
			// 에러가 발생시 처리한다. 응답 response에 오류를 알린다.
			resp.setResponse(list);
		} catch (Exception e) {
			resp.setMessage(e.toString());
			resp.setCheck(false);
		}
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //Gson 라이브러리로 json을 리턴한다.
        new Gson().toJson(resp, response.getWriter());
        
	}

}