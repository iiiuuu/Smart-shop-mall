package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.Good;


public class GoodInfBean implements GoodInf {
   public List<Good>getGoodInf(String gg) 
	{
		List<Good> re=new ArrayList<Good>();
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";
		String userName = "sa"; // Ĭ���û���
		String userPwd = "123456"; // ����   ��Ҫ�޸�
		String sql1 = "select gid,sid,gname,gprice,sname from viewlist where gname like '"+gg+"%' ";
		try {
			Class.forName(driverName);
			Connection db = DriverManager.getConnection(dbURL, userName,userPwd);// �������ݿ����
			Statement st = db.createStatement();// ����SQL�������
			ResultSet ad = st.executeQuery(sql1);// ����SQL����ѯ�����
			while (ad.next()) {
				int gid=ad.getInt("gid");
				String gname = ad.getString("gname");
				int gprice = ad.getInt("gprice");
				int sid = ad.getInt("sid");
				String sname=ad.getString("sname");
				re.add(new Good(gid,gname,gprice,sid,sname));
			}
		} catch (Exception e) {
			System.exit(0);
		}
		return re;
		}

	
	
	}
	
		

