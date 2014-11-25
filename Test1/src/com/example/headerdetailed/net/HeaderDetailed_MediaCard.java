package com.example.headerdetailed.net;

import java.io.Serializable;
import java.util.List;

import com.example.mainpager.net.MediaModule;

public class HeaderDetailed_MediaCard extends MediaModule implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;

	/**
	 * 0:url 1:width 2:height
	 */
	private List<String> pic_show;

	private String commentCount;

	/**
	 * 0:id 1:name 2:avatar 3:info
	 */
	private List<String> user_show;
	private String title;
	private String desc;
	private String location;
	private String content;
	private String objId;
	private String detailed_show;
	/**
	 * 0:title 1:icon
	 */
	private List<String> level_show;

	/**
	 * 0:id 1:avatar
	 */
	private List<String> likes_show;
	private String likeCount;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 0:url 1:width 2:height
	 */
	public List<String> getPic_show() {
		return pic_show;
	}

	public void setPic_show(List<String> pic_show) {
		this.pic_show = pic_show;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 0:title 1:icon
	 */
	public List<String> getLevel_show() {
		return level_show;
	}

	public void setLevel_show(List<String> level_show) {
		this.level_show = level_show;
	}

	/**
	 * 0:id 1:avatar
	 */
	public List<String> getLikes_show() {
		return likes_show;
	}

	public void setLikes_show(List<String> likes_show) {
		this.likes_show = likes_show;
	}

	public String getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	/**
	 * 0:id 1:name 2:avatar 3:info
	 */
	public List<String> getUser_show() {
		return user_show;
	}

	public void setUser_show(List<String> user_show) {
		this.user_show = user_show;
	}

	public String getDetailed_show() {
		return detailed_show;
	}

	public void setDetailed_show(String detailed_show) {
		this.detailed_show = detailed_show;
	}

	@Override
	public String toString() {
		return "HeaderDetailed_MediaCard [type=" + type + ", pic_show="
				+ pic_show + ", commentCount=" + commentCount + ", user_show="
				+ user_show + ", title=" + title + ", desc=" + desc
				+ ", location=" + location + ", content=" + content
				+ ", objId=" + objId + ", detailed_show=" + detailed_show
				+ ", level_show=" + level_show + ", likes_show=" + likes_show
				+ ", likeCount=" + likeCount + "]";
	}

}
