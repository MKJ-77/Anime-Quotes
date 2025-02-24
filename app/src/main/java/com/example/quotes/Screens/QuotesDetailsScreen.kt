package com.example.quotes.Screens

import android.media.Image
import androidx.activity.compose.BackHandler
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotes.DataManager
import com.example.quotes.R
import com.example.quotes.check_anime
import com.example.quotes.models.Quote

@Composable
fun QuoteDetails(quote: Quote ) {
    BackHandler {
        DataManager.switchPages(quote)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFC6C367),
                        Color(0xFF7BD9BE),
                        Color(0xFFC7D56E),
                    )
                )
            )
    ) {

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
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
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp)
                    )
                }
            }
        }
    }
}
