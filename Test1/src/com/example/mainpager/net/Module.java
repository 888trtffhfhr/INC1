package com.example.mainpager.net;

import java.util.List;

public class Module {
	private EventCard eventCard;
	private List<MediaCard> mediaCard;
	private PicCard picCard;
	private TitleCard titleCard;

	public EventCard getEventCard() {
		return eventCard;
	}

	public void setEventCard(EventCard eventCard) {
		this.eventCard = eventCard;
	}

	public List<MediaCard> getMediaCard() {
		return mediaCard;
	}

	public void setMediaCard(List<MediaCard> mediaCard) {
		this.mediaCard = mediaCard;
	}

	public PicCard getPicCard() {
		return picCard;
	}

	public void setPicCard(PicCard picCard) {
		this.picCard = picCard;
	}

	public TitleCard getTitleCard() {
		return titleCard;
	}

	public void setTitleCard(TitleCard titleCard) {
		this.titleCard = titleCard;
	}

	@Override
	public String toString() {
		return "Module [eventCard=" + eventCard + ", mediaCard=" + mediaCard
				+ ", picCard=" + picCard + ", titleCard=" + titleCard + "]";
	}

}
