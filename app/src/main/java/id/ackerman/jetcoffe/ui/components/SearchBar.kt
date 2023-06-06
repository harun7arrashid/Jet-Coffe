package id.ackerman.jetcoffe.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ackerman.jetcoffe.R
import id.ackerman.jetcoffe.ui.theme.JetCoffeTheme

@Composable
fun SearchBar(modifier: Modifier = Modifier) {

    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {

        },
        color = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        ),
        modifier = modifier.padding(16.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {

    JetCoffeTheme {
        SearchBar()
    }
}