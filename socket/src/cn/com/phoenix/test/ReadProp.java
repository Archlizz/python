package cn.com.phoenix.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadProp {

	/**
	 * instance
	 */
	private static ReadProp instance;

	/**
	 * cacheMap
	 */
	private Map<String, Map<String, String>> cacheMap;
	
	public ReadProp(){
		cacheMap = new HashMap<String, Map<String, String>>();
	}

	/**
	 * 获取配置参数
	 * 
	 * @param filePath
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getProperties(String filePath, String key, String defaultValue) {
		String value = getPropertiesValue(filePath, key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	private String getPropertiesValue(String filePath, String key) {
		Map<String, String> map = getPropertiesMap(filePath);
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return null;
		}
	}

	private Map<String, String> getPropertiesMap(String filePath) {
		File file = new File(filePath);
		String name = file.getAbsolutePath();
		Map<String, String> map = new HashMap<String, String>();
		InputStream in = null;
		if (cacheMap.containsKey(name)) {
			return cacheMap.get(name);
		} else {
			try {
				in = new BufferedInputStream(new FileInputStream(file));
				Properties proper = new Properties();
				proper.load(in);

				for (Object obj : proper.keySet()) {
					String key = obj.toString();
					map.put(key, proper.getProperty(key));
				}
			} catch (Exception e) {
				// do nothing
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (Exception e) {
						// do nothing
					}
				}

			}
			return map;
		}
	}

	/**
	 * get instance
	 * 
	 * @return
	 */
	public static ReadProp getInstance() {
		if (instance == null) {
			return new ReadProp();
		} else {
			return instance;
		}
	}

}
