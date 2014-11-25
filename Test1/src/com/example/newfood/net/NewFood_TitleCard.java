package com.example.newfood.net;

public class NewFood_TitleCard{
	private String type,id,title,url,count;
	private String  paddingTop,borderTop,cardView,borderBottom;
	
	
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getCount() {
		return count;
	}



	public void setCount(String count) {
		this.count = count;
	}



	public String getPaddingTop() {
		return paddingTop;
	}



	public void setPaddingTop(String paddingTop) {
		this.paddingTop = paddingTop;
	}



	public String getBorderTop() {
		return borderTop;
	}



	public void setBorderTop(String borderTop) {
		this.borderTop = borderTop;
	}



	public String getCardView() {
		return cardView;
	}



	public void setCardView(String cardView) {
		this.cardView = cardView;
	}



	public String getBorderBottom() {
		return borderBottom;
	}



	public void setBorderBottom(String borderBottom) {
		this.borderBottom = borderBottom;
	}



	@Override
	public String toString() {
		return "TitleCard [type=" + type + ", id=" + id + ", title=" + title
				+ ", url=" + url + ", count=" + count + ", paddingTop="
				+ paddingTop + ", borderTop=" + borderTop + ", cardView="
				+ cardView + ", borderBottom=" + borderBottom + "]";
	}
	
	
	
	
}
