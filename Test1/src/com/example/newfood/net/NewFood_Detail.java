package com.example.newfood.net;


public class NewFood_Detail {
	private String api,title,type;

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Detail [api=" + api + ", title=" + title + ", type=" + type
				+ "]";
	}
	
	
	
}
