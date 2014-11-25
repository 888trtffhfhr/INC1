package com.example.newfood.net;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewFood_JSONutil_wy {
	private List<String> file_list;// level中一属性；
	private NewFood_TitleCard titleCard;
	private NewFood_Title_detail title_detail;
	private List<NewFood_MediaCard> mediaCards_list;
	private List<NewFood_Pic> pics_list;
	private List<NewFood_User> users_list;

	private List<NewFood_Level> levels_list;
	private List<NewFood_Like> like_list;
	private List<NewFood_Likes> likess_list;
	private List<NewFood_Detail> details_list;
	private List<NewFood_ActionBtn> actionBtns_list;
	private List<NewFood_CmtDetail> cmtDetails_list;
	private NewFood_Module module;// 用来接收所有解析后的数据

	public NewFood_JSONutil_wy() {

		module = new NewFood_Module();
		file_list = new ArrayList<String>();
		mediaCards_list = new ArrayList<NewFood_MediaCard>();
		pics_list = new ArrayList<NewFood_Pic>();
		users_list = new ArrayList<NewFood_User>();
		like_list = new ArrayList<NewFood_Like>();
		likess_list = new ArrayList<NewFood_Likes>();
		details_list = new ArrayList<NewFood_Detail>();
		levels_list = new ArrayList<NewFood_Level>();
		actionBtns_list = new ArrayList<NewFood_ActionBtn>();
		cmtDetails_list = new ArrayList<NewFood_CmtDetail>();

	}

	public NewFood_Module parseJson(String result) {

		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(result);

			JSONArray jsonArray = jsonObject.getJSONArray("data");
			// 解析北京Titlcard
			JSONObject object_titlecard = (JSONObject) jsonArray.get(0);
			titleCard = new NewFood_TitleCard();
			titleCard.setType(object_titlecard.getString("type"));
			titleCard.setId(object_titlecard.getString("id"));
			titleCard.setTitle(object_titlecard.getString("title"));
			titleCard.setUrl(object_titlecard.getString("url"));
			titleCard.setCount(object_titlecard.getString("count"));
			titleCard.setPaddingTop(object_titlecard.getString("paddingTop"));
			titleCard.setBorderTop(object_titlecard.getString("borderTop"));
			titleCard.setCardView(object_titlecard.getString("cardView"));
			titleCard.setBorderBottom(object_titlecard
					.getString("borderBottom"));

			// 解析Title_detail
			JSONObject object_title_detail = object_titlecard
					.getJSONObject("detail");
			title_detail = new NewFood_Title_detail();
			title_detail.setTitle(object_title_detail.getString("title"));
			title_detail.setApi(object_title_detail.getString("api"));
			title_detail.setPop(object_title_detail.getString("pop"));

			// 解析MediaCard
			for (int i = 1; i < jsonArray.length(); i++) {
				JSONObject object_mediacard = (JSONObject) jsonArray.get(i);
				NewFood_MediaCard mediaCard = new NewFood_MediaCard();
				mediaCard.setType(object_mediacard.getString("type"));
				mediaCard.setObjId(object_mediacard.getString("objId"));
				mediaCard.setId(object_mediacard.getString("id"));
				mediaCard.setTitle(object_mediacard.getString("title"));
				mediaCard.setDesc(object_mediacard.getString("desc"));
				mediaCard.setContent(object_mediacard.getString("content"));
				mediaCard.setLocation(object_mediacard.getString("location"));
				mediaCard.setViewApi(object_mediacard.getString("viewApi"));
				mediaCard.setMoreLikeApi(object_mediacard
						.getString("moreLikeApi"));
				mediaCard.setLikeApi(object_mediacard.getString("likeApi"));
				mediaCard.setUnlikeApi(object_mediacard.getString("unlikeApi"));
				// mediaCard.setCommentCount(object_mediacard
				// .getString("commentCount"));
				mediaCard.setCommentCount("1");
				mediaCard.setLiked(object_mediacard.getString("liked"));
				mediaCard.setLikeCount(object_mediacard.getString("likeCount"));
				mediaCard.setBorderTop(object_mediacard.getString("borderTop"));
				mediaCard.setPaddingTop(object_mediacard
						.getString("paddingTop"));
				mediaCard.setCardView(object_mediacard.getString("cardView"));
				mediaCard.setBorderBottom(object_mediacard
						.getString("borderBottom"));
				mediaCards_list.add(mediaCard);

				// 解析pic
				JSONObject object_pic = object_mediacard.getJSONObject("pic");
				NewFood_Pic pic = new NewFood_Pic();
				pic.setUrl(object_pic.getString("url"));
				pic.setWidth(object_pic.getInt("width"));
				pic.setHeight(object_pic.getInt("height"));
				pics_list.add(pic);

				// 解析user
				JSONObject object_user = object_mediacard.getJSONObject("user");
				NewFood_User user = new NewFood_User();
				user.setId(object_user.getString("id"));
				user.setName(object_user.getString("name"));
				user.setAvatar(object_user.getString("avatar"));
				user.setV(object_user.getString("v"));
				user.setInfo(object_user.getString("info"));
				user.setGender(object_user.getString("gender"));
				user.setIsFollowing(object_user.getInt("isFollowing"));
				user.setIsFollower(object_user.getInt("isFollower"));
				users_list.add(user);

				// 解析level
				JSONObject object_level = object_mediacard
						.getJSONObject("level");
				NewFood_Level level = new NewFood_Level();
				level.setTitle(object_level.getString("title"));
				level.setIcon(object_level.getString("icon"));
				levels_list.add(level);

				// 解析file
				JSONObject object_file = object_level.getJSONObject("pic");
				String string_file = object_file.getString("file");
				file_list.add(string_file);

				// 解析actionbtn
				JSONObject object_actionbtn = object_mediacard
						.getJSONObject("actionBtn");
				NewFood_ActionBtn actionBtn = new NewFood_ActionBtn();
				actionBtn.setTitleNormal(object_actionbtn
						.getString("titleNormal"));
				actionBtn.setTitleSelected(object_actionbtn
						.getString("titleSelected"));
				actionBtn.setApi(object_actionbtn.getString("api"));
				actionBtn
						.setApichangeId(object_actionbtn.getString("changeId"));
				actionBtn.setSelectde(object_actionbtn.getInt("selected"));
				actionBtns_list.add(actionBtn);

				// 解析detail
				JSONObject object_detail = object_mediacard
						.getJSONObject("detail");
				NewFood_Detail detail = new NewFood_Detail();
				detail.setApi(object_detail.getString("api"));
				detail.setTitle(object_detail.getString("title"));
				detail.setType(object_detail.getString("type"));
				details_list.add(detail);

				// 解析cmtDetail
				JSONObject object_cmtdetail = object_mediacard
						.getJSONObject("cmtDetail");
				NewFood_CmtDetail cmtDetail = new NewFood_CmtDetail();
				cmtDetail.setApi(object_cmtdetail.getString("api"));
				cmtDetail.setTitle(object_cmtdetail.getString("title"));
				cmtDetail.setType(object_cmtdetail.getString("type"));
				cmtDetails_list.add(cmtDetail);

				// 解析likes
				JSONArray array_likes = object_mediacard.getJSONArray("likes");// ??????
				for (int j = 0; j < array_likes.length(); j++) {

					JSONObject object_likes = (JSONObject) array_likes.get(j);
					NewFood_Likes likes = new NewFood_Likes();
					likes.setId(object_likes.getString("id"));
					likes.setAvatar(object_likes.getString("avatar"));
					likes.setV(object_likes.getString("v"));
					likess_list.add(likes);
				}

				// 解析like
				JSONObject object_like = object_mediacard.getJSONObject("like");
				NewFood_Like like = new NewFood_Like();
				like.setId(object_like.getString("id"));
				like.setLikeApi(object_like.getString("likeApi"));
				like.setUnlikeApi(object_like.getString("unlikeApi"));
				like.setLikeCount(object_like.getInt("likeCount"));
				like.setLiked(object_like.getInt("liked"));
				like_list.add(like);

			}

			module.setTitleCard(titleCard);
			module.setTitle_detail(title_detail);
			module.setMediaCards_list(mediaCards_list);
			module.setFile_list(file_list);
			module.setMediaCards_list(mediaCards_list);
			module.setPics_list(pics_list);
			module.setUsers_list(users_list);
			module.setLike_list(like_list);
			module.setLikess_list(likess_list);
			module.setDetails_list(details_list);
			module.setLevels_list(levels_list);
			module.setActionBtns_list(actionBtns_list);
			module.setCmtDetails_list(cmtDetails_list);

			return module;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}
}
