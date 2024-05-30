package com.booster.booster.ui.screen.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
import com.booster.booster.data.TodayExerciseData
import com.booster.booster.ui.theme.BoosterTheme
import com.booster.booster.ui.theme.LightBrandPrimary
import com.booster.booster.ui.theme.LightLabelDisabledLight
import com.booster.booster.ui.theme.LightLabelPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodayRoutineScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 30.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.book),
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .padding(end = 20.dp)
                .align(Alignment.End),
            contentDescription = null,
        )
        Scaffold(
            contentColor = Color.White,
            containerColor = Color.White,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Color.White),
                    title = {
                        Text(
                            text = "Today",
                            modifier = Modifier.padding(start = 10.dp),
                            fontFamily = FontFamily(Font(resId = R.font.intertight_variablefont_wght)),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            ) {
                Column {
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 30.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.temp_body),
            contentDescription = "temp resource",
            modifier = Modifier
                .width(165.dp)
                .height(154.dp)
        )
        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text(
                text = "Day 3 겨울",
                fontSize = 18.sp,
                color = LightLabelPrimary,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "등 • 이두",
                fontSize = 16.sp,
                color = Color(0xFF61646B),
                modifier = Modifier.padding(top = 5.dp)
            )
        }
        Text(
            text = "7개",
            fontSize = 16.sp,
            color = Color(0xFFA8AAB1),
            modifier = Modifier
                .padding(top = 20.dp, start = 30.dp)
                .align(Alignment.Bottom),
        )
    }
}

@Composable
fun TodayProgressScreen() {
    // 일단 이렇게 설정 -> 나중에는 viewmodel에서 값 받아오기
    LinearProgressIndicator(
        progress = 0.15f,
        modifier = Modifier
            .padding(start = 20.dp, top = 30.dp, end = 20.dp)
            .fillMaxWidth(),
        trackColor = LightLabelDisabledLight,
        color = LightBrandPrimary
    )
}

@Composable
fun TodayLazyScreen() {
    val todayExerciseDataList = listOf(
        TodayExerciseData("암 풀 다운", "등", "4 세트 • 10 회"),
        TodayExerciseData("벤치 프레스", "가슴", "3 세트 • 12 회"),
        TodayExerciseData("스쿼트", "하체", "5 세트 • 8 회"),
        TodayExerciseData("레그 프레스", "하체", "1 세트 • 20 회"),
        TodayExerciseData("렛 풀 다운", "등", "4 세트 • 15 회"),
        TodayExerciseData("데드리프트", "등", "5 세트 • 5 회"),
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(todayExerciseDataList) { exercise ->
            TodayOneSetScreen(todayExerciseData = exercise)
        }
    }
}

@Composable
fun TodayOneSetScreen(todayExerciseData: TodayExerciseData) {
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(end = 25.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 25.dp)
        ) {
            Column {
                Row {
                    Text(
                        text = todayExerciseData.name,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.wantedsans_regular)),
                        fontWeight = FontWeight.Bold,
                        color = LightLabelPrimary,
                        modifier = Modifier.padding(end = 15.dp)
                    )
                    Text(
                        text = todayExerciseData.type,
                        fontSize = 12.sp,
                        color = Color(0xFF82858B),
                    )
                }
                Row {
                    Text(
                        text = todayExerciseData.setAndRep,
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
fun CustomCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = if (checked) R.drawable.checkbox_on else R.drawable.checkbox_off),
        contentDescription = "CheckBox",
        modifier = modifier
            .size(30.dp)
            .clickable { onCheckedChange(!checked) }
    )
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