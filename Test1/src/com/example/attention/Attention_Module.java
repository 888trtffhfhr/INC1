package com.example.attention;

import java.util.List;

public class Attention_Module {
	private Attention_EventCard eventCard;
	private Attention_SeparatorCard separatorCard;
	private List<Attention_TopicCard> topicCards_list;
	private List<List<String>> urls_list;
	public Attention_EventCard getEventCard() {
		return eventCard;
	}
	public void setEventCard(Attention_EventCard eventCard) {
		this.eventCard = eventCard;
	}
	
	public Attention_SeparatorCard getSeparatorCard() {
		return separatorCard;
	}
	public void setSeparatorCard(Attention_SeparatorCard separatorCard) {
		this.separatorCard = separatorCard;
	}
	
	public List<Attention_TopicCard> getTopicCards_list() {
		return topicCards_list;
	}
	public void setTopicCards_list(List<Attention_TopicCard> topicCards_list) {
		this.topicCards_list = topicCards_list;
	}
	public List<List<String>> getUrls_list() {
		return urls_list;
	}
	public void setUrls_list(List<List<String>> urls_list) {
		this.urls_list = urls_list;
	}
	@Override
	public String toString() {
		return "Module [eventCard=" + eventCard + ", separatorCard="
				+ separatorCard + ", topicCards_list=" + topicCards_list
				+ ", urls_list=" + urls_list + "]";
	}

	
	
}
