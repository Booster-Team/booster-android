package com.booster.booster.ui.screen.bottom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
import com.booster.booster.model.CalendarRoutineItem
import com.booster.booster.model.FamousRoutineItem
import com.booster.booster.ui.theme.BoosterTheme
import com.booster.booster.ui.theme.CommunityChipBorderBody
import com.booster.booster.ui.theme.CommunityChipBorderSelected
import com.booster.booster.ui.theme.CommunityChipBorderUnselected

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TotalRoutineScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                title = {
                    Text(
                        text = "전체루틴",
                        modifier = Modifier.padding(start = 10.dp),
                        fontFamily = FontFamily(Font(resId = R.font.wantedsans_regular)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.White)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            ChoiceTotalChip()

            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEFEFF0)
            )

            PopularRoutine()
            CalendarRoutine()

        }
    }
}

@Composable
fun CalendarRoutine() {
    val calendarRoutineItemList = listOf(
        CalendarRoutineItem("가을 Day3 - 등, 이두", "1", 10, 2, 3, "레그 익스텐션, 스쿼트, 힙어브", false, "1일 전"),
        CalendarRoutineItem("가을 Day3 - 등, 이두", "1", 10, 2, 3, "레그 익스텐션, 스쿼트, 힙어브", false, "1일 전"),
        CalendarRoutineItem("가을 Day3 - 등, 이두", "1", 10, 2, 3, "레그 익스텐션, 스쿼트, 힙어브", false, "1일 전"),
        CalendarRoutineItem("가을 Day3 - 등, 이두", "1", 10, 2, 3, "레그 익스텐션, 스쿼트, 힙어브", false, "1일 전"),
        CalendarRoutineItem("가을 Day3 - 등, 이두", "1", 10, 2, 3, "레그 익스텐션, 스쿼트, 힙어브", false, "1일 전"),
        CalendarRoutineItem("가을 Day3 - 등, 이두", "1", 10, 2, 3, "레그 익스텐션, 스쿼트, 힙어브", false, "1일 전")
    )
    Column(
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 5.dp)
            .background(Color.White)
    ) {
        Text(
            text = "1월",
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold,
            color = CommunityChipBorderSelected,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        LazyColumn {
            items(calendarRoutineItemList) { item ->
                CalendarRoutineItemScreen(item)
            }
        }
    }

}

@Composable
fun CalendarRoutineItemScreen(calendarRoutineItem: CalendarRoutineItem) {
    Card(
        modifier = Modifier
            .width(382.dp)
            .height(128.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, color = Color(0xFFEFEFF0))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 12.dp, top = 10.dp, start = 15.dp)
        ) {
            Text(
                text = calendarRoutineItem.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.community_book),
                contentDescription = "Community Book ",
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 12.dp, top = 5.dp, start = 15.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "★${calendarRoutineItem.rating}",
                color = Color(0xFF61646B),
                fontSize = 14.sp
            )
            Text(
                text = "(${calendarRoutineItem.count})",
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 3.dp, top = 1.dp)
            )
            Text(
                text = "| ✅",
                color = Color(0xFF61646B),
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 3.dp, top = 1.dp)
            )

            Text(
                text = "오운완 ${calendarRoutineItem.done}회",
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 3.dp, top = 1.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 30.dp, end = 12.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "${calendarRoutineItem.sets}개",
                color = Color(0xFF61646B),
                fontSize = 13.sp
            )

            Text(
                text = "|",
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )

            Text(
                text = calendarRoutineItem.exerciseName,
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                lineHeight = TextUnit.Unspecified
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = calendarRoutineItem.createdAt,
                fontSize = 14.sp,
                color = Color(0xFFB3B4B8),
            )
        }
    }
}


