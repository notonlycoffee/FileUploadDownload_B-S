package cn.itcast.web.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.factory.ServiceFactory;
import cn.itcast.service.BusinessService;

public class AllFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BusinessService service = ServiceFactory.getInstance(BusinessService.class);
		
		Map map = new LinkedHashMap();
		map = service.getFileType();
		
		request.setAttribute("type", map);
		request.getRequestDispatcher("/WEB-INF/pages/allfile.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
