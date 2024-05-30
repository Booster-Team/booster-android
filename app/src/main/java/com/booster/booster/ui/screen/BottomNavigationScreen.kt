package com.booster.booster.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.booster.booster.R
import com.booster.booster.model.BottomNavigationItem
import com.booster.booster.ui.screen.bottom.CommunityScreen
import com.booster.booster.ui.screen.bottom.ProfileScreen
import com.booster.booster.ui.screen.bottom.TodayRoutineScreen
import com.booster.booster.ui.screen.bottom.TotalRoutineScreen
import com.booster.booster.ui.theme.BoosterTheme

@Composable
fun BottomNavigationScreen(navController: NavController) {
    val bottomDatas = listOf(
        BottomNavigationItem("오늘 루틴", R.drawable.dumbbell_fill, "오늘 루틴"),
        BottomNavigationItem("전체 루틴", R.drawable.square_stack_fill, "전체 루틴"),
        BottomNavigationItem("커뮤니티", R.drawable.ellipsis_bubble_fill, "커뮤니티"),
        BottomNavigationItem("프로필", R.drawable.person_crop_circle_fill, "프로필"),
    )

    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = Color.White,
        contentColor = Color.White,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier
                    .border(BorderStroke(1.dp, Color.LightGray))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    bottomDatas.forEachIndexed { index, bottomData ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable { selectedItem = index }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp),
                                painter = painterResource(id = bottomData.resourceId),
                                contentDescription = bottomData.title,
                                tint = if (selectedItem == index) Color(0xFF282B2E) else Color(
                                    0xFFA8AAB1
                                )
                            )

                            Spacer(modifier = Modifier.padding(2.dp))

                            Text(
                                text = bottomData.title,
                                fontSize = 10.sp,
                                color = if (selectedItem == index) Color(0xFF282B2E) else Color(
                                    0xFFA8AAB1
                                ),
                                modifier = Modifier.padding(top = 3.dp)
                            )
                        }
                    }

                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            when (selectedItem) {
                0 -> TodayRoutineScreen()
                1 -> TotalRoutineScreen()
                2 -> CommunityScreen()
                3 -> ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationScreenPreview() {
    BoosterTheme {
        val navController = rememberNavController()
        BottomNavigationScreen(navController)
    }
}