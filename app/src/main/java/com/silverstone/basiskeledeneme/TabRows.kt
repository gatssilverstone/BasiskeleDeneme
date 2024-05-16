package com.silverstone.basiskeledeneme

import android.content.SharedPreferences
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRows(navController: NavController, sharedPreferences:SharedPreferences,selectedTab:Int){
    val context= LocalContext.current
    val language=sharedPreferences.getString("selectedLanguage","tr").apply {  }.toString()
    val places= updateList(context = context,language)


    var selectedTabIndex by remember {
        mutableStateOf(selectedTab)
    }

    val tabItems= listOf(
            TabRowsItems(
                unselectedIcon = Icons.Outlined.List,
                selectedIcon = Icons.Filled.List,
                title = "Home"
            ),
            TabRowsItems(
                unselectedIcon = Icons.Outlined.Map,
                selectedIcon = Icons.Filled.Map,
                title = "Map"
            )
    )

    Column(Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.ustbanner), contentDescription = "",Modifier.fillMaxWidth())
        Text(text = language)
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, item ->
                Tab(selected = index==selectedTabIndex,
                    onClick = { selectedTabIndex=index },
                    icon = { Icon(imageVector =
                    if (index==selectedTabIndex){
                        item.selectedIcon }
                        else{
                            item.unselectedIcon
                            }, contentDescription = "")},
                )
            }
        }
            Box(modifier = Modifier.fillMaxSize()){
                when(selectedTabIndex){
                    0 -> ListLazyColum(navController = navController, places = places)
                    1 -> MyGoogleMapMultiple(places = places)
                }
            }
            
    }
}


data class TabRowsItems(
    val unselectedIcon:ImageVector,
    val selectedIcon:ImageVector,
    val title:String
)