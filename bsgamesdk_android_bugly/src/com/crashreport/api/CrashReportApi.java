package com.crashreport.api;

import android.content.Context;

public class CrashReportApi implements ICrashReportApi{
	public Context mContext;
	public CrashReportApi(Context context) {
		mContext = context;
	}

	@Override
	public void doCrashReport(Context context) {
		//
	}

}
