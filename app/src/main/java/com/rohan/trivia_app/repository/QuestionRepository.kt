package com.rohan.trivia_app.repository

import android.util.Log
import com.rohan.trivia_app.data.DataOrException
import com.rohan.trivia_app.model.QuestionItem
import com.rohan.trivia_app.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>,
            Boolean,
           Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, java.lang.Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exception", "getAllQuestions:${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}