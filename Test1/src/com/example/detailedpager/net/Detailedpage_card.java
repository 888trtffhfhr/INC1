package com.example.detailedpager.net;


public class Detailedpage_card {
	private String url;
	private String title;
	private String desc;
	private String objId;
	/**
	 * url
	 */
	private String pic;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Detailedpage_twocard [url=" + url + ", title=" + title
				+ ", desc=" + desc + ", objId=" + objId + ", pic=" + pic + "]";
	}

}
