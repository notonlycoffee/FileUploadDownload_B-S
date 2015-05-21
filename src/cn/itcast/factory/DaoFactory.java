package cn.itcast.factory;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static Properties daoconfig = new Properties();

	private static final DaoFactory instance = new DaoFactory();

	private DaoFactory() {
		try {
			daoconfig.load(DaoFactory.class.getClassLoader()
					.getResourceAsStream("factory.properties"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	};

	public static <T> T getInstanse(Class<T> interfaceclass) {
		try {
			String name = interfaceclass.getSimpleName();
			String className = daoconfig.getProperty(name);
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
