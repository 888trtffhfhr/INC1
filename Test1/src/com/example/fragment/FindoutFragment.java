package com.example.fragment;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.callback.MainToFindOut;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.example.test1.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.meg7.widget.CustomShapeImageView;
import com.widget.WidgetUtils;

public class FindoutFragment extends Fragment implements MainToFindOut {

	private int count = 0;
	private Timer timer;

	@ViewInject(R.id.smallImageView)
	private ImageView smallImageView;

	@ViewInject(R.id.showText)
	private TextView showText;

	@ViewInject(R.id.numberbar1)
	private NumberProgressBar numberbar1;

	@ViewInject(R.id.cancle)
	private ImageView cancle;

	@ViewInject(R.id.shareView)
	private LinearLayout shareView;

	@ViewInject(R.id.stateList)
	private ListView stateList;

	@ViewInject(R.id.loadingLayout)
	private View loadingLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_findout, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ViewUtils.inject(this, view);
		timer = new Timer();

	}

	@Override
	public void setImageCallBack(Bitmap bitmap) {
		if (bitmap != null) {
			loadingLayout.setVisibility(View.VISIBLE);
			if (smallImageView != null) {
				smallImageView.setImageBitmap(bitmap);

				WidgetUtils.IMAGE_COUNT++;
				setTime();
				stateList.setAdapter(new MyAdapter(getActivity(), bitmap));
			} else {
			}
		} else {
		}

	}

	public void setTime() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				getActivity().runOnUiThread(new Runnable() {
					@Override
					public void run() {
						numberbar1.incrementProgressBy(1);
						count++;
						if (count == 101) {
							numberbar1.setVisibility(View.INVISIBLE);
							timer.cancel();
							showText.setText("上传完成!分享到:");
							cancle.setVisibility(View.VISIBLE);
							shareView.setVisibility(View.VISIBLE);
							cancle.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View arg0) {
									loadingLayout.setVisibility(View.GONE);

								}
							});
						}
					}
				});
			}
		}, 0, 70);

	}
}

class MyAdapter extends BaseAdapter {
	private Context context;
	private Bitmap bitmap;

	public MyAdapter(Context context, Bitmap bitmap) {
		this.context = context;
		this.bitmap = bitmap;
	}

	@Override
	public int getCount() {

		return WidgetUtils.IMAGE_COUNT;
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
			convertView = LayoutInflater.from(context).inflate(
					R.layout.mainpage_item, null);
			viewHolder = new ViewHolder();
			viewHolder.userhead = (CustomShapeImageView) convertView
					.findViewById(R.id.userhead);
			viewHolder.usernameTextView = (TextView) convertView
					.findViewById(R.id.username);
			viewHolder.timeTextView = (TextView) convertView
					.findViewById(R.id.time);
			viewHolder.levelIcon = (ImageView) convertView
					.findViewById(R.id.levelIcon);
			viewHolder.imageview = (ImageView) convertView
					.findViewById(R.id.imageview);
			viewHolder.locationTextView = (TextView) convertView
					.findViewById(R.id.location);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.userhead.setImageResource(R.drawable.progress);
		viewHolder.usernameTextView.setText("VIP用户");
		viewHolder.timeTextView.setText(WidgetUtils.IMAGE_TIME / 60 / 60 / 24
				+ "");
		viewHolder.levelIcon.setImageResource(R.drawable.icon_rank_6);
		viewHolder.imageview.setImageBitmap(bitmap);
		viewHolder.locationTextView.setText("北京");

		return convertView;
	}

	private static class ViewHolder {
		private TextView iconTextView;
		private CustomShapeImageView userhead;
		private TextView usernameTextView;
		private TextView timeTextView;
		private ImageView levelIcon;
		private ImageView imageview;
		private TextView locationTextView;
	}
}
