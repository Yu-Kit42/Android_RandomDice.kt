package com.example.myrandom

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        // 이미지뷰
        val dice_1: ImageView = findViewById(R.id.img_Dice_1)
        val dice_2: ImageView = findViewById(R.id.img_Dice_2)
        val dice_3: ImageView = findViewById(R.id.img_Dice_3)
        val dice_4: ImageView = findViewById(R.id.img_Dice_4)
        val dice_5: ImageView = findViewById(R.id.img_Dice_5)
        val dice_6: ImageView = findViewById(R.id.img_Dice_6)
        
        val et_diceNum: EditText = findViewById(R.id.et_diceNum)
        val create_dice: Button = findViewById(R.id.btn_createDice)
        val delete_dice: Button = findViewById(R.id.btn_deleteDice)

        // 생성된 수를 저장할 페이지  ->  미완성
        val save_dice: Button = findViewById(R.id.btn_saveDice)
        val rnd = java.util.Random()
        var listDice = Array<Int>(6, { 0 })
        var isSave: Boolean = false
        save_dice.isEnabled = isSave

        // 이미지를 안보이게하기
        dice_1.visibility = View.INVISIBLE
        dice_2.visibility = View.INVISIBLE
        dice_3.visibility = View.INVISIBLE
        dice_4.visibility = View.INVISIBLE
        dice_5.visibility = View.INVISIBLE
        dice_6.visibility = View.INVISIBLE

        create_dice.setOnClickListener {
            
            // 값이 비어 있는지 체크
            if (et_diceNum.text.isEmpty()) {
                Toast.makeText(this, "값을 입력하고 누르세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            
            val diceNum: Int = et_diceNum.text.toString().toInt()
            var rnd_list = Array(diceNum, { 0 })
            var temp: String = ""
            
            // 중복된 자리에 주사위눈이 생성되는지 체크
            var Itemp: Int = 0
            var check: Boolean = false

            // 입력값 유효성 체크
            if (diceNum > 6 || diceNum < 1) {
                Toast.makeText(this, "1 ~ 6 사이를 입력해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            // 다시 이미지뷰 안보이게
            dice_1.visibility = View.INVISIBLE
            dice_2.visibility = View.INVISIBLE
            dice_3.visibility = View.INVISIBLE
            dice_4.visibility = View.INVISIBLE
            dice_5.visibility = View.INVISIBLE
            dice_6.visibility = View.INVISIBLE

            // 주사위 눈이 출력되는 자리가 랜덤하게 만들기 위해서 위치값을 미중복으로 넣음
            for (i in 0 until diceNum) {
                while (true) {
                    Itemp = rnd.nextInt(6)
                    check = true
                    if (i == 0) {
                        rnd_list[i] = Itemp
                        break
                    }
                    for (j in 0 until i) {
                        if (Itemp == rnd_list[j]) {
                            check = false
                            break
                        }
                    }
                    if (check) {
                        rnd_list[i] = Itemp
                        Log.d("디버깅", "$check  ${rnd_list[i]}")
                        break
                    } else {
                        continue
                    }
                }
                
//                Log.d("디버깅", "==========한번중복끝============") 디버그

                // 아이디를 int형으로 가져오기때문에 랜덤값을 더해주면 주사위눈이 랜덤으로 출력됨 
                temp = (R.drawable.dice_1 + rnd.nextInt(6)).toString()
//                Toast.makeText(this, temp, Toast.LENGTH_SHORT).show() 디버그
                
                // 서로다른 자리에 주사위 눈을 출력하기 위해서 when을 사용
                when (rnd_list[i]) {
                    0 -> {
                        dice_1.setImageResource(temp.toInt())
                        dice_1.visibility = View.VISIBLE
                    }
                    1 -> {
                        dice_2.setImageResource(temp.toInt())
                        dice_2.visibility = View.VISIBLE
                    }
                    2 -> {
                        dice_3.setImageResource(temp.toInt())
                        dice_3.visibility = View.VISIBLE
                    }
                    3 -> {
                        dice_4.setImageResource(temp.toInt())
                        dice_4.visibility = View.VISIBLE
                    }
                    4 -> {
                        dice_5.setImageResource(temp.toInt())
                        dice_5.visibility = View.VISIBLE
                    }
                    5 -> {
                        dice_6.setImageResource(temp.toInt())
                        dice_6.visibility = View.VISIBLE
                    }
                }
            }

            // 생성된 수를 저장할 페이지  ->  미완성
            save_dice.isEnabled = true
            listDice = rnd_list
        }

        delete_dice.setOnClickListener {
            dice_1.visibility = View.INVISIBLE
            dice_2.visibility = View.INVISIBLE
            dice_3.visibility = View.INVISIBLE
            dice_4.visibility = View.INVISIBLE
            dice_5.visibility = View.INVISIBLE
            dice_6.visibility = View.INVISIBLE
        }

        // 생성된 수를 저장할 페이지  ->  미완성
        save_dice.setOnClickListener { }


    }
}