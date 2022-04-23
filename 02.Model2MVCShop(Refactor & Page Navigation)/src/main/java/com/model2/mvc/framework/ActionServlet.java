package com.model2.mvc.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.util.HttpUtil;


public class ActionServlet extends HttpServlet {
	
	///Field
	private RequestMapping requestMapping;
	
	///Method
	@Override
	public void init() throws ServletException {
		super.init();
		String resources=getServletConfig().getInitParameter("resources");
		requestMapping=RequestMapping.getInstance(resources);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
																						throws ServletException, IOException {
		
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String reqeustPath = url.substring(contextPath.length()); // /xx.do
		System.out.println("\nActionServlet.service() RequestURI : "+reqeustPath); 
		
		try{
			Action action = requestMapping.getAction(reqeustPath);
			action.setServletContext(getServletContext()); // xxxAction 매핑, action = xxxAction 클래스
			
			String resultPage=action.execute(request, response); // 화면 전환 ex)loginAction에서 id, pwd값 vo에 세팅후, "redirect:/index.jsp"
			String path=resultPage.substring(resultPage.indexOf(":")+1); // "/index.jsp"
			System.out.println("JSP path : " +path);
			
			
			if(resultPage.startsWith("forward:")){
				HttpUtil.forward(request, response, path); // getRequsetDispatcher에 필요한 result(path)
			}else{
				HttpUtil.redirect(response, path);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}