package com.example.codsoft4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.codsoft4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , quizAdapter.Inter {

    public lateinit var binding: ActivityMainBinding
    public lateinit var adapter: quizAdapter
    public lateinit var listOfQuiz : ArrayList<quiz>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listOfQuiz = arrayListOf()
        adapter = quizAdapter(this, listOfQuiz ,this)
        binding.grid.adapter = adapter

        listOfQuiz.add(quiz(1, "Math Quiz"))
        listOfQuiz.add(quiz(2, "Science Quiz"))
        listOfQuiz.add(quiz(3, "History Quiz"))
        listOfQuiz.add(quiz(4, "Geography Quiz"))





    }

    override fun onQuizClick(position: Int, id: Int, name: String) {
        val quizID = listOfQuiz[position].quizID
        val quizName = listOfQuiz[position].quizName

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("id", quizID)
        intent.putExtra("name", quizName)

        startActivity(intent)

        finish()
    }

}