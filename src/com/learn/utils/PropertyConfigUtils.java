package com.learn.utils;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class PropertyConfigUtils {
	public String getvalue(String file,String key){
		Properties prop = new Properties();
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			prop.load(in);
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				return prop.getProperty(key);
			}
			in.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
