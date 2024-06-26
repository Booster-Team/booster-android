package com.booster.booster.ui.screen.bottom.todayroutine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
import com.booster.booster.model.DoneCountExerciseItem
import com.booster.booster.ui.theme.LightBrandPrimary
import com.booster.booster.ui.theme.LightLabelAccent
import com.booster.booster.ui.theme.LightLabelDisabledLight
import com.booster.booster.ui.theme.LightLabelPrimary
import com.booster.booster.ui.theme.LightLabelSecondary
import com.booster.booster.ui.theme.LightLabelTertiary
import com.booster.booster.utils.CustomDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodayRatingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 30.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.today_book_gray),
            modifier = Modifier
                .width(37.dp)
                .height(44.dp)
                .padding(end = 15.dp)
                .align(Alignment.End),
            contentDescription = null,
        )

        Scaffold(
            modifier = Modifier.background(Color.Transparent),
            contentColor = Color.Transparent,
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                    title = {
                        Text(
                            text = "Today",
                            modifier = Modifier.padding(start = 10.dp),
                            fontFamily = FontFamily(Font(resId = R.font.intertight_variablefont_wght)),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                RatingMiddleScreen()

                Divider(
                    thickness = 1.5.dp,
                    color = LightLabelDisabledLight,
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 20.dp)
                )

                DoneCountExerciseScreen()
                Spacer(modifier = Modifier.height(10.dp))
                ReStartSetButton()

            }
        }
    }
}

@Composable
fun ReStartSetButton() {
    var showDialog by remember { mutableStateOf(false) }
    var rating by remember { mutableStateOf(0) } // 별의 상태를 관리

    Button(
        onClick = { showDialog = true },
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(start = 20.dp, end = 20.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.5.dp
        ),
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            Color.White
        )
    ) {
        Text(
            text = "운동 다시 시작하기",
            color = LightLabelAccent
        )
    }

    if (showDialog) {
        CustomDialog(
            onDismissRequest = { showDialog = false },
            dismissText = "취소",
            onConfirmation = {
                showDialog = false
                // 루틴 저장해서 서버로 보내주기
            },
            confirmText = "저장",
            dialogTitle = "루틴 평가하기"
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 45.dp, start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in 1..5) {
                    Image(
                        painter = painterResource(
                            id = if (i <= rating) R.drawable.dialog_star_blue else R.drawable.dialog_star_gray
                        ),
                        contentDescription = "Rating",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { rating = i }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ReStartSetButtonPreview() {
    ReStartSetButton()
}

@Composable
fun RatingMiddleScreen() {
    var rating by remember { mutableStateOf(0) }
    var showTip by remember { mutableStateOf(true) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.temp_body),
                contentDescription = "temp resource",
                modifier = Modifier
                    .width(165.dp)
                    .height(154.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = "등 - 이두",
                    fontSize = 18.sp,
                    color = LightLabelPrimary,
                    modifier = Modifier.padding(top = 5.dp)
                )
                Text(
                    text = "Week 21, Day 3",
                    fontSize = 16.sp,
                    color = LightLabelTertiary,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(end = 25.dp)
                .align(Alignment.End),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            for (i in 1..5) {
                Image(
                    painter = painterResource(
                        id = if (i <= rating) R.drawable.star_blue else R.drawable.star_gray
                    ),
                    contentDescription = "Rating",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { rating = i }
                )
            }
        }

        if (showTip) {
           // TipMessage()
        }
    }
}

@Composable
fun DoneCountExerciseScreen() {
    val doneItems = listOf(
        DoneCountExerciseItem("1회차", 2, 8, "등 1", "6월 23일 13:00 PM"),
        DoneCountExerciseItem("2회차", 1, 3, "등 5, 이두 2", "7월 2일 08:30 PM"),
        DoneCountExerciseItem("10회차", 2, 2, "하체 1", "8월 8일 24:00 PM"),
        DoneCountExerciseItem("13회차", 1, 1, "어깨 1", "7월 27일 13:20 PM")
    )

    LazyColumn(
        modifier = Modifier.padding(10.dp)
    ) {
        items(doneItems) { item ->
            DoneCountOneSetScreen(item)
        }
    }
}

@Composable
fun DoneCountOneSetScreen(doneCountExerciseItem: DoneCountExerciseItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = doneCountExerciseItem.sessionNumber,
                color = LightLabelTertiary,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = doneCountExerciseItem.time,
                color = LightLabelTertiary,
                fontSize = 14.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(
                text = "${doneCountExerciseItem.muscleCount}",
                color = LightBrandPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = " / ",
                color = LightLabelSecondary,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "${doneCountExerciseItem.totalMuscleCount}",
                color = LightLabelSecondary,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = " 개",
                color = LightLabelSecondary,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = doneCountExerciseItem.routine,
                color = LightLabelSecondary,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }

    Divider(
        thickness = 1.5.dp,
        color = LightLabelDisabledLight,
        modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp)
    )
}

@Preview
@Composable
fun DoneCountExerciseScreenPreview() {
    DoneCountExerciseScreen()
}

@Preview
@Composable
fun TodayRatingScreenPreview() {
    TodayRatingScreen()
}