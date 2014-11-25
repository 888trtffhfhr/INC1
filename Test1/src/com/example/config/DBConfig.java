package com.example.config;

public class DBConfig {
	public boolean isFirst;
	public String id;

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DBConfig [isFirst=" + isFirst + ", id=" + id + "]";
	}
}
