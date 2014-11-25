package com.example.headerdetailed.net;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HeaderDetailed_JsonUtil {

	public static HeaderDetailed_Module parseJson(String data) {
		HeaderDetailed_Module module = new HeaderDetailed_Module();
		List<HeaderDetailed_MediaCard> mediaCards = new ArrayList<HeaderDetailed_MediaCard>();
		List<HeaderDetailed_LikeCard> likeCards = new ArrayList<HeaderDetailed_LikeCard>();
		try {
			JSONArray dataArray = new JSONObject(data).getJSONArray("data");
			for (int i = 0; i < dataArray.length(); i++) {
				JSONObject dataJsonObject = dataArray.getJSONObject(i);
				String type = dataJsonObject.getString("type");
				if (type.equals("EventCard")) {
					HeaderDetailed_EventCard eventCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									HeaderDetailed_EventCard.class);
					eventCard.setPic_show(dataJsonObject.getJSONObject("pic")
							.getString("url"));
					eventCard.setTitle(dataJsonObject.getString("title"));
					eventCard.setDesc(dataJsonObject.getString("desc"));
					module.setEventCard(eventCard);
				} else if (type.equals("PicCard")) {
					HeaderDetailed_PicCard picCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									HeaderDetailed_PicCard.class);
					module.setPicCard(picCard);
				} else if (type.equals("MediaCard")) {
					HeaderDetailed_MediaCard mediaCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									HeaderDetailed_MediaCard.class);
					/**
					 * detailed_show
					 */
					mediaCard
							.setDetailed_show("https://api.shiseapp.com/v2/media/"
									+ dataJsonObject.getString("objId")
									+ "/detail/?uuid=43cd5af6218d3e1abf4202c378aba474&_version=1.6.2&_device=Android4.4.4&gps=40.0371,116.369245&_city=&_channel=wandoujia");

					/**
					 * user_show
					 */
					JSONObject userJsonObject = dataJsonObject
							.getJSONObject("user");
					List<String> userList = new ArrayList<String>();
					userList.add(userJsonObject.getString("id"));
					userList.add(userJsonObject.getString("name"));
					userList.add(userJsonObject.getString("avatar"));
					userList.add(userJsonObject.getString("info"));
					mediaCard.setUser_show(userList);

					/*
					 * pic_show
					 */
					JSONObject picJsonObject = dataJsonObject
							.getJSONObject("pic");
					List<String> picList = new ArrayList<String>();
					picList.add(picJsonObject.getString("url"));
					picList.add(picJsonObject.getString("width"));
					picList.add(picJsonObject.getString("height"));
					mediaCard.setPic_show(picList);
					module.setMediaCard(mediaCards);
					/*
					 * level_show
					 */
					JSONObject levelJsonObject = dataJsonObject
							.getJSONObject("level");
					List<String> levelList = new ArrayList<String>();
					levelList.add(levelJsonObject.getString("title"));
					levelList.add("http://matcha-resource.qiniudn.com/"
							+ levelJsonObject.getString("icon"));
					mediaCard.setLevel_show(levelList);
					module.setMediaCard(mediaCards);
					/*
					 * likes_show
					 */
					JSONArray likesJsonArray = dataJsonObject
							.getJSONArray("likes");
					List<String> likesList = new ArrayList<String>();
					for (int j = 0; j < likesJsonArray.length(); j++) {
						JSONObject userObject = (JSONObject) likesJsonArray
								.get(j);
						likesList.add(userObject.getString("avatar"));
					}

					mediaCard.setLikeCount(likesList.size() + "");

					mediaCard.setLikes_show(likesList);
					mediaCards.add(mediaCard);
					module.setMediaCard(mediaCards);
				} else if (type.equals("UserCard")) {
					HeaderDetailed_UserCard userCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									HeaderDetailed_UserCard.class);
					/*
					 * user_show
					 */
					JSONObject userJsonObject = dataJsonObject
							.getJSONObject("user");
					List<String> userList = new ArrayList<String>();
					userList.add(userJsonObject.getString("name"));
					userList.add(userJsonObject.getString("avatar"));
					userList.add(userJsonObject.getString("info"));
					userCard.setUser_show(userList);
					/*
					 * level_show
					 */
					JSONObject levelJsonObject = dataJsonObject
							.getJSONObject("level");
					List<String> levelList = new ArrayList<String>();
					levelList.add(levelJsonObject.getString("title"));
					levelList.add("http://matcha-resource.qiniudn.com/"
							+ levelJsonObject.getString("icon"));
					userCard.setLevel_show(levelList);
					module.setUserCard(userCard);
				} else if (type.equals("LikeCard")) {
					HeaderDetailed_LikeCard likeCard = com.alibaba.fastjson.JSONObject
							.parseObject(dataJsonObject.toString(),
									HeaderDetailed_LikeCard.class);
					/**
					 * likes_show
					 */
					JSONArray likesJsonArray = dataJsonObject
							.getJSONArray("likes");
					List<String> likesList = new ArrayList<String>();
					for (int j = 0; j < likesJsonArray.length(); j++) {
						JSONObject userObject = (JSONObject) likesJsonArray
								.get(j);
						likesList.add(userObject.getString("id"));
						likesList.add(userObject.getString("avatar"));
					}
					likeCard.setLikes_show(likesList);
					likeCards.add(likeCard);
					module.setLikeCard(likeCard);

				}

			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return module;

	}
}
