package com.example.attention;

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

public class Attention_ListViewAdapter extends BaseAdapter {
	private Context mContext;
	private Attention_Module mmodule;
	private List<Attention_TopicCard> mtopicCards_list;
	private List<List<String>> murls_list;
	private BitmapUtils bitmapUtils;

	public Attention_ListViewAdapter(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
		bitmapUtils = new BitmapUtils(mContext);
	}

	public void setDatas(Attention_Module module) {
		// TODO Auto-generated method stub
		mmodule = module;
		mtopicCards_list = mmodule.getTopicCards_list();
		murls_list = mmodule.getUrls_list();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (mtopicCards_list != null && murls_list != null) {
			return mtopicCards_list.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.attention_list_item, null);
			holder = new Holder();
			holder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_title_find);
			holder.tv_desc = (TextView) convertView
					.findViewById(R.id.tv_desc_find);
			holder.iv1 = (ImageView) convertView.findViewById(R.id.iv1_find);
			holder.iv2 = (ImageView) convertView.findViewById(R.id.iv2_find);
			holder.iv3 = (ImageView) convertView.findViewById(R.id.iv3_find);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}

		Attention_TopicCard topicCard = mtopicCards_list.get(position);
		holder.tv_title.setText(topicCard.getTitle());
		holder.tv_desc.setText(topicCard.getDesc());
		List<String> image_url_list = murls_list.get(position);

		String image_url0 = image_url_list.get(0);
		bitmapUtils.display(holder.iv1, image_url0);
		String image_url1 = image_url_list.get(1);
		bitmapUtils.display(holder.iv2, image_url1);
		String image_url2 = image_url_list.get(2);
		bitmapUtils.display(holder.iv3, image_url2);

		return convertView;
	}

	static class Holder {
		private TextView tv_title, tv_desc;
		private ImageView iv1, iv2, iv3;

	}

}
