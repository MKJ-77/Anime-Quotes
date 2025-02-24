package com.example.quotes
    var img = emptyList<Int>()
    fun check_anime(anime: String): List<Int> {
        if(anime == "Dragon Ball Z"){
            img = listOf(
                R.drawable.star1dragonball,
                R.drawable.star2dragonball,
                R.drawable.star3dragonball,
                R.drawable.star4dragonball,
                R.drawable.star5dragonball,
                R.drawable.star6dragonball,
                R.drawable.star7dragonball,
            )
        }else if(anime == "Naruto"){
            img = listOf(
                R.drawable.leafninja,
                R.drawable.sharingan,
                R.drawable.solarnaruto,
                R.drawable.uchihaclan
            )
        }
        else {
            img = listOf(
                R.drawable.format_quote
            )
        }
        return img
    }