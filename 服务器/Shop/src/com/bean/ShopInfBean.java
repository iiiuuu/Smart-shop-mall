package com.bean;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.Shop;

public class ShopInfBean implements ShopInf {//����˴������ݿ���ʴ�����ȡ����������װ��
	public List<Shop> getShopInf(String sg)
	{
		List<Shop> re=new ArrayList<Shop>();
		// Map<String, String> params = new HashMap<String, String>();
				// params.put("id", id);
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Shop";
		String userName = "sa"; // Ĭ���û���
		String userPwd = "123456"; // ����     ��Ҫ�޸�
		String sql1 = "select* from shoptable where sname like '"+sg+"% ' ";//
		try {
			Class.forName(driverName);
			Connection db = DriverManager.getConnection(dbURL, userName,userPwd);// �������ݿ����
			Statement st = db.createStatement();// ����SQL�������
			ResultSet ad = st.executeQuery(sql1);// ����SQL����ѯ�����
			while (ad.next()) {
				int sid = ad.getInt("sid");
				int layer = ad.getInt("layer");
				String sname = ad.getString("sname");
				String smessage = ad.getString("smessage");
				String sphone = ad.getString("sphone");
				int prise = ad.getInt("prise");
				int step = ad.getInt("step");
				int x = ad.getInt("x");
				int y = ad.getInt("y");
				re.add(new Shop(sid, sname, layer, smessage,sphone,prise,step,x,y));
			}
		} catch (Exception e) {
			System.exit(0);
		}
		return re;
		}

}
