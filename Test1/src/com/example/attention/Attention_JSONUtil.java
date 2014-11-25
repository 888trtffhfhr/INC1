package com.example.attention;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Attention_JSONUtil {
	private Attention_EventCard eventCard;
	private Attention_SeparatorCard separatorCard;
	private List<Attention_TopicCard> topicCards_list;
	private List<List<String>> urls_list; // 接收图片url信息
	private Attention_Module module; //

	public Attention_JSONUtil() {
		topicCards_list = new ArrayList<Attention_TopicCard>();
		urls_list = new ArrayList<List<String>>();

	}

	public Attention_Module parseJson(String result) {
		try {
			JSONObject jsonObject = new JSONObject(result);
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = (JSONObject) jsonArray.get(i);
				String type = object.getString("type");
				if (type.equals("EventCard")) {
					eventCard = new Attention_EventCard();
					eventCard.setTitle(object.getString("title"));
					eventCard.setDesc(object.getString("desc"));
					eventCard.setRemain(object.getString("remain"));
					JSONObject pic = object.getJSONObject("pic");
					String url = pic.getString("url");
					eventCard.setPic_url(url);
				} else if (type.equals("SeparatorCard")) {
					separatorCard = new Attention_SeparatorCard();
					separatorCard.setTitle(object.getString("title"));

				} else if (type.equals("TopicCard")) {
					List<String> piclList = new ArrayList<String>();
					Attention_TopicCard topicCard = new Attention_TopicCard();
					topicCard.setTitle(object.getString("title"));
					topicCard.setDesc(object.getString("desc"));
					topicCards_list.add(topicCard);
					JSONArray pics = object.getJSONArray("pics");
					for (int j = 0; j < pics.length(); j++) {
						JSONObject object_pic = (JSONObject) pics.get(j);
						String url = object_pic.getString("url");
						piclList.add(url);
					}
					urls_list.add(piclList);
				}

			}

			module = new Attention_Module();
			module.setEventCard(eventCard);
			module.setTopicCards_list(topicCards_list);
			module.setUrls_list(urls_list);
			module.setSeparatorCard(separatorCard);
			return module;

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

	}

}
