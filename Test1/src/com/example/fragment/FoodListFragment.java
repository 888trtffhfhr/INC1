package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.FoodList_Adapter;
import com.example.foodList_bean.FoodList_Module;
import com.example.foodList_bean.FoodList_PicJsonUtils;
import com.example.test1.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class FoodListFragment extends Fragment implements OnClickListener {
	private ListView food_listview;
	private View view;
	private FoodList_Adapter adapter;
	private String URL = "https://api.shiseapp.com/v2/slist/feature/lst/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.032247,116.350004&_city=%E5%8C%97%E4%BA%AC&_channel=wandoujia";
	private Button back;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.foodlist_fragment, container, false);
		food_listview = (ListView) view.findViewById(R.id.food_listview);
		back = (Button) view.findViewById(R.id.back);
		back.setOnClickListener(this);
		adapter = new FoodList_Adapter(getActivity());
		getData();
		return view;
	}

	private void getData() {

		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, URL, null,
				new RequestCallBack<String>() {
					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {
						String result = responseInfo.result;
						FoodList_Module module = new FoodList_PicJsonUtils()
								.parseJson(result);
						if (module != null) {
							adapter.setDatas(module);
						}
						food_listview.setAdapter(adapter);
						adapter.notifyDataSetChanged();
					}

					@Override
					public void onFailure(HttpException error, String msg) {
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