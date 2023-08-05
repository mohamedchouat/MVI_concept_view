package com.chtmed.mvi

import java.math.BigDecimal

sealed class CalculateRandomDivisionViewState {
    object Standby : CalculateRandomDivisionViewState()
    data class Result(val result: BigDecimal) : CalculateRandomDivisionViewState()
    data class Error(val error: String) : CalculateRandomDivisionViewState()
}