package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Upfile;
import cn.itcast.factory.ServiceFactory;
import cn.itcast.service.BusinessService;
import cn.itcast.utils.WebUtils;

public class ChagenFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		BusinessService service = ServiceFactory.getInstance(BusinessService.class);
		
		Upfile upfile = service.find(id);
		
		request.setAttribute("upfile", upfile);
		request.getRequestDispatcher("/WEB-INF/pages/changefile.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		BusinessService service = ServiceFactory.getInstance(BusinessService.class);
		Upfile upfile = service.find(id);
		
		String username = request.getParameter("username");
		String filename = request.getParameter("filename");
		String description = request.getParameter("description");
		
		upfile.setUsername(username);
		upfile.setFilename(filename);
		upfile.setDescription(description);
		upfile.setUuidname(WebUtils.generateFileName(filename));
		
		service.updateFile(upfile);
		
		request.setAttribute("message", "ÐÞ¸Ä³É¹¦");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

}
