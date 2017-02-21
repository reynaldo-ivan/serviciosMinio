package com.anzen.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anzen.bean.MainBean;
import com.anzen.implem.Operaciones;
import com.anzen.interfaces.IOperaciones;
 

@Configuration
public class AppConfig {
	
	
	@Bean(name="coreConfig")
	public MainBean coreConfig(){
		return new MainBean();
	}
	
	@Bean(name="coreConfigInterface")
	public IOperaciones coreConfigInterface(){
		return new Operaciones();
	}
	 	

}
