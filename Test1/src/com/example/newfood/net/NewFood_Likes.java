package com.example.newfood.net;

public class NewFood_Likes {
	private String id,avatar,v;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return "Likes [id=" + id + ", avatar=" + avatar + ", v=" + v + "]";
	}
	
	
	
}
