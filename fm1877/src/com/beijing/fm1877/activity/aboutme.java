package com.beijing.fm1877.activity;

import com.beijing.fm1877.util.ObjectTools;

import android.app.Activity;
import android.os.Bundle;

public class aboutme extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ObjectTools.lists.add(this);
	}
	
}
