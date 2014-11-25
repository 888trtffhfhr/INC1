package com.example.detailedpager.net;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Detailedpage_JSONUtils {
	public static Detailedpage_Module parseJSON(String data) {
		Detailedpage_Module module = new Detailedpage_Module();
		try {
			JSONArray dataArray = new JSONObject(data).getJSONArray("data");
			for (int i = 0; i < dataArray.length(); i++) {
				JSONObject dataJsonObject = dataArray.getJSONObject(i);
				if (dataJsonObject.getString("type").equals("LikeCard")) {
					module.setComment_title(dataJsonObject.getString("title"));
					module.setComment_objectId(dataJsonObject
							.getString("objectId"));
					List<String> likesList = new ArrayList<String>();
					JSONArray likesArray = dataJsonObject.getJSONArray("likes");
					for (int j = 0; j < likesArray.length(); j++) {
						likesList.add(likesArray.getJSONObject(j).getString(
								"avatar"));
					}
					module.setComment_likes_show(likesList);
				} else if (dataJsonObject.getString("type").equals("TitleCard")) {
					module.setAbout_title(dataJsonObject.getString("title"));
					module.setAbout_count(dataJsonObject.getString("count"));
					module.setAbout_url(dataJsonObject.getString("url"));
				} else if (dataJsonObject.getString("type").equals("TwoCard")) {

					List<Detailedpage_card> cards = new ArrayList<Detailedpage_card>();

					JSONArray cardsJsonArray = dataJsonObject
							.getJSONArray("cards");

					for (int j = 0; j < cardsJsonArray.length(); j++) {
						JSONObject cardsJsonObject = cardsJsonArray
								.getJSONObject(j);
						Detailedpage_card card = new Detailedpage_card();
						card.setUrl(cardsJsonObject.getString("url"));
						card.setTitle(cardsJsonObject.getString("title"));
						card.setDesc(cardsJsonObject.getString("desc"));
						card.setObjId(cardsJsonObject.getString("objId"));
						card.setPic(cardsJsonObject.getJSONObject("pic")
								.getString("url"));
						cards.add(card);
					}
					module.setTwocard(cards);
				} else if (dataJsonObject.getString("type").equals("TopicCard")) {
					module.setEvent_title(dataJsonObject.getString("title"));
					module.setEvent_desc(dataJsonObject.getString("desc"));

					List<Detailedpage_pics> pics = new ArrayList<Detailedpage_pics>();

					JSONArray detailedPageArray = dataJsonObject
							.getJSONArray("pics");
					for (int j = 0; j < 3; j++) {
						Detailedpage_pics detailedpage_pics = new Detailedpage_pics();
						JSONObject detaieldPageJsonObject = detailedPageArray
								.getJSONObject(j);
						detailedpage_pics.setUrl(detaieldPageJsonObject
								.getString("url"));
						detailedpage_pics
								.setDetailed_api("https://api.shiseapp.com"
										+ detaieldPageJsonObject
												.getJSONObject("detail")
												.getJSONObject("detail")
												.getString("api")
										+ "?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.0371,116.369245&_city=&_channel=wandoujia");
						pics.add(detailedpage_pics);
					}

					module.setEvent_pic(pics);

				}
			}
			return module;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}
}
