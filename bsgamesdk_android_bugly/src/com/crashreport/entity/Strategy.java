package com.crashreport.entity;

/**
 * 扩展参数
 */
public class Strategy {
	
	private boolean debug;
	private String appId;
	private String channelId;
	private String appVersion;
	private String appPackageName;
	private String appReportDelay;
	
	public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getAppPackageName() {
		return appPackageName;
	}
	public void setAppPackageName(String appPackageName) {
		this.appPackageName = appPackageName;
	}
	public String getAppReportDelay() {
		return appReportDelay;
	}
	public void setAppReportDelay(String appReportDelay) {
		this.appReportDelay = appReportDelay;
	}
	
	
	
	
}
