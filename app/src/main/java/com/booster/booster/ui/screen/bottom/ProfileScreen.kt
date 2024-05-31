package com.booster.booster.ui.screen.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.booster.booster.ui.theme.BoosterTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val painter = painterResource(id = R.drawable.profile_back)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter, contentScale = ContentScale.Crop),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    title = {
                        Text(
                            text = "Profile",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .background(Color.Transparent),
                            fontFamily = FontFamily(Font(resId = R.font.intertight_variablefont_wght)),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "라즈베리 스쿼트",
                        modifier = Modifier.padding(start = 30.dp, end = 5.dp),
                        fontSize = 16.sp,
                        color = Color(0xFF61646B),
                    )

                    Image(
                        painter = painterResource(id = R.drawable.profile_name_in),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically)
                            .padding(top = 2.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BoosterTheme {
        ProfileScreen()
    }
}