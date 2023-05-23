package com.jchavez.restaurantracker.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jchavez.restaurantracker.Repository.RestauranRepository
import com.jchavez.restaurantracker.data.model.RestauranModel

class ReestauranViewModel(var repository: RestauranRepository): ViewModel() {

    fun getRestauran() = repository.getRestaurants()

    var name = MutableLiveData("")
    var qualification = MutableLiveData("")
    var Location = MutableLiveData("")
    var Type = MutableLiveData("")
    var status = MutableLiveData("")

    fun createRestauran(){

    }


    fun clearData(){
        name.value = ""
        qualification.value = ""
        Location.value = ""
        Type.value = ""
    }

    fun addRestauran(restauranModel: RestauranModel) = repository.addRestaurants(restauranModel)

    companion object{
        val factory = viewModelFactory {
            initializer {
                val repository = (this[APPLICATION_KEY] as RestauranRepository)
                ReestauranViewModel(repository = repository)


            }
        }
    }
}