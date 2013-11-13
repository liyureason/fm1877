package com.beijing.fm1877.activity;

import com.beijing.fm1877.R;
import com.beijing.fm1877.R.layout;
import com.beijing.fm1877.view.SlidingLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class player extends Activity{
	/**
	 * 侧滑布局对象，用于通过手指滑动将左侧的菜单布局进行显示或隐藏。
	 */
	private SlidingLayout slidingLayout;
	private View view2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_home);
		slidingLayout = (SlidingLayout) findViewById(R.id.slidingLayout);
		view2=(ListView)findViewById(R.id.player_textview);
		slidingLayout.setScrollEvent(view2);
		
		
	}
}
