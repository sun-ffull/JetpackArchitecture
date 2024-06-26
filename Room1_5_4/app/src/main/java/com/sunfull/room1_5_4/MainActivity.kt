package com.sunfull.room1_5_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sunfull.room1_5_4.adapter.CustomAdapter
import com.sunfull.room1_5_4.db.TextDatabase
import com.sunfull.room1_5_4.entity.TextEntity
import com.sunfull.room1_5_4.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val db = TextDatabase.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.input)
        val insert = findViewById<Button>(R.id.insert)
        val getAllData = findViewById<Button>(R.id.getdata)
        val delete = findViewById<Button>(R.id.delete)

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.testList.observe(this, Observer{
            val customAdapter = CustomAdapter(it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })

        insert.setOnClickListener {
            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")
        }

        getAllData.setOnClickListener {
            viewModel.getData()
        }

        delete.setOnClickListener {
            viewModel.deleteData()
        }
    }
}