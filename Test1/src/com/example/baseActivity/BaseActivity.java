package com.example.baseActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;

import com.example.cache.ACache;
import com.example.config.HttpUtil;
import com.example.slidingWedget.IntentUtils;
import com.tiger.quicknews.wedget.crouton.Crouton;
import com.tiger.quicknews.wedget.crouton.Style;

/**
 * @author 菲克
 * 
 */
public class BaseActivity extends FragmentActivity {
	private Dialog progressDialog;
	private boolean isPressed;
	private double preTime = 0;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		MyApplication.getIntance().addActivty(this);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		return super.onCreateView(parent, name, context, attrs);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	// //////////activity中的传值操作
	/**
	 * 
	 * 携带自定义Activity切换效果的启动Activity
	 * 
	 * @param anotherClass
	 */
	public void openActivity(Class<?> anotherClass, Bundle bundle) {
		openActivity(anotherClass, bundle, 0);
	}

	public void openActivity(Class<?> anotherClass) {
		openActivity(anotherClass, null, 0);
	}

	public void openAcitivity(Class<?> anotherClass, int requestCode) {
		openActivity(anotherClass, null, requestCode);
	}

	public void openActivity(Class<?> anotherClass, Bundle bundle,
			int requestCode) {
		Intent intent = new Intent(this, anotherClass);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		if (requestCode == 0) {
			IntentUtils.startPreviewActivity(this, intent, 0);
		} else {
			IntentUtils.startPreviewActivity(this, intent, requestCode);
		}
	}

	public DisplayMetrics getDisplayMetrics() {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics;
	}

	public int getScreenWidth() {
		return getDisplayMetrics().widthPixels;

	}

	public int getScreenHeight() {
		return getDisplayMetrics().heightPixels;
	}

	// ////////经常在activity中的操作

	/**
	 * 
	 * 显示加载信息页面
	 */
	// public void showProgressDialog() {
	// if (progressDialog == null) {
	// progressDialog = DialogUtils.createLoadingDialog(this);
	// }
	// progressDialog.show();
	// }
	/**
	 * 
	 * 取消加载信息页面
	 */
	public void dismissProgressDialog() {
		if (ProgressDialogIsShow()) {
			progressDialog.dismiss();
		}
	}

	public boolean ProgressDialogIsShow() {
		if (progressDialog != null && progressDialog.isShowing()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 监测网络状态
	 * 
	 * @return
	 */
	public boolean hasNetWork() {
		return HttpUtil.isNetworkAvailable(this);
	}

	/**
	 * 
	 * 自定义Toast
	 * 
	 * @param message
	 */
	public void showShortToast(String message) {
		Crouton.makeText(this, message, Style.CONFIRM).show();
	}

	public void showLongToast(String message, int id) {
		Crouton.makeText(this, message, Style.CONFIRM, id).show();
	}

	/**
	 * 
	 * 存储临时的字符串数据,类似于SharedPreference
	 * 
	 * @param key
	 * @param value
	 */
	public void setDataCache(String key, String value) {
		if (TextUtils.isEmpty(value) && TextUtils.isEmpty(key)) {
			ACache.get(this).put(key, value);
		}
	}

	/**
	 * 
	 * 取出临时数据
	 * 
	 * @param key
	 * @return
	 */
	public String getDataCache(String key) {
		return ACache.get(this).getAsString(key);
	}

	/**
	 * 
	 * 退回键
	 * 
	 * @param view
	 */
	public void doBack(View view) {
		onBackPressed();

	}
}
