package com.chtmed.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal

class CalculateRandomDivisionViewModel : ViewModel() {
    val intentChannel = Channel<CalculateRandomDivisionIntent>(Channel.UNLIMITED)
    private val _viewState =
        MutableStateFlow<CalculateRandomDivisionViewState>(CalculateRandomDivisionViewState.Standby)
    val viewState: StateFlow<CalculateRandomDivisionViewState> get() = _viewState

    init {

        processIntent()
    }

    fun processIntent() {

        viewModelScope.launch {

            intentChannel.consumeAsFlow().collect {

                when (it) {

                    is CalculateRandomDivisionIntent.TryRandom -> {

                        tryRandom()
                    }
                }
            }
        }
    }

    private fun tryRandom() {

        _viewState.value =
            try {
                var dividend = (0..100).random()
                var divisor = (0..dividend).random()
                var quotient = BigDecimal(dividend.div(divisor))
                CalculateRandomDivisionViewState.Result(quotient)
            } catch (e: Exception) {
                CalculateRandomDivisionViewState.Error(e.message!!)
            }
    }

    fun reduceIntent() {}
}