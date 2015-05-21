package cn.itcast.service;

import java.util.List;
import java.util.Map;

import cn.itcast.domain.Upfile;

public interface BusinessService {

	void addFile(Upfile file);

	void delete(String id);

	List<Upfile> getAll();

	Upfile find(String id);

	void updateFile(Upfile file);

	public Map getFileType();
}