package com.example.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.sina.weibo.SinaWeibo.ShareParams;

import com.etsy.android.grid.StaggeredGridView;
import com.example.detailedpager.net.DetailedAdapter;
import com.example.detailedpager.net.Detailedpage_JSONUtils;
import com.example.detailedpager.net.Detailedpage_Module;
import com.example.detailedpager.net.Detailedpage_card;
import com.example.detailedpager.net.Detailedpage_pics;
import com.example.mainpager.net.MediaModule;
import com.example.test1.R;
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

public class DetailedPageActivity extends Activity {

	@ViewInject(R.id.back)
	private Button back;

	@ViewInject(R.id.invite)
	private Button invite;

	@ViewInject(R.id.detailed_title)
	private ImageView detailed_title;

	@ViewInject(R.id.detailed_head)
	private CustomShapeImageView detailed_head;

	@ViewInject(R.id.detailed_username)
	private TextView detailed_username;

	@ViewInject(R.id.detailed_levelicon)
	private ImageView detailed_levelicon;

	@ViewInject(R.id.detailed_level)
	private TextView detailed_level;

	@ViewInject(R.id.detailed_time)
	private TextView detailed_time;

	@ViewInject(R.id.detailed_content)
	private TextView detailed_content;

	@ViewInject(R.id.detailed_show)
	private TextView detailed_show;

	@ViewInject(R.id.detailed_commentUser)
	private View detaield_commentUser;

	@ViewInject(R.id.user0)
	private CustomShapeImageView user0;

	@ViewInject(R.id.user1)
	private CustomShapeImageView user1;

	@ViewInject(R.id.user2)
	private CustomShapeImageView user2;

	@ViewInject(R.id.user3)
	private CustomShapeImageView user3;

	@ViewInject(R.id.user4)
	private CustomShapeImageView user4;

	@ViewInject(R.id.user5)
	private CustomShapeImageView user5;

	@ViewInject(R.id.user6)
	private CustomShapeImageView user6;

	@ViewInject(R.id.user7)
	private CustomShapeImageView user7;

	@ViewInject(R.id.detailed_check)
	private TextView detailed_check;

	@ViewInject(R.id.detailed_grid_view)
	private StaggeredGridView gridView;

	@ViewInject(R.id.detailed_eventInformation)
	private View detailed_eventInformation;

	@ViewInject(R.id.detailed_event)
	private TextView detailed_event;

	@ViewInject(R.id.detailed_endTime)
	private TextView detailed_endTime;

	@ViewInject(R.id.picInformation1)
	private ImageView picInformation1;

	@ViewInject(R.id.picInformation2)
	private ImageView picInformation2;

	@ViewInject(R.id.picInformation3)
	private ImageView picInformation3;

	private String aboutURL;
	private String objId;
	private BitmapUtils bitmapUtils;
	private DetailedAdapter detailedAdapter;
	private List<String> detailedList;
	private MediaModule mediaCard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_detaieldpage);
		ViewUtils.inject(this);
		bitmapUtils = new BitmapUtils(this);
		detailedAdapter = new DetailedAdapter(this, bitmapUtils);
		String URL = getIntent().getStringExtra("nextURL");
		String headerURL = getIntent().getStringExtra("headerURL");

		if (!TextUtils.isEmpty(URL)) {
			mediaCard = (MediaModule) getIntent().getSerializableExtra("value");
			download(URL);
		} else if (!TextUtils.isEmpty(headerURL)) {
			mediaCard = (MediaModule) getIntent().getSerializableExtra(
					"headervalue");
			download(headerURL);

		}
		initView();

	}

	private void initView() {
		if (mediaCard != null) {
			List<String> userList = mediaCard.getUser_show();
			bitmapUtils.display(detailed_head, userList.get(2));
			detailed_username.setText(userList.get(1));
			detailed_time.setText(mediaCard.getDesc());
			bitmapUtils.display(detailed_levelicon, mediaCard.getLevel_show()
					.get(1));
			bitmapUtils.display(detailed_title, mediaCard.getPic_show().get(0));
			detailed_content.setText(mediaCard.getContent());
		} else {
		}
	}

	public void download(String URL) {
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, URL, new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				Detailedpage_Module module = Detailedpage_JSONUtils
						.parseJSON(responseInfo.result);
				initView(module);

			}

			@Override
			public void onFailure(HttpException error, String msg) {

			}
		});
	}

	private void initView(Detailedpage_Module module) {
		List<String> userLikeList = module.getComment_likes_show();
		if (userLikeList != null && userLikeList.size() != 0) {
			ImageView[] userImageViews = { user0, user1, user2, user3, user4,
					user5, user6, user7 };
			for (int i = 0; i < 2; i++) {
				bitmapUtils.display(userImageViews[i], userLikeList.get(i));
			}
			detailed_show.setText(userLikeList.size()
					+ module.getComment_title().replace("%d", " "));
		}
		objId = module.getComment_objectId();

		detailed_check.setText(module.getAbout_title());
		aboutURL = module.getAbout_url();

		List<Detailedpage_card> cards = module.getTwocard();
		if (cards != null && cards.size() != 0) {
			detailedAdapter.bindDatas(cards);
			gridView.setAdapter(detailedAdapter);
		} else {
			gridView.setVisibility(View.GONE);
		}

		detailed_event.setText(module.getEvent_title());
		detailed_endTime.setText(module.getEvent_desc());

		List<Detailedpage_pics> pics = module.getEvent_pic();

		ImageView[] infoImageViews = { picInformation1, picInformation2,
				picInformation3 };
		detailedList = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			if (pics != null) {
				if (!TextUtils.isEmpty(pics.get(i).getUrl())) {
					bitmapUtils
							.display(infoImageViews[i], pics.get(i).getUrl());
					detailedList.add(pics.get(i).getDetailed_api());
				}
			}
		}
	}

	@OnClick({ R.id.invite, R.id.back })
	public void click(View view) {
		switch (view.getId()) {
		case R.id.invite:
			// 1 得到平台
			final Platform platform = ShareSDK
					.getPlatform(this, SinaWeibo.NAME);
			// 2 设置回调
			platform.setPlatformActionListener(new PlatformActionListener() {
				@Override
				public void onError(Platform arg0, int arg1, Throwable arg2) {
				}

				@Override
				public void onComplete(Platform arg0, int arg1,
						HashMap<String, Object> arg2) {
					if (arg1 == Platform.ACTION_AUTHORIZING) {
						// 登陆成功
						ShareParams params = new ShareParams();
						params.setText("这是来自千锋的微博！");
						params.setImagePath(Environment
								.getExternalStorageDirectory().getPath()
								+ "/screenshot.png");
						platform.share(params);

					} else if (arg1 == Platform.ACTION_SHARE) {
					}
				}

				@Override
				public void onCancel(Platform arg0, int arg1) {
				}
			});

			// 3 认证
			platform.authorize();
			break;
		case R.id.back:
			this.finish();
			break;
		default:
			break;
		}

	}
}
