package com.example.huodong_javabean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Huodong_JSONUtil {
	private Huodong_TitleCard titleCard;
	private List<Huodong_TopicCard> topicCards_list;
	private List<List<String>> urls_list;

	private Huodong_Moudle moudle;

	public Huodong_JSONUtil() {

		topicCards_list = new ArrayList<Huodong_TopicCard>();
		urls_list = new ArrayList<List<String>>();
		moudle = new Huodong_Moudle();

	}

	public Huodong_Moudle parseJson(String result) {

		try {
			JSONObject jsonObject = new JSONObject(result);
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = (JSONObject) jsonArray.get(i);
				String type = object.getString("type");
				if (type.equals("TitleCard")) {
					titleCard = new Huodong_TitleCard();
					titleCard.setTitle(object.getString("title"));

				} else if (type.equals("TopicCard")) {
					Huodong_TopicCard topicCard = new Huodong_TopicCard();
					topicCard.setTitle(object.getString("title"));
					topicCard.setDesc(object.getString("desc"));

					topicCards_list.add(topicCard);
					JSONArray pics = object.getJSONArray("pics");
					List<String> urls = new ArrayList<String>();
					for (int j = 0; j < pics.length(); j++) {
						JSONObject pic = (JSONObject) pics.get(j);
						String url = pic.getString("url");
						urls.add(url);

					}

					urls_list.add(urls);

				}

			}

			moudle.setTitleCard(titleCard);
			moudle.setTopicCards_list(topicCards_list);
			moudle.setUrls_list(urls_list);
			return moudle;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

}
