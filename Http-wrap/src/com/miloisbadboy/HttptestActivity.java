package com.miloisbadboy;

import com.miloisbadboy.net.RequestException;
import com.miloisbadboy.net.RequestParameters;
import com.miloisbadboy.net.Utility;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class HttptestActivity extends Activity {
	private static final String TAG = "HttptestActivity";
	String url = "http://183.237.208.24/phone/news/hotWordAction!searchHotWordsJson.action";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new Thread(){
        	public void run(){
        		RequestParameters parameters = new RequestParameters();
        		try {
        			String rlt = Utility.openUrl(HttptestActivity.this, url, Utility.HTTPMETHOD_GET, parameters);
        			Log.i(TAG, rlt);
        		} catch (RequestException e) {
        			e.printStackTrace();
        		}
        	}
        	
        }.start();
    }
}