package com.widget;

import java.io.File;

import android.os.Environment;

public class WidgetUtils {
	public static String remainTime(int time) {
		float remainTime = time / 60 / 60 / 24;
		if (remainTime <= 0) {
			return "已经开始了";
		} else if (remainTime > 0 && remainTime <= 1) {
			return "还有1天结束";
		} else if (remainTime > 1 && remainTime <= 2) {
			return "还有2天结束";
		} else {
			return "活动已经结束";
		}
	}

	public static long IMAGE_TIME;
	public static int IMAGE_COUNT = 0;
	/**
	 * 从相机挑选图片的回传码
	 */
	public static final int REQUEST_CODE_PICK_IMAGE = 12;
	/**
	 * 拍照的回传码
	 */
	public static final int REQUEST_CODE_CAPTURE_CAMEIA = 13;

	public static boolean isSDKUsable() {
		return Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState());
	}

	public static File getImageFile(String imageName) {
		return new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),
				imageName);
	}
}
