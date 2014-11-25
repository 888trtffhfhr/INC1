package com.example.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.ShareSDK;

import com.example.adapter.MainPageAdapter;
import com.example.baseActivity.BaseActivity;
import com.example.baseActivity.MyApplication;
import com.example.fragment.AttentionFragment;
import com.example.fragment.FindoutFragment;
import com.example.fragment.MainPageFragment;
import com.example.fragment.UserFragment;
import com.example.test1.R;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;
import com.widget.WidgetUtils;

public class MainActivity extends BaseActivity implements OnClickListener {
	private boolean isPressed;
	private double preTime = 0;
	private ViewPager viewPager;
	private List<Fragment> fragments;
	private MainPageAdapter mainPageAdapter;
	private Button add;
	private Button notify;
	private Button setting;
	private ImageView line;
	private LinearLayout.LayoutParams linearLayout;
	private int prePosition;

	private TextView mainpage;
	private TextView attention;
	private TextView findout;
	private TextView user;
	private ImageView background;
	GoogleProgressBar progressDialog;
	private MainPageFragment mainPageFragment;
	private AttentionFragment attentionFragment;
	private FindoutFragment findoutFragment;
	private UserFragment userFragment;
	private Button photoButton;

	private final static int MAIN_PAGE = 0;
	private final static int ATTENTION_PAGE = 1;
	private final static int FINDOUT_PAGE = 2;
	private final static int USER_PAGE = 3;

