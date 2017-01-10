package com.cyou;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity 
{
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DevicePolicyManager policyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
		ComponentName componentName = new ComponentName(this, MyAdminReceiver.class);
		
		boolean isAdminActive = policyManager.isAdminActive(componentName);
		if(!isAdminActive)
		{
			Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN); 
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName); 
			startActivity(intent);
		}
		
		intent = new Intent(this, MyService.class);
		startService(intent);
	}
	
}
