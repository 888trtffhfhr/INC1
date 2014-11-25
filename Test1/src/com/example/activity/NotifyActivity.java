package com.example.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.baseActivity.BaseActivity;
import com.example.test1.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class NotifyActivity extends BaseActivity {

	@ViewInject(R.id.listview)
	private ListView listView;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_notify);
		ViewUtils.inject(this);
		NotifyAdapter adapter = new NotifyAdapter();
		listView.setAdapter(adapter);
		// listView.setScrollbarFadingEnabled(false);
	}

	@OnClick(R.id.back)
	public void click(View view) {
		switch (view.getId()) {
		case R.id.back:
			this.finish();
			break;

		default:
			break;
		}
	}

	private class NotifyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			ViewHolder viewHolder;
			if (convertView == null) {
				viewHolder = new ViewHolder();
				convertView = LayoutInflater.from(NotifyActivity.this).inflate(
						R.layout.notify_list, null);
				viewHolder.icImageView = (ImageView) convertView
						.findViewById(R.id.icon);
				viewHolder.textView = (TextView) convertView
						.findViewById(R.id.textView1);

			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}

			if (position == 0) {
				viewHolder.icImageView
						.setImageResource(R.drawable.btn_notification_comment);
				viewHolder.textView.setText("评论");
			} else if (position == 1) {
				viewHolder.icImageView
						.setImageResource(R.drawable.btn_notification_like);
				viewHolder.textView.setText("赞");
			} else if (position == 2) {
				viewHolder.icImageView
						.setImageResource(R.drawable.btn_notification_notice);
				viewHolder.textView.setText("通知");
			}

			return convertView;
		}

	}

	private static class ViewHolder {
		private ImageView icImageView;
		private TextView textView;
	}

}
