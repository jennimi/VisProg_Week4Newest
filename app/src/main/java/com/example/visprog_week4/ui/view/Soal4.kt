package com.example.visprog_week4.ui.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_week4.R
import com.example.visprog_week4.data.DataSource
import com.example.visprog_week4.model.Instagram.Picture

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorePageView(pictureList: List<Picture>) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            LazyVerticalGrid (
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .background(darkBG)
            ){
                item (span = { GridItemSpan(3) }) {
                    SearchBar()
                }
                items(pictureList) {
                    PictureCard(picture = it)
                }
                item (span = { GridItemSpan(3)}) {
                    invisibleBox()
                }
            }
        },
        bottomBar = {
            instagramNavBar()
        }
    )
}

@Composable
fun invisibleBox() {
    // don't judge me
    Column (
        modifier = Modifier
            .height(50.dp)
    ) {
        Text(
            text = ""
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        placeholder = {
            Text (
                text = "Search",
                color = Color.White,
                style = TextStyle (
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    fontFamily = onest
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            textColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp),
        leadingIcon = {
            Image (
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search White Icon",
                modifier = Modifier
                    .size(25.dp)
            )
        }
    )
}

@Composable
fun PictureCard(picture: Picture) {

    val context = LocalContext.current

    val onClick: () -> Unit = {
        val text = "${picture.imageName}"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    Image (
        painter = painterResource(id = picture.getImagePath(context)),
        contentDescription = "Picture",
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxHeight()
            .clickable { onClick() },
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExplorePagePreview() {
    ExplorePageView(DataSource().loadExplorePageData())
}