package com.example.newfood.net;

public class NewFood_ActionBtn {
	private String titleNormal,titleSelected,api,apichangeId;
	private int selectde;
	public String getTitleNormal() {
		return titleNormal;
	}
	public void setTitleNormal(String titleNormal) {
		this.titleNormal = titleNormal;
	}
	public String getTitleSelected() {
		return titleSelected;
	}
	public void setTitleSelected(String titleSelected) {
		this.titleSelected = titleSelected;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getApichangeId() {
		return apichangeId;
	}
	public void setApichangeId(String apichangeId) {
		this.apichangeId = apichangeId;
	}
	public int getSelectde() {
		return selectde;
	}
	public void setSelectde(int selectde) {
		this.selectde = selectde;
	}
	@Override
	public String toString() {
		return "ActionBtn [titleNormal=" + titleNormal + ", titleSelected="
				+ titleSelected + ", api=" + api + ", apichangeId="
				+ apichangeId + ", selectde=" + selectde + "]";
	}
	
	
		
}
