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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
import com.booster.booster.model.CommunityItem
import com.booster.booster.ui.theme.BoosterTheme
import com.booster.booster.ui.theme.CommunityChipBorderBody
import com.booster.booster.ui.theme.CommunityChipBorderSelected
import com.booster.booster.ui.theme.CommunityChipBorderUnselected

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreen() {
    val communityItemList = listOf(
        CommunityItem("운동", "제목", "내용", "5월 31일", false),
        CommunityItem("일상", "아파요", "아파서 쉴래요 쉴래요 쉴래요 쉴래요 아파욤 쉴래여 운동안할래용", "6월 1일", false),
        CommunityItem("식단", "소고기", "소고기 먹고 싶어요", "8월 10일", false),
        CommunityItem("운동", "등", "등 운동 추천부탁드려요", "11월 1일", false),
        CommunityItem("식단", "마라탕", "마라탕 먹고 싶어요 마라탕 먹고 싶어요 마라탕 먹고 싶어요", "5월 31일", false),
        CommunityItem("운동", "하체 운동 꿀팁입니다", "열심히 하세요", "1월 11일", false)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                title = {
                    Text(
                        text = "커뮤니티",
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
            ChoiceCommunityChip()

            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEFEFF0)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFAFAFA))
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp)
            ) {
                items(communityItemList) { comm ->
                    CommunityItemScreen(
                        category = comm.category,
                        title = comm.title,
                        body = comm.body,
                        date = comm.date,
                        booked = comm.book,
                    )
                }
            }
        }
    }
}

@Composable
fun ChoiceCommunityChip() {
    var selectedChipIndex by remember { mutableStateOf(-1) }
    val chipLabels = listOf("전체", "운동", "식단", "일상")

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
                    .width(55.dp)
                    .height(30.dp)
                    .border(1.5.dp, borderColor, RoundedCornerShape(20.dp))
                    .background(CommunityChipBorderBody)
                    .clickable { selectedChipIndex = index },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun CommunityItemScreen(
    category: String,
    title: String,
    body: String,
    date: String,
    booked: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(bottom = 10.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp, Color(0xFFEFEFF0))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 30.dp, end = 20.dp, bottom = 15.dp)
        ) {
            Text(
                text = category,
                fontSize = 14.sp,
                color = Color(0xFFB3B4B8),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.community_book),
                contentDescription = "Community Book ",
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
        }

        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = CommunityChipBorderSelected,
            modifier = Modifier.padding(start = 30.dp, end = 20.dp, bottom = 10.dp)
        )

        Text(
            text = body,
            fontSize = 14.sp,
            color = Color(0xFF61646B),
            modifier = Modifier.padding(start = 30.dp, end = 20.dp, bottom = 10.dp)
        )

        Text(
            text = date,
            fontSize = 14.sp,
            color = Color(0xFFB3B4B8),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 30.dp)
        )
    }
}

@Preview
@Composable
fun CommunityItemScreenPreview() {
    CommunityItemScreen("일상", "제목", "내용", "6월 1일", true)
}

@Preview(showBackground = true)
@Composable
fun CommunityScreenPreview() {
    BoosterTheme {
        CommunityScreen()
    }
}