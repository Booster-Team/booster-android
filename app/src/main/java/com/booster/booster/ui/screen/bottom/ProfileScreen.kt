package com.booster.booster.ui.screen.bottom

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R
import com.booster.booster.ui.theme.BoosterTheme
import com.booster.booster.ui.theme.LightLabelPrimary
import com.booster.booster.ui.theme.LightLabelSecondary
import com.booster.booster.ui.theme.LightLabelTertiary
import com.booster.booster.ui.theme.LightSeperatorPrimary


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.setting),
            contentDescription = "Setting",
            modifier = Modifier
                .size(55.dp)
                .align(Alignment.End)
                .padding(end = 30.dp, top = 20.dp),
        )
        Text(
            text = "Let's Boost!",
            modifier = Modifier.padding(start = 30.dp),
            fontSize = 18.sp,
            color = LightLabelTertiary,
        )

        Row {
            Text(
                text = "라즈베리 스쿼트",
                modifier = Modifier.padding(start = 30.dp, end = 1.dp),
                fontSize = 20.sp,
                color = LightLabelPrimary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "님",
                fontSize = 20.sp,
                color = LightLabelPrimary,
            )
        }

        Row(
            modifier = Modifier.padding(start = 30.dp, top = 30.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_book),
                contentDescription = "Book List Icon",
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterVertically),
            )
            Text(
                text = "북마크 목록",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 16.sp,
                color = LightLabelPrimary,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.profile_in_gray),
                contentDescription = "Click Bookmark",
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.CenterVertically)
                    .padding(end = 20.dp)
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
            color = LightSeperatorPrimary
        )

        DoneScreen()
    }
}

@Composable
fun DoneScreen() {
    Box(
        modifier = Modifier
            .paint(
                painterResource(id = R.drawable.profile_done_back),
                contentScale = ContentScale.FillWidth
            )
            .width(300.dp)
            .height(130.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 30.dp, start = 30.dp)
        ) {
            Text(
                text = "2024년 6월",
                color = Color.White
            )
            Row {
                Column(
                    modifier = Modifier.padding(top = 7.dp)
                ) {
                    Text(
                        text = "부스터 수행 3일",
                        color = LightLabelPrimary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                    Row {
                        Text(
                            text = "운동 10개 완료",
                            color = LightLabelPrimary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        Text(
                            text = "24.06.03",
                            color = LightLabelSecondary,
                            fontSize = 10.sp,
                            modifier = Modifier.align(Alignment.Bottom)
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.profile_in_blue),
                    contentDescription = "Click Bookmark",
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.CenterVertically)
                        .padding(end = 20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DoneScreenPreview() {
    DoneScreen()
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BoosterTheme {
        ProfileScreen()
    }
}