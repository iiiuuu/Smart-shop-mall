package com.example.shopclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class Recomt extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.recomt);
		TabHost tabHost = (TabHost) this.findViewById(R.id.Tablet);  
        tabHost.setup(); 
        tabHost.addTab(tabHost.newTabSpec("liuli")  .setContent(R.id.tab1).setIndicator("��Ʒ"));  
        tabHost.addTab(tabHost.newTabSpec("kaka").setContent(R.id.tab3).setIndicator("����"));
        tabHost.setCurrentTab(0);
	}

}
