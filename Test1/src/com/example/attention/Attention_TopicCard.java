package com.example.attention;

public class Attention_TopicCard {
	private String title,desc;

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

	@Override
	public String toString() {
		return "TopicCard [title=" + title + ", desc=" + desc + "]";
	}

	
}
