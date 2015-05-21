package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Upfile;

public interface UpfileDao {

	/**
	 * id varchar(40) primary key, uuidname varchar(100) not null unique,
	 * filename varchar(100) not null, savepath varchar(255) not null, uptime
	 * datetime not null, description varchar(255), username varchar(40) not
	 * null
	 * 
	 * @param file
	 */

	void add(Upfile file);

	void delete(String id);

	List<Upfile> getAll();

	Upfile find(String id);

	void update(Upfile file);

	public long returnAll();
}