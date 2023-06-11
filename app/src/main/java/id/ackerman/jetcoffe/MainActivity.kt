package id.ackerman.jetcoffe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ackerman.jetcoffe.model.*
import id.ackerman.jetcoffe.ui.components.*
import id.ackerman.jetcoffe.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp(modifier: Modifier = Modifier) {

    Scaffold(bottomBar = { BottomBar() }) { innerPadding ->

        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding) // agar gk ketutupan BottomNavigation
        ) {

            Banner()

            HomeSection(
                title = stringResource(R.string.section_category),
                content = { CategoryRow() }
            )

            HomeSection(stringResource(R.string.section_favorite_menu)) {
                MenuRow(dummyMenu)
            }

            HomeSection(stringResource(R.string.section_best_seller_menu)) {
                MenuRow(dummyBestSellerMenu)
            }

            HomeSection(stringResource(R.string.section_best_seller_menu)) {
                MenuRow(dummyBestSellerMenu)
            }

            Spacer(modifier = Modifier.padding(16.dp))

        }

    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {

        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop, // Fit, Fill Bounds
            modifier     = Modifier.height(160.dp)
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
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp), // margin per item
        contentPadding = PaddingValues(horizontal = 16.dp), // padding di Rv nya
        modifier = modifier
    ) {
        
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu)
        }
        
    }

}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

    BottomNavigation(
        contentColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {

        val navigationItems = listOf<BottomBarItem>(

            BottomBarItem(stringResource(R.string.menu_home), Icons.Default.Home),
            BottomBarItem(stringResource(R.string.menu_favorite), Icons.Default.Favorite),
            BottomBarItem(stringResource(R.string.menu_profile), Icons.Default.AccountCircle)
        
        )
        
        navigationItems.map { 
            
            BottomNavigationItem(
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) },
                label = { Text(it.title) },
                selected = it.title == navigationItems[0].title,
                onClick = {}
            )
            
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun CategoryRowPreview() {
    JetCoffeeTheme {
        CategoryRow()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}