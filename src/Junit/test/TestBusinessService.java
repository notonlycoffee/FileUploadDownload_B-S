package Junit.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BesinessServiceImpl;

public class TestBusinessService {

	
	@Test
	public void testGetFileType() {
		
		BusinessService service = new BesinessServiceImpl();
		
		service.getFileType();
		
	}
	
	
	@Test
	public void testMapPut() {
		Map map = new HashMap();
		map.put("1", 1);
		map.put("1", 123);
		System.out.println(map.get("1"));
		
	}
}
