package com.booster.booster.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.booster.booster.R
import com.booster.booster.ui.theme.BoosterTheme

@Composable
fun LoginScreen(navController: NavController) {
    val painter = painterResource(id = R.drawable.login_back)

    Box(modifier = Modifier
        .fillMaxSize()
        .paint(painter, contentScale = ContentScale.Crop),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(1f))
            LoginMiddleView()
            Spacer(modifier = Modifier.weight(1f))
            LoginBottomView(navController)
        }
    }
}

@Composable
fun LoginMiddleView() {
    Text(
        text = "Booster",
        fontSize = 40.sp,
        fontFamily = FontFamily(Font(R.font.intertight_variablefont_wght)),
        color = Color(0xFF1E53DC)
    )

    Text(
        text = "운동일지로 Boost up",
        style = MaterialTheme.typography.titleSmall,
        color = Color(0xFF61646B),
        fontSize = 18.sp
    )
}

@Composable
fun LoginBottomView(navController: NavController) {
    Button(
        onClick = { navController.navigate("main")},
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 20.dp, end = 20.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            Color.Black
        )
    ) {
        Icon(
            painterResource(id = R.drawable.ic_google),
            contentDescription = "Google Logo"
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Sign in with Google")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            LoginInfoText("위 버튼을 누르면 ", TextDecoration.None)
            LoginInfoText("서비스 이용약관", TextDecoration.Underline)
            LoginInfoText("과", TextDecoration.None)
        }
        Row {
            LoginInfoText("개인정보처리방침", TextDecoration.Underline)
            LoginInfoText("에 ", TextDecoration.None)
            LoginInfoText("동의하시게 됩니다.", TextDecoration.None)
        }
    }
}

@Composable
fun LoginInfoText(text: String, textDecoration: TextDecoration) {
    Text(
        text = text,
        fontSize = 12.sp,
        textDecoration = textDecoration,
        fontFamily = FontFamily(Font(R.font.wantedsans_regular)),
        color = Color(0xFF61646B)
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    BoosterTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}