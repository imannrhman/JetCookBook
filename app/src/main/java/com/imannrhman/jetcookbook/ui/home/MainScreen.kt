package com.imannrhman.jetcookbook.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.imannrhman.jetcookbook.R
import com.imannrhman.jetcookbook.navigation.Screen

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val list by viewModel.mealCategories
    val pagerState = rememberPagerState(initialPage = 0)

    if (!list.isNullOrEmpty()) {
       Column {

           Spacer(modifier = Modifier.height(50.dp))
           Text(
               text = "Category",
               modifier= Modifier.padding(32.dp),
               fontFamily = FontFamily.SansSerif,
               fontWeight = FontWeight.Bold,
               fontSize = 30.sp,
           )
           Spacer(modifier = Modifier.height(10.dp))
           HorizontalPager(
               pageCount = list!!.size,
               state = pagerState,

               ) {page ->
               val categories = list!![page]
               val configuration = LocalConfiguration.current
               val widthInDp = configuration.screenWidthDp.dp
               Box(
                   modifier = Modifier
                       .width(widthInDp)
                       .padding(16.dp)
               ) {
                   Card(
                       shape = RoundedCornerShape(16.dp),
                       modifier = Modifier
                           .padding(top = 30.dp)
                           .fillMaxWidth()
                           .padding(16.dp)
                           .height(150.dp)
                   ) {
                       Box(modifier = Modifier.fillMaxSize()) {
                           Text(
                               text = categories.categoryName,
                               Modifier
                                   .align(Alignment.BottomCenter)
                                   .padding(bottom = 30.dp),
                               fontFamily = FontFamily.SansSerif,
                               fontWeight = FontWeight.SemiBold,
                               fontSize = 20.sp,
                           )
                       }
                   }
                   AsyncImage(
                       model = categories.categoryThumb,
                       contentDescription = categories.categoryName,
                       modifier = Modifier
                           .height(130.dp)
                           .align(Alignment.TopCenter)
                   )


               }
           }
       }
    }

}


