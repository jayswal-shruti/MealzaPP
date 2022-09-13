package com.example.mealzapp.ui.details

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.model.MealsRepository
import com.example.model.response.MealResponse

class MealDetailsViewModel(
    private val savesStateHandle: SavedStateHandle,
    ): ViewModel() {
    private val repository: MealsRepository = MealsRepository.getInstance()
    var mealsState = mutableStateListOf<MealResponse?>(null)

    init {
         val mealId = SavedStateHandle().get<String>("meal_category_id")?:""
         mealsState.value = repository.getMeal(mealId)
    }
}