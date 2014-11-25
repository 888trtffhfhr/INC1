package com.example.mainpager.net;

import java.util.List;

public class TitleCard {
	private String type;
	private String title;
	/**
	 * 这是一个JSONObject
	 * 
	 */
	private List<String> detail_show;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getDetail_show() {
		return detail_show;
	}

	public void setDetail_show(List<String> detail_show) {
		this.detail_show = detail_show;
	}

	@Override
	public String toString() {
		return "TitleCard [type=" + type + ", title=" + title
				+ ", detail_show=" + detail_show + "]";
	}

}
