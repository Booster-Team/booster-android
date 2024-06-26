package com.booster.booster.ui.screen.bottom.todayroutine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
import com.booster.booster.data.model.Exercise
import com.booster.booster.enums.TargetMuscle
import com.booster.booster.model.TodayExerciseItem
import com.booster.booster.ui.theme.BoosterTheme
import com.booster.booster.ui.theme.LightBrandPrimary
import com.booster.booster.ui.theme.LightBrandPrimaryLight
import com.booster.booster.ui.theme.LightLabelAccent
import com.booster.booster.ui.theme.LightLabelDisabledLight
import com.booster.booster.ui.theme.LightLabelPrimary
import com.booster.booster.ui.theme.LightLabelTertiary
import com.booster.booster.utils.CustomCheckBox
import com.booster.booster.utils.CustomDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodayRoutineScreen() {
    //val exercises by viewModel.exercises -> viewModel을 사용할 때
    // val exercises = listOf<Exercise>() -> 빈 값 Test
    val exercises = listOf(
        Exercise(1, "풀업", TargetMuscle.BACK, "2023-06-01"),
        Exercise(2, "레그프레스", TargetMuscle.LEGS, "2023-06-02"),
        Exercise(3, "체스트프레스", TargetMuscle.CHEST, "2023-06-03")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(
                if (exercises.isEmpty()) {
                    Modifier.background(Color.White)
                } else {
                    Modifier.paint(
                        painterResource(id = R.drawable.today_top_back),
                        contentScale = ContentScale.Crop
                    )
                }
            )
            .padding(top = 30.dp),
    ) {
        if (exercises.isNotEmpty()) {
            Icon(
                painter = painterResource(id = R.drawable.today_book_gray),
                modifier = Modifier
                    .width(37.dp)
                    .height(44.dp)
                    .padding(end = 15.dp)
                    .align(Alignment.End),
                contentDescription = null,
            )
        }
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
                if (exercises.isEmpty()) {
                    TodayEmptyScreen()
                } else {
                    TodayMiddleScreen()
                    TodayProgressScreen()
                    TodayLazyScreen()
                }
            }
        }
    }
}

@Composable
fun TodayMiddleScreen() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.temp_body_white),
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
                .align(Alignment.End)
        ) {
            Text(
                text = "1",
                fontSize = 15.sp,
                color = LightLabelAccent,
            )
            Text(
                text = " / ",
                fontSize = 14.sp,
                color = LightLabelDisabledLight,
            )
            Text(
                text = "7",
                fontSize = 15.sp,
                color = LightLabelTertiary
            )
            Text(
                text = " 개",
                fontSize = 14.sp,
                color = LightLabelTertiary
            )
        }
    }
}

@Composable
fun TodayProgressScreen() {
    // 일단 이렇게 설정 -> 나중에는 viewmodel에서 값 받아오기
    LinearProgressIndicator(
        progress = 0.15f,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        trackColor = LightLabelDisabledLight,
        color = LightBrandPrimary
    )
}

@Composable
fun TodayLazyScreen() {
    val todayExerciseItemLists = listOf(
        TodayExerciseItem("암 풀 다운", "등", "4 세트 • 10 회"),
        TodayExerciseItem("벤치 프레스", "가슴", "3 세트 • 12 회"),
        TodayExerciseItem("스쿼트", "하체", "5 세트 • 8 회"),
        TodayExerciseItem("레그 프레스", "하체", "1 세트 • 20 회"),
        TodayExerciseItem("렛 풀 다운", "등", "4 세트 • 15 회"),
        TodayExerciseItem("데드리프트", "등", "5 세트 • 5 회"),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        items(todayExerciseItemLists) { exercise ->
            TodayOneSetScreen(todayExerciseItem = exercise)
        }
        item {
            Spacer(modifier = Modifier.height(30.dp))
            TodaySetDoneButton()
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun TodayOneSetScreen(todayExerciseItem: TodayExerciseItem) {
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 20.dp, start = 25.dp, end = 25.dp, bottom = 20.dp)
        ) {
            Column {
                Row {
                    Text(
                        text = todayExerciseItem.name,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.wantedsans_regular)),
                        fontWeight = FontWeight.Bold,
                        color = LightLabelPrimary,
                        modifier = Modifier.padding(end = 15.dp)
                    )
                    Text(
                        text = todayExerciseItem.type,
                        fontSize = 12.sp,
                        color = Color(0xFF82858B),
                    )
                }
                Row {
                    Text(
                        text = todayExerciseItem.setAndRep,
                        fontSize = 12.sp,
                        color = Color(0xFF82858B),
                        modifier = Modifier.padding(top = 5.dp, start = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            CustomCheckBox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }

    Divider(
        thickness = 1.5.dp,
        color = LightLabelDisabledLight,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    )
}

@Composable
fun TodaySetDoneButton() {
    var showDialog by remember { mutableStateOf(false) }
    var showRatingScreen by remember { mutableStateOf(false) }

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
            LightBrandPrimaryLight
        )
    ) {
        Text(
            text = "운동 완료하기",
            color = LightLabelAccent
        )
    }

    if (showDialog) {
        CustomDialog(
            onDismissRequest = { showDialog = false },
            dismissText = "취소",
            onConfirmation = {
                showDialog = false
                showRatingScreen = true
            },
            confirmText = "확인",
            dialogTitle = "운동을 완료할까요?"
        ) {

        }
    }

    if (showRatingScreen) {
        TodayRatingScreen()
    }
}

@Preview
@Composable
fun TodaySetDoneButtonPreview() {
    TodaySetDoneButton()
}

@Preview
@Composable
fun TodayProgressScreenPreview() {
    TodayProgressScreen()
}


@Preview(showBackground = true)
@Composable
fun TodayRoutineScreenPreview() {
    BoosterTheme {
        TodayRoutineScreen()
    }
}