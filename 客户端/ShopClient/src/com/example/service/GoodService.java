package com.example.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.example.domain.Good;
import com.example.domain.Shop;

public class GoodService {
	public static List<Good> getShopInf(String gg) throws Exception{
		String path = "http://10.3.10.20:8080/Shop/GoodInfServlet";//ÐèÒªÐÞ¸Äip
		Map<String, String> params = new HashMap<String, String>();
		params.put("gg", gg);
		try {
			return sendGETRequest(path, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<Good> sendGETRequest(String path,Map<String, String> params) throws Exception{
		StringBuilder url = new StringBuilder(path);
		url.append("?");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			url.append(entry.getKey()).append("=");
			url.append(entry.getValue());
			url.append("&");
		}
		url.deleteCharAt(url.length() - 1);
		HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
		conn.setConnectTimeout(10000);
		conn.setRequestMethod("GET");
		if (conn.getResponseCode() == 200) {
			InputStream inStream = conn.getInputStream();
			return parseXML(inStream);
		}
		return null;
		
		
	}
	
	private static List<Good> parseXML(InputStream inStream) throws Exception {
		List<Good> Goodes = new ArrayList<Good>();
		Good good = null;
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(inStream, "UTF-8");
		int event = parser.getEventType();
		while( event != XmlPullParser.END_DOCUMENT){
			switch (event) {
			case XmlPullParser.START_TAG:
				if("news".equals(parser.getName())){
					int id = new Integer(parser.getAttributeValue(0));
					good = new Good();
				    good.setSid(id);
				}else if("gname".equals(parser.getName())){
					good.setGname(parser.nextText());
				}else if("gprice".equals(parser.getName())){
					good.setGprice(new Integer(parser.nextText()));
				}else if("sid".equals(parser.getName())){
					good.setSid(new Integer(parser.nextText()));
				}
				else if("sname".equals(parser.getName())){
					good.setSname(parser.nextText());
				}
				break;

			case XmlPullParser.END_TAG:
				if("news".equals(parser.getName())){
					Goodes.add(good);
					good = null;
				}
				break;
			}
			event = parser.next();
		}
		return Goodes;
	}

}