package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GqureyBean {
	StringBuffer queryResult;//���ݿ��¼��
	public GqureyBean()//������
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
		
		rs=sql.executeQuery("select *from goodtable");//ִ��sql���ѡ�����ݿ��е����е���
		str.append("<table bored=1>");//�����ͷ
		str.append("<th width=80>"+"gid");
		str.append("<th width=80>"+"gname");
		str.append("<th width=80>"+"gprice");
		str.append("<th width=80>"+"sid");//���80
		
		while(rs.next())//�ƶ���¼��Ȼ��������
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
	return str;//������
}
	}
