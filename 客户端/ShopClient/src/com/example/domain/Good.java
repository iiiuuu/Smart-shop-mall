package com.example.domain;

public class Good {
private int gid;
private String gname;
private int gprice;
private int sid;
private String sname;
public Good(){};
public Good(int gid,String gname,int gprice,int sid,String sname)
{   this.gid=gid;
	this.gname=gname;
	this.gprice=gprice;
	this.sid=sid;
	this.sname=sname;
	
}
public int getGid(){
	return gid;
}
public  void setGid(int gid){
	this.gid=gid;
}
public String getGname(){
	return gname;
}
public void setGname(String gname){
	this.gname=gname;
}
public int getGprice(){
	return gprice;
}
public void setGprice(int gprice){
	this.gprice=gprice;
}
public int getSid(){
	return sid;
}
public void setSid(int Sid){
	this.sid=Sid;
}
public String getSname(){
	return sname;
}
public void setSname(String sname){
	this.sname=sname;
}

}
