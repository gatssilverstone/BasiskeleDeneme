package com.silverstone.basiskeledeneme

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun PageNavigations(sharedPreferences: SharedPreferences){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "MainPage" ){

        composable("Language"){
            SelectLanguage(sharedPreferences =sharedPreferences,navController )
        }
        composable("TabRows/{selectedTab}",arguments= listOf(
            navArgument("selectedTab"){type= NavType.IntType}
        )){
            val selectedTab=it.arguments?.getInt("selectedTab")!!
            TabRows(navController = navController, sharedPreferences,selectedTab)
        }
        composable("MainPage"){
            MainPage(navController,sharedPreferences )
        }
        composable("DetailsScreene/{name}/{address}/{description}/{phoneNumber}/{image}/{latitude}/{longitude}", arguments = listOf(
            navArgument("name"){type= NavType.StringType},
            navArgument("address"){type= NavType.StringType},
            navArgument("description"){type= NavType.StringType},
            navArgument("phoneNumber"){type= NavType.StringType},
            navArgument("image"){type= NavType.IntType},
            navArgument("latitude"){type= NavType.StringType},
            navArgument("longitude"){type= NavType.StringType},



        )){

            val name=it.arguments?.getString("name")!!
            val address=it.arguments?.getString("address")!!
            val description=it.arguments?.getString("description")!!
            val phoneNumber=it.arguments?.getString("phoneNumber")!!
            val image=it.arguments?.getInt("image")!!
            val latitude=it.arguments?.getString("latitude")!!.toDouble()
            val longitude=it.arguments?.getString("longitude")!!.toDouble()

            DetailsScreene(name,address,description,phoneNumber,image,latitude,longitude)
        }
    }
}