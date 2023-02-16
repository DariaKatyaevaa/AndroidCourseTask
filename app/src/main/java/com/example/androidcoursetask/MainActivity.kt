package com.example.androidcoursetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

const val CONFIG_CHANGE_COUNT = "configChangeCount"

class MainActivity : AppCompatActivity() {
    private val TAG = "LifecycleFirstActivity"
    private var configChangeCount: Int = 0
    private lateinit var counterText: TextView
    private lateinit var toSecondActivityButton: Button

    private val onButtonClickListener = View.OnClickListener {
        Intent(this, SecondActivity::class.java)
            .putExtra("configChangeCount", configChangeCount)
            .run { startActivity(this) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        setContentView(R.layout.activity_main)

        counterText = findViewById<TextView>(R.id.count_value)
        counterText.text = configChangeCount.toString()

        toSecondActivityButton = findViewById<Button>(R.id.button_go_to_second_activity)
        toSecondActivityButton.setOnClickListener(onButtonClickListener)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CONFIG_CHANGE_COUNT, configChangeCount)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        configChangeCount = savedInstanceState.getInt(CONFIG_CHANGE_COUNT) + 1
        counterText.text = configChangeCount.toString()
    }
}