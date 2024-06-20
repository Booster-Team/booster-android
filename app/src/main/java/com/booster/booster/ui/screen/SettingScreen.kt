package com.booster.booster.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.booster.booster.R
import com.booster.booster.ui.theme.LightBackgroundSecondary
import com.booster.booster.ui.theme.LightBrandPrimary
import com.booster.booster.ui.theme.LightLabelPrimary
import com.booster.booster.ui.theme.LightLabelTertiary
import com.booster.booster.ui.theme.LightSeperatorPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "설정",
                        color = LightLabelPrimary,
                        fontSize = 18.sp,
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.setting_back),
                        contentDescription = "Setting Back",
                        tint = LightBrandPrimary,
                        modifier = Modifier
                            .size(20.dp, 22.dp)
                            .padding(start = 5.dp)
                            .clickable {
                                navController.navigate("profile")
                            }
                        ,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.White)
            )
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(LightBackgroundSecondary)
        ) {

            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                color = LightSeperatorPrimary
            )
            SettingTopScreen()
            SettingMiddleScreen()
            SettingThirdScreen()
            SettingBottomScreen()
        }
    }
}

@Composable
fun SettingTopScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(20.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 10.dp)
                .align(Alignment.Center),
        ) {
            Column {
                Text(
                    text = "라즈베리 스쿼트",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = LightLabelPrimary
                )
                Text(
                    text = "내 정보",
                    fontSize = 14.sp,
                    color = LightLabelTertiary
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.profile_in_gray),
                contentDescription = "Edit My Info",
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun SettingMiddleScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(20.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            ) {
                Column {
                    Text(
                        text = "알림",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LightLabelPrimary
                    )
                    Text(
                        text = "루틴, 커뮤니티 업데이트",
                        fontSize = 14.sp,
                        color = LightLabelTertiary
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "Alarm",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                color = LightSeperatorPrimary
            )

            Row(
            ) {
                Column {
                    Text(
                        text = "테마",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LightLabelPrimary
                    )
                    Text(
                        text = "시스템 설정과 동일",
                        fontSize = 14.sp,
                        color = LightLabelTertiary
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "Theme",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                color = LightSeperatorPrimary
            )

            Row(
            ) {
                Column {
                    Text(
                        text = "앱 버전",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LightLabelPrimary
                    )
                    Text(
                        text = "1.0.0",
                        fontSize = 14.sp,
                        color = LightLabelTertiary
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "업데이트",
                    fontSize = 16.sp,
                    color = LightLabelTertiary,
                    modifier = Modifier.padding(top = 7.dp, end = 5.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "App Version",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun SettingThirdScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
    ) {

        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                Text(
                    text = "서비스 소개",
                    fontSize = 16.sp,
                    color = LightLabelPrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "App Version",
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = LightSeperatorPrimary
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
            ) {
                Text(
                    text = "문의하기",
                    fontSize = 16.sp,
                    color = LightLabelPrimary
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "App Version",
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = LightSeperatorPrimary
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.padding(bottom = 15.dp)
            ) {
                Text(
                    text = "약관 및 개인정보처리 동의내역",
                    fontSize = 16.sp,
                    color = LightLabelPrimary
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "App Version"
                )
            }
        }
    }
}

@Composable
fun SettingBottomScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(20.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
    ) {

        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(
                    text = "로그아웃",
                    fontSize = 16.sp,
                    color = LightLabelPrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "Logout",
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = LightSeperatorPrimary
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
            ) {
                Text(
                    text = "탈퇴하기",
                    fontSize = 16.sp,
                    color = LightLabelPrimary
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.profile_in_gray),
                    contentDescription = "Appout",
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    val navController = rememberNavController()
    SettingScreen(navController)
}