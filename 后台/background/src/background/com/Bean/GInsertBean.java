package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class GInsertBean {
String gid="",//Ӣ���ֶ�
     gname="",//Ӣ���ֶ�
     gprice="",//Ӣ������
     sid="";//����
String addMessage="";//���������Ϣ59-91
public GInsertBean(){//������
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//����sqlserver����������try{}catch{}��䲶���쳣
	}
	catch(Exception e){}
}
	public void setGid(String s)
	{
		gid=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=gid.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    gid=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setGname(String s)
	{
		gname=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=gname.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    gname=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setGprice(String s)
	{
		gprice=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=gprice.getBytes("ISO-8859-1");//��Ӣ�����ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    gprice=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setSid(String s)
	{
		sid=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=sid.getBytes("ISO-8859-1");//�������ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    sid=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public String getAddMessage()//Ϊstring���ͺ������뷵��string���͵Ľ��
	{
		String insertCondition="INSERT  goodtable VALUES('"+gid+"','"+gname+"','"+gprice+"','"+sid+"')";//��dictionary���в��봫����ֶ�
		String str="";//������
		Connection con;
		Statement sql;
		try {
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql��url����127.0.0.1�Ǳ��ط�������1433�����ݿ�Ľӿڣ�DATABASENAME��dictionary���ݿ�
			con=DriverManager.getConnection(url,"sa","123456");//�������ݿ�
			sql=con.createStatement();//��������
			if(gid.length()>0)
			{
				int m=sql.executeUpdate(insertCondition);//ִ��sql���
				if(m!=0){
					str="���"+m+"����¼�ɹ�";
				}//ִ�гɹ�
				else{
					str="���ʧ��";
				}//ִ��ʧ��
			}
			else
			{
				str="����Ҫ��gid��";
			}//ִ��ʧ��
			con.close();
		}
		catch(SQLException e){
			str="�����gid�������ظ�"+e;
		}
		return str;
	}
	
}