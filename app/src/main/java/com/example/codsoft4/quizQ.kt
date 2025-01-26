package com.example.codsoft4

data class quizQ(
    var quizId : Int,
    var quizQ   : String,
    var quizAns   : String,
    var quizAns2   : String,
    var quizAns3   : String,
    var quizAns4   : String,
    var correctAns : Int,
    var selectedAnswer: Int? = null

)
