package com.example.shopclient;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.domain.Good;
import com.example.domain.Shop;
import com.example.service.ShopService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

public class Map extends Activity{
	private ImageView image1;
	private ImageView image2;
	private EditText ed;
	private Button but;
	int layer;
	int x;
	int y;
	int x1=0;
    int y1=0;
    int x2=0;
    int y2=0;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		ed=(EditText)this.findViewById(R.id.editText1);
		but=(Button)this.findViewById(R.id.button1);
		image1=(ImageView)this.findViewById(R.id.imageView1);
		image2=(ImageView)this.findViewById(R.id.imageView2);
		image1.setVisibility(View.GONE);
		image2.setVisibility(View.GONE);
		
		 try{  
			final TabHost tabHost = (TabHost) this.findViewById(R.id.Table);  
            tabHost.setup(); 
            tabHost.addTab(tabHost.newTabSpec("liuli")  .setContent(R.id.tab1).setIndicator("一层"));  
            tabHost.addTab(tabHost.newTabSpec("kaka").setContent(R.id.tab2).setIndicator("二层"));
            
            but.setOnClickListener(new OnClickListener() {
            	@Override
				public void onClick(View v) {
					image1.setVisibility(View.GONE);
					image2.setVisibility(View.GONE);
            		x=0;
            		y=0;

            		
					String s1=ed.getText().toString();
					List<Shop> shops;
					try {
						shops = ShopService.getShopInf(s1);
						 final List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
						    for(Shop shop : shops){
						    	layer=shop.getLayer();
							    x=shop.getX();
						        y=shop.getY();
						    }
						    if(layer==1)
						    {
						    	Dmap3();
						    	tabHost.setCurrentTab(0);
						    	Dmap1(x,y);
						    	image1.setVisibility(View.VISIBLE);	
						    	x1=x;
						    	y1=y;
						    }
						    else if(layer==2)
						    {
						    	Dmap4();
						    	tabHost.setCurrentTab(1);
						    	Dmap2(x,y);
						    	image2.setVisibility(View.VISIBLE);
						    	x2=x;
						    	y2=y;
						    }
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//需修改成你本机的Http请求路径  
				}
            	
			
			});
             }
		 catch(Exception ex){  
            ex.printStackTrace();  
            Log.d("EXCEPTION", ex.getMessage());  
        } 
		
		
     
	}
	public void Dmap1(int x,int y)
	{
		 
    	//image1=(ImageView)this.findViewById(R.id.imageView1);
   	    image1.setPadding( image1.getPaddingLeft(),  image1.getPaddingTop()+x,  
   		image1.getPaddingRight()+y,  image1.getPaddingBottom());
	}
	public void Dmap2(int x,int y)
	{
		 
    	//image2=(ImageView)this.findViewById(R.id.imageView2);
   	    image2.setPadding( image2.getPaddingLeft(),  image2.getPaddingTop()+x,  
   		image2.getPaddingRight()+y,  image2.getPaddingBottom());
	}
	public void Dmap3()
	{
		image1.setPadding(image1.getPaddingLeft(), 0, 0, image1.getPaddingBottom());
	}
	public void Dmap4()
	{
		image2.setPadding(image2.getPaddingLeft(), 0, 0, image2.getPaddingBottom());
	}
	

}
