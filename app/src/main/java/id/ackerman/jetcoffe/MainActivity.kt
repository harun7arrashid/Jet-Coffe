package id.ackerman.jetcoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ackerman.jetcoffe.model.dummyCategory
import id.ackerman.jetcoffe.ui.components.CategoryItem
import id.ackerman.jetcoffe.ui.components.SearchBar
import id.ackerman.jetcoffe.ui.components.SectionText
import id.ackerman.jetcoffe.ui.theme.JetCoffeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp() {

    Column {
        Banner()
        SectionText(stringResource(R.string.section_category))
        CategoryRow()
    }

}

@Composable
fun Banner(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {

        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop, // Fit, Fill Bounds
            modifier = Modifier.height(160.dp)
        )

        SearchBar()

    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp), // untuk mengatur jarak antar item di dalam list
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {

        items(dummyCategory, key = { it.textCategory }) { category -> // key digunakan supaya Lazy List menjadi Efesien ketika ada perubahan data

            CategoryItem(category)

        }
    }
}

@Composable
//@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetCoffeTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeTheme {
        JetCoffeeApp()
    }
}