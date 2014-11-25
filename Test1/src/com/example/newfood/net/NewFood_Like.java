package com.example.newfood.net;



public class NewFood_Like {
	private String id,likeApi,unlikeApi;
	private int likeCount,liked;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLikeApi() {
		return likeApi;
	}
	public void setLikeApi(String likeApi) {
		this.likeApi = likeApi;
	}
	public String getUnlikeApi() {
		return unlikeApi;
	}
	public void setUnlikeApi(String unlikeApi) {
		this.unlikeApi = unlikeApi;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	@Override
	public String toString() {
		return "Like [id=" + id + ", likeApi=" + likeApi + ", unlikeApi="
				+ unlikeApi + ", likeCount=" + likeCount + ", liked=" + liked
				+ "]";
	}
	
	
	
}
