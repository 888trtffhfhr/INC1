package com.example.ranting_javabean;

import java.util.List;

public class Ranting_Moudle {

	private Ranting_SeparatorCard separatorCard;
	private Ranting_TitleCard titleCard;
	private List<Ranting_UserCard> userCards_list;
	public Ranting_SeparatorCard getSeparatorCard() {
		return separatorCard;
	}
	public void setSeparatorCard(Ranting_SeparatorCard separatorCard) {
		this.separatorCard = separatorCard;
	}
	public Ranting_TitleCard getTitleCard() {
		return titleCard;
	}
	public void setTitleCard(Ranting_TitleCard titleCard) {
		this.titleCard = titleCard;
	}
	public List<Ranting_UserCard> getUserCards_list() {
		return userCards_list;
	}
	public void setUserCards_list(List<Ranting_UserCard> userCards_list) {
		this.userCards_list = userCards_list;
	}
	@Override
	public String toString() {
		return "Moudle [separatorCard=" + separatorCard + ", titleCard="
				+ titleCard + ", userCards_list=" + userCards_list + "]";
	}
	
	
	
}
