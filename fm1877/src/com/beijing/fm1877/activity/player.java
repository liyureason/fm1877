package com.beijing.fm1877.activity;

import com.beijing.fm1877.R;
import com.beijing.fm1877.R.layout;
import com.beijing.fm1877.service.PlayService;
import com.beijing.fm1877.util.ObjectTools;
import com.beijing.fm1877.view.SlidingLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class player extends Activity implements OnClickListener {
	/**
	 * 侧滑布局对象，用于通过手指滑动将左侧的菜单布局进行显示或隐藏。
	 */
	private SlidingLayout slidingLayout;
	private View view2;
	private ImageView mode;
	public static ImageView play;
	public static ProgressBar bar;
	public static TextView playTime;
	public static TextView qidian;
	private TextView jianjie;       //歌曲简介
	private boolean isMode, isPlay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_home);
		ObjectTools.lists.add(this);
		slidingLayout = (SlidingLayout) findViewById(R.id.slidingLayout);
		view2 = (ListView) findViewById(R.id.player_textview);
		slidingLayout.setScrollEvent(view2);
		initView();
	}

	public void initView() {
		mode = (ImageView) findViewById(R.id.mode);
		play = (ImageView) findViewById(R.id.play);
		mode.setOnClickListener(this);
		findViewById(R.id.kuaijin).setOnClickListener(this);
		findViewById(R.id.kuaitui).setOnClickListener(this);
		play.setOnClickListener(this);
		findViewById(R.id.xihuan).setOnClickListener(this);
		bar=(ProgressBar)findViewById(R.id.player_progressbar);
		playTime=(TextView)findViewById(R.id.player_zhongdian);
		jianjie=(TextView)findViewById(R.id.player_liebiao);
		qidian=(TextView)findViewById(R.id.player_qidian);
		play.setBackgroundResource(R.drawable.kaishi);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mode:
//			Intent intent1 = new Intent(player.this, PlayService.class);
			// intent1.putExtra("playState", PlayService.);
//			startService(intent1);
			break;
		case R.id.play:
			Intent intent2 = new Intent(player.this, PlayService.class);
			if (!isPlay) {
				intent2.putExtra("playState", PlayService.play);
				play.setBackgroundResource(R.drawable.stop);
				isPlay = true;
			} else {
				intent2.putExtra("playState", PlayService.pause);
				play.setBackgroundResource(R.drawable.kaishi);
				isPlay = false;
			}
			startService(intent2);
			break;
		case R.id.kuaijin:
			Intent intent3 = new Intent(player.this, PlayService.class);
			intent3.putExtra("playState", PlayService.kuaijin);
			startService(intent3);
			break;
		case R.id.kuaitui:
			Intent intent4 = new Intent(player.this, PlayService.class);
			intent4.putExtra("playState", PlayService.kuaitui);
			startService(intent4);
			break;
		case R.id.xihuan:
//			Intent intent5 = new Intent(player.this, PlayService.class);
			// intent5.putExtra("playState", PlayService.xihuan);
//			startService(intent5);
			break;
		}

	}
}
