package com.beijing.fm1877.activity;

import com.beijing.fm1877.R;
import com.beijing.fm1877.service.PlayService;
import com.beijing.fm1877.util.ObjectTools;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class HomeActivity extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		findViewById(R.id.guangbo).setOnClickListener(this);
		findViewById(R.id.yingyue).setOnClickListener(this);
		findViewById(R.id.wenzhang).setOnClickListener(this);
		findViewById(R.id.aboutme).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.guangbo:
			startActivity(new Intent(HomeActivity.this,guangbo.class));
			break;
		case R.id.yingyue:
			startActivity(new Intent(HomeActivity.this,yinyue.class));
			break;
		case R.id.wenzhang:
			startActivity(new Intent(HomeActivity.this,wenzhang.class));
			break;
		case R.id.aboutme:
			startActivity(new Intent(HomeActivity.this,aboutme.class));
			break;
		}
		
	}
	public void closeActivity(){
		for (int i = 0; i <ObjectTools.lists.size(); i++) {
			ObjectTools.lists.get(i).finish();
		}
	}

	protected void dialog() { 
		AlertDialog.Builder builder = new Builder(HomeActivity.this); 
		builder.setMessage("确定要退出吗?"); 
		builder.setTitle("提示"); 
		builder.setPositiveButton("确认", 
				new android.content.DialogInterface.OnClickListener() { 
			public void onClick(DialogInterface dialog, int which) { 
				dialog.dismiss(); 
				closeActivity();
				HomeActivity.this.finish(); 
				stopService(new Intent(HomeActivity.this,PlayService.class));
			} 
		}); 
		builder.setNegativeButton("取消", 
				new android.content.DialogInterface.OnClickListener() { 
			public void onClick(DialogInterface dialog, int which) { 
				dialog.dismiss(); 
			} 
		}); 
		builder.create().show(); 
	} 

	public boolean dispatchKeyEvent(KeyEvent event) {  

		// menuUtils.createTwoDispatcher(event);  

		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {  

			dialog();

		}  

		return false;  

	} 
}
