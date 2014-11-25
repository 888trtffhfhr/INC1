package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attention.Attention_EventCard;
import com.example.attention.Attention_JSONUtil;
import com.example.attention.Attention_ListViewAdapter;
import com.example.attention.Attention_Module;
import com.example.attention.Attention_SeparatorCard;
import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class AttentionFragment extends Fragment implements OnClickListener {
	private ListView lv_find;
	private Attention_ListViewAdapter adapter;
	private String url = "https://api.shiseapp.com/v2/timeline/eventDiscover/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.0371,116.369245&_city=&_channel=wandoujia";
	private BitmapUtils bitmapUtils;

	private Button foodList;
	private Button activityList;
	private Button personList;
	private View headView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.attention_activity_main, container,
				false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		headView = LayoutInflater.from(getActivity()).inflate(
				R.layout.attention_headview, null);
		lv_find = (ListView) view.findViewById(R.id.lv_find);
		lv_find.addHeaderView(headView);
		foodList = (Button) view.findViewById(R.id.foodList);
		activityList = (Button) view.findViewById(R.id.activityList);
		personList = (Button) view.findViewById(R.id.personList);
		foodList.setOnClickListener(this);
		activityList.setOnClickListener(this);
		personList.setOnClickListener(this);
		initview();
		getData();
	}

	private void initview() {
		bitmapUtils = new BitmapUtils(getActivity());
		adapter = new Attention_ListViewAdapter(getActivity());
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
				Attention_Module module = new Attention_JSONUtil()
						.parseJson(result);
				adapter.setDatas(module);
				TextView tv2 = (TextView) headView
						.findViewById(R.id.tV2_headview);
				TextView tv1 = (TextView) headView
						.findViewById(R.id.tv1_headview);
				TextView tv3 = (TextView) headView
						.findViewById(R.id.tv3_headview);
				ImageView iv = (ImageView) headView
						.findViewById(R.id.iv1_headview);
				Attention_EventCard eventCard = module.getEventCard();
				Attention_SeparatorCard separatorCard = module
						.getSeparatorCard();
				tv2.setText(eventCard.getTitle());
				tv1.setText(eventCard.getDesc());
				tv3.setText(separatorCard.getTitle());
				String pic_url = eventCard.getPic_url();
				bitmapUtils.display(iv, pic_url);

				lv_find.setAdapter(adapter);
				adapter.notifyDataSetChanged();

			}
		});

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.foodList:
			FragmentTransaction foodListTransaction = getActivity()
					.getSupportFragmentManager().beginTransaction()
					.replace(R.id.main, new FoodListFragment());
			foodListTransaction.addToBackStack(null);
			foodListTransaction
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			foodListTransaction.commit();
			break;
		case R.id.activityList:
			FragmentTransaction huodongTransaction = getActivity()
					.getSupportFragmentManager().beginTransaction()
					.replace(R.id.main, new Fragment_huodong());
			huodongTransaction.addToBackStack(null);
			huodongTransaction
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			huodongTransaction.commit();
			break;
		case R.id.personList:
			FragmentTransaction transaction = getActivity()
					.getSupportFragmentManager().beginTransaction()
					.replace(R.id.main, new Ranting_Fragment());
			transaction.addToBackStack(null);
			transaction
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			transaction.commit();
			break;

		default:
			break;
		}
	}
}
