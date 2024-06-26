package com.booster.booster.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.booster.booster.R

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