package com.example.newfood.net;

public class NewFood_User {

	private String id,name,avatar,v,info,gender; //v??
	private int isFollowing,isFollower;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getIsFollowing() {
		return isFollowing;
	}
	public void setIsFollowing(int isFollowing) {
		this.isFollowing = isFollowing;
	}
	public int getIsFollower() {
		return isFollower;
	}
	public void setIsFollower(int isFollower) {
		this.isFollower = isFollower;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", avatar=" + avatar
				+ ", v=" + v + ", info=" + info + ", gender=" + gender
				+ ", isFollowing=" + isFollowing + ", isFollower=" + isFollower
				+ "]";
	}
	
	
	
	
}
