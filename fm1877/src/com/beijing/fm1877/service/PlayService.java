package com.beijing.fm1877.service;

import java.io.IOException;

import com.beijing.fm1877.R;
import com.beijing.fm1877.activity.player;
import com.beijing.fm1877.util.ObjectTools;
import com.beijing.fm1877.util.UtilTools;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class PlayService extends Service{
    private MediaPlayer mPlayer;
    private int playerState;
    private boolean isPlay;
    public final static int play=0;
    public final static int pause=1;
    public final static int stop=2;
    public final static int kuaijin=3;
    public final static int kuaitui=4;
    private boolean isRun;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		mPlayer=new MediaPlayer();
		mPlayer.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer arg0) {
				player.play.setBackgroundResource(R.drawable.kaishi);
				isPlay=false;
				mPlayer.reset();
			}
		});
		isRun=true;
		new Thread(new MyThread()).start();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		playerState=intent.getIntExtra("playState",0);  
		switch(playerState){
		case play:
			try {
				play();
			} catch (Exception e) {
				
			}
			break;
		case pause:
			mPlayer.pause();
			
			break;
		case stop:
			mPlayer.stop();
			mPlayer.reset();
			break;
		case kuaijin:
			if(mPlayer.getCurrentPosition()+10000<mPlayer.getDuration()){
      			mPlayer.seekTo(mPlayer.getCurrentPosition()+10000);
			}else{
				mPlayer.stop();
			}
			break;
		case kuaitui:
			if(mPlayer.getCurrentPosition()-10000>0){
      			mPlayer.seekTo(mPlayer.getCurrentPosition()-10000);
			}else{
				mPlayer.seekTo(0);
			}
			break;
		}
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	public void play(){
		if(!isPlay){
			try {
				AssetFileDescriptor afd = getAssets().openFd("dahai.mp3");
				mPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
				mPlayer.prepare();
				mPlayer.start();
				player.playTime.setText(UtilTools.formatterNum(mPlayer.getDuration()));//运行报错
				isPlay=true;
			} catch (IllegalStateException e) {
				Log.i("service", "----------------no player");
			} catch (IOException e) {
				e.printStackTrace();
			}
			}else{
				mPlayer.start();
				isPlay=true;
			}
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.release();
		isRun=false;
	}
	class MyThread extends Thread{
        
		@Override
		public void run() {
			super.run();
			while(isRun){
				Message msg=handler.obtainMessage();
				if(isPlay){
			    msg.what=mPlayer.getCurrentPosition()*100/mPlayer.getDuration();
			    msg.arg1=mPlayer.getCurrentPosition();
			    msg.sendToTarget();
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(msg!=null)
			player.bar.setProgress(msg.what);
			player.qidian.setText(UtilTools.formatterNum(msg.arg1));
		}
		
	};
	

}
