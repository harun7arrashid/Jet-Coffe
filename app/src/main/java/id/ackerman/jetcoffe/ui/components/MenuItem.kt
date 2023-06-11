package id.ackerman.jetcoffe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ackerman.jetcoffe.model.Menu
import id.ackerman.jetcoffe.R

@Composable
fun MenuItem(menu: Menu, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.width(140.dp).shadow(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {

        Column {

            Image(
                painter = painterResource(menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth() // maybe mirip dgn 0dp ConstraintLayout
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))

            )

            Column(modifier = Modifier.padding(8.dp)) {

                Text(
                    text = menu.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis, // menentukan mekanisme jika ada teks yg lebih panjang dari pada ruang yg ada
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.ExtraBold)
                )

                Text(
                    text = menu.price,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Composable
@Preview
fun MenuItemPreview() {
    MaterialTheme {
        MenuItem(
            menu = Menu(R.drawable.menu2, "Hot Pumpkin Spice Latte Premium", "Rp 18.000"),
            modifier = Modifier.padding(8.dp)
        )
    }
}