package id.ackerman.jetcoffe.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


// Contoh State yg salah
@Composable
fun MyScreen(modifier: Modifier = Modifier) {

    // State hanya ada di MyScreen
    var checked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(16.dp)
    ) {

        MySwitch(checked, onCheckedChanged = { checked = it } )
        Text(
            text = if (checked) "ON" else "OFF",
            Modifier.clickable {
                checked = !checked
            }
        )
    }
}

// checked bersifat Immutable (tidak dapat diubah)
@Composable
fun MySwitch(checked: Boolean, onCheckedChanged: (Boolean) -> Unit) {

    Switch(
        checked = checked,
        onCheckedChange = { onCheckedChanged(it) }
    )
}




// Contoh State yg bener
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) }

    StatelessCounter(
        count = count,
        onClick = { count++ },
        modifier = modifier
    )

}


@Composable
fun StatelessCounter(
    count: Int, // state
    onClick: () -> Unit, // event
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {

        Text("Button Clicked $count times:")

        Button(onClick = { onClick() }) {
            Text("Click me Lapet!")
        }

    }

}