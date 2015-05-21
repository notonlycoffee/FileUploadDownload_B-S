package cn.itcast.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.domain.Upfile;

public class WebUtils {

	public static Upfile upload(HttpServletRequest request, String uppath)
			throws FileSizeLimitExceededException {

		Upfile bean = new Upfile();
		
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/temp")));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			upload.setFileSizeMax(1024 * 1024 * 500);
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list ) {
				if( item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(bean, name, value);
				} else {
					String filename = item.getName().substring(item.getName().lastIndexOf("\\")+1);
					
					String uuidname = generateFileName(filename);
					
					String savepath = generateSavePath(uuidname,uppath);
					
					InputStream in = item.getInputStream();
					int len = 0;
					byte buffer [] = new byte[1024];
					
					FileOutputStream out = new FileOutputStream(new File(savepath+ File.separator + uuidname));
					
					while((len=in.read(buffer))>0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					
					bean.setFilename(filename);
					bean.setId(UUID.randomUUID().toString());
					bean.setSavepath(savepath);
					bean.setUptime(new Date());
					bean.setUuidname(uuidname);
				}
			}
			
			return bean;
			
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static String generateSavePath(String filename, String uppath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf;
		int dir2 = (hashcode>>4)&0xf;
		
		String savepath = uppath + File.separator + dir1 + File.separator + dir2;
		
		File file = new File(savepath);//asdfhpqwehqpeoihefh
		if(!file.exists()) {
			file.mkdirs();
		}
		return savepath;
		
	}

	public static String generateFileName(String filename) {
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		return UUID.randomUUID().toString() + "." + ext;
	}

}
