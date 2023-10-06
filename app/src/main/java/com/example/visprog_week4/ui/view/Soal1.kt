package com.example.visprog_week4.ui.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_week4.R
import com.example.visprog_week4.data.DataSource
import com.example.visprog_week4.model.LineChat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LineView(lineChatList: List<LineChat>) {

    Column (
        modifier = Modifier
            .background(Color.Black)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = "Chats",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 10.dp),
            )
            Image (
                painter = painterResource(id = R.drawable.morebutton),
                contentDescription = "More Icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 16.dp),
                contentScale = ContentScale.FillWidth
            )
        }
        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
        ) {
            items(lineChatList){
                LineChatBox(linechat = it)
            }
        }
    }
}

@Composable
fun LineChatBox(linechat: LineChat) {

    val context = LocalContext.current

    val onClick: () -> Unit = {
        val text = "${linechat.name} Clicked"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    Row (
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.account),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(60.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column (
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Text (
                text = linechat.name,
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
                Text (
                    text = linechat.message,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )
            }
        Spacer(modifier = Modifier.width(5.dp))
        Text (
            text = linechat.date,
            color = Color.White,
            fontSize = 10.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LinePreview() {
    LineView(DataSource().loadLineChat())
}
