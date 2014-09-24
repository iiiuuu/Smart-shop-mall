package com.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingRequestWrapper extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	public EncodingRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {//此方法内部不应涉及格式转换

	    String value = request.getParameter(name);
	    /*try {
			
			value=new String(value.getBytes(""), "Unicode");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
//		String temp = request.getCharacterEncoding();
		if(value!=null){
			try {
				value = new String(value.getBytes(), "GBK");
		   } catch (UnsupportedEncodingException e) {
		e.printStackTrace();
			}
		}
		
		return value;
	
	

}}
