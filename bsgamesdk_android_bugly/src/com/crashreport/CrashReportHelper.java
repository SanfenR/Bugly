package com.crashreport;

import com.crashreport.api.CrashReportApi;
import com.crashreport.file.CrashCacheHelper;
import com.crashreport.utils.Utils;

import android.content.Context;

public class CrashReportHelper {
	
	public Context mContext;
	public CrashReportApi mCrashReportApi;
	public CrashCacheHelper mCrashCacheHelper;
	public Utils utils;
	
	
	public CrashReportHelper(Context context) {
		mContext = context;
		
		mCrashReportApi = new CrashReportApi(mContext);
		mCrashCacheHelper = new CrashCacheHelper(mContext);
		utils = new Utils();
	}
	
}
