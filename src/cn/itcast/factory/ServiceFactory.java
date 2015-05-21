package cn.itcast.factory;

import java.util.Properties;

public class ServiceFactory {

	private static Properties serviceconfig = new Properties();

	private ServiceFactory() {
		try {
			serviceconfig.load(ServiceFactory.class.getClassLoader()
					.getResourceAsStream("factory.properties"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	};

	private static final ServiceFactory instance = new ServiceFactory();

	public static <T> T getInstance(Class interfaceclass) {
		String name = interfaceclass.getSimpleName();
		String className = serviceconfig.getProperty(name);
		
		
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
