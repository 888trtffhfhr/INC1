package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodList_bean.FoodList_FoodPicCard;
import com.example.foodList_bean.FoodList_Module;
import com.example.test1.R;
import com.lidroid.xutils.BitmapUtils;

public class FoodList_Adapter extends BaseAdapter {
	private List<FoodList_FoodPicCard> mfoodPicCard;
	private Context mcontext;
	private BitmapUtils bitmapUtils;
	private FoodList_Module mmodule;

	public FoodList_Adapter(Context context) {
		this.mcontext = context;
		bitmapUtils = new BitmapUtils(mcontext);
	}

	public void setDatas(FoodList_Module module) {
		mmodule = module;
		mfoodPicCard = mmodule.getFoodPicCard();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if (mfoodPicCard != null) {
			return mfoodPicCard.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mcontext).inflate(
					R.layout.foodlist_list_item, null);
			holder.food_list_item_pic = (ImageView) convertView
					.findViewById(R.id.food_list_item_pic);
			holder.food_list_item_subtitle = (TextView) convertView
					.findViewById(R.id.food_list_item_subtitle);
			holder.food_list_item_title = (TextView) convertView
					.findViewById(R.id.food_list_item_title);
			holder.food_list_item_desc = (TextView) convertView
					.findViewById(R.id.food_list_item_desc);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		FoodList_FoodPicCard foodPicCard = mfoodPicCard.get(position);
		List<String> picList = foodPicCard.getPic_show();
		bitmapUtils.display(holder.food_list_item_pic, picList.get(0));

		holder.food_list_item_subtitle.setText(foodPicCard.getSubTitle());
		holder.food_list_item_title.setText(foodPicCard.getTitle());
		holder.food_list_item_desc.setText(foodPicCard.getDesc());
		return convertView;
	}

	class ViewHolder {
		public ImageView food_list_item_pic;
		public TextView food_list_item_subtitle;
		public TextView food_list_item_title;
		public TextView food_list_item_desc;

	}

}
