package com.etsy.android.grid;

import java.util.List;

import com.example.detailedpager.net.Detailedpage_card;
import com.example.detailedpager.net.Detailedpage_pics;

public class Detailedpage_Module {
	/**
	 * comment
	 */
	private String comment_title;
	private String comment_objectId;
	private List<String> comment_likes_show;
	/**
	 * about
	 */
	private String about_title;
	private String about_count;
	private String about_url;
	/**
	 * menulist
	 */
	private List<Detailedpage_card> twocard;
	/**
	 * 活动标题
	 */
	private String event_title;
	private String event_desc;
	private List<Detailedpage_pics> event_pic;

	public String getComment_title() {
		return comment_title;
	}

	public void setComment_title(String comment_title) {
		this.comment_title = comment_title;
	}

	public String getComment_objectId() {
		return comment_objectId;
	}

	public void setComment_objectId(String comment_objectId) {
		this.comment_objectId = comment_objectId;
	}

	public List<String> getComment_likes_show() {
		return comment_likes_show;
	}

	public void setComment_likes_show(List<String> comment_likes_show) {
		this.comment_likes_show = comment_likes_show;
	}

	public String getAbout_title() {
		return about_title;
	}

	public void setAbout_title(String about_title) {
		this.about_title = about_title;
	}

	public String getAbout_count() {
		return about_count;
	}

	public void setAbout_count(String about_count) {
		this.about_count = about_count;
	}

	public String getAbout_url() {
		return about_url;
	}

	public void setAbout_url(String about_url) {
		this.about_url = about_url;
	}

	public List<Detailedpage_card> getTwocard() {
		return twocard;
	}

	public void setTwocard(List<Detailedpage_card> twocard) {
		this.twocard = twocard;
	}

	public String getEvent_title() {
		return event_title;
	}

	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}

	public String getEvent_desc() {
		return event_desc;
	}

	public void setEvent_desc(String event_desc) {
		this.event_desc = event_desc;
	}

	public List<Detailedpage_pics> getEvent_pic() {
		return event_pic;
	}

	public void setEvent_pic(List<Detailedpage_pics> event_pic) {
		this.event_pic = event_pic;
	}

	@Override
	public String toString() {
		return "Detailedpage_Module [comment_title=" + comment_title
				+ ", comment_objectId=" + comment_objectId
				+ ", comment_likes_show=" + comment_likes_show
				+ ", about_title=" + about_title + ", about_count="
				+ about_count + ", about_url=" + about_url + ", twocard="
				+ twocard + ", event_title=" + event_title + ", event_desc="
				+ event_desc + ", event_pic=" + event_pic + "]";
	}

}
