package cn.itcast.web.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Upfile;
import cn.itcast.factory.ServiceFactory;
import cn.itcast.service.BusinessService;

public class ListFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BusinessService service = ServiceFactory.getInstance(BusinessService.class);
		List<Upfile> list = service.getAll();

		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/pages/listfile.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
