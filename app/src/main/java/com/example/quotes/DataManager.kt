package com.example.quotes

import android.content.Context
import android.media.Image
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.models.Quote
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DataManager {
    var data = emptyArray<Quote>()
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote : Quote? = null
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsfromfile(context: Context) { // Make it suspendable
        val inputStream = context.assets.open("Quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)

        // Update state on UI thread
//        withContext(Dispatchers.Main) {
            isDataLoaded.value = true
        print(isDataLoaded)
//        }
    }
    fun switchPages(quote: Quote ){
        if(currentPage.value == Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAILS
        }else {
            currentPage.value = Pages.LISTING
        }
    }

}