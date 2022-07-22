package com.example.myrandom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice : Button = findViewById(R.id.dice)
        val random : Button = findViewById(R.id.random)

        // 생성된 수를 저장할 페이지  ->  미완성
        val save : Button = findViewById(R.id.save)
        save.isEnabled = false

        // 난수값뽑기 페이지 넘기기
        random.setOnClickListener{
            val intent = Intent(this, RandomActivity::class.java)
            startActivity(intent)
        }

        // 주사위 페이지 넘기기
        dice.setOnClickListener{
            val intent = Intent(this, DiceActivity::class.java)
            startActivity(intent)
        }



    }
}