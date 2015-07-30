package pt.belele.project.util;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

public class Database {
	private static Map<String, Object> db = new HashMap<String, Object>();

	public static Object getObject(String key, Class<?> objectClass) {
		if (!db.containsKey(key)) {
			db.put(key, HttpUtil.doGet(key, objectClass));
		}
		return db.get(key);
	}

	public static Object getObject(String key, Class<?> objectClass,
			MultivaluedMap<String, Object> queryParams) {
		String params = "?";
		for(String str : queryParams.keySet())
		{
			params+=str+"="+queryParams.get(str);
		}
		if (!db.containsKey(key+params)) {
			db.put(key+params, HttpUtil.doGet(key, objectClass, queryParams));
		}
		return db.get(key+params);
	}
}
