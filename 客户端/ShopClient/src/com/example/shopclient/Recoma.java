package com.example.shopclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class Recoma extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.recoma);
		TabHost tabHost = (TabHost) this.findViewById(R.id.Tablea);  
        tabHost.setup(); 
        tabHost.addTab(tabHost.newTabSpec("liuli")  .setContent(R.id.tab1).setIndicator("…Ã∆∑"));  
        tabHost.addTab(tabHost.newTabSpec("kaka").setContent(R.id.tab3).setIndicator("¥Ú’€"));
        tabHost.setCurrentTab(0);
	}

}
