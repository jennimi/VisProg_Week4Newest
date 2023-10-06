package com.example.visprog_week4.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_week4.R
import com.example.visprog_week4.data.DataSource
import com.example.visprog_week4.model.Tokopedia.TokPedCategory
import com.example.visprog_week4.model.Tokopedia.TokPedProducts


@Composable
fun TokopediaView(tokopediaCategoryList: List<TokPedCategory>, tokopediaProductList: List<TokPedProducts>) {
    Column (
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = "Tokopedia",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp),
            )
            Image (
                painter = painterResource(id = R.drawable.more),
                contentDescription = "More Icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 16.dp),
                contentScale = ContentScale.FillWidth
            )
        }
        Image (
            painter = painterResource(id = R.drawable.tokopediablackpink),
            contentDescription = "Tokopedia Banner",
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        Text (
            text = "Categories",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 16.dp)
        )
        LazyRow() {
            items(tokopediaCategoryList) {
                CategoryCard(category = it)
            }
        }
        Text (
            text = "Products",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 10.dp, top = 20.dp, start = 16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ){
            items(tokopediaProductList) {
                ProductCard(product = it)
            }
        }
    }
}

@Composable
fun ProductCard(product: TokPedProducts) {
    Card (
        modifier = Modifier
            .padding(end = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image (
                painter = painterResource(id = product.productImage),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(140.dp)
                    .aspectRatio(1f)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            Text (
                text = "${product.productName}",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text (
                text = "Rp. ${product.price}",
                fontSize = 10.sp
            )
            Text (
                text = "Kota ${product.location}",
                fontSize = 10.sp
            )
            Text (
                text = "${product.sold} Sold",
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun CategoryCard(category: TokPedCategory) {
    Card (
        modifier = Modifier
            .padding(end = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image (
                painter = painterResource(id = category.categoryImage),
                contentDescription = "Category Image",
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(1f)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text (
                text = "${category.categoryName}",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text (
                text = "${category.categoryStock} Products",
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TokopediaPreview() {
    TokopediaView(DataSource().loadTokPedCategoryData(), DataSource().loadTokPedProductData())
}