package com.example.test.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object Formatting {
    fun converterDate(time: Long): String {
        val timeStamp = Timestamp(time * 1000L)
        val secondApiFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
        val date = secondApiFormat.format(Date(timeStamp.time))
        return date.toString()
    }

    fun roundTheNumber(numInDouble: Double): String {
        return "%.2f".format(numInDouble)
    }
}