package com.example.detailedpager.net;

import java.util.List;
import java.util.Random;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;

public class DetailedAdapter extends BaseAdapter {
	private Context context;
	private List<Detailedpage_card> cards;
	private BitmapUtils bitmapUtils;
	private final Random mRandom;
	private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();

	public DetailedAdapter(Context context, BitmapUtils bitmapUtils) {
		this.bitmapUtils = bitmapUtils;
		this.context = context;
		mRandom = new Random();
	}

	public void bindDatas(List<Detailedpage_card> cards) {
		this.cards = cards;
	}

	@Override
	public int getCount() {
		return cards == null ? 0 : cards.size();
	}

	@Override
	public Object getItem(int arg0) {
		return cards.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.detailed_list, null);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) convertView
					.findViewById(R.id.imageview);
			viewHolder.textView1 = (TextView) convertView
					.findViewById(R.id.textview1);
			viewHolder.textView2 = (TextView) convertView
					.findViewById(R.id.textview2);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		// double positionHeight = getPositionRatio(position);
		// viewHolder.textView2.setHeightRatio(positionHeight);

		bitmapUtils.display(viewHolder.imageView, cards.get(position).getPic());
		viewHolder.textView1.setText(cards.get(position).getTitle());
		viewHolder.textView2.setText(cards.get(position).getDesc());
		return convertView;
	}

	private class ViewHolder {
		private ImageView imageView;
		private TextView textView1;
		private TextView textView2;
	}

	// private double getPositionRatio(final int position) {
	// double ratio = sPositionHeightRatios.get(position, 0.0);
	// if (ratio == 0) {
	// ratio = getRandomHeightRatio();
	// sPositionHeightRatios.append(position, ratio);
	// }
	// return ratio;
	// }
	//
	// private double getRandomHeightRatio() {
	// return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5
	// // the width
	// }
}