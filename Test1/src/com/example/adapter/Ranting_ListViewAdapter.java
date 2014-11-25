package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ranting_javabean.Ranting_Moudle;
import com.example.ranting_javabean.Ranting_UserCard;
import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;

public class Ranting_ListViewAdapter extends BaseAdapter {
	private Context mContext;
	private Ranting_Moudle mmoudle;
	private BitmapUtils bitmapUtils;
	private List<Ranting_UserCard> mUserCards_list;

	public Ranting_ListViewAdapter(Context context) {
		mContext = context;
		bitmapUtils = new BitmapUtils(mContext);
	}

	public void setDatas(Ranting_Moudle moudle) {
		mmoudle = moudle;
		mUserCards_list = mmoudle.getUserCards_list();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if (mUserCards_list != null) {
			return mUserCards_list.size();
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
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.ranting_list_item, null);
			holder = new Holder();
			holder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_name_darenbang);
			holder.tv_desc = (TextView) convertView
					.findViewById(R.id.tv_desc_darendbang);
			holder.iv_avatar = (ImageView) convertView
					.findViewById(R.id.iv_avatar_darenbang);
			holder.iv_icon = (ImageView) convertView
					.findViewById(R.id.iv_icon_darenbang);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}

		Ranting_UserCard userCard = mUserCards_list.get(position);
		holder.tv_title.setText(userCard.getTitle());
		holder.tv_desc.setText(userCard.getDesc());
		String iamge_url_avatar = userCard.getAvatar();
		String icon = userCard.getIcon();
		bitmapUtils.display(holder.iv_avatar, iamge_url_avatar);
		bitmapUtils.display(holder.iv_icon, icon);

		return convertView;
	}

	static class Holder {
		private TextView tv_title, tv_desc;
		private ImageView iv_avatar, iv_icon;

	}

}
