package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqureyBean {
	StringBuffer queryResult;//���ݿ��¼��
	public SqureyBean()//������
	{
		queryResult=new StringBuffer();//������¼��ΪStringBUffer���Ϳ�������
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//����sqlserver����������try{}catch{}��䲶���쳣
		}
		catch(Exception e){}
	}
	public StringBuffer getQueryResult(){//����STRINGBuffer�ĺ���
		StringBuffer str=new StringBuffer();//�½�StringBuffer��
		Connection con;//���ݿ����Ӷ���
		Statement sql;//��¼��
		ResultSet rs;//�������ݿ��������ļ�¼������������ݿ�����
		try{
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql��url����127.0.0.1�Ǳ��ط�������1433�����ݿ�Ľӿڣ�DATABASENAME��dictionary���ݿ�
		con=DriverManager.getConnection(url,"sa","123456");//�������ݿ�
		sql=con.createStatement();//��������
	    	 rs=sql.executeQuery("select *from shoptable");//ִ��sql���ѡ�����ݿ��е����е���
	 		str.append("<table bored=1>");//�����ͷ
	 		str.append("<th width=80>"+"sid");
	 		str.append("<th width=80>"+"layer");
	 		str.append("<th width=80>"+"sname");
	 		str.append("<th width=80>"+"smessage");//���80
	 		str.append("<th width=80>"+"sphone");
	 		str.append("<th width=80>"+"prise");
	 		str.append("<th width=80>"+"step");
	 		str.append("<th width=80>"+"x");
	 		str.append("<th width=80>"+"y");
	 		while(rs.next())//�ƶ���¼��Ȼ��������
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
	return str;//������
}
	}
