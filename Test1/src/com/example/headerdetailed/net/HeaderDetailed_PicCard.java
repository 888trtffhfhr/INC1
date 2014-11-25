package com.example.headerdetailed.net;

/**
 * 
 * type; title; id;desc;
 * 
 * @author edison
 * 
 */

public class HeaderDetailed_PicCard {
	private String type;
	private String title;
	private String desc;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String borderBottom;

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

	public String getBorderBottom() {
		return borderBottom;
	}

	public void setBorderBottom(String borderBottom) {
		this.borderBottom = borderBottom;
	}

	@Override
	public String toString() {
		return "PicCard [title=" + title + ", desc=" + desc + ", borderBottom="
				+ borderBottom + "]";
	}

}
