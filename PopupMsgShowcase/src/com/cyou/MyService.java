package com.cyou;

import java.util.Timer;
import java.util.TimerTask;

import android.app.KeyguardManager;
import android.os.PowerManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service 
{
	private MyReceiver receiver;

	@Override
	public IBinder onBind(Intent intent) 
	{
		return null;
	}

	@Override
	public void onCreate() 
	{
		super.onCreate();
		receiver = new MyReceiver();
		IntentFilter filter = new IntentFilter();
        filter.addAction("com.cyou.receiver");
        registerReceiver(receiver,filter);

		
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() 
		{
			
			@Override
			public void run() 
			{
				Log.v("AlertNotifi", "I am running.....");
				
				PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);  
				boolean isScreenOn = pm.isScreenOn();
				//KeyguardManager mKeyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
				//if (!mKeyguardManager.inKeyguardRestrictedInputMode()) 
				if (isScreenOn)
				{
					Log.v("AlertNotifi", "Screen is on.....");
				}
				else
				{
					Log.v("AlertNotifi", "Screen is off.....");
					Intent intentReceiver = new Intent("com.cyou.receiver");
					sendBroadcast(intentReceiver);
				}
			}
		}, 2*1000, 2*1000);
	}

	@Override
	public void onDestroy() 
	{
		super.onDestroy();
		unregisterReceiver(receiver);
	}

	
}
