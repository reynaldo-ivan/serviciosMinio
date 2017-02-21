package com.anzen.implem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.xmlpull.v1.XmlPullParserException;

import com.anzen.bean.File;
import com.anzen.bean.MainBean;
import com.anzen.configuration.AppConfig;
import com.anzen.interfaces.IOperaciones;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class Operaciones implements IOperaciones{
	
	  ApplicationContext appContext=null;
	  MainBean coreBean=null;

	public String insertFile(String bucketName, String route, String nameFile ) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException{
		String request="";
		appContext=new AnnotationConfigApplicationContext(AppConfig.class);   
		coreBean=(MainBean) appContext.getBean("coreConfig");
		
		Properties propiedades = new Properties();
	    InputStream entrada = null;
	    
	    entrada = new FileInputStream("src/main/resources/configuracion.properties");
	    propiedades.load(entrada); 
		 
		
		coreBean.setFile(new File(route, nameFile, bucketName));
		 System.out.println("la propiedad e url  "+propiedades.getProperty("anzen.crecencials.url"));
		try {
		      MinioClient minioClient = new MinioClient(propiedades.getProperty("anzen.crecencials.url"),propiedades.getProperty("anzen.crecencials.accessKey"),propiedades.getProperty("anzen.crecencials.secretKey"));
		      // Valida si existe el nodo
		      boolean isExist = minioClient.bucketExists(coreBean.getFile().getBucketName());
		      if(isExist) {
		        System.out.println("Bucket already exists.");
		        minioClient.setTimeout(TimeUnit.SECONDS.toMillis(10), TimeUnit.SECONDS.toMillis(10),
			              TimeUnit.SECONDS.toMillis(30));
			      
			      minioClient.putObject(coreBean.getFile().getBucketName(),
			    		  coreBean.getFile().getNameFile(), coreBean.getFile().getRoute());
			      request="El archivo "+coreBean.getFile().getNameFile()+" fue almacenado en "+coreBean.getFile().getBucketName();
		      } else {  
		    	  request="El nodo "+coreBean.getFile().getBucketName() +" no existe";
		      }
		 
		      
		      
		      
		    } catch(MinioException e) {
		    	request="Error occurred: " + e;
		    }
		return request;
	}
	
	
	
	
	
	public String generaURL(String nameFile, String bucketName ) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException{
		String request="";
		appContext=new AnnotationConfigApplicationContext(AppConfig.class);   
		coreBean=(MainBean) appContext.getBean("coreConfig");
		
		Properties propiedades = new Properties();
	    InputStream entrada = null;
	    
	    entrada = new FileInputStream("src/main/resources/configuracion.properties");
	    propiedades.load(entrada); 
		  
		coreBean.setFile(new File(bucketName,nameFile)); 
		try {
		      MinioClient minioClient = new MinioClient(propiedades.getProperty("anzen.crecencials.url"),propiedades.getProperty("anzen.crecencials.accessKey"),propiedades.getProperty("anzen.crecencials.secretKey"));
		      coreBean.setUrl(minioClient.presignedGetObject(coreBean.getFile().getBucketName(),
		    		  coreBean.getFile().getNameFile(), 60 * 60 * 24));
		    
		      
		    } catch(MinioException e) {
		    	request="Error occurred: " + e;
		    }
		return coreBean.getUrl();
	}
	 
}
