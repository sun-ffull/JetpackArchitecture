package com.sunfull.sqlite1_5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var db : SQLiteHelperSample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = SQLiteHelperSample(this)

        val insertBtn = findViewById<Button>(R.id.insert)
        val inputArea = findViewById<EditText>(R.id.inputArea)
        val getAllBtn = findViewById<Button>(R.id.getAll)
        val result = findViewById<TextView>(R.id.result)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {
            val inputText = inputArea.text.toString()
            db.insert(inputText)
            inputArea.setText("")
        }

        getAllBtn.setOnClickListener {
            val arr = db.getAllData()
            result.text = arr.toString()
        }

        deleteBtn.setOnClickListener {
            db.deleteAll()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}