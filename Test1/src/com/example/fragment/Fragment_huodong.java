package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.ListviewAdapter_huodong;
import com.example.huodong_javabean.Huodong_JSONUtil;
import com.example.huodong_javabean.Huodong_Moudle;
import com.example.test1.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class Fragment_huodong extends Fragment implements OnClickListener {
	private String url = "https://api.shiseapp.com/v2/timeline/event/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.032247,116.350004&_city=%E5%8C%97%E4%BA%AC&_channel=wandoujia";
	private ListView lv_huodong;
	private ListviewAdapter_huodong adapter;
	private View view;
	private Button back;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_huodong, container, false);
		initview();
		getData();
		return view;
	}

	private void initview() {
		lv_huodong = (ListView) view.findViewById(R.id.lv_huodong);
		adapter = new ListviewAdapter_huodong(getActivity());
		back = (Button) view.findViewById(R.id.back);
		back.setOnClickListener(this);
	}

	private void getData() {
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				Toast.makeText(getActivity(), "服务器在笑呵呵", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				String result = arg0.result;
				Huodong_Moudle moudle = new Huodong_JSONUtil()
						.parseJson(result);
				View v = LayoutInflater.from(getActivity()).inflate(
						R.layout.headview_huodong, null);
				TextView tv1 = (TextView) v
						.findViewById(R.id.tv_title_titlecard_huodong);
				tv1.setText(moudle.getTitleCard().getTitle());
				lv_huodong.addHeaderView(v);
				adapter.setDatas(moudle);
				lv_huodong.setAdapter(adapter);
				adapter.notifyDataSetChanged();

			}
		});

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.back:
			getActivity().getSupportFragmentManager().popBackStack();
			break;
		default:
			break;
		}

	}
}
