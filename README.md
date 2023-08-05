# MVI_concept_view
This project is implimented with the MVI architecture
It has simple classes 
- MainActivity
- CalculateRandomDivisionIntent
- CalculateRandomDivisionViewState
- CalculateRandomDivisionViewModel

- The idea is to creat simple ui to calculate the division of two random number

- the returned result can be one of those results (standby or result: BigDecimal or error: String)
- The intent is just one TryRandom

- In the viewModel we have two type of variables:

  
   . intentChannel her type is a Channel to get the action
   . viewState  her type is StateFlow to handel results and i choice it as state flow to avoid rendring ui if it has the same old value

- The CalculateRandomDivisionViewState and the CalculateRandomDivisionIntent are declared as sealed classes




  
