package com.domain;

public class Shop {
	private int sid;
	private int layer;
	private String sname;
	private String smessage;
	private String sphone;
	private int praise;
	private int step;
	private int x;
	private int y;

	public Shop(){}
	public Shop(int sid,String sname,int layer,String smessage,String sphone,int praise,int step,int x,int y)
	{
		
		this.sid = sid;
		this.layer = layer;
		this.sname = sname;
		this.smessage = smessage;
		this.sphone = sphone;
		this.praise = praise;
		this.step = step;
		this.x=x;
		this.y=y;
		
	
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmessage() {
		return smessage;
	}
	public void setSmessage(String smessage) {
		this.smessage = smessage;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
