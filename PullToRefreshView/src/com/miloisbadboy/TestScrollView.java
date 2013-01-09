package com.miloisbadboy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.miloisbadboy.view.PullToRefreshView;
import com.miloisbadboy.view.PullToRefreshView.OnFooterRefreshListener;
import com.miloisbadboy.view.PullToRefreshView.OnHeaderRefreshListener;

public class TestScrollView extends Activity implements
		OnHeaderRefreshListener, OnFooterRefreshListener {
	PullToRefreshView mPullToRefreshView;
	TextView textview;
	String text = "http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/http://miloisbadboy.com/";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_scrollview);
		
		mPullToRefreshView = (PullToRefreshView) findViewById(R.id.main_pull_refresh_view);
		textview = (TextView)findViewById(R.id.textview);
		textview.setText(text);
		
		mPullToRefreshView.setOnHeaderRefreshListener(this);
		mPullToRefreshView.setOnFooterRefreshListener(this);

	}

	@Override
	public void onFooterRefresh(PullToRefreshView view) {
		mPullToRefreshView.postDelayed(new Runnable() {

			@Override
			public void run() {
				mPullToRefreshView.onFooterRefreshComplete();
			}
		}, 1000);
	}

	@Override
	public void onHeaderRefresh(PullToRefreshView view) {
		mPullToRefreshView.postDelayed(new Runnable() {

			@Override
			public void run() {
				// 设置更新时间
				//mPullToRefreshView.onHeaderRefreshComplete("最近更新:01-23 12:01");
				mPullToRefreshView.onHeaderRefreshComplete();
			}
		}, 1000);

	}
}
