package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class SInsertBean {
String sid="",//Ӣ���ֶ�
       layer="",
     sname="",//Ӣ���ֶ�
     smessage="",//Ӣ������
     sphone="",//����
     prise="",
    step="",
    x="",
    y="";
String addMessage="";//���������Ϣ59-91
public SInsertBean(){//������
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//����sqlserver����������try{}catch{}��䲶���쳣
	}
	catch(Exception e){}
}
	public void setLayer(String s)
	{
		layer=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=layer.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    layer=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setSname(String s)
	{
		sname=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=sname.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    sname=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setSmessage(String s)
	{
		smessage=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=smessage.getBytes("ISO-8859-1");//��Ӣ�����ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    smessage=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
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
	public void setSphone(String s)
	{
		sphone=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=sphone.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    sphone=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setPrise(String s)
	{
		layer=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=layer.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    layer=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setStep(String s)
	{
		step=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=step.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    step=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setX(String s)
	{
		x=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=x.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    x=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public void setY(String s)
	{
		y=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
		try{
			byte bb[]=y.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
		    y=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
	       }
		catch(Exception e){
			
		}
	}
	public String getAddMessage()//Ϊstring���ͺ������뷵��string���͵Ľ��
	{
		String insertCondition="INSERT  shoptable VALUES('"+sid+"','"+sname+"','"+smessage+"','"+sphone+"','"+prise+"','"+step+"','"+x+"','"+y+"')";//��dictionary���в��봫����ֶ�
		String str="";//������
		Connection con;
		Statement sql;
		try {
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql��url����127.0.0.1�Ǳ��ط�������1433�����ݿ�Ľӿڣ�DATABASENAME��dictionary���ݿ�
			con=DriverManager.getConnection(url,"sa","123456");//�������ݿ�
			sql=con.createStatement();//��������
			if(sid.length()>0)
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
				str="����Ҫ��sid��";
			}//ִ��ʧ��
			con.close();
		}
		catch(SQLException e){
			str="�����sid�������ظ�"+e;
		}
		return str;
	}
	
}