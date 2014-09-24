package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class GInsertBean {
String gid="",//英语字段
     gname="",//英译字段
     gprice="",//英语例句
     sid="";//汉译
String addMessage="";//传递添加消息59-91
public GInsertBean(){//构造器
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载sqlserver驱动必须用try{}catch{}语句捕获异常
	}
	catch(Exception e){}
}
	public void setGid(String s)
	{
		gid=s.trim();//移掉字符串中的开头和结尾空格或其他字符
		try{
			byte bb[]=gid.getBytes("ISO-8859-1");//将英语字段进行转码在tomcat6上编码方式是iso-8859-1
		    gid=new String(bb,"gb2312");//转换为国标2312识别汉字
	       }
		catch(Exception e){
			
		}
	}
	public void setGname(String s)
	{
		gname=s.trim();//移掉字符串中的开头和结尾空格或其他字符
		try{
			byte bb[]=gname.getBytes("ISO-8859-1");//将英译字段进行转码在tomcat6上编码方式是iso-8859-1
		    gname=new String(bb,"gb2312");//转换为国标2312识别汉字
	       }
		catch(Exception e){
			
		}
	}
	public void setGprice(String s)
	{
		gprice=s.trim();//移掉字符串中的开头和结尾空格或其他字符
		try{
			byte bb[]=gprice.getBytes("ISO-8859-1");//将英例句字段进行转码在tomcat6上编码方式是iso-8859-1
		    gprice=new String(bb,"gb2312");//转换为国标2312识别汉字
	       }
		catch(Exception e){
			
		}
	}
	public void setSid(String s)
	{
		sid=s.trim();//移掉字符串中的开头和结尾空格或其他字符
		try{
			byte bb[]=sid.getBytes("ISO-8859-1");//将汉译字段进行转码在tomcat6上编码方式是iso-8859-1
		    sid=new String(bb,"gb2312");//转换为国标2312识别汉字
	       }
		catch(Exception e){
			
		}
	}
	public String getAddMessage()//为string类型函数必须返回string类型的结果
	{
		String insertCondition="INSERT  goodtable VALUES('"+gid+"','"+gname+"','"+gprice+"','"+sid+"')";//向dictionary表中插入传入的字段
		String str="";//输出结果
		Connection con;
		Statement sql;
		try {
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql的url其中127.0.0.1是本地服务器，1433是数据库的接口，DATABASENAME是dictionary数据库
			con=DriverManager.getConnection(url,"sa","123456");//连接数据库
			sql=con.createStatement();//创建连接
			if(gid.length()>0)
			{
				int m=sql.executeUpdate(insertCondition);//执行sql语句
				if(m!=0){
					str="添加"+m+"条记录成功";
				}//执行成功
				else{
					str="添加失败";
				}//执行失败
			}
			else
			{
				str="必须要有gid项";
			}//执行失败
			con.close();
		}
		catch(SQLException e){
			str="输入的gid不允许重复"+e;
		}
		return str;
	}
	
}