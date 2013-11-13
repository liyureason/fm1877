package com.beijing.fm1877.activity;

import com.beijing.fm1877.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

}
