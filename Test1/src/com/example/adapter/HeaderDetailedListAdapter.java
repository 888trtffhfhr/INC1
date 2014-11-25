package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.activity.DetailedPageActivity;
import com.example.headerdetailed.net.HeaderDetailed_MediaCard;
import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;
import com.meg7.widget.CustomShapeImageView;

public class HeaderDetailedListAdapter extends BaseAdapter {
	private BitmapUtils bitmapUtils;
	private List<HeaderDetailed_MediaCard> mediaCards;
	private Context context;

	public HeaderDetailedListAdapter(Context context, BitmapUtils bitmapUtils) {
		this.context = context;
		this.bitmapUtils = bitmapUtils;
	}

	public void setDatas(List<HeaderDetailed_MediaCard> mediaCards) {
		this.mediaCards = mediaCards;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mediaCards == null ? 0 : mediaCards.size();
	}

	@Override
	public Object getItem(int arg0) {
		return mediaCards.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder viewHolder;
		HeaderDetailed_MediaCard mediaCard = mediaCards.get(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.mainpage_item, null);
			viewHolder = new ViewHolder();
			viewHolder.support = (Button) convertView
					.findViewById(R.id.support);
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
			viewHolder.contentTextView = (TextView) convertView
					.findViewById(R.id.content);
			viewHolder.countTextView = (TextView) convertView
					.findViewById(R.id.count);
			viewHolder.user0ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user0);
			viewHolder.user1ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user1);
			viewHolder.user2ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user2);
			viewHolder.user3ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user3);
			viewHolder.user4ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user4);
			viewHolder.user5ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user5);
			viewHolder.user6ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user6);
			viewHolder.user7ImageView = (CustomShapeImageView) convertView
					.findViewById(R.id.user7);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		List<String> userList = mediaCard.getUser_show();

		bitmapUtils.display(viewHolder.userhead, userList.get(2));
		viewHolder.support.setText(mediaCard.getLikeCount());
		viewHolder.usernameTextView.setText(userList.get(1));
		viewHolder.timeTextView.setText(mediaCard.getDesc());
		bitmapUtils.display(viewHolder.levelIcon, mediaCard.getLevel_show()
				.get(1));
		bitmapUtils.display(viewHolder.imageview, mediaCard.getPic_show()
				.get(0));
		final HeaderDetailed_MediaCard valueCard = mediaCard;
		final String detailedURL = mediaCard.getDetailed_show();
		viewHolder.imageview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, DetailedPageActivity.class);
				intent.putExtra("headerURL", detailedURL);
				intent.putExtra("headervalue", valueCard);
				context.startActivity(intent);
			}
		});

		viewHolder.locationTextView.setText(mediaCard.getLocation());
		viewHolder.contentTextView.setText(mediaCard.getContent());
		viewHolder.countTextView.setText(mediaCard.getCommentCount());

		List<String> likes_show = mediaCard.getLikes_show();
		com.meg7.widget.CustomShapeImageView[] images = {
				viewHolder.user0ImageView, viewHolder.user1ImageView,
				viewHolder.user2ImageView, viewHolder.user3ImageView,
				viewHolder.user4ImageView, viewHolder.user5ImageView,
				viewHolder.user6ImageView, viewHolder.user7ImageView };

		List<String> realLikeList = new ArrayList<String>();
		for (int i = 0; i < likes_show.size(); i++) {
			if (!TextUtils.isEmpty(likes_show.get(i))) {
				realLikeList.add(likes_show.get(i));
			}
		}

		if (realLikeList.size() <= 7) {
			for (int i = 0; i < realLikeList.size() - 1; i++) {
				int index = i + 1;
				bitmapUtils.display(images[i], realLikeList.get(index));
			}
		} else {
			for (int i = 0; i < 7; i++) {
				int index = i + 1;
				bitmapUtils.display(images[i], realLikeList.get(index));
			}
		}

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
		private TextView contentTextView;
		private Button support;
		private TextView countTextView;
		private CustomShapeImageView user0ImageView;
		private CustomShapeImageView user1ImageView;
		private CustomShapeImageView user2ImageView;
		private CustomShapeImageView user3ImageView;
		private CustomShapeImageView user4ImageView;
		private CustomShapeImageView user5ImageView;
		private CustomShapeImageView user6ImageView;
		private CustomShapeImageView user7ImageView;

	}

}
