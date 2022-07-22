package com.example.myrandom

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class RandomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        // 에딧 텍스트
        val et_Number: EditText = findViewById(R.id.number)
        val et_maxNum: EditText = findViewById(R.id.maxNum)

        // 텍스트뷰
        val TV: TextView = findViewById(R.id.TV)
        var txtViewStr: String = ""

        // 버튼
        val createNum: Button = findViewById(R.id.createNum)
        val deleteList: Button = findViewById(R.id.deleteList)


        createNum.setOnClickListener {
            val rnd = Random();

            // 에딧텍스트가 비어있는지 체크(isEmpty() 사용)
            if (et_Number.text.isEmpty() || et_maxNum.text.isEmpty()) {
                // 값이 비어있다면 메세지를 뛰우고 리턴
                Toast.makeText(this, "값을 모두 입력해 주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 에딧 텍스트에 값을 숫자로 바꿔서 저장
            var IntNum: Int = et_Number.text.toString().toInt()
            var IntMax: Int = et_maxNum.text.toString().toInt()

            // 입력값 유효성 체크
            if (IntNum > 40 || IntNum < 1 || IntMax > 1000 || IntMax < 1) {
                Toast.makeText(this, "범위 외 입력입니다!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 텍스트뷰 초기화
            TV.text = ""
            txtViewStr = ""

            // 생성된 난수값을 저장할 배열 생성
            var strarr = Array(IntNum, { 0 })

            // 생성할 난수의 크기에 따라 클수록 줄바꿈을 넣기
            var Enter: Int = 0;
            when (IntMax) {
                in 0 until 10 -> Enter = 10
                in 10 until 100 -> Enter = 8
                in 100..1000 -> Enter = 6
            }

            Log.d("디버깅", "$IntNum \n ${strarr.size} \n $IntMax")


            for (i in 0 until IntNum) {
                strarr[i] = rnd.nextInt(IntMax) + 1
            }

            // 보기좋게 정렬
            strarr.sort()

            // 배열로 생성한 난수값을 출력하기 위해 하나에 문자열에 넣기
            for (i in 0 until IntNum) {
                txtViewStr += strarr[i].toString() + " "
                if (i % Enter == 0 && i != 0)           // 만약 크기가 크다면 줄바꿈
                    txtViewStr += "\n"
            }

            TV.text = txtViewStr
        }

        // 초기화
        deleteList.setOnClickListener {
            et_Number.setText("")
            et_maxNum.setText("")
            TV.text = ""
            txtViewStr = ""


        }

    }
}