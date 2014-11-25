package com.example.huodong_javabean;

import java.util.List;

public class Huodong_Moudle {

	private Huodong_TitleCard titleCard;
	private List<Huodong_TopicCard> topicCards_list;
	private List<List<String>> urls_list;
	public Huodong_TitleCard getTitleCard() {
		return titleCard;
	}
	public void setTitleCard(Huodong_TitleCard titleCard) {
		this.titleCard = titleCard;
	}
	public List<Huodong_TopicCard> getTopicCards_list() {
		return topicCards_list;
	}
	public void setTopicCards_list(List<Huodong_TopicCard> topicCards_list) {
		this.topicCards_list = topicCards_list;
	}
	public List<List<String>> getUrls_list() {
		return urls_list;
	}
	public void setUrls_list(List<List<String>> urls_list) {
		this.urls_list = urls_list;
	}
	
	
}
