package com.example.baseActivity;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {
	private static MyApplication myApplication;
	private List<Activity> activities;

	private MyApplication() {
		activities = new LinkedList<Activity>();
	}

	public static MyApplication getIntance() {
		if (myApplication == null) {
			myApplication = new MyApplication();
		}
		return myApplication;
	}

	public void addActivty(Activity activity) {
		if (activities != null | activities.size() >= 0) {
			if (!activities.contains(activity)) {
				activities.add(activity);
			}
		} else {
			activities.add(activity);
		}
	}

	public void exit() {
		if (activities != null && activities.size() != 0) {
			for (Activity activity : activities) {
				activity.finish();
			}
			System.exit(0);
		}
	}
}
