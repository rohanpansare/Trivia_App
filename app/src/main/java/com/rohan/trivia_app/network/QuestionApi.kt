package com.rohan.trivia_app.network

import com.rohan.trivia_app.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}