package com.example.framgianguyenvulan.kotlinbeginning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.framgianguyenvulan.kotlinbeginning.data.EmployeeTask
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val value: Any = EmployeeTask(2,"2",3,"me")
        text_test.text="Hello"

    }

}
