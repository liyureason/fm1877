package com.beijing.fm1877.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beijing.fm1877.R;
import com.beijing.fm1877.adapter.guangboAdapter;
import com.beijing.fm1877.util.ObjectTools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;



public class guangbo extends Activity{
	   
	private ListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guangbo);
		ObjectTools.lists.add(this);
		mListView=(ListView)findViewById(R.id.guangbo_list);
		//模拟数据
		List<Map<String, Object>> lists=new ArrayList<Map<String,Object>>();
		for(int i=0;i<10;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("tv1", "江南"+i);
			map.put("tv2", "江小北"+i);
			lists.add(map);
		}
		mListView.setAdapter(new guangboAdapter(lists,this));
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				 startActivity(new Intent(guangbo.this,player.class));	
				
			}
		});
		
	}
	
	
}
