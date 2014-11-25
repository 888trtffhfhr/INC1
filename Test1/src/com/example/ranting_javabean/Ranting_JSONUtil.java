package com.example.ranting_javabean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Ranting_JSONUtil {

	private Ranting_SeparatorCard separatorCard;
	private Ranting_TitleCard titleCard;
	private List<Ranting_UserCard> userCards_list;
	private Ranting_Moudle moudle;

	public Ranting_JSONUtil() {

		userCards_list = new ArrayList<Ranting_UserCard>();
		moudle = new Ranting_Moudle();

	}

	public Ranting_Moudle parseJson(String result) {

		try {
			JSONObject jsonObject = new JSONObject(result);
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = (JSONObject) jsonArray.get(i);
				String type = object.getString("type");
				if (type.equals("TitleCard")) {
					titleCard = new Ranting_TitleCard();
					titleCard.setTitle(object.getString("title"));

				} else if (type.equals("SeparatorCard")) {
					separatorCard = new Ranting_SeparatorCard();
					separatorCard.setTitle(object.getString("title"));

				} else if (type.equals("UserCard")) {
					Ranting_UserCard userCard = new Ranting_UserCard();
					userCard.setTitle(object.getString("title"));
					userCard.setDesc(object.getString("desc"));
					JSONObject user = object.getJSONObject("user");
					userCard.setAvatar(user.getString("avatar"));
					JSONObject level = object.getJSONObject("level");
					userCard.setIcon("http://matcha-resource.qiniudn.com/"
							+ level.getString("icon"));

					userCards_list.add(userCard);
				}
			}
			moudle.setTitleCard(titleCard);
			moudle.setSeparatorCard(separatorCard);
			moudle.setUserCards_list(userCards_list);
			return moudle;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

}
