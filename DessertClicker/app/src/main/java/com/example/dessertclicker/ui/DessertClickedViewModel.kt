package com.example.dessertclicker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickedViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DessertClickedUiState())
    val uiState: StateFlow<DessertClickedUiState> = _uiState.asStateFlow()

    var currentDessertIndex by mutableStateOf(0)
        private set

     val currentDessertImageId: Int
        get() = Datasource.dessertList.get(currentDessertIndex).imageId

    private fun determineDessertIndexToShow(
        desserts: List<Dessert> = Datasource.dessertList,
    ): Int {
        var index = 0
        var result = 0
        for (dessert in desserts) {
            if (_uiState.value.dessertsSold >= dessert.startProductionAmount) {
                result = index
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
            index++
        }

        return result
    }


    fun onDessertClicked() {
        val currentDessert: Dessert = Datasource.dessertList.get(currentDessertIndex)

        _uiState.update { currentState ->
            currentState.copy(
                revenue = currentState.revenue.plus(currentDessert.price),
                dessertsSold = currentState.dessertsSold.inc()
            )
        }

        currentDessertIndex = determineDessertIndexToShow()
    }
}