@Composable
fun PopularRoutine() {
    val famousRoutineItemList = listOf(
        FamousRoutineItem("가을 Day3 - 등, 이두", "1", 5, 1, 5, "렛풀 다운, 바벨 이두 운동, 데드리프트", false),
        FamousRoutineItem("여름 Day10 - 가슴", "3.8", 120, 8, 1, "벤치 프레스, 케이블 마ㅓㄴ", true),
        FamousRoutineItem("봄 Day1 - 하체", "5", 100, 0, 6, "레그 익스텐션, 스쿼트, 힙 어브덕션", false),
        FamousRoutineItem("겨울 Day3 - 어깨", "3", 11, 2, 10, "사레레, 사레레, 사레레, 사레레, 사레레", true),
        FamousRoutineItem("가을 Day3 - 등, 이두", "4.5", 70, 2, 7, "레그 익스텐션, 스쿼트, 힙 어브덕션", true),
        FamousRoutineItem("여름 Day3 - 하체", "1", 500, 5, 2, "스쿼트, 바벨 스쿼트, 스미스 스쿼트", false)
    )
    Column(
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
    ) {
        Text(
            text = "인기 루틴",
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold,
            color = CommunityChipBorderSelected,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        LazyRow(
            modifier = Modifier.padding(end = 20.dp)
        ) {
            items(famousRoutineItemList) { item ->
                PopularRoutineItemScreen(famousRoutineItem = item)
            }
        }
    }
}

@Composable
fun PopularRoutineItemScreen(famousRoutineItem: FamousRoutineItem) {
    Card(
        modifier = Modifier
            .width(270.dp)
            .height(128.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, color = Color(0xFFEFEFF0))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 12.dp, top = 10.dp, start = 12.dp)
        ) {
            Text(
                text = famousRoutineItem.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.community_book),
                contentDescription = "Community Book ",
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 12.dp, top = 5.dp, start = 12.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "★${famousRoutineItem.rating}",
                color = Color(0xFF61646B),
                fontSize = 14.sp
            )
            Text(
                text = "(${famousRoutineItem.count})",
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 3.dp, top = 1.dp)
            )
            Text(
                text = "| ✅",
                color = Color(0xFF61646B),
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 3.dp, top = 1.dp)
            )

            Text(
                text = "오운완 ${famousRoutineItem.done}회",
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 3.dp, top = 1.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 12.dp, top = 30.dp, end = 50.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "${famousRoutineItem.sets}개",
                color = Color(0xFF61646B),
                fontSize = 13.sp
            )

            Text(
                text = "|",
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )

            Text(
                text = famousRoutineItem.exerciseName,
                color = Color(0xFF61646B),
                fontSize = 13.sp,
                lineHeight = TextUnit.Unspecified
            )
        }
    }
}

@Composable
fun ChoiceTotalChip() {
    var selectedChipIndex by remember { mutableStateOf(-1) }
    val chipLabels = listOf("부위", "최신순")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        chipLabels.forEachIndexed { index, label ->
            val isSelected = selectedChipIndex == index
            val borderColor =
                if (isSelected) CommunityChipBorderSelected else CommunityChipBorderUnselected

            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(30.dp)
                    .border(1.5.dp, borderColor, RoundedCornerShape(20.dp))
                    .background(CommunityChipBorderBody)
                    .clickable { selectedChipIndex = index },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = label,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        Icons.Outlined.KeyboardArrowDown,
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .width(20.dp)
                            .height(20.dp),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TotalRoutineScreenPreview() {
    BoosterTheme {
        TotalRoutineScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarRoutinePreview() {
    CalendarRoutine()
}

@Preview
@Composable
fun CalendarRoutineItemPreview() {
    CalendarRoutineItemScreen(
        CalendarRoutineItem(
            "가을 Day3 - 등, 이두",
            "1",
            10,
            2,
            3,
            "레그 익스텐션, 스쿼트, 힙어브",
            false,
            "1일 전"
        )
    )
}

@Preview
@Composable
fun PopularRoutineSmallPreview() {
    PopularRoutineItemScreen(
        FamousRoutineItem(
            "가을 Day3 - 등, 이두",
            "1",
            10,
            2,
            3,
            "레그 익스텐션, 스쿼트, 힙어브",
            false
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PopularRoutinePreview() {
    PopularRoutine()
}