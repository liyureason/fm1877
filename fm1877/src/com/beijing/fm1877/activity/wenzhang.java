package com.beijing.fm1877.activity;

import com.beijing.fm1877.util.ObjectTools;

import android.app.Activity;
import android.os.Bundle;

public class wenzhang extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ObjectTools.lists.add(this);
	}
	
}
