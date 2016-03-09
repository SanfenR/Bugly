package com.example.bsgamesdk_android_bugly_demo;

import com.crashreport.CrashReport;

import android.app.Application;

public class DemoApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		CrashReport.init(getApplicationContext());
		
		com.tencent.bugly.crashreport.CrashReport.initCrashReport(getApplicationContext(), "900019203", true);
	}
}
