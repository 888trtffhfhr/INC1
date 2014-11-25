package com.example.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.activity.HeaderDailedActivity;
import com.example.activity.MainActivity;
import com.example.activity.NewFoodActivity;
import com.example.adapter.MainListAdapter;
import com.example.config.UrlUtils;
import com.example.mainpager.net.EventCard;
import com.example.mainpager.net.JSONUtils;
import com.example.mainpager.net.MediaCard;
import com.example.mainpager.net.Module;
import com.example.mainpager.net.PicCard;
import com.example.mainpager.net.TitleCard;
import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.widget.WidgetUtils;

public class MainPageFragment extends Fragment {
	/**
	 * 头视图
	 */

	@ViewInject(R.id.headview)
	private ImageView headView;

	@ViewInject(R.id.time)
	private TextView timeTextView;

	@ViewInject(R.id.title)
	private TextView titleTextView;

	@ViewInject(R.id.count)
	private TextView countTextView;
	/**
	 * 制定推荐
	 */

	@ViewInject(R.id.recommendText)
	private TextView recommendText;

	@ViewInject(R.id.recommendIcon)
	private ImageView recommendIcon;

	@ViewInject(R.id.recommendTitle)
	private TextView recommendTitle;

	@ViewInject(R.id.recommendContent)
	private TextView recommendContent;
	/**
	 * 北京最新美食
	 */

	@ViewInject(R.id.newFoodLocation)
	private TextView newFoodLocation;
	/**
	 * 编辑精选
	 */

	@ViewInject(R.id.listview)
	private ListView listview;
	private MainListAdapter adapter;

	private MainActivity mainActivity;

	/**
	 * 得到的网络数据
	 */
	Module module;
	private BitmapUtils bitmapUtils;
	private String detailedPageUrl;
	private String recommendUrl;
	private String newFoodUrl;

	@ViewInject(R.id.swipe_container)
	private android.support.v4.widget.SwipeRefreshLayout swipe_container;
	private View headLayout;

	/**
	 * 
	 * 这两个数据实现了数据的懒加载
	 */
	private boolean isPrepared;
	private boolean isVisible;

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		isVisible = isVisibleToUser;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		headLayout = LayoutInflater.from(getActivity()).inflate(
				R.layout.mainpage_headview, null);
		isPrepared = true;
		return inflater.inflate(R.layout.fragment_mainpage, container, false);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mainActivity = (MainActivity) getActivity();
		ViewUtils.inject(this, view);
		listview.addHeaderView(headLayout);
		ViewUtils.inject(this, headLayout);
		/**
		 * 第一次加载数据
		 */
		loadInitData();
		setRefresh();
		bitmapUtils = new BitmapUtils(getActivity());
		adapter = new MainListAdapter(getActivity(), bitmapUtils);

		listview.setOnScrollListener(new PauseOnScrollListener(bitmapUtils,
				false, true));
		listview.setAdapter(adapter);
	}

	@OnClick({ R.id.frame, R.id.recommend, R.id.newFood, R.id.newFoodDetailed })
	public void Click(View view) {
		switch (view.getId()) {
		case R.id.frame:
			Bundle bundle = new Bundle();
			bundle.putString("headerdetailed", detailedPageUrl);
			mainActivity.openActivity(HeaderDailedActivity.class, bundle);
			break;
		case R.id.recommend:
			break;

		case R.id.newFood:
			Bundle newFood = new Bundle();
			newFood.putString("newfood", newFoodUrl);
			mainActivity.openActivity(NewFoodActivity.class, newFood);
			break;
		case R.id.newFoodDetailed:
			// Bundle SecondFood = new Bundle();
			// SecondFood
			// .putString(
			// "newfood",
			// "https://api.shiseapp.com/v2/timeline/city/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.0371,116.369245&_city=&_channel=wandoujia");
			// mainActivity.openActivity(DetailedPageActivity.class,
			// SecondFood);
			break;

		default:
			break;
		}
	}

	public void setDatas(Module module) {
		this.module = module;
		EventCard eventCard = module.getEventCard();
		String eventCard_pic_show = eventCard.getPic_show();
		String eventCard_title = eventCard.getTitle();
		String eventCard_remain = eventCard.getRemain();
		int eventCard_remainTime = Integer.parseInt(eventCard_remain);
		String eventCard_time = WidgetUtils.remainTime(eventCard_remainTime);
		String eventCard_count = eventCard.getDesc();
		detailedPageUrl = eventCard.getDetail_show().get(2);

		bitmapUtils.display(headView, eventCard_pic_show);
		timeTextView.setText(eventCard_time);
		titleTextView.setText(eventCard_title);
		countTextView.setText(eventCard_count);
		// ////
		PicCard picCard = module.getPicCard();
		String pic_title = picCard.getTitle();
		String pic_desc = picCard.getDesc();
		recommendUrl = picCard.getUrl();
		String pic_recommendTag = picCard.getRecommendTag();

		List<String> pic_show = picCard.getPic_show();
		String pic_url = pic_show.get(0);
		int pic_width = Integer.parseInt(pic_show.get(1));
		int pic_height = Integer.parseInt(pic_show.get(2));
		bitmapUtils.display(recommendIcon, pic_url);

		// RelativeLayout.LayoutParams recommendIcon_layoutParams = new
		// RelativeLayout.LayoutParams(
		// pic_width, pic_height);
		// recommendIcon.setLayoutParams(recommendIcon_layoutParams);
		recommendTitle.setText(pic_title);
		recommendContent.setText(pic_desc);
		recommendText.setText(pic_recommendTag);
		// /////
		TitleCard titleCard = module.getTitleCard();
		String title_title = titleCard.getTitle();
		newFoodUrl = titleCard.getDetail_show().get(1);
		newFoodLocation.setText(title_title);
		// /////
		List<MediaCard> mediaCards = module.getMediaCard();

		adapter.setDatas(mediaCards);
	}

	/**
	 * 设置刷新
	 */
	private void setRefresh() {
		swipe_container.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
		swipe_container.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				swipe_container.setRefreshing(true);
				loadData();
			}
		});
	}

	public void loadInitData() {
		// System.out.println(isPrepared + "''''''''''" + isVisible);
		// if (isPrepared && isVisible) {
		loadData();
		// }
	}

	/**
	 * 获取首页网络数据
	 */
	public void loadData() {
		// if (mainActivity.getDataCache("mainPage").equals("isFirst")) {
		// background.setVisibility(View.VISIBLE);
		// progressDialog.setVisibility(View.VISIBLE);
		if (mainActivity != null) {
			showLoading();
			if (mainActivity.hasNetWork()) {
				HttpUtils httpUtils = new HttpUtils();
				httpUtils.send(HttpMethod.GET, UrlUtils.MAINPAGE, null,
						new RequestCallBack<String>() {
							@Override
							public void onSuccess(
									ResponseInfo<String> responseInfo) {
								Module module = JSONUtils
										.parseJSON(responseInfo.result);
								mainActivity.setDataCache("mainPage",
										"isSecond");
								if (module != null) {
									MainPageFragment.this.setDatas(module);
									cancleLoading();
								}

							}

							@Override
							public void onFailure(HttpException error,
									String msg) {
								System.err.println("第一个失败了");
								// cancleLoading();
								mainActivity.showShortToast("请检查网络");
							}
						});
			} else {
				// cancleLoading();
				mainActivity.showShortToast("请检查网络");
			}
		} else {
		}

	}

	private void cancleLoading() {
		swipe_container.setRefreshing(false);
		mainActivity.cancelLoading();
	}

	private void showLoading() {
		mainActivity.showLoading();

	}

}
