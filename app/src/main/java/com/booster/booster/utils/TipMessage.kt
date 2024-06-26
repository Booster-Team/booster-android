package com.booster.booster.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.booster.R

@Composable
fun TipMessage() {
    var showTip by remember { mutableStateOf(true) }

    if (showTip) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.tip_back),
                contentDescription = "Tip Message Background",
                modifier = Modifier
                    .background(Color.White)
                    .size(350.dp, 150.dp)
            )

            Row(
                modifier = Modifier.padding(top = 35.dp, start = 60.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tip_star),
                    contentDescription = "Tip",
                    modifier = Modifier
                        .size(40.dp, 50.dp)
                        .padding(top = 10.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(190.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "별점을 남겨주세요",
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 5.dp)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            painter = painterResource(id = R.drawable.tip_close),
                            contentDescription = "Tip close",
                            modifier = Modifier
                                .size(40.dp, 20.dp)
                                .align(Alignment.CenterVertically)
                                .padding(start = 20.dp, end = 7.dp)
                                .clickable { showTip = false }
                            ,
                        )

                    }
                    Text(
                        text = "별점을 남긴 루틴은 '프로필' 메뉴에서 \n확인할 수 있어요",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
            }

        }
    }

}

@Preview
@Composable
fun TipMessagePreview() {
    TipMessage()
}
