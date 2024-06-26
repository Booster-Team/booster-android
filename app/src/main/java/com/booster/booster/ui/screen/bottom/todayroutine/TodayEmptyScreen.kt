package com.booster.booster.ui.screen.bottom.todayroutine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
import com.booster.booster.ui.theme.LightLabelAccent
import com.booster.booster.ui.theme.LightLabelPrimary

@Composable
fun TodayEmptyScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(354.dp)
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.today_top_back),
                contentDescription = "temp nothing Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(246.dp)
            )
            Text(
                text = "오늘은 휴식입니다.",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                color = LightLabelPrimary,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = "다른 루틴으로 운동하기",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                color = LightLabelAccent,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Preview
@Composable
fun TodayEmptyScreenPreview() {
    TodayEmptyScreen()
}