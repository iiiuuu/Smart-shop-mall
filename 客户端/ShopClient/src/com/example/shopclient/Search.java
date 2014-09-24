package com.example.shopclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;







import com.example.domain.Good;
import com.example.domain.Shop;

import com.example.service.GoodService;
import com.example.service.ShopService;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Search extends Activity {
	private ListView listView;
	private EditText ed;
	private Button but;
	private RadioGroup group;
	private ProgressDialog mDialog;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		listView = (ListView) this.findViewById(R.id.List);
		ed=(EditText)this.findViewById(R.id.Edit);
		but=(Button)this.findViewById(R.id.Button);
		RadioGroup group = (RadioGroup)this.findViewById(R.id.radioGroup1);
		//final List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
		group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int checkedId) {
				if(checkedId==R.id.Shop)
				{
					but.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							String s1=ed.getText().toString();
							try {
								    List<Shop> shops = ShopService.getShopInf(s1);//需修改成你本机的Http请求路径
									List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
									for(Shop shop : shops){
										HashMap<String, Object> item = new HashMap<String, Object>();
										item.put("id", shop.getSid());
										item.put("layer", getResources().getString(R.string.layer)+shop.getLayer());
										item.put("sname", shop.getSname());
										item.put("smessage", getResources().getString(R.string.message)+shop.getSmessage());
										item.put("sphone", getResources().getString(R.string.phone)+shop.getSphone());
										item.put("praise",getResources().getString(R.string.praise)+shop.getPraise());
										item.put("step",getResources().getString(R.string.step)+shop.getStep());
										data.add(item);
									}
									SimpleAdapter adapter = new SimpleAdapter(Search.this, data, R.layout.sitem,
											new String[]{"sname","layer","smessage","sphone","praise","step"}, new int[]{R.id.sname,R.id.layer,R.id.smessage,R.id.sphone,R.id.praise,R.id.step});
									listView.setAdapter(adapter);
								} catch (Exception e) {
									e.printStackTrace();
								}
						}
				});
				
			}
				else
				{
					but.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
						    //响应按钮单击事件的函数 
							String s1=ed.getText().toString();
							 try {
									List<Good> goods = GoodService.getShopInf(s1);//需修改成你本机的Http请求路径
									List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
									for(Good good :goods){
										HashMap<String, Object> item = new HashMap<String, Object>();
										item.put("id", good.getGid());
										item.put("gname", good.getGname());
										item.put("gprice",getResources().getString(R.string.price)+good.getGprice());
										
										item.put("sid", good.getSid());
										item.put("sname", good.getSname());
										
										data.add(item);
									}
									SimpleAdapter adapter = new SimpleAdapter(Search.this, data, R.layout.gitem,
											new String[]{"gname","sname","gprice"}, new int[]{R.id.gname,R.id.ssname,R.id.gprice});
									listView.setAdapter(adapter);
								} catch (Exception e) {
									e.printStackTrace();
								}
						}
				});
					
				}
				
		}
		});
	}

	

	
        
  

}
	     
	  
				
				 
			
	

				
			
				
		
		

	

	
	

