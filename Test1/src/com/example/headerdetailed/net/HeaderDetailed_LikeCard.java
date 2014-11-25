package com.example.headerdetailed.net;

import java.util.List;

public class HeaderDetailed_LikeCard {
		private String id;
		private String title;
		private String moreApi;
		private String likeApi;
		private String unlikeApi;
		private String objectId;
		
		/**
		 * 0:id 1:name 2:avatar 3:v 4:info 5
		 * 
		 */
		private String user;
		/**
		 * 0:id 1:avatar
		 */
		private List<String> likes_show; 
		
		private String likeCount;

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

		public String getMoreApi() {
			return moreApi;
		}

		public void setMoreApi(String moreApi) {
			this.moreApi = moreApi;
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

		public String getObjectId() {
			return objectId;
		}

		public void setObjectId(String objectId) {
			this.objectId = objectId;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}


		public String getLikeCount() {
			return likeCount;
		}

		public void setLikeCount(String likeCount) {
			this.likeCount = likeCount;
		}

		public List<String> getLikes_show() {
			return likes_show;
		}

		public void setLikes_show(List<String> likes_show) {
			this.likes_show = likes_show;
		}

		@Override
		public String toString() {
			return "LikeCard [id=" + id + ", title=" + title + ", moreApi="
					+ moreApi + ", likeApi=" + likeApi + ", unlikeApi="
					+ unlikeApi + ", objectId=" + objectId + ", user=" + user
					+ ", likes_show=" + likes_show + ", likeCount=" + likeCount
					+ "]";
		}

}
