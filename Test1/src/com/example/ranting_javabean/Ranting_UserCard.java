package com.example.ranting_javabean;

public class Ranting_UserCard {
	private String title, desc, avatar, icon;

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "UserCard [title=" + title + ", desc=" + desc + ", avatar="
				+ avatar + ", icon=" + icon + "]";
	}

}
