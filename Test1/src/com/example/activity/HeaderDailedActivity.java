package com.example.activity;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.OnekeyShare;

import com.example.adapter.HeaderDetailedListAdapter;
import com.example.baseActivity.BaseActivity;
import com.example.headerdetailed.net.HeaderDetailed_EventCard;
import com.example.headerdetailed.net.HeaderDetailed_JsonUtil;
import com.example.headerdetailed.net.HeaderDetailed_MediaCard;
import com.example.headerdetailed.net.HeaderDetailed_Module;
import com.example.headerdetailed.net.HeaderDetailed_UserCard;
import com.example.test1.R;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.meg7.widget.CustomShapeImageView;
import com.widget.SimpleFooter;
import com.widget.SimpleHeader;
import com.widget.WidgetUtils;
import com.widget.ZrcListView;
import com.widget.ZrcListView.OnStartListener;

public class HeaderDailedActivity extends BaseActivity {
	/**
	 * 头视图
	 */

	@ViewInject(R.id.headerDetailed_headview)
	private ImageView headerDetailed_headview;

	@ViewInject(R.id.headertime)
	private TextView timeTextView;

	@ViewInject(R.id.title)
	private TextView titleTextView;

	@ViewInject(R.id.count)
	private TextView countTextView;
	/**
	 * 专题用户信息
	 */
	@ViewInject(R.id.userhead)
	private CustomShapeImageView userhead;

	@ViewInject(R.id.username)
	private TextView username;

	@ViewInject(R.id.time)
	private TextView time;

	@ViewInject(R.id.levelIcon)
	private ImageView levelIcon;

	@ViewInject(R.id.content)
	private TextView content;
	/**
	 * 标题头
	 */

	@ViewInject(R.id.back)
	private Button back;

	@ViewInject(R.id.invite)
	private Button invite;

	/**
	 * 详情页面
	 */
	@ViewInject(R.id.listview)
	private ZrcListView zrcListView;

	/**
	 * 得到的网络数据
	 */
	HeaderDetailed_Module module;
	private BitmapUtils bitmapUtils;
	private HeaderDetailedListAdapter adapter;
	/**
	 * loading界面
	 */
	@ViewInject(R.id.background)
	private ImageView background;

	@ViewInject(R.id.google_progress)
	GoogleProgressBar progressDialog;

