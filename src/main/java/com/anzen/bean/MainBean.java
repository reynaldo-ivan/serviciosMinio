package com.anzen.bean;

import com.anzen.interfaces.IOperaciones;

public class MainBean {
	

	private File file;
	private Credencials credencials;
	private IOperaciones iOperaciones;
	
	private String url;
	
	
	private String result;
	
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Credencials getCredencials() {
		return credencials;
	}
	public void setCredencials(Credencials credencials) {
		this.credencials = credencials;
	}
	public IOperaciones getiOperaciones() {
		return iOperaciones;
	}
	public void setiOperaciones(IOperaciones iOperaciones) {
		this.iOperaciones = iOperaciones;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
