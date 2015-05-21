package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.UpfileDao;
import cn.itcast.domain.Upfile;
import cn.itcast.utils.JdbcUtil;

public class UpfileDaoImpl implements UpfileDao {

	/**
	 * id varchar(40) primary key, uuidname varchar(100) not null unique,
	 * filename varchar(100) not null, savepath varchar(255) not null, uptime
	 * datetime not null, description varchar(255), username varchar(40) not
	 * null
	 * 
	 * @param file
	 */

	public void add(Upfile file) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "insert into upfile(id,uuidname,filename,savepath,uptime,description,username) values(?,?,?,?,?,?,?)";
			Object params[] = { file.getId(), file.getUuidname(),
					file.getFilename(), file.getSavepath(),file.getUptime(),
					file.getDescription(), file.getUsername() };
			runner.update(sql, params);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delete(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "delete from upfile where id=?";
			runner.update(JdbcUtil.getConnection(),sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Upfile> getAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "select * from upfile order by uptime desc";
			return (List<Upfile>) runner.query(sql, new BeanListHandler(Upfile.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Upfile find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "select * from upfile where id=?";
			return (Upfile) runner
					.query(sql, id, new BeanHandler(Upfile.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void update(Upfile file) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "update upfile set uuidname=?,filename=?,savepath=?,uptime=?,description=?,username=? where id=?";
			Object params[] = { file.getUuidname(), file.getFilename(),file.getSavepath(), file.getUptime(),file.getDescription(), file.getUsername(), file.getId() };
			runner.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public long returnAll() {
		
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select count(*) from upfile";
		try {
			Object [] result = (Object[]) runner.query(sql, new ArrayHandler());
			//int a = (Integer) result[0]; 数组是long类型的
			Long a = (Long) result[0];
			return a;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
