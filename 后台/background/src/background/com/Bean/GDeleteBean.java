package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GDeleteBean {
	String id="";//英语字段
	String deleteMessage="";//传递的删除消息在63-90行可见;
	public GDeleteBean(){//构造器
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载sqlserver驱动必须用try{}catch{}语句捕获异常
		}
		catch(Exception e){}
	}
		public void setid(String s)
		{
			id=s.trim();//移掉字符串中的开头和结尾空格或其他字符
			try{
				byte bb[]=id.getBytes("ISO-8859-1");//将英语字段进行转码在tomcat6上编码方式是iso-8859-1
			    id=new String(bb,"gb2312");//转换为国标2312识别汉字
		       }
			catch(Exception e){
				
			}
		}
		
		public String getDeleteMessage()//为string类型函数必须返回string类型的结果
		{
			String deleteCondition="delete  from  goodtable where gid='"+id+"'";//执行sql语句通过英语字段选择所要删除的列
			String str="";//输出的结果
			Connection con;//数据库连接对象
			Statement sql;//记录集
			try {
				String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql的url其中127.0.0.1是本地服务器，1433是数据库的接口，DATABASENAME是dictionary数据库
				con=DriverManager.getConnection(url,"sa","123456");//连接数据库
				sql=con.createStatement();//创建连接
				if(id.length()>0)//英语字段输入的是否大于0
				{
					int m=sql.executeUpdate(deleteCondition);//执行sql语句
					if(m!=0){
						str="删除成功";//执行成功
					}
					else{
						str="删除失败";//执行失败
					}
				}
				con.close();//关闭连接
			}
			catch(SQLException e){
			
			}
			return str;//返回输出结果
		}
}
