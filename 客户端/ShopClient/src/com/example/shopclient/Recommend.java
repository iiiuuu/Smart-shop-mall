package com.example.shopclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Recommend extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.recommend);
	}
	public void threeActivity(View v)
	{
		Intent intent=new Intent(this,Recomt.class);
		startActivity(intent);
		
	}
	public void nikeActivity(View v)
	{
		Intent intent=new Intent(this,Recomn.class);
		startActivity(intent);
		
	}
	public void adActivity(View v)
	{
		Intent intent=new Intent(this,Recoma.class);
		startActivity(intent);
		
	}
	

}
