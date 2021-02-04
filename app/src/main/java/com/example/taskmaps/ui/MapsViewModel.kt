package com.example.taskmaps.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.taskmaps.data.Repository.FireBaseRepository

class MapsViewModel  @ViewModelInject constructor(private val fireBaseRepo : FireBaseRepository) :ViewModel(){


}