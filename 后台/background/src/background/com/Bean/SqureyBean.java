package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqureyBean {
	StringBuffer queryResult;//数据库记录集
	public SqureyBean()//构造器
	{
		queryResult=new StringBuffer();//建立记录集为StringBUffer类型可以增添
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载sqlserver驱动必须用try{}catch{}语句捕获异常
		}
		catch(Exception e){}
	}
	public StringBuffer getQueryResult(){//返回STRINGBuffer的函数
		StringBuffer str=new StringBuffer();//新建StringBuffer类
		Connection con;//数据库连接对象
		Statement sql;//记录集
		ResultSet rs;//调用数据库所出来的记录集用来输出数据库数据
		try{
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql的url其中127.0.0.1是本地服务器，1433是数据库的接口，DATABASENAME是dictionary数据库
		con=DriverManager.getConnection(url,"sa","123456");//连接数据库
		sql=con.createStatement();//创建连接
	    	 rs=sql.executeQuery("select *from shoptable");//执行sql语句选择数据库中的所有的项
	 		str.append("<table bored=1>");//输出表头
	 		str.append("<th width=80>"+"sid");
	 		str.append("<th width=80>"+"layer");
	 		str.append("<th width=80>"+"sname");
	 		str.append("<th width=80>"+"smessage");//宽度80
	 		str.append("<th width=80>"+"sphone");
	 		str.append("<th width=80>"+"prise");
	 		str.append("<th width=80>"+"step");
	 		str.append("<th width=80>"+"x");
	 		str.append("<th width=80>"+"y");
	 		while(rs.next())//移动记录集然后输出结果
	 		{
	 			str.append("<tr>");
	 			str.append("<td>"+rs.getString(1)+"</td>");
	 			str.append("<td>"+rs.getString(2)+"</td>");
	 			str.append("<td>"+rs.getString(3)+"</td>");
	 			str.append("<td>"+rs.getString(4)+"</td>");
	 			str.append("<td>"+rs.getString(5)+"</td>");
	 			str.append("<td>"+rs.getString(6)+"</td>");
	 			str.append("<td>"+rs.getString(7)+"</td>");
	 			str.append("<td>"+rs.getString(8)+"</td>");
	 			str.append("<td>"+rs.getString(9)+"</td>");
	 			str.append("</tr>");
	 		}
	 		str.append("<table border=1>");
		
		con.close();
	}
	catch(SQLException e){
		System.out.println(e);
	}
	return str;//输出结果
}
	}
