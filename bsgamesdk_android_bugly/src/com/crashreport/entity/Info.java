package com.crashreport.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.crashreport.utils.RootUtils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

/**
 * 错误信息实体类
 *
 */
public class Info {
	
	public static String model;//机型
	public static String ver; //系统版本
	public static boolean root; //是否root,true,false
	public static long diskSize = 0; //磁盘占用百分比    取值  1 - 100
	public static long diskAvailable = 0;
	
	public static long sdCardSize = 0; //SD卡总空间
	public static long sdCardAvailable = 0; //SD卡可用空间
	
	public static String ram; //内存占用百分比  取值 1- 100
	public static String cpu;
	public static String message; //系统错误信息
	public static String timestamp; //报错时客户端系统时间
	
	public static void init(){
		model = Build.MODEL;
		ver = Build.VERSION.RELEASE;
		root = RootUtils.isDeviceRooted();
		getDiskStatus();
		getSDCardStatus();
		cpu = getCpuInfo().toString();
	}
	
	/**
	 * 获取外部存储
	 */
	@SuppressLint("NewApi")
	public static void getSDCardStatus(){
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			File path = Environment.getExternalStorageDirectory();
			StatFs statFs = new StatFs(path.getPath());
			
			long blockSize = statFs.getBlockSizeLong();
			long blockCount = statFs.getBlockCountLong();
			long blockAvailable = statFs.getAvailableBlocksLong();
			
			sdCardSize = blockSize * blockCount;
			sdCardAvailable = blockAvailable * blockCount;
		}
	}

	/**
	 * 获取内部存储
	 */
	@SuppressLint("NewApi")
	public static void getDiskStatus(){
		File root = Environment.getRootDirectory();   
		StatFs statFs = new StatFs(root.getPath());
		

		long blockSize = statFs.getBlockSizeLong();
		long blockCount = statFs.getBlockCountLong();
		long blockAvailable = statFs.getAvailableBlocksLong();
		
		diskSize = blockSize * blockCount;
		diskAvailable = blockAvailable * blockCount;
	}
	
	public static String[] getCpuInfo() {  
	    String str1 = "/proc/cpuinfo";  
	    String str2="";  
	    String[] cpuInfo={"",""};  
	    String[] arrayOfString;  
	    try {  
	        FileReader fr = new FileReader(str1);  
	        BufferedReader localBufferedReader = new BufferedReader(fr, 8192);  
	        str2 = localBufferedReader.readLine();  
	        arrayOfString = str2.split("\\s+");  
	        for (int i = 2; i < arrayOfString.length; i++) {  
	            cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";  
	        }  
	        str2 = localBufferedReader.readLine();  
	        arrayOfString = str2.split("\\s+");  
	        cpuInfo[1] += arrayOfString[2];  
	        localBufferedReader.close();  
	    } catch (IOException e) {  
	    }  
	    return cpuInfo;  
	} 
	
}
