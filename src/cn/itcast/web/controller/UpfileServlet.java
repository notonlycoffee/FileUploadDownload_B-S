package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.domain.Upfile;
import cn.itcast.factory.ServiceFactory;
import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BesinessServiceImpl;
import cn.itcast.utils.WebUtils;

public class UpfileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/pages/addfile.jsp").forward(
				request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("message", "����ȷ�Ĳ���");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}

		try {
			String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
			Upfile upFile = WebUtils.upload(request, savepath);
			
			BusinessService service = ServiceFactory.getInstance(BusinessService.class);
			service.addFile(upFile);
			request.setAttribute("message", "�ϴ��ɹ�");

		} catch(FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("message", "�ļ���С���ܳ���500M");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "�ϴ�ʧ��");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
