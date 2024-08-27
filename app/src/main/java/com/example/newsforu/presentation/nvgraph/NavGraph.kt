package com.example.newsforu.presentation.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsforu.presentation.home.HomeScreen
import com.example.newsforu.presentation.home.HomeViewModel
import com.example.newsforu.presentation.onboarding.OnBoardingScreen
import com.example.newsforu.presentation.onboarding.OnBoardingViewModel
import com.example.newsforu.presentation.search.SearchScreen
import com.example.newsforu.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination ){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )

            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ){
            composable(route = Route.NewsNavigationScreen.route){
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(state = viewModel.state.value, event = viewModel::onEvent, navigate = {} )
            }
        }

    }


}