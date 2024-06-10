package com.booster.booster.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.booster.booster.R
import com.booster.booster.ui.theme.DialogBorder
import com.booster.booster.ui.theme.LightLabelAccent

@Composable
fun CustomDialog(
    onDismissRequest: () -> Unit,
    dismissText: String,
    onConfirmation: () -> Unit,
    confirmText: String,
    dialogTitle: String,
    content: @Composable () -> Unit // 추가: 다이얼로그 내부 컨텐츠
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
        content = {
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(270.dp)
            ) {
                Column(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(
                        text = dialogTitle,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily(Font(resId = R.font.wantedsans_regular)),
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        textAlign = TextAlign.Center
                    )

                    // Rating 줄 부분이 들어갈 곳
                    content()

                    Divider(
                        modifier = Modifier
                            .height(0.33.dp)
                            .background(DialogBorder)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        TextButton(
                            onClick = onDismissRequest,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = dismissText,
                                color = LightLabelAccent,
                            )
                        }
                        Divider(
                            modifier = Modifier
                                .width(0.33.dp)
                                .fillMaxHeight()
                                .background(DialogBorder)
                        )

                        TextButton(
                            onClick = onConfirmation,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = confirmText,
                                color = LightLabelAccent,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
            }
        }

    )
}

@Preview
@Composable
fun CustomDialogPreview() {
    CustomDialog(
        onDismissRequest = {},
        dismissText = "취소",
        onConfirmation = {},
        confirmText = "저장",
        dialogTitle = "루틴 평가하기"
    ) {
        //Text("This is the content of the dialog")
    }
}