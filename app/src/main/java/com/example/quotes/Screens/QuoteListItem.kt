package com.example.quotes.Screens

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotes.check_anime
import com.example.quotes.models.Quote


@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    colors = listOf(

//                        Color(0xFFDC3D82),
//                        Color(0xFF6736EC),
//                        Color(0xFFAB44F5),
                        Color(0xFC2E1150),
                        Color(0xFF27174C),
                        Color(0xFF100B40)
                    )
                )
            )
    ) {

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick(quote) }
        ) {
            Row(
                modifier = Modifier
                    .background(Color(0xFFD9DADB))
                    .padding(16.dp)
            ) {
                val img = check_anime(quote.anime)
                when (quote.anime) {
                    "Dragon Ball Z" -> {
                        val modiji = Modifier
                            .size(40.dp)
                        GetImage(modiji, img, quote.anime)
                    }
                    "Naruto" -> {
                        val modiji = Modifier
                            .size(50.dp)
//                            .clip(CircleShape)
                        GetImage(modiji, img, quote.anime)
                    }
                    else -> {
                        val modiji = Modifier
                            .size(40.dp)
                            .rotate(180f)
                            .background(Color.Black)
                        GetImage(modiji, img, "FormatQuote")
                    }
                }


                Spacer(Modifier.padding(4.dp))
                Column(Modifier.weight(1f)) {
                    Text(
                        text = '\"' + quote.text + '\"',
                        color = Color(0xFF012152),
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 2.dp)
                    )

                    Box(
                        modifier = Modifier
                            .background(Color(0xFF9A9595))
                            .fillMaxWidth(.4f)
                            .height(1.dp)
                    )
                    Text(
                        text = quote.author,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF016C3A),
                        modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GetImage(modiji: Modifier, img: List<Int>, title: String) {
    Image(
        painter = painterResource(id = img.random()),
        contentDescription = title,
        colorFilter = if (title == "FormatQuote") {
            ColorFilter.tint(Color.White)
//        } else if (title == "Naruto") {
//            ColorFilter.tint(Color.Red)
        } else null,
        alignment = Alignment.TopStart,
        modifier = modiji
    )

}
