package com.crashreport;

import com.crashreport.entity.Info;
import com.crashreport.entity.Strategy;

import android.content.Context;

public class CrashReport {
	
	public static CrashHandler mCrashHandler;
	
	public Info mInfo;
	
	public static Strategy mStrategy;
	
	public static void init(Context context){
		init(context, null);
	}
	
	public static void init(Context context, Strategy strategy){
		mCrashHandler = CrashHandler.getInstance();
		mCrashHandler.init(context);
		
/*		if (strategy != null) {
			mStrategy = strategy;
		}
		mStrategy = new Strategy();
		
		Info.init();*/
		
		
	}
}
