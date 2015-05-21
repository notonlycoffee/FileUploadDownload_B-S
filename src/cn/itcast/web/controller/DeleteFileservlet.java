package cn.itcast.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Upfile;
import cn.itcast.factory.ServiceFactory;
import cn.itcast.service.BusinessService;
import cn.itcast.utils.JdbcUtil;

public class DeleteFileservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			JdbcUtil.startTransaction();
			BusinessService service = ServiceFactory.getInstance(BusinessService.class);
			Upfile upfile = service.find(id);
			if (upfile == null) {
				request.setAttribute("message", "您要删除的文件已经不存在了");
				request.getRequestDispatcher("/message.jsp").forward(request,response);
				return;
			}

			service.delete(id);

			String savepath = upfile.getSavepath();
			String uuidname = upfile.getUuidname();

			File file = new File(savepath + File.separator + uuidname);

			if (!file.exists()) {
				return;
			}
			file.delete();
			request.setAttribute("message", "文件删除成功");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
			JdbcUtil.commitTransaction();
			JdbcUtil.closeConnection();
		} catch (Exception e) {
			request.setAttribute("message", "删除操作失败了");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
