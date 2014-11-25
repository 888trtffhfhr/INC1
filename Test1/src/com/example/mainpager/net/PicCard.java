package com.example.mainpager.net;

import java.util.List;

public class PicCard {
	private String type;
	private String title;
	private String desc;

	/**
	 * 0:url 1:width 2:height
	 */
	private List<String> pic_show;
	private String url;
	private String recommendTag;

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

	public String getRecommendTag() {
		return recommendTag;
	}

	public void setRecommendTag(String recommendTag) {
		this.recommendTag = recommendTag;
	}

	@Override
	public String toString() {
		return "PicCard [type=" + type + ", title=" + title + ", desc=" + desc
				+ ", pic=" + pic_show + ", url=" + url + ", recommendTag="
				+ recommendTag + "]";
	}

	/**
	 * 0:url 1:width 2:height
	 */
	public List<String> getPic_show() {
		return pic_show;
	}

	public void setPic_show(List<String> pic_show) {
		this.pic_show = pic_show;
	}

}
