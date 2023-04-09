package com.rohan.trivia_app.data

data class DataOrException<T, Boolean, E: java.lang.Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)
