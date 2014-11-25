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

import com.example.adapter.Ranting_ListViewAdapter;
import com.example.ranting_javabean.Ranting_JSONUtil;
import com.example.ranting_javabean.Ranting_Moudle;
import com.example.test1.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class Ranting_Fragment extends Fragment implements OnClickListener {

	private String url = "https://api.shiseapp.com/v2/timeline/star/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.032247,116.350004&_city=%E5%8C%97%E4%BA%AC&_channel=wandoujia";
	private ListView lv_darenbang;
	private Ranting_ListViewAdapter adapter;
	private View view;
	private Button back;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.ranting_fragment, container, false);
		initview();
		getData();
		return view;
	}

	private void initview() {
		lv_darenbang = (ListView) view.findViewById(R.id.lv_darenbang);
		adapter = new Ranting_ListViewAdapter(getActivity());
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
				Ranting_Moudle moudle = new Ranting_JSONUtil()
						.parseJson(result);

				View v = LayoutInflater.from(getActivity()).inflate(
						R.layout.ranting_headview, null);
				TextView tv1 = (TextView) v
						.findViewById(R.id.tv_title_titlecard);
				TextView tv2 = (TextView) v
						.findViewById(R.id.tv_title_SeparatorCard);
				tv1.setText(moudle.getTitleCard().getTitle());
				tv2.setText(moudle.getSeparatorCard().getTitle());
				lv_darenbang.addHeaderView(v);
				adapter.setDatas(moudle);
				lv_darenbang.setAdapter(adapter);
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
