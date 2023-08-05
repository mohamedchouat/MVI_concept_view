package com.chtmed.mvi

sealed class CalculateRandomDivisionIntent {
    object TryRandom : CalculateRandomDivisionIntent()
}