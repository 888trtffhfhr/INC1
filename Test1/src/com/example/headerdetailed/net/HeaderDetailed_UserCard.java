package com.example.headerdetailed.net;

import java.util.List;

public class HeaderDetailed_UserCard {

	/**
	 * 0:name 1:avatar 2:info
	 */
	private List<String> user_show;

	private String title;
	private String desc;
	private String url;

	/**
	 * 0:title 1:icon
	 */

	private List<String> level_show;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 0:title 1:icon
	 */
	public List<String> getLevel_show() {
		return level_show;
	}

	public void setLevel_show(List<String> level_show) {
		this.level_show = level_show;
	}

	/**
	 * 0:name 1:avatar 2:info
	 */
	public List<String> getUser_show() {
		return user_show;
	}

	public void setUser_show(List<String> user_show) {
		this.user_show = user_show;
	}

	@Override
	public String toString() {
		return "UserCard [user_show=" + user_show + ", title=" + title
				+ ", desc=" + desc + ", url=" + url + ", level_show="
				+ level_show + "]";
	}

}
