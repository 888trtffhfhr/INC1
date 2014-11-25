package com.example.activity;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.baseActivity.BaseActivity;
import com.example.test1.R;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.tiger.quicknews.wedget.discrollview.DiscrollView;

public class WelcomeActivity extends BaseActivity {

	@ViewInject(R.id.layout)
	private DiscrollView mDiscrollView;
	@ViewInject(R.id.lastView3)
	private Button mButton;
	private DbUtils database;
	private DBConfig config;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		database = DbUtils.create(this, "config");
		ViewUtils.inject(this);
		initView();
	}

	public void initView() {
		mDiscrollView.setVisibility(View.VISIBLE);
		List<DBConfig> findAll;
		try {
			findAll = database.findAll(DBConfig.class);
			if (findAll != null) {

				for (int i = 0; i < findAll.size(); i++) {
					if (!findAll.get(i).isFirst) {
						mDiscrollView.setVisibility(View.GONE);
						System.out.println("不是第一次了");
						openActivity(MainActivity.class);
					} else {
						System.out.println(findAll.get(i) + "到这里了");
						mDiscrollView.setVisibility(View.VISIBLE);
					}
				}
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@OnClick(R.id.lastView3)
	public void startApp(View view) {
		config = new DBConfig();
		config.setFirst(false);
		try {
			database.save(config);
			openActivity(MainActivity.class);

		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}
