package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;


public class GetProductAction extends Action {
	public String execute(	HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// prodName이 널이면 getParameter("prodName")해야함
		String prodName=request.getParameter("prodName");
		
		if("".equals(prodName) || prodName==null) { // null은 equals메서드 호출 불가 !!!
			int prodNo=Integer.parseInt(request.getParameter("prodNo"));
			System.out.println(prodNo);
			ProductService service=new ProductServiceImpl();
			Product vo=service.getProduct(prodNo);
			System.out.println(vo);
			request.setAttribute("vo", vo);
		}else{
			System.out.println(prodName);
			ProductService service=new ProductServiceImpl();
			Product vo=service.getProduct(prodName);
			System.out.println(vo); //널값나옴 ...
			request.setAttribute("vo", vo);
		}
		
		return "forward:/product/getProduct.jsp";
}
}