	/**
	 * 上一个页面传递的url
	 */
	private String headerdetailedURL;
	/**
	 * 添加头视图
	 */
	private View headLayout;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_headerdetailed);
		ViewUtils.inject(this);

		headerdetailedURL = getIntent().getExtras().getString("headerdetailed");
		headLayout = LayoutInflater.from(this).inflate(
				R.layout.headerdetailed_headview, null);
		zrcListView.addHeaderView(headLayout);
		ViewUtils.inject(this, headLayout);
		initZrcListView();
		/**
		 * 第一次加载数据
		 */
		loadData();
		/**
		 * 
		 * 初始化listview
		 */
		bitmapUtils = new BitmapUtils(this);
		adapter = new HeaderDetailedListAdapter(this, bitmapUtils);

		zrcListView.setAdapter(adapter);
	}

	@OnClick({ R.id.back, R.id.newFoodDetailed, R.id.invite, R.id.headerFrame })
	public void Click(View view) {
		switch (view.getId()) {
		case R.id.newFoodDetailed:
			Bundle SecondFood = new Bundle();
			SecondFood
					.putString(
							"newfood",
							"https://api.shiseapp.com/v2/timeline/city/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.0371,116.369245&_city=&_channel=wandoujia");

			this.openActivity(HeaderDailedActivity.class, SecondFood);
			break;
		case R.id.back:
			this.finish();
			break;
		// case R.id.headerFrame:
		// System.out.println(1);
		// Bundle detailedPager = new Bundle();
		// detailedPager.putString("headerURL", headerdetailedURL);
		// this.openActivity(DetailedPageActivity.class, detailedPager);
		// break;

		default:
			break;
		}
	}

	public void setDatas(HeaderDetailed_Module module) {
		this.module = module;
		HeaderDetailed_EventCard eventCard = module.getEventCard();
		String eventCard_pic_show = eventCard.getPic_show();
		String eventCard_title = eventCard.getTitle();
		String eventCard_remain = eventCard.getRemain();
		int eventCard_remainTime = Integer.parseInt(eventCard_remain);
		String eventCard_time = WidgetUtils.remainTime(eventCard_remainTime);
		String eventCard_count = eventCard.getDesc();

		bitmapUtils.display(headerDetailed_headview, eventCard_pic_show);
		timeTextView.setText(eventCard_time);
		titleTextView.setText(eventCard_title);
		countTextView.setText(eventCard_count);
		// ///////
		HeaderDetailed_UserCard userCard = module.getUserCard();
		String userCard_desc = userCard.getDesc();
		List<String> userCard_level = userCard.getLevel_show();
		String userCard_levelicon = userCard_level.get(1);
		List<String> userCard_user = userCard.getUser_show();
		String userCard_userhead = userCard_user.get(1);
		String userCard_username = userCard_user.get(0);
		String userCard_usertime = userCard_user.get(2);

		String userCard_content = module.getPicCard().getDesc();

		bitmapUtils.display(userhead, userCard_userhead);
		username.setText(userCard_username);

		time.setText("2014年" + userCard_desc + "前结束" + "\n" + userCard_usertime);
		bitmapUtils.display(levelIcon, userCard_levelicon);
		content.setText(userCard_content);

		// ///////
		List<HeaderDetailed_MediaCard> mediaCards = module.getMediaCard();
		adapter.setDatas(mediaCards);

	}

	/**
	 * 设置刷新
	 */
	public void initZrcListView() {
		zrcListView.setFirstTopOffset((int) (50 * getResources()
				.getDisplayMetrics().density));
		SimpleHeader header = new SimpleHeader(this);
		header.setTextColor(0xff33bbee);
		header.setCircleColor(0xff33bbee);
		zrcListView.setHeadable(header);
		SimpleFooter footer = new SimpleFooter(this);
		footer.setCircleColor(0xff33bbee);
		zrcListView.setFootable(footer);
		zrcListView.setItemAnimForTopIn(R.anim.topitem_in);
		zrcListView.setItemAnimForBottomIn(R.anim.bottomitem_in);
		zrcListView.setOnRefreshStartListener(new OnStartListener() {

			@Override
			public void onStart() {
				loadData();
			}

		});

	}

	/**
	 * 获取首页网络数据
	 * 
	 * @param headerdetailedURL
	 */
	public void loadData() {

		showLoading();

		if (this.hasNetWork()) {
			HttpUtils httpUtils = new HttpUtils();
			httpUtils.send(HttpMethod.GET, headerdetailedURL, null,
					new RequestCallBack<String>() {
						@Override
						public void onSuccess(ResponseInfo<String> responseInfo) {
							HeaderDetailed_Module module = HeaderDetailed_JsonUtil
									.parseJson(responseInfo.result);
							if (module != null) {
								zrcListView.setRefreshSuccess("成功了哦");
								HeaderDailedActivity.this.setDatas(module);
								cancleLoading();
							}
						}

						@Override
						public void onFailure(HttpException error, String msg) {
							System.err.println("第一个失败了");
							zrcListView.setRefreshFail("刷新失败了哦");
						}
					});
		} else {
			this.showShortToast("请检查网络");
			zrcListView.setRefreshFail("刷新失败了哦");
		}
	}

	private void cancleLoading() {
		progressDialog.setVisibility(View.GONE);
		background.setVisibility(View.GONE);
	}

	private void showLoading() {
		progressDialog.setVisibility(View.VISIBLE);
		background.setVisibility(View.VISIBLE);

	}

	@OnClick(R.id.invite)
	public void click(View view) {
		OnekeyShare oks = new OnekeyShare();

		// 分享时Notification的图标和文字
		oks.setNotification(R.drawable.ic_launcher,
				"ShareSDK notification content");
		// address是接收人地址，仅在信息和邮件使用
		oks.setAddress("12345678901");
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle("ShareSDK share title");
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl("http://sharesdk.cn");
		// text是分享文本，所有平台都需要这个字段
		oks.setText("ShareSDK share content");
		// imagePath是图片的本地路径，sdcard卡中图片地址
		// oks.setImagePath(MainActivity.TEST_IMAGE);
		// imageUrl是图片的网络路径，新浪微博、人人网、微信
		oks.setImageUrl("http://img.appgo.cn/imgs/sharesdk/content/2013/07/25/1374723172663.jpg");
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl("http://sharesdk.cn");
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("comment");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite("web site name");
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://sharesdk.cn");
		// latitude是维度数据，仅在新浪微博、腾讯微博和Foursquare使用
		oks.setLatitude(23.122619f);
		// longitude是经度数据，仅在新浪微博、腾讯微博和Foursquare使用
		oks.setLongitude(113.372338f);
		// 是否直接分享（true则直接分享），false是有九格宫，true没有
		oks.setSilent(false);

		oks.show(this);
	}
}
