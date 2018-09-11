package com.example.led;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import android.R.bool;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	WifiManager mywifi;Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
	OutputStream os;Socket mykehu=null;String str;TextView tv;
	DhcpInfo dhcp;WifiManager wifi;BufferedReader br;int isconnected=0;
	Message msg=new Message();
	void fasong(byte[] c)
	{
		try {
			mykehu=new Socket(Formatter.formatIpAddress(dhcp.serverAddress),333);
			os=mykehu.getOutputStream();os.write(c);os.close();mykehu.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public Handler handler = new Handler()
	{
		public void handleMessage(Message m)
		{
			switch (m.what)
			{
			case 1:tv.setText("11111");break;
			case 2:tv.setText("2222");break;
			case 0:tv.setText(str);break;
			}
			super.handleMessage(m);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DisplayMetrics dm=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		tv =(TextView)this.findViewById(R.id.textView1);
		int kuan=dm.widthPixels;int gao=dm.heightPixels;
		bt1=(Button)this.findViewById(R.id.button1);
		bt1.setWidth(kuan/4);bt1.setHeight(gao/6);
        bt2=(Button)this.findViewById(R.id.button2);
        bt2.setWidth(kuan/4);bt2.setHeight(gao/6);
        bt3=(Button)this.findViewById(R.id.button3);
        bt3.setWidth(kuan/4);bt3.setHeight(gao/6);
        bt4=(Button)this.findViewById(R.id.button4);
        bt4.setWidth(kuan/4);bt4.setHeight(gao/6);
        bt5=(Button)this.findViewById(R.id.button5);
        bt5.setWidth(kuan/4);bt5.setHeight(gao/6);
        bt6=(Button)this.findViewById(R.id.button6);
        bt6.setWidth(kuan/4);bt6.setHeight(gao/6);
        bt7=(Button)this.findViewById(R.id.button7);
        bt7.setWidth(kuan/4);bt7.setHeight(gao/6);
        bt8=(Button)this.findViewById(R.id.button8);
        bt8.setWidth(kuan/4);bt8.setHeight(gao/6);
        bt9=(Button)this.findViewById(R.id.button9);
        bt9.setWidth(kuan/4);bt9.setHeight(gao/6);
        wifi=(WifiManager) getSystemService(Context.WIFI_SERVICE);
        dhcp=wifi.getDhcpInfo();
        tv.setText(Formatter.formatIpAddress(dhcp.serverAddress));
        class receive extends Thread
		{
			public void run(){
				try {
					if(isconnected==1)br= new BufferedReader(new InputStreamReader(mykehu.getInputStream()));
					while(true)if(isconnected==1)
					{
						str=br.readLine();
						if(str!=null){msg.what = 0;handler.sendMessage(msg);}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}//new receive().start();

        
		bt1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("1".getBytes("utf-8"));
					/*mykehu=new Socket(Formatter.formatIpAddress(dhcp.serverAddress),8080);
					os=mykehu.getOutputStream();os.write("1\n\r".getBytes("utf-8"));
					br= new BufferedReader(new InputStreamReader(mykehu.getInputStream()));
					str=br.readLine();tv.setText(str);os.close();mykehu.close();*/
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
        }});
		bt2.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("2".getBytes("utf-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
		bt3.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("3".getBytes("utf-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
		bt4.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("4".getBytes("utf-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
		bt5.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {fasong("5".getBytes("utf-8"));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
		bt6.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("6".getBytes("utf-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
		bt7.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("7".getBytes("utf-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
		bt8.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("8".getBytes("utf-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
		bt9.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {//new acp().start();
				try {
					fasong("9".getBytes("utf-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        }});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
