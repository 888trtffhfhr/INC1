package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baseActivity.BaseActivity;
import com.example.newfood.net.NewFoodAdapter;
import com.example.newfood.net.NewFood_JSONutil_wy;
import com.example.newfood.net.NewFood_Module;
import com.example.test1.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class NewFoodActivity extends BaseActivity {

	private ListView lv;
	private NewFood_Module module;
	private NewFoodAdapter adapter;
	private View header;
	private TextView prePager;
	private TextView selectCity;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newfood);

		initview();
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		url = bundle.getString("newfood");
		getData();
	}

	private void initview() {
		lv = (ListView) findViewById(R.id.lv_beijing);
		prePager = (TextView) findViewById(R.id.prePager);
		selectCity = (TextView) findViewById(R.id.selectCity);

		prePager.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				NewFoodActivity.this.finish();
			}
		});

		selectCity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Intent intent=new
				// Intent(NewFoodActivity.this,CityActivity.class);
				//
				// startActivityForResult(intent, 0);
			}
		});

	}

	private void getData() {
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {
			@Override
			public void onFailure(HttpException arg0, String arg1) {
				Toast.makeText(NewFoodActivity.this, "服务器睡着了",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				String result = arg0.result;
				module = new NewFood_JSONutil_wy().parseJson(result);
				adapter = new NewFoodAdapter(NewFoodActivity.this);
				adapter.setDatas(module);
				lv.setAdapter(adapter);
				adapter.notifyDataSetChanged();

			}
		});
	}
}
