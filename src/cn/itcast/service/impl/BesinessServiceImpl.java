package cn.itcast.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.dao.UpfileDao;
import cn.itcast.domain.Upfile;
import cn.itcast.factory.DaoFactory;
import cn.itcast.service.BusinessService;

public class BesinessServiceImpl implements BusinessService {

	private UpfileDao dao = DaoFactory.getInstanse(UpfileDao.class);

	public void addFile(Upfile file) {
		dao.add(file);
	}

	public void delete(String id) {
		dao.delete(id);
	}

	public List<Upfile> getAll() {
		return dao.getAll();

	}

	public Upfile find(String id) {
		return dao.find(id);
	}

	public void updateFile(Upfile file) {
		dao.update(file);
	}

	public Map getFileType() {
		List<Upfile> upfileList = dao.getAll();
		Map map = new LinkedHashMap();
		for (Upfile file : upfileList) {
			String filetype = file.getFilename().substring(file.getFilename().lastIndexOf("."));

			if (map.containsKey(filetype)) {
				int num = Integer.parseInt((String) (map.get(filetype)));
				num++;
				map.put(filetype, String.valueOf(num));
			} else {
				map.put(filetype, "1");
			}
		}
		
		long num = dao.returnAll();
		map.put("×Ü¼Æ", num);
		
		return map;
	}
}
