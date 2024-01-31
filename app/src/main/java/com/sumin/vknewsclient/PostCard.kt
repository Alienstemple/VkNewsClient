package com.sumin.vknewsclient

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sumin.vknewsclient.ui.theme.VkNewsClientTheme

@Composable
fun PostCard() {
    Card {
        Column(modifier = Modifier.padding(8.dp)) {
            PostHeader()
            Spacer(modifier = Modifier.height(8.dp))
            Text(stringResource(R.string.post_text))
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.post_content_image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics()
        }
    }
}

@Composable
private fun PostHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.post_comunity_thumbnail),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "/dev/null",
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "14:00",
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert, contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun Statistics() {
    Row {
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(R.drawable.ic_views_count, "100")
        }
        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween) {
            IconWithText(R.drawable.ic_share, "3")
            IconWithText(R.drawable.ic_comment, "5")
            IconWithText(R.drawable.ic_like, "20")
        }
    }
}

@Composable
private fun IconWithText(iconRes: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(id = iconRes), contentDescription = null, tint = MaterialTheme.colors.onSecondary)
        Text(text = text, color = MaterialTheme.colors.onSecondary)
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardLight() {
    VkNewsClientTheme(darkTheme = false) {
        PostCard()
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardDark() {
    VkNewsClientTheme(darkTheme = true) {
        PostCard()
    }
}
