package background.com.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GDeleteBean {
	String id="";//Ӣ���ֶ�
	String deleteMessage="";//���ݵ�ɾ����Ϣ��63-90�пɼ�;
	public GDeleteBean(){//������
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//����sqlserver����������try{}catch{}��䲶���쳣
		}
		catch(Exception e){}
	}
		public void setid(String s)
		{
			id=s.trim();//�Ƶ��ַ����еĿ�ͷ�ͽ�β�ո�������ַ�
			try{
				byte bb[]=id.getBytes("ISO-8859-1");//��Ӣ���ֶν���ת����tomcat6�ϱ��뷽ʽ��iso-8859-1
			    id=new String(bb,"gb2312");//ת��Ϊ����2312ʶ����
		       }
			catch(Exception e){
				
			}
		}
		
		public String getDeleteMessage()//Ϊstring���ͺ������뷵��string���͵Ľ��
		{
			String deleteCondition="delete  from  goodtable where gid='"+id+"'";//ִ��sql���ͨ��Ӣ���ֶ�ѡ����Ҫɾ������
			String str="";//����Ľ��
			Connection con;//���ݿ����Ӷ���
			Statement sql;//��¼��
			try {
				String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";//sql��url����127.0.0.1�Ǳ��ط�������1433�����ݿ�Ľӿڣ�DATABASENAME��dictionary���ݿ�
				con=DriverManager.getConnection(url,"sa","123456");//�������ݿ�
				sql=con.createStatement();//��������
				if(id.length()>0)//Ӣ���ֶ�������Ƿ����0
				{
					int m=sql.executeUpdate(deleteCondition);//ִ��sql���
					if(m!=0){
						str="ɾ���ɹ�";//ִ�гɹ�
					}
					else{
						str="ɾ��ʧ��";//ִ��ʧ��
					}
				}
				con.close();//�ر�����
			}
			catch(SQLException e){
			
			}
			return str;//����������
		}
}
