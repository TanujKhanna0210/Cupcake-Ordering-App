package com.example.cupcake.model

import android.Manifest.permission_group.CALENDAR
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel:ViewModel() {
    private val _quantity = MutableLiveData<Int>(0)
    val quantity : LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>("")
    val flavor : LiveData<String> = _flavor

    private val _date = MutableLiveData<String>("")
    val date : LiveData<String> = _date

    private val _price = MutableLiveData<Double>(0.0)
    val price : LiveData<Double> = _price

    val dateOptions = getPickUpOptions()

    fun setQuantity(numberCupcakes:Int){
        _quantity.value = numberCupcakes
    }

    fun setFlavor(DesiredFlavor:String){
        _flavor.value = DesiredFlavor
    }

    fun setDate(pickUpDate:String){
        _date.value = pickUpDate
    }

    fun hasNoFlavorSet() : Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickUpOptions() : List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calender = Calendar.getInstance()
        repeat(4){
            options.add(formatter.format(calender.time))
            calender.add(Calendar.DATE,1)
        }
        return options
    }
}