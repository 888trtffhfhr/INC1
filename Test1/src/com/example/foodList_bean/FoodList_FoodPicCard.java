package com.example.foodList_bean;

import java.util.List;

public class FoodList_FoodPicCard {
	private String type;
	private String title;
	private String desc;
	private String id;
	private String objId;
	private String subTitle;
	
	private List<String> pic_show;
	
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
/**
 * 0:url 1:tag
 * @return
 */
	public List<String> getPic_show() {
		return pic_show;
	}

	public void setPic_show(List<String> pic_show) {
		this.pic_show = pic_show;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FoodPicCard [type=" + type + ", title=" + title + ", desc="
				+ desc + ", id=" + id + ", objId=" + objId + ", subTitle="
				+ subTitle + ", pic_show=" + pic_show + ", url=" + url + "]";
	}
	
	
}
