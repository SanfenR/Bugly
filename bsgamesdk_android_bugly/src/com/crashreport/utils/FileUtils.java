package com.crashreport.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import android.content.Context;
import android.os.Environment;

public class FileUtils {
	
	public String read(Context context, String filename){
		
		String ret = null;
		FileInputStream fis = null;
		try {
			
			String status = Environment.getExternalStorageState();
			if (status.equals(Environment.MEDIA_MOUNTED)) {
				File file =new File(Environment.getExternalStorageDirectory().toString() + filename) ;
				
				if (!file.exists()) {
					return ret;
				}
				
				fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				
				String len;
				
				StringBuilder sb = new StringBuilder();
				while((len = br.readLine())!= null){
					sb.append(len);
				}
				
				
				ret = sb.toString();	
			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			close(fis);
		}
		
		return ret;
		
	}
	
	public void write(Context context, String filename, String str){
		PrintWriter pw = null;
		
		try {
		
			String status = Environment.getExternalStorageState();
			
			if (status.equals(Environment.MEDIA_MOUNTED)) {
				File file = new File(Environment.getExternalStorageDirectory().toString() + filename) ;
				
				if (!file.exists()) {
					file.createNewFile();
				}
				
				pw = new PrintWriter(file);
				
				pw.print(str);
				
				pw.flush();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pw);
		}
		
	}
	
	
	public void close(Object object) {
		try {
			if (object == null) {
				return;
			} else if (object instanceof InputStream) {
				((InputStream) object).close();
			} else if (object instanceof OutputStream){
				((OutputStream) object).close();
			} else if (object instanceof Writer) {
				((Writer) object).close();
			} else if (object instanceof Reader) {
				((Reader) object).close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