	private String imageName;
	private File imageFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ShareSDK.initSDK(this);
		initView();
		initFragment();
		initAdapter();
	}

	public void showLoading() {
		progressDialog.setVisibility(View.VISIBLE);
		background.setVisibility(View.VISIBLE);
	}

	public void cancelLoading() {
		progressDialog.setVisibility(View.GONE);
		background.setVisibility(View.GONE);
	}

	private void initView() {
		photoButton = (Button) findViewById(R.id.photo);
		photoButton.setOnClickListener(this);
		background = (ImageView) findViewById(R.id.background);
		progressDialog = (GoogleProgressBar) findViewById(R.id.google_progress);

		viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setOffscreenPageLimit(4);
		add = (Button) findViewById(R.id.add);
		notify = (Button) findViewById(R.id.notify);
		setting = (Button) findViewById(R.id.setting);
		line = (ImageView) findViewById(R.id.line);

		linearLayout = (android.widget.LinearLayout.LayoutParams) line
				.getLayoutParams();
		linearLayout.width = getScreenWidth() / 4;
		line.setLayoutParams(linearLayout);

		add.setOnClickListener(this);
		notify.setOnClickListener(this);
		setting.setOnClickListener(this);

		mainpage = (TextView) findViewById(R.id.mainpage);
		attention = (TextView) findViewById(R.id.attention);
		findout = (TextView) findViewById(R.id.findout);
		user = (TextView) findViewById(R.id.user);

		mainpage.setOnClickListener(this);
		attention.setOnClickListener(this);
		findout.setOnClickListener(this);
		user.setOnClickListener(this);

	}

	private void initFragment() {
		this.setDataCache("mainPage", "isFirst");
		fragments = new ArrayList<Fragment>();
		mainPageFragment = new MainPageFragment();
		attentionFragment = new AttentionFragment();
		findoutFragment = new FindoutFragment();
		userFragment = new UserFragment();
		fragments.add(mainPageFragment);
		fragments.add(attentionFragment);
		fragments.add(findoutFragment);
		fragments.add(userFragment);
	}

	private void initAdapter() {
		mainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
		mainPageAdapter.setFragment(fragments);
		viewPager.setAdapter(mainPageAdapter);

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				prePosition = position;
				switch (position) {
				case 0:
					// mainPageFragment.loadData();
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int position, float arg1,
					int positionOffsetPixels) {
				if (prePosition == position) {
					// 正向滑动
					linearLayout.leftMargin = positionOffsetPixels / 4
							+ prePosition * getScreenWidth() / 4;
				} else {
					// 反向滑动
					linearLayout.leftMargin = -(getScreenWidth() - positionOffsetPixels)
							/ 3 + prePosition * getScreenWidth() / 4;
				}
				line.setLayoutParams(linearLayout);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.mainpage:
			viewPager.setCurrentItem(MAIN_PAGE);
			break;
		case R.id.attention:
			viewPager.setCurrentItem(ATTENTION_PAGE);
			break;
		case R.id.findout:
			viewPager.setCurrentItem(FINDOUT_PAGE);
			break;
		case R.id.user:
			viewPager.setCurrentItem(USER_PAGE);
			break;

		case R.id.add:
			new AlertDialog.Builder(this).setItems(new String[] { "扫一扫" },
					new AlertDialog.OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int position) {
							switch (position) {
							case 0:
								openActivity(CaptureActivity.class);
								break;

							default:
								break;
							}
						}

					}).show();

			break;
		case R.id.notify:
			openActivity(NotifyActivity.class);
			break;
		case R.id.setting:
			break;
		case R.id.photo:
			new AlertDialog.Builder(this).setItems(
					new String[] { "从相册中获取美食图片", "使用相机拍出美食" },
					new AlertDialog.OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int index) {
							switch (index) {
							case 0:
								Intent galleryIntent = new Intent(
										Intent.ACTION_PICK);
								galleryIntent.setType("image/*");
								startActivityForResult(galleryIntent,
										WidgetUtils.REQUEST_CODE_PICK_IMAGE);
								break;
							case 1:
								long time = System.currentTimeMillis();
								WidgetUtils.IMAGE_TIME = time;
								imageName = time + ".jpg";

								Intent cameraIntent = new Intent();
								cameraIntent
										.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
								if (!WidgetUtils.isSDKUsable()) {
									Toast.makeText(MainActivity.this, "SDK不可用",
											Toast.LENGTH_SHORT).show();
								} else {

									imageFile = WidgetUtils
											.getImageFile(imageName);
									cameraIntent.putExtra(
											MediaStore.EXTRA_OUTPUT,
											Uri.fromFile(imageFile));
									startActivityForResult(
											cameraIntent,
											WidgetUtils.REQUEST_CODE_CAPTURE_CAMEIA);
								}
								break;

							default:
								break;
							}
						}
					}).show();
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == WidgetUtils.REQUEST_CODE_CAPTURE_CAMEIA) {

			Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getPath());
			// 这只是一个压缩的效果
			bitmap = loadBigBitmap(imageFile.getPath(), 200, 200);
			// 裁剪
			Intent i = new Intent("com.android.camera.action.CROP");
			i.setDataAndType(Uri.fromFile(imageFile), "image/*");
			i.putExtra("aspectX", 1);
			i.putExtra("aspectY", 1);
			i.putExtra("outputX", 200);
			i.putExtra("outputY", 200);
			i.putExtra("scale", true);
			i.putExtra("return-data", true);
			startActivityForResult(i, RESULT_FIRST_USER);
		}
		if (data != null) {
			if (requestCode == WidgetUtils.REQUEST_CODE_PICK_IMAGE) {
				Bitmap bm = null;
				// 外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
				ContentResolver resolver = getContentResolver();
				// 此处的用于判断接收的Activity是不是你想要的那个
				try {
					viewPager.setCurrentItem(FINDOUT_PAGE);
					Uri originalUri = data.getData(); // 获得图片的uri
					bm = MediaStore.Images.Media.getBitmap(resolver,
							originalUri);
					findoutFragment.setImageCallBack(bm);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} // 显得到bitmap图片

			} else if (requestCode == RESULT_FIRST_USER) {
				viewPager.setCurrentItem(FINDOUT_PAGE);
				Bitmap cropBitmap = data.getParcelableExtra("data");
				findoutFragment.setImageCallBack(cropBitmap);
			} else if (requestCode == RESULT_CANCELED) {
				viewPager.setCurrentItem(MAIN_PAGE);
			}
		}

		else {
			viewPager.setCurrentItem(MAIN_PAGE);
		}

	}

	/**
	 * 压缩
	 * 
	 * @param path
	 * @param i
	 * @param j
	 * @return
	 */
	private Bitmap loadBigBitmap(String path, int i, int j) {
		Options options = new Options();
		BitmapFactory.decodeFile(path, options);
		int height = options.outHeight;
		int width = options.outWidth;
		int size = 1;
		while (height / i > size || width / j > size) {
			size++;
		}
		options.inSampleSize = size;
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeFile(path, options);
	}

	@Override
	public void onBackPressed() {
		this.showLongToast("你确定退出么,再次点击退出", R.id.toast);
		if (isPressed && preTime + 2000 > System.currentTimeMillis()) {
			MyApplication.getIntance().exit();
		} else {
			isPressed = true;
			preTime = System.currentTimeMillis();
		}
	}

}
