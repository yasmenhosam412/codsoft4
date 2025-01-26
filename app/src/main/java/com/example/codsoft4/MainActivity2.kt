package com.example.codsoft4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codsoft4.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), quizQAdapter.Inter {
    private lateinit var binding: ActivityMain2Binding

    private var id: Int = 0
    private var name: String = ""
    public lateinit var adapter: quizQAdapter

    public lateinit var listOfQ: ArrayList<quizQ>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listOfQ = arrayListOf()
        adapter = quizQAdapter(listOfQ, this)

        binding.rec.adapter = adapter
        binding.rec.layoutManager = LinearLayoutManager(this)

        id = intent.getIntExtra("id", 0)
        name = intent.getStringExtra("name") ?: "Unknown"

        binding.textView3.text = "ID: $id"
        binding.textView4.text = "Name: $name"

        binding.button4.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.button5.setOnClickListener {
            getResult(id)
        }

        checkQuiz(id)
    }

    private fun getResult(id: Int) {
        var correctAnswers = 0

        for (i in listOfQ.indices) {
            val selectedAnswer = listOfQ[i].selectedAnswer
            if (selectedAnswer == listOfQ[i].correctAns) {
                correctAnswers++
            }
        }

        val result = correctAnswers


        openAlert(
            this, result
        )


    }

    private fun openAlert(context: Context, result: Int) {
        val builder = AlertDialog.Builder(context)

        // Inflate custom layout
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_quiz_result, null)

        // Get views from the layout
        val resultTextView = dialogView.findViewById<TextView>(R.id.tvResult)
        val btnClose = dialogView.findViewById<Button>(R.id.btnClose)

        resultTextView.text = "Your Score: $result"

        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.show()

        btnClose.setOnClickListener {
            alertDialog.dismiss()
            startActivity(
                Intent(
                    this, MainActivity::class.java
                )
            )
            finish()
        }
    }

    private fun checkQuiz(id: Int) {
        listOfQ.clear()

        if (id == 1) {
            listOfQ.add(quizQ(id, "What is 15 × 4?", "45", "50", "60", "65", 3))
            listOfQ.add(quizQ(id, "What is the square root of 81?", "7", "8", "9", "10", 3))
            listOfQ.add(
                quizQ(
                    id,
                    "If a triangle has angles of 40° and 60°, what is the third angle?",
                    "70°",
                    "80°",
                    "90°",
                    "100°",
                    2
                )
            )
            listOfQ.add(quizQ(id, "What is 12 ÷ 4 + 3 × 2?", "3", "9", "10", "12", 3))
            listOfQ.add(
                quizQ(
                    id,
                    "If x = 5, what is the value of 2x² + 3x - 4?",
                    "51",
                    "47",
                    "55",
                    "61",
                    1
                )
            )
        } else if (id == 2) {
            listOfQ.add(
                quizQ(
                    id,
                    "What is the chemical symbol for water?",
                    "O₂",
                    "H₂O",
                    "CO₂",
                    "O₃",
                    2
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Which planet is known as the 'Red Planet'?",
                    "Earth",
                    "Mars",
                    "Venus",
                    "Jupiter",
                    2
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "What is the most abundant gas in the Earth's atmosphere?",
                    "Oxygen",
                    "Carbon Dioxide",
                    "Nitrogen",
                    "Hydrogen",
                    3
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "What is the process by which plants make their own food?",
                    "Respiration",
                    "Photosynthesis",
                    "Digestion",
                    "Transpiration",
                    2
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Who is known as the father of modern physics?",
                    "Albert Einstein",
                    "Isaac Newton",
                    "Galileo Galilei",
                    "Nikola Tesla",
                    1
                )
            )
        } else if (id == 3) {
            listOfQ.add(
                quizQ(
                    id,
                    "Who was the first president of the United States?",
                    "George Washington",
                    "Abraham Lincoln",
                    "Thomas Jefferson",
                    "John Adams",
                    1
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Which year did World War I start?",
                    "1912",
                    "1914",
                    "1916",
                    "1918",
                    2
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Who discovered America?",
                    "Christopher Columbus",
                    "Ferdinand Magellan",
                    "Leif Erikson",
                    "Marco Polo",
                    1
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "In which year did the Titanic sink?",
                    "1908",
                    "1912",
                    "1916",
                    "1920",
                    2
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "What was the name of the ship that carried the Pilgrims to America in 1620?",
                    "Mayflower",
                    "Santa Maria",
                    "Endeavour",
                    "Discovery",
                    1
                )
            )
        } else if (id == 4) {
            listOfQ.add(
                quizQ(
                    id,
                    "What is the capital city of France?",
                    "Berlin",
                    "Madrid",
                    "Paris",
                    "Rome",
                    3
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Which is the largest ocean in the world?",
                    "Atlantic Ocean",
                    "Indian Ocean",
                    "Southern Ocean",
                    "Pacific Ocean",
                    4
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Mount Everest is located in which country?",
                    "India",
                    "Nepal",
                    "China",
                    "Bhutan",
                    2
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Which continent is the Sahara Desert located in?",
                    "Asia",
                    "Africa",
                    "Australia",
                    "South America",
                    2
                )
            )
            listOfQ.add(
                quizQ(
                    id,
                    "Which country has the most population in the world?",
                    "India",
                    "USA",
                    "China",
                    "Russia",
                    3
                )
            )
        }

        Toast.makeText(this, "$id", Toast.LENGTH_SHORT).show()

        adapter.notifyDataSetChanged()
    }

    override fun onAnswerSelected(questionPos: Int, selectedAnswer: Int) {
        listOfQ[questionPos].selectedAnswer = selectedAnswer
        val correctAnswer = listOfQ[questionPos].correctAns

    }
}
