package com.maria.deliveryclub.Models


class PopularModel {
    private var foodImage : Int? = null
    private var foodName : String = ""
    private var foodPrice : String = ""
    private var foodCount : Int = 1


    constructor()
    constructor(foodImage: Int?, foodName: String, foodPrice: String, foodCount : Int) {
        this.foodImage = foodImage
        this.foodName = foodName
        this.foodPrice = foodPrice
        this.foodCount = foodCount
    }

    fun getFoodCount() : Int{
        return foodCount
    }

    fun setFoodCount(foodCount: Int){
        this.foodCount = foodCount
    }

    fun getFoodImage() : Int? {
        return foodImage
    }

     fun getFoodName() : String{
        return foodName
    }

     fun getFoodPrice() : String{
        return foodPrice
    }

     fun setFoodImage(foodImage: Int?) {
        this.foodImage = foodImage
    }

     fun setFoodName(foodName: String) {
        this.foodName = foodName
    }

     fun setFoodPrice(foodPrice: String) {
        this.foodPrice = foodPrice
    }

}