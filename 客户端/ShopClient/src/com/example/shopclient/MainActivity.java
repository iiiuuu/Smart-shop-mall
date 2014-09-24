package com.example.shopclient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);
	}
	public void aboutActivity(View v)
	{
		Intent intent=new Intent(this,About.class);
		startActivity(intent);
		
	}
	public void mapActivity(View v)
	{
		Intent intent=new Intent(this,Map.class);
		startActivity(intent);
		
	}
	public void searchActivity(View v)
	{
		Intent intent=new Intent(this,Search.class);
		startActivity(intent);
		
	}
	public void recommendActivity(View v)
	{
		Intent intent=new Intent(this,Recommend.class);
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
