package com.example.foodList_bean;

import java.util.List;

public class FoodList_Module {
	private List<FoodList_FoodPicCard> foodPicCard;

	public List<FoodList_FoodPicCard> getFoodPicCard() {
		return foodPicCard;
	}

	public void setFoodPicCard(List<FoodList_FoodPicCard> foodPicCard) {
		this.foodPicCard = foodPicCard;
	}

	@Override
	public String toString() {
		return "Module [foodPicCard=" + foodPicCard + "]";
	}

	
}
