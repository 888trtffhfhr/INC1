package com.example.mainpager.net;

import java.util.List;

public abstract class MediaModule {
	/**
	 * 0:title 1:icon
	 */
	public List<String> level_show;
	/**
	 * 0:url 1:width 2:height
	 */
	public List<String> pic_show;
	public String desc;
	public String content;
	/**
	 * 0:id 1:name 2:avatar 3:info
	 */
	public List<String> user_show;

	public List<String> getLevel_show() {
		return level_show;
	}

	public void setLevel_show(List<String> level_show) {
		this.level_show = level_show;
	}

	public List<String> getPic_show() {
		return pic_show;
	}

	public void setPic_show(List<String> pic_show) {
		this.pic_show = pic_show;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getUser_show() {
		return user_show;
	}

	public void setUser_show(List<String> user_show) {
		this.user_show = user_show;
	}

}
