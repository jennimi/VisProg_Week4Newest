package com.example.visprog_week4.ui.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_week4.R
import com.example.visprog_week4.data.DataSource
import com.example.visprog_week4.model.Instagram.Story
import com.example.visprog_week4.model.Instagram.Suggestion
import com.example.visprog_week4.model.Instagram.Feed
import java.text.SimpleDateFormat
import java.util.Calendar

val darkBG = Color(0xFF0B0B0B)
val darkGray = Color(0xFF121212)

val onest = FontFamily (
    Font(R.font.onest_regular, FontWeight.Normal),
    Font(R.font.onest_medium, FontWeight.Medium),
    Font(R.font.onest_semibold, FontWeight.SemiBold),
    Font(R.font.onest_bold, FontWeight.Bold),
    Font(R.font.onest_extrabold, FontWeight.ExtraBold),
    Font(R.font.onest_black, FontWeight.Black)
)

// pls notice what i did
// like-unlike, save-unsave, follow-following-followback, tbh that's it but i added some toast here and there
// ps. i added some values to the dummy data

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramView(storyList: List<Story>, suggestionList: List<Suggestion>, feedList: List<Feed>) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .background(darkBG),
        content = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .background(darkBG)
                    .fillMaxHeight()
            ) {
                item {
                    instagramTopBar()
                }
                item {
                    instagramStoryRow(storyList)
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
                var feedCardCount = 5
                for (feed in feedList) {
                    if (feedCardCount % 6 == 0) {
                        item {
                            instagramSuggestionRow(suggestionList)
                        }
                        item {
                            FeedCard(feed = feed)
                        }
                        feedCardCount = 0
                    } else {
                        item {
                            FeedCard(feed = feed)
                        }
                    }
                    feedCardCount++
                }
                item {
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
fun instagramNavBar() {

    val context = LocalContext.current

    val onHomeClick: () -> Unit = {
        val text = "Home"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onExploreClick: () -> Unit = {
        val text = "Explore"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onUploadClick: () -> Unit = {
        val text = "Upload"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onReelsClick: () -> Unit = {
        val text = "Reels"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onProfileClick: () -> Unit = {
        val text = "Profile"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    Box (
        modifier = Modifier
            .background(darkBG)
            .fillMaxWidth()
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .background(darkBG)
        ) {
            Image (
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home Page",
                modifier = Modifier
                    .clickable { onHomeClick() }
            )
            Image (
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Explore Page",
                modifier = Modifier
                    .clickable { onExploreClick() }
            )
            Image (
                painter = painterResource(id = R.drawable.post),
                contentDescription = "Upload Page",
                modifier = Modifier
                    .clickable { onUploadClick() }
            )
            Image (
                painter = painterResource(id = R.drawable.reels),
                contentDescription = "Reels Page",
                modifier = Modifier
                    .clickable { onReelsClick() }
            )
            Image (
                painter = painterResource(id = R.drawable.account),
                contentDescription = "Profile Page",
                modifier = Modifier
                    .clickable { onProfileClick() }
            )
        }
    }
}

@Composable
fun instagramTopBar() {

    val context = LocalContext.current

    val onInstagramLogoClick: () -> Unit = {
        val text = "Instagram"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onLikeLogoClick: () -> Unit = {
        val text = "Notifications"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onDmLogoClick: () -> Unit = {
        val text = "DM"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 13.dp)
    ){
        Image (
            painter = painterResource(id = R.drawable.logo_dark),
            contentDescription = "Instagram Logo",
            modifier = Modifier
                .clickable { onInstagramLogoClick() }
        )
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image (
                painter = painterResource(id = R.drawable.like),
                contentDescription = "Notifications Logo",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { onLikeLogoClick() },

            )
            Spacer(modifier = Modifier.width(20.dp))
            Image (
                painter = painterResource(id = R.drawable.dm),
                contentDescription = "Dm Logo",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { onDmLogoClick() }
            )
        }
    }
}

@Composable
fun instagramSuggestionRow(suggestionList: List<Suggestion>) {
    LazyRow {
        item {
            Spacer(modifier = Modifier.width(15.dp))
        }
        items(suggestionList) {
            SuggestionCard(suggestion = it)
        }
    }
}

@Composable
fun instagramStoryRow(storyList: List<Story>) {
    LazyRow {
        item {
            Spacer(modifier = Modifier.width(10.dp))
            val myStory = Story("Your Story", R.drawable.profile_12, true, false)
            StoryCard(myStory)
        }
        items(storyList) {
            StoryCard(story = it)
        }
    }
}

@Composable
fun FeedCard(feed: Feed) {

    val context = LocalContext.current

    val onClick: () -> Unit = {
        val text = "${feed.name} Story"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onMoreLogoClick: () -> Unit = {
        val text = "More Button"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onCommentLogoClick: () -> Unit = {
        val text = "Comment Button"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    val onShareLogoClick: () -> Unit = {
        val text = "Share Button"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clickable { onClick() }
                ) {
                    Image(
                        painter = painterResource(id = feed.profilePicture),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(35.dp)
                            .aspectRatio(1f)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Image(
                        painter = painterResource(R.drawable.story),
                        contentDescription = "Story Border",
                        modifier = Modifier
                            .size(42.dp)
                    )
                }
                // everyone has the story circle logo cuz in the dummy data everyone posted story (otherwise i'd add a simple if else)
                // am i allowed to change the dummy data idk

                Spacer(modifier = Modifier.width(15.dp))
                Text (
                    text = "${feed.name}",
                    fontFamily = onest,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }

            var isFollowingFeed by remember { mutableStateOf(feed.isFollowing) }

            if (!isFollowingFeed) {
                var suggestionButtonText by remember { mutableStateOf("Follow") }
                var suggestionButtonColor by remember { mutableStateOf(Color(0xFF262626)) }
                // i didn't make it blue because instagram made it grey
                var isFollowing by remember { mutableStateOf(false) }
                var suggestionButtonPressed by remember { mutableStateOf(false) }

                LaunchedEffect(suggestionButtonPressed) {
                    if (suggestionButtonPressed) {
                        isFollowing = !isFollowing
                        suggestionButtonPressed = false
                    }
                }

                if (isFollowing) {
                    suggestionButtonText = "Following"
                } else {
                    if (feed.isFollowers) {
                        suggestionButtonText = "Follow Back"
                    } else {
                        suggestionButtonText = "Follow"
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    DisposableFollowButton(
                        text = suggestionButtonText,
                        color = suggestionButtonColor,
                        onClick = {
                            suggestionButtonPressed = true
                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.morebutton),
                        contentDescription = "More Button",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { onMoreLogoClick() }
                    )
                }
            } else {
                Image(
                    painter = painterResource(id = R.drawable.morebutton),
                    contentDescription = "More Button",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { onMoreLogoClick() }
                )
            }
        }
        Image(
            painter = painterResource(id = feed.feedContent),
            contentDescription = "ok",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                DisposableLikeButton(feed = feed)
                Spacer(modifier = Modifier.width(15.dp))
                Image (
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Comment Button",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { onCommentLogoClick() }
                )
                Spacer(modifier = Modifier.width(15.dp))
                Image (
                    painter = painterResource(id = R.drawable.messanger),
                    contentDescription = "Share Button",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { onShareLogoClick() }
                )
            }
            DisposableSaveButton(feed = feed)
        }
        val likeLabel: String

        if (feed.like <= 1) {
            likeLabel = "like"
        } else {
            likeLabel = "likes"
        }

        Text (
            text = "${feed.like} $likeLabel",
            color = Color.White,
            fontFamily = onest,
            modifier = Modifier
                .padding(start = 15.dp),
            fontSize = 13.sp
        )
        ExpandableCaption(feed = feed)
        showDate(feed = feed)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun DisposableSaveButton(feed: Feed) {
    @DrawableRes val saveButton: Int
    val context = LocalContext.current
    var saved by remember { mutableStateOf(feed.isSaves) }
    var text by remember { mutableStateOf("Unsaved") }

    if (saved) {
        saveButton = R.drawable.saved_light
    } else {
        saveButton = R.drawable.save
    }

    val onSaveLogoClick: () -> Unit = {

        saved = !saved

        if (saved) {
            text = "Saved"
        } else {
            text = "Unsaved"
        }

        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    DisposableEffect(Unit) {
        onDispose {
            Toast.makeText(context, "", Toast.LENGTH_SHORT).cancel()
        }
    }

    Image(
        painter = painterResource(id = saveButton),
        contentDescription = "Save Button",
        modifier = Modifier
            .size(25.dp)
            .clickable { onSaveLogoClick() }
    )
}
@Composable
fun DisposableLikeButton(feed: Feed) {
    @DrawableRes val likeButton: Int
    val context = LocalContext.current
    var liked by remember { mutableStateOf(feed.isLike) }
    var text by remember {mutableStateOf("Unliked")}

    if (liked) {
        likeButton = R.drawable.liked
    } else {
        likeButton = R.drawable.like
    }

    val onLikeLogoClick: () -> Unit = {

        liked = !liked

        if (liked) {
            text = "Liked"
        } else {
            text = "Unliked"
        }

        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    DisposableEffect(Unit) {
        onDispose {
            Toast.makeText(context, "", Toast.LENGTH_SHORT).cancel()
        }
    }

    Image(
        painter = painterResource(id = likeButton),
        contentDescription = "Like Button",
        modifier = Modifier
            .size(25.dp)
            .clickable { onLikeLogoClick() }
    )
}
@Composable
fun showDate(feed: Feed) {
    val normalDate = SimpleDateFormat("yyyy-MM-dd")
    val sameYearDate = SimpleDateFormat("MMMM dd")
    val diffYearDate = SimpleDateFormat("MMMM dd, yyyy")
    val date = normalDate.parse(feed.date)
    var dateFormatted by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    calendar.time = date
    dateFormatted = if (Calendar.getInstance().get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
        sameYearDate.format(date)
    } else {
        diffYearDate.format(date)
    }

    Text (
        text = "$dateFormatted",
        color = Color.Gray,
        fontFamily = onest,
        fontSize = 10.sp,
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 2.dp)
    )
}

@Composable
fun ExpandableCaption(feed: Feed) {
    var expanded by remember { mutableStateOf(false) }

    val caption = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = onest,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(feed.name)
        }
        append("  ")
        withStyle(
            style = SpanStyle(
                fontFamily = onest
            )
        ) {
            append(feed.caption)
        }
    }

    val onCaptionClick: () -> Unit = {
        expanded = !expanded
    }

    if (expanded) {
        Text(
            text = "$caption",
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 5.dp)
                .clickable { onCaptionClick() },
            color = Color.White,
            fontFamily = onest,
            fontSize = 13.sp
        )
    } else {
        val result = caption.substring(0, 110)

        Text(
            text = "$result...",
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 5.dp)
                .clickable { onCaptionClick() },
            color = Color.White,
            fontFamily = onest,
            maxLines = 2,
            fontSize = 13.sp
        )
    }
}

@Composable
fun SuggestionCard(suggestion: Suggestion) {
    Column (
        modifier = Modifier
            .padding(end = 20.dp, top = 10.dp, bottom = 20.dp)
    ) {
        Column (
            modifier = Modifier
                .border(0.5.dp, darkGray, shape = RoundedCornerShape(8.dp))
                .background(darkGray, shape = RoundedCornerShape(8.dp))
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box () {
                Image(
                    painter = painterResource(id = suggestion.profilePicture),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(135.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Image (
                    painter = painterResource(id = R.drawable.cancelwhite),
                    contentDescription = "Close Button",
                    modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.TopEnd)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text (
                text = "${suggestion.name}",
                fontFamily = onest,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            var suggestionButtonText by remember { mutableStateOf("Follow") }
            var suggestionButtonColor by remember { mutableStateOf(Color(0xFF0098FE)) }
            var isFollowing by remember { mutableStateOf(false) }
            var suggestionButtonPressed by remember { mutableStateOf(false) }

            LaunchedEffect(suggestionButtonPressed) {
                if (suggestionButtonPressed) {
                    isFollowing = !isFollowing
                    suggestionButtonPressed = false
                }
            }

            if (isFollowing) {
                suggestionButtonText = "Following"
            } else {
                if (suggestion.isFollowers) {
                    suggestionButtonText = "Follow Back"
                } else {
                    suggestionButtonText = "Follow"
                }
            }

            if (isFollowing) {
                suggestionButtonColor = Color(0xFF262626)
            } else {
                suggestionButtonColor = Color(0xFF0098FE)
            }

            DisposableFollowButton(
                text = suggestionButtonText,
                color = suggestionButtonColor,
                onClick = {
                    suggestionButtonPressed = true
                }
            )
        }
    }
}

@Composable
fun DisposableFollowButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(color, shape = RoundedCornerShape(7.dp))
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            fontSize = 13.sp,
            fontFamily = onest,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun StoryCard(story: Story) {

    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    val onClick: () -> Unit = {
        val name = "${story.name}"

        if (name == "Your Story") {
            text = "Your Story"
        } else {
            text = "$name Story"
        }

        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(end = 10.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable { onClick() }
        ) {
            Image(
                painter = painterResource(id = story.profilePicture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(70.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(R.drawable.story),
                contentDescription = "Story Border",
                modifier = Modifier
                    .size(85.dp)
            )
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "${story.name}",
            fontFamily = onest,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.White,
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InstagramPreview() {
    InstagramView(DataSource().loadStoryData(), DataSource().loadSuggestionData(), DataSource().loadFeedData())
}