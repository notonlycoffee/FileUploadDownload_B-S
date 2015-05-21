package cn.itcast.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Upfile;
import cn.itcast.factory.ServiceFactory;
import cn.itcast.service.BusinessService;

public class DownLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		BusinessService service = ServiceFactory.getInstance(BusinessService.class);
		
		Upfile upfile = service.find(id);
		
		File file = new File(upfile.getSavepath()+File.separator +upfile.getUuidname());
		if(!file.exists()) {
			request.setAttribute("message", "您要下载的文件不存在");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		 
		
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(upfile.getFilename(), "UTF-8"));
		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		
		int len=0;
		byte [] buffer = new byte[1024];
		
		while( (len=in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
