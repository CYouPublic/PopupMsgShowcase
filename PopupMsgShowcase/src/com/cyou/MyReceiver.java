package com.cyou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver
{
	public static Intent intentAlert = null;

	@Override
	public void onReceive(Context context, Intent intent) {
		
		if(intentAlert == null)
		{
			intentAlert = new Intent(context, AlertActivity.class);
			intentAlert.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intentAlert);
		}
		else
		{
			context.startActivity(intentAlert);
		}
	}
}
