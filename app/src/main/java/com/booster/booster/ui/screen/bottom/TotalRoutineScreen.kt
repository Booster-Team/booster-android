package com.booster.booster.ui.screen.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
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

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFAFAFA))
            ) {

            }
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