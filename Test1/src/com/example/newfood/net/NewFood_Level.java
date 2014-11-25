package com.example.newfood.net;

public class NewFood_Level {
	private String title,icon; //file

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Level [title=" + title + ", icon=" + icon + "]";
	}
	
	
	
}
