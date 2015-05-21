package Junit.test;

import org.junit.Test;

import cn.itcast.dao.UpfileDao;
import cn.itcast.dao.impl.UpfileDaoImpl;

public class TestDao {

	@Test
	public void testGetAll() {
		UpfileDao dao = new UpfileDaoImpl();
		dao.getAll();
	}
	

	@Test
	public void testArrayHandler() {
		UpfileDao dao = new UpfileDaoImpl();
		System.out.println(dao.returnAll());
	}
	
}
