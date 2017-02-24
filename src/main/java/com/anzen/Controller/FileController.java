package com.anzen.Controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xmlpull.v1.XmlPullParserException;

import com.anzen.bean.MainBean;
import com.anzen.configuration.AppConfig;
import com.anzen.interfaces.IOperaciones;

@RestController
public class FileController {
	ApplicationContext appContext=null;
	MainBean beanLogin=null; 
	IOperaciones beanLoginI=null; 
	   
  
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST, value = "/insertFile")
    public  JSONObject insertPersona(@RequestBody JSONObject  json ) {
		 	
			System.out.println("json  "+json);
			appContext=new AnnotationConfigApplicationContext(AppConfig.class);
			JSONObject jsonObject=null;
			 
			beanLogin=(MainBean) appContext.getBean("coreConfig");
			
			beanLoginI=(IOperaciones) appContext.getBean("coreConfigInterface");
			try { 
				
				beanLogin.setResult(beanLoginI.insertFile(json.get("nodo").toString(),json.get("ruta").toString(),json.get("archivo").toString()));
				
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","200");
				jsonObject.put("Descripcion",beanLogin.getResult()); 
				
				
			} catch (InvalidKeyException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","09");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","10");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			} catch (IOException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","11");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","12");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			}catch (Exception e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","13");
				jsonObject.put("Descripcion","JSON Incorrecto"); 
			}
			   
			/**
			 * Cerramos el ApplicationContext
			 */
			
			((ConfigurableApplicationContext) appContext).close();
			
			
        return jsonObject;
    }
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST, value = "generaURL")
    public  JSONObject serviciogeneraURL(@RequestBody JSONObject  json ) {
		 
			appContext=new AnnotationConfigApplicationContext(AppConfig.class);
			JSONObject jsonObject=null;
			 
			beanLogin=(MainBean) appContext.getBean("coreConfig");
			
			beanLoginI=(IOperaciones) appContext.getBean("coreConfigInterface");
			try { 
				
				beanLogin.setResult(beanLoginI.generaURL(
						json.get("nodo").toString(),json.get("archivo").toString()));
				
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","200");
				jsonObject.put("Descripcion",beanLogin.getResult()); 
				
				
			} catch (InvalidKeyException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","09");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","10");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			} catch (IOException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","11");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","12");
				jsonObject.put("Descripcion",e.getMessage()); 
				e.printStackTrace();
			}catch (Exception e) {
				jsonObject=new JSONObject(); 
				jsonObject.put("codigo","13");
				jsonObject.put("Descripcion","JSON Incorrecto"); 
			}
			   
			/**
			 * Cerramos el ApplicationContext
			 */
			
			((ConfigurableApplicationContext) appContext).close();
			
			
        return jsonObject;
    }

}
