package com.moaimar.pkmtcgapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moaimar.pkmtcgapp.presentation.composables.home.HomeScreen
import com.moaimar.pkmtcgapp.presentation.composables.pokemonCard.PokemonCardDetailScreen
import com.moaimar.pkmtcgapp.presentation.composables.setCard.SetCardListScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf

@OptIn(KoinExperimentalAPI::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                onSetClicked = { setId, setName -> navController.navigate("setList/$setId/$setName") },
                vm = koinViewModel(),
            )
        }

        composable(
            route = "setList/{setId}/{setName}",
            arguments = listOf(
                navArgument("setId") { type = NavType.StringType },
                navArgument("setName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val setId = checkNotNull(backStackEntry.arguments?.getString("setId"))
            val setName = checkNotNull(backStackEntry.arguments?.getString("setName"))
            SetCardListScreen(
                vm = koinViewModel(parameters = { parametersOf(setId, setName) }),
                onCardClicked = { cardId, cardName -> navController.navigate("cardDetail/$cardId/$cardName") },
                onBack = { navController.popBackStack() })
        }

        composable(
            route = "cardDetail/{cardId}/{cardName}",
            arguments = listOf(
                navArgument("cardId") { type = NavType.StringType },
                navArgument("cardName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val cardId = checkNotNull(backStackEntry.arguments?.getString("cardId"))
            val cardName = checkNotNull(backStackEntry.arguments?.getString("cardName"))
            PokemonCardDetailScreen(
                vm = koinViewModel(parameters = { parametersOf(cardId, cardName) }),
                onBack = { navController.popBackStack() }
            )
        }
    }
}