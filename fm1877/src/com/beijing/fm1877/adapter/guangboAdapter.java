package com.beijing.fm1877.adapter;

import java.util.List;
import java.util.Map;

import com.beijing.fm1877.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class guangboAdapter extends BaseAdapter{
    private List<Map<String,Object>> lists;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
	
	public guangboAdapter(List<Map<String,Object>> lists,Context mContext){  
    	this.lists=lists;
    	this.mContext=mContext;
    	mLayoutInflater=LayoutInflater.from(mContext);
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int arg0) {
		return lists.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		ViewHolder mViewHolder;
		if(view==null){
			mViewHolder=new ViewHolder();
			view=mLayoutInflater.inflate(R.layout.guangbo_listitem, null);
			mViewHolder.tv1=(TextView) view.findViewById(R.id.guangbo_item_tv1);
			mViewHolder.tv2=(TextView) view.findViewById(R.id.guangbo_item_tv2);
		    view.setTag(mViewHolder);
		}else{
			mViewHolder=(ViewHolder) view.getTag();
		}
		mViewHolder.tv1.setText(lists.get(position).get("tv1").toString());
		mViewHolder.tv2.setText(lists.get(position).get("tv2").toString());
		return view;
	}
	class ViewHolder {
		TextView tv1;
		TextView tv2;
	}
}
