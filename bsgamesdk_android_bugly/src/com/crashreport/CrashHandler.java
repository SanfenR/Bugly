package com.crashreport;

import java.lang.Thread.UncaughtExceptionHandler;

import com.crashreport.utils.LogUtils;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

public class CrashHandler implements UncaughtExceptionHandler{

	 //CrashHandler实例
    private static CrashHandler INSTANCE = new CrashHandler();
    
    private CrashReportHelper mCrashReportHelper;
    
    private CrashHandler(){};
    
	public static CrashHandler getInstance(){
		return INSTANCE;
	}
	
	private Thread.UncaughtExceptionHandler mDefaultHandler;
	//程序的Context对象
	private Context mContext;
	
	/**
	 * 初始化
	 * @param context
	 */
	public void init(Context context){
		mContext = context;
		//获取系统默认的UncaughtException处理器
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		//设置该CrashHandler为程序的默认处理器
		Thread.setDefaultUncaughtExceptionHandler(INSTANCE);
		
		//mCrashReportHelper = new CrashReportHelper(context);
		
		LogUtils.d("", "-----> 初始化成功");
	}
	
	 /**
     * 当UncaughtException发生时会转入该函数来处理
     */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //LogUtils.e("error : ", e);
            }
            //退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
	}
	
	public boolean handleException(final Throwable ex){
		if (ex == null) {
			return false;
		}
		 //使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "很抱歉,程序出现异常,即将退出." + ex.toString(), Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();
		
		return true;
	}
	
	
}
