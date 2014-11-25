package com.example.headerdetailed.net;

import java.util.List;

public class HeaderDetailed_Module {
	private HeaderDetailed_EventCard eventCard;
	private List<HeaderDetailed_MediaCard> mediaCard;
	private HeaderDetailed_PicCard picCard;
	private HeaderDetailed_UserCard UserCard;
	private HeaderDetailed_LikeCard likeCard;
	
	public HeaderDetailed_LikeCard getLikeCard() {
		return likeCard;
	}
	public void setLikeCard(HeaderDetailed_LikeCard likeCard) {
		this.likeCard = likeCard;
	}
	public HeaderDetailed_EventCard getEventCard() {
		return eventCard;
	}
	public void setEventCard(HeaderDetailed_EventCard eventCard) {
		this.eventCard = eventCard;
	}
	public List<HeaderDetailed_MediaCard> getMediaCard() {
		return mediaCard;
	}
	public void setMediaCard(List<HeaderDetailed_MediaCard> mediaCard) {
		this.mediaCard = mediaCard;
	}
	public HeaderDetailed_PicCard getPicCard() {
		return picCard;
	}
	public void setPicCard(HeaderDetailed_PicCard picCard) {
		this.picCard = picCard;
	}
	public HeaderDetailed_UserCard getUserCard() {
		return UserCard;
	}
	public void setUserCard(HeaderDetailed_UserCard userCard) {
		UserCard = userCard;
	}
	@Override
	public String toString() {
		return "Module [eventCard=" + eventCard + ", mediaCard=" + mediaCard
				+ ", picCard=" + picCard + ", UserCard=" + UserCard
				+ ", likeCard=" + likeCard + "]";
	}
	
}
