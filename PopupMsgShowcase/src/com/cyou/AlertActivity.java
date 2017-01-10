package com.cyou;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.cyou.R;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class AlertActivity extends Activity implements OnClickListener
{
	private TextView titleTextV;
	private TextView msgTextV;
	
	private Button cancleBtn;
	private Button okBtn;

	private static int messageCount = 0;

	@SuppressLint("ShowToast")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		Window window = getWindow();

		window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

		LayoutInflater inflater = getLayoutInflater();
		
		View[] tmpView = new View[5];
		for(int i = 0; i < 5; ++i)
		{
			tmpView[i] = inflater.inflate(R.layout.alert_layout, null);

			getWindow().addContentView(tmpView[i], 
			new ViewGroup.LayoutParams
				(ViewGroup.LayoutParams.FILL_PARENT,
				500 + i*600));
		}
		
		for(int i = 0; i < 5; ++i)
		{
			titleTextV = (TextView) tmpView[i].findViewById(R.id.msg_title_textV);
			titleTextV.setText("天龙3D: ");
			msgTextV = (TextView) tmpView[i].findViewById(R.id.msg_content_textV);
			String str = "帮战开始了，速来！" + messageCount++;
			msgTextV.setText(str);

			okBtn = (Button) tmpView[i].findViewById(R.id.alert_ok_btn);
			okBtn.setOnClickListener(this);
		}

		
	}

	@Override
	public void onClick(View v) 
	{
		// if(v == okBtn)
		{
			//back to app 
			finish();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}
	
	
}
