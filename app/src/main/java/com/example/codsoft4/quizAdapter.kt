package com.example.codsoft4

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.BaseAdapter
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class quizAdapter(var x: Activity, var quizList: ArrayList<quiz>, var inter: Inter) : BaseAdapter() {

    var listColors = arrayListOf(
        R.color.one,
        R.color.two,
        R.color.three,
        R.color.four,
        R.color.five,
        R.color.six,
        R.color.seven,
        R.color.eight,
        R.color.nine,
        R.color.ten,
    )

    interface Inter {
        fun onQuizClick(position: Int , id : Int , name : String)
    }

    override fun getCount(): Int {
        return quizList.size
    }

    override fun getItem(position: Int): Any {
        return quizList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(x)
            view = inflater.inflate(R.layout.quiz_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val currentQuiz = quizList[position]
        holder.name.text = currentQuiz.quizName
        holder.num.text = currentQuiz.quizID.toString()

        // Assign colors based on position to maintain consistency
        val colorResId = listColors[position % listColors.size]
        val color = ContextCompat.getColor(x, colorResId)
        holder.coc.setCardBackgroundColor(color)

        holder.btn.setOnClickListener {
            inter.onQuizClick(position , currentQuiz.quizID , currentQuiz.quizName)
        }

        return view
    }

    private class ViewHolder(view: View) {
        var btn: Button = view.findViewById(R.id.button)
        var name: TextView = view.findViewById(R.id.textView)
        var num: TextView = view.findViewById(R.id.textView2)
        var coc: CardView = view.findViewById(R.id.coc)
    }
}
