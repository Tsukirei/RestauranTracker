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


    var BADATA= "WRONG INFORMATION"
    var STATIC= ""
    var CREATED= "RESTAURAN CREATED"
    fun createRestauran(){
        if(validateData()==true){
            status.value = BADATA
            clearData()
            clearStatus()
            return

        }

        var restauranReady = RestauranModel(
            name.value!!,
            qualification.value!!,
            Location.value!!,
            Type.value!!

        )

        addRestauran(restauranReady)
        status.value = CREATED
        clearData()
        clearStatus()


    }


    fun clearData(){
        name.value = ""
        qualification.value = ""
        Location.value = ""
        Type.value = ""
    }

    fun clearStatus(){
        status.value= STATIC
    }

    fun validateData(): Boolean {
        when{
           name.value.isNullOrEmpty() -> return true
            qualification.value.isNullOrEmpty() -> return true
            Location.value.isNullOrEmpty() -> return true
            Type.value.isNullOrEmpty() -> return true
        }
        return false
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