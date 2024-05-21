package com.comcast.com.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDatafromProperties(String key) throws IOException {
		FileInputStream fis= new FileInputStream("./ConfigAppData/CommonData (2).properties");
		Properties prob= new Properties();
		prob.load(fis);
		String data= prob.getProperty(key);
		return data;
	}

}
