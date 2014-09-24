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

import com.example.domain.Shop;



public class ShopService {
	public static List<Shop> getShopInf(String sg) throws Exception{
		String path = "http://10.3.10.20:8080/Shop/ShopInfServlet";//ÐèÒªÐÞ¸Äip
		Map<String, String> params = new HashMap<String, String>();
		params.put("sg", sg);
		try {
			return sendGETRequest(path, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<Shop> sendGETRequest(String path,Map<String, String> params) throws Exception{
		StringBuilder url = new StringBuilder(path);
		url.append("?");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			url.append(entry.getKey()).append("=");
			url.append(entry.getValue());
			url.append("&");
		}
		//url = new String(url.getBytes("ISO-8859-1"), "UTF-8");
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
	
	private static List<Shop> parseXML(InputStream inStream) throws Exception {
		List<Shop> shopes = new ArrayList<Shop>();
		Shop shop = null;
		XmlPullParser parser = Xml.newPullParser();
		parser.setInput(inStream, "UTF-8");
		int event = parser.getEventType();
		while( event != XmlPullParser.END_DOCUMENT){
			switch (event) {
			case XmlPullParser.START_TAG:
				if("news".equals(parser.getName())){
					int id = new Integer(parser.getAttributeValue(0));
					shop = new Shop();
					shop.setSid(id);
				}else if("sname".equals(parser.getName())){
					shop.setSname(parser.nextText());
				}else if("layer".equals(parser.getName())){
					shop.setLayer(new Integer(parser.nextText()));
				}else if("smessage".equals(parser.getName())){
					shop.setSmessage(parser.nextText());
				}
				else if("sphone".equals(parser.getName())){
					shop.setSphone(parser.nextText());
				}
				else if("praise".equals(parser.getName())){
					shop.setPraise(new Integer(parser.nextText()));
				}
				else if("step".equals(parser.getName())){
					shop.setStep(new Integer(parser.nextText()));
				}
				else if("x".equals(parser.getName())){
					shop.setX(new Integer(parser.nextText()));
				}
				else if("y".equals(parser.getName())){
					shop.setY(new Integer(parser.nextText()));
				}
				break;

			case XmlPullParser.END_TAG:
				if("news".equals(parser.getName())){
					shopes.add(shop);
					shop = null;
				}
				break;
			}
			event = parser.next();
		}
		return shopes;
	}

}
