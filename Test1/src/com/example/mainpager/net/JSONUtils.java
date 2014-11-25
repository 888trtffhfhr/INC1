package com.example.mainpager.net;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
	public static Module parseJSON(String data) {
		Module module = new Module();
		List<MediaCard> mediaCards = new ArrayList<MediaCard>();
		try {
			JSONArray datasArray = new JSONObject(data).getJSONArray("data");

			for (int i = 0; i < datasArray.length(); i++) {
				JSONObject dataJsonObject = datasArray.getJSONObject(i);
				String type = dataJsonObject.getString("type");
				if (type.equals("EventCard")) {

					EventCard eventCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									EventCard.class);
					eventCard.setPic_show(dataJsonObject.getJSONObject("pic")
							.getString("url"));

					List<String> detailedList = new ArrayList<String>();
					JSONObject detailedJsonObject = dataJsonObject
							.getJSONObject("detail");
					detailedList.add(detailedJsonObject.getString("title"));
					detailedList.add(detailedJsonObject.getString("type"));
					detailedList
							.add("https://api.shiseapp.com"
									+ detailedJsonObject.getString("api")
									+ "?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.0371,116.369245&_city=&_channel=wandoujia");
					eventCard.setDetail_show(detailedList);

					module.setEventCard(eventCard);
					// /////////
				} else if (type.equals("PicCard")) {
					PicCard picCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									PicCard.class);
					List<String> picList = new ArrayList<String>();
					JSONObject picObject = dataJsonObject.getJSONObject("pic");
					picList.add(picObject.getString("url"));
					picList.add(picObject.getString("width"));
					picList.add(picObject.getString("height"));
					picCard.setPic_show(picList);
					module.setPicCard(picCard);
					// //////////
				} else if (type.equals("TitleCard")) {
					TitleCard titleCard = new TitleCard();
					titleCard.setType(dataJsonObject.getString("type"));
					titleCard.setTitle(dataJsonObject.getString("title"));

					JSONObject detailedJsonObject = dataJsonObject
							.getJSONObject("detail");

					List<String> detailedList = new ArrayList<String>();
					detailedList.add(detailedJsonObject.getString("title"));
					detailedList
							.add("https://api.shiseapp.com"
									+ detailedJsonObject.getString("api")
									+ "?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.0371,116.369245&_city=&_channel=wandoujia");
					titleCard.setDetail_show(detailedList);
					module.setTitleCard(titleCard);
					// ////////////
				} else if (type.equals("MediaCard")) {
					MediaCard mediaCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									MediaCard.class);
					JSONObject picJsonObject = dataJsonObject
							.getJSONObject("pic");
					List<String> picList = new ArrayList<String>();
					picList.add(picJsonObject.getString("url"));
					picList.add(picJsonObject.getString("width"));
					picList.add(picJsonObject.getString("height"));
					mediaCard.setPic_show(picList);

					List<String> levelList = new ArrayList<String>();
					JSONObject levelJsonObject = dataJsonObject
							.getJSONObject("level");
					levelList.add(levelJsonObject.getString("title"));
					levelList.add("http://matcha-resource.qiniudn.com/"
							+ levelJsonObject.getString("icon"));
					mediaCard.setLevel_show(levelList);

					List<String> likeList = new ArrayList<String>();
					JSONArray likeJsonArray = dataJsonObject
							.getJSONArray("likes");
					for (int j = 0; j < likeJsonArray.length(); j++) {
						JSONObject userObject = (JSONObject) likeJsonArray
								.get(j);
						likeList.add(userObject.getString("avatar"));

					}

					mediaCard.setLikes_show(likeList);
					String nextUrl = "https://api.shiseapp.com/v2/media/"
							+ dataJsonObject.getString("objId")
							+ "/detail/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.037123,116.369812&_city=%E5%8C%97%E4%BA%AC&_channel=wandoujia";
					mediaCard.setNextUrl(nextUrl);

					List<String> userList = new ArrayList<String>();
					JSONObject userJsonObject = dataJsonObject
							.getJSONObject("user");
					userList.add(userJsonObject.getString("id"));
					userList.add(userJsonObject.getString("name"));
					userList.add(userJsonObject.getString("avatar"));
					userList.add(userJsonObject.getString("info"));
					userList.add(userJsonObject.getString("isFollowing"));
					userList.add(userJsonObject.getString("isFollower"));
					mediaCard.setUser_show(userList);

					mediaCards.add(mediaCard);

				}
			}
			module.setMediaCard(mediaCards);
			return module;

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return module;
	}

}
