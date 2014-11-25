package com.example.newfood.net;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;
import com.meg7.widget.CustomShapeImageView;

public class NewFoodAdapter extends BaseAdapter {
	private Context mcontext;
	private List<NewFood_MediaCard> mmediaCards_list;
	private List<NewFood_Pic> mpics_list;
	private NewFood_Module mmodule;
	private List<NewFood_User> mUsers_list;
	private BitmapUtils bitmapUtils;
	private List<NewFood_Level> mlLevels_lisList;

	public NewFoodAdapter(Context context) {
		mcontext = context;
		bitmapUtils = new BitmapUtils(context);
	}

	public void setDatas(NewFood_Module module) {
		mmodule = module;
		mmediaCards_list = mmodule.getMediaCards_list();
		mpics_list = mmodule.getPics_list();
		mUsers_list = mmodule.getUsers_list();
		mlLevels_lisList = mmodule.getLevels_list();
		notifyDataSetChanged();

	}

	@Override
	public int getCount() {
		if (mmediaCards_list != null && mpics_list != null
				&& mUsers_list != null) {
			return mmediaCards_list.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mcontext).inflate(
					R.layout.newfood_list_item, null);
			holder = new Holder();
			holder.tv_titleT = (TextView) convertView
					.findViewById(R.id.tv_title);
			holder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
			holder.tv_location = (TextView) convertView
					.findViewById(R.id.tv_location);
			holder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_content);
			holder.iv_pic_imageurl = (ImageView) convertView
					.findViewById(R.id.iv_pic_url);
			holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
			holder.iv_user = (CustomShapeImageView) convertView
					.findViewById(R.id.iv_user);
			holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}

		NewFood_MediaCard mediaCard = mmediaCards_list.get(position);
		holder.tv_titleT.setText(mediaCard.getTitle());
		holder.tv_desc.setText(mediaCard.getDesc());
		holder.tv_location.setText(mediaCard.getLocation());
		holder.tv_content.setText(mediaCard.getContent());
		NewFood_Pic pic = mpics_list.get(position);
		NewFood_User user = mUsers_list.get(position);
		NewFood_Level level = mlLevels_lisList.get(position);
		String icon = level.getIcon();
		String image_icon_url = "http://matcha-resource.qiniudn.com/" + icon;
		String image_user_url = user.getAvatar();
		String imageurl = pic.getUrl();
		bitmapUtils.display(holder.iv_user, image_user_url);
		bitmapUtils.display(holder.iv_pic_imageurl, imageurl);
		bitmapUtils.display(holder.iv_icon, image_icon_url);
		return convertView;
	}

	static class Holder {

		private TextView tv_titleT, tv_desc, tv_location, tv_content;
		private CustomShapeImageView iv_user;
		private ImageView iv_pic_imageurl, iv_icon;
	}

}
