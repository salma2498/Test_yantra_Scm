package com.scmflex.Genericutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	
	/**
	 * @author SALMA
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.Filepath);
		Properties plib=new Properties();
		plib.load(fis);
		String value=plib.getProperty(key);
		return value;
	}
	

}
