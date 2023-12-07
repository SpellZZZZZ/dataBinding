package com.example.practical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nickNameEditText: EditText
    lateinit var nickNameTextView: TextView
    lateinit var confirmBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        nickNameEditText = findViewById(R.id.nickNameEditText)
        nickNameTextView = findViewById(R.id.nickNameText)
        confirmBtn = findViewById(R.id.confirmBtn)

        confirmBtn.setOnClickListener { changeNickName(it) }
        nickNameTextView.setOnClickListener { updateNickName() }

    }

    private fun changeNickName(view: View){

        if (!nickNameEditText.text.toString().isBlank()) {
            nickNameTextView.text = nickNameEditText.text.toString()
            nickNameEditText.visibility = View.GONE
            nickNameTextView.visibility = View.VISIBLE
            confirmBtn.visibility = View.GONE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun updateNickName(){
        nickNameEditText.requestFocus()
        nickNameEditText.visibility = View.VISIBLE
        confirmBtn.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickNameEditText, 0)
    }


}