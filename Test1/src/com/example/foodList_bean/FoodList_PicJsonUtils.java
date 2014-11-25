package com.example.foodList_bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FoodList_PicJsonUtils {

	public FoodList_Module parseJson(String data) {

		FoodList_Module module = new FoodList_Module();

		List<FoodList_FoodPicCard> foodPicCards = new ArrayList<FoodList_FoodPicCard>();
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(data);
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject dataJsonObject = jsonArray.getJSONObject(i);
				FoodList_FoodPicCard foodPicCard = com.alibaba.fastjson.JSONObject
						.parseObject(dataJsonObject.toString(),
								FoodList_FoodPicCard.class);

				/*
				 * pic_show
				 */
				JSONObject picJsonObject = dataJsonObject.getJSONObject("pic");
				List<String> picList = new ArrayList<String>();
				picList.add(picJsonObject.getString("url"));
				picList.add(picJsonObject.getString("tag"));
				foodPicCard.setPic_show(picList);

				foodPicCards.add(foodPicCard);

			}
			module.setFoodPicCard(foodPicCards);
			return module;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return module;

	}

}
