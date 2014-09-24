package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GqureyBean {
	StringBuffer queryResult;//数据库记录集
	public GqureyBean()//构造器
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
		
		rs=sql.executeQuery("select *from goodtable");//执行sql语句选择数据库中的所有的项
		str.append("<table bored=1>");//输出表头
		str.append("<th width=80>"+"gid");
		str.append("<th width=80>"+"gname");
		str.append("<th width=80>"+"gprice");
		str.append("<th width=80>"+"sid");//宽度80
		
		while(rs.next())//移动记录集然后输出结果
		{
			str.append("<tr>");
			str.append("<td>"+rs.getString(1)+"</td>");
			 str.append("<td>"+rs.getString(2)+"</td>");
		  str.append("<td>"+rs.getString(3)+"</td>");
			str.append("<td>"+rs.getString(4)+"</td>");
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
