package com.example.attention;

public class Attention_EventCard {
	private String pic_url,title,desc,remain;

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
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

	public String getRemain() {
		return remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

	@Override
	public String toString() {
		return "EventCard [pic_url=" + pic_url + ", title=" + title + ", desc="
				+ desc + ", remain=" + remain + "]";
	}
	
	
	
	
}
