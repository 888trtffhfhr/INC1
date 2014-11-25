package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huodong_javabean.Huodong_Moudle;
import com.example.huodong_javabean.Huodong_TopicCard;
import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;

public class ListviewAdapter_huodong extends BaseAdapter {

	private Context mContext;
	private Huodong_Moudle mmoudle;
	private BitmapUtils bitmapUtils;
	private List<Huodong_TopicCard> mtopicCards_list;
	private List<List<String>> murls_list;

	public ListviewAdapter_huodong(Context context) {
		mContext = context;
		bitmapUtils = new BitmapUtils(mContext);
	}

	public void setDatas(Huodong_Moudle moudle) {
		mmoudle = moudle;
		mtopicCards_list = mmoudle.getTopicCards_list();
		murls_list = mmoudle.getUrls_list();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if (mtopicCards_list != null) {
			return mtopicCards_list.size();
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
					R.layout.list_item_huodong, null);
			holder = new Holder();
			holder.tv_title_huodong = (TextView) convertView
					.findViewById(R.id.tv_title_huodong);
			holder.tv_desc_huodong = (TextView) convertView
					.findViewById(R.id.tv_desc_huodong);
			holder.iv1_huodong = (ImageView) convertView
					.findViewById(R.id.iv1_huodong);
			holder.iv2_huogdong = (ImageView) convertView
					.findViewById(R.id.iv2_huodong);
			holder.iv3_huogdong = (ImageView) convertView
					.findViewById(R.id.iv3_huodong);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}

		Huodong_TopicCard topicCard = mtopicCards_list.get(position);
		holder.tv_title_huodong.setText(topicCard.getTitle());
		holder.tv_desc_huodong.setText(topicCard.getDesc());
		List<String> urls = murls_list.get(position);
		String url0 = urls.get(0);
		String url1 = urls.get(1);
		String url2 = urls.get(2);
		bitmapUtils.display(holder.iv1_huodong, url0);
		bitmapUtils.display(holder.iv2_huogdong, url1);
		bitmapUtils.display(holder.iv3_huogdong, url2);

		return convertView;
	}

	static class Holder {
		private TextView tv_title_huodong, tv_desc_huodong;
		private ImageView iv1_huodong, iv2_huogdong, iv3_huogdong;

	}

}
