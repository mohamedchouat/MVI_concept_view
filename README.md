This project is implemented with the MVI architecture It has simple classes
image

MVI stands for Model-View-Intent :

Model: instead of having a separate state for the View, ViewModel, and the Data layer, the Model will be the single source of truth of the overall state, and it’s immutable to ensure that it will be updated from only one place. View: represent the UI layer, the activity, or the fragment, it defines the user actions and renders the state emitted by the model. Intent: do not confuse it with the Android Intent, it’s the intention to perform an action either by the user or the app itself.

image

MainActivity
CalculateRandomDivisionIntent
CalculateRandomDivisionViewState
CalculateRandomDivisionViewModel
The idea is to create simple ui to calculate the division of two random numbers

the returned result can be one of those **results (standby or result: BigDecimal or error: String) **

In the ViewModel we have two types of variables: https://developer.android.com/topic/libraries/architecture/viewmodel?hl=en

intentChannel her type is a Channel to get the action
viewState her type is State Flow to handle results and my choice it as state flow to avoid rendering ui if it has the same old value. https://developer.android.com/kotlin/flow/stateflow-and-sharedflow?hl=en .
The CalculateRandomDivisionViewState and the CalculateRandomDivisionIntent are declared as sealed classes.

The project uses also Coroutines components https://developer.android.com/kotlin/coroutines?hl=en .
