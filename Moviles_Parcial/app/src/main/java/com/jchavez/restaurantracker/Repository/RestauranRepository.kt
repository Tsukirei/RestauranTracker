package com.jchavez.restaurantracker.Repository

import com.jchavez.restaurantracker.data.model.RestauranModel

class RestauranRepository ( var restaurans: MutableList<RestauranModel>) {

    fun getRestaurants()= restaurans

    fun addRestaurants(restauran:RestauranModel)= restaurans.add(restauran)

}