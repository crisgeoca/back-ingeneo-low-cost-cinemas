package com.ingeneo.cinemas.utilities;

import com.google.gson.Gson;

public class ObjectParserUtil {
	
	public static <T> T parseObject(Object object, Class<T> classOfT){	
		return new Gson().fromJson(new Gson().toJson(object), classOfT);
	}
}
