package com.example.mainpager.net;

import java.util.List;

public class EventCard {
	private String type;
	/**
	 * 这是一个JSONObject
	 */
	private String pic_show;
	private String title;
	private String remain;
	private String desc;

	/**
	 * 0:title 1: type 2:api
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

	public String getRemain() {
		return remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "EventCard [type=" + type + ", pic=" + pic_show + ", title="
				+ title + ", remain=" + remain + ", desc=" + desc + ", detail="
				+ detail_show + "]";
	}

	public String getPic_show() {
		return pic_show;
	}

	public void setPic_show(String pic_show) {
		this.pic_show = pic_show;
	}

	/**
	 * 0:title 1: type 2:api
	 */
	public List<String> getDetail_show() {
		return detail_show;
	}

	public void setDetail_show(List<String> detail_show) {
		this.detail_show = detail_show;
	}

}
