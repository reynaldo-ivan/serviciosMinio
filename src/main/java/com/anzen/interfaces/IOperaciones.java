package com.anzen.interfaces;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.xmlpull.v1.XmlPullParserException;
 

public interface IOperaciones {
	
	 
	public String insertFile(String bucketName, String route, String nameFile) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException;

	public String generaURL(String bucketName, String nameFile ) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException;
}
