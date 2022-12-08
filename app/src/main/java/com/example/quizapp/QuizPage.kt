package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityQuizPageBinding

lateinit var binding:ActivityQuizPageBinding
private var score=0
private var i=0
class QuizPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuizPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data1=Data("Android","Python","C++","iOS",R.drawable.android,"Android")
        val data2=Data("JavaScript","CSS","C#","Python",R.drawable.python,"Python")
        val data3=Data("C","mysql","Java","C++",R.drawable.mysql,"mysql")
        val data4=Data("React","Nodejs",".Net","Ruby",R.drawable.nodejs,"Nodejs")
        val datalist= arrayListOf(data1,data2,data3,data4)
        binding.image.setImageResource(data1.img)
        binding.btn1.text=data1.op1
        binding.btn2.text=data1.op2
        binding.btn3.text=data1.op3
        binding.btn4.text=data1.op4
        i=0
        score=0
        binding.btn1.setOnClickListener{
           if(binding.btn1.text==datalist[i].ans) score++

            binding.apply {
                btn1.isEnabled=false
                btn2.isEnabled=false
                btn3.isEnabled=false
                btn4.isEnabled=false
                btn2.setBackgroundColor(resources.getColor(R.color.grey))
                btn3.setBackgroundColor(resources.getColor(R.color.grey))
                btn4.setBackgroundColor(resources.getColor(R.color.grey))
            }
        }
        binding.btn2.setOnClickListener{
            if(binding.btn2.text==datalist[i].ans) score++
            binding.apply {
                btn1.isEnabled=false
                btn2.isEnabled=false
                btn3.isEnabled=false
                btn4.isEnabled=false
                btn1.setBackgroundColor(resources.getColor(R.color.grey))
                btn3.setBackgroundColor(resources.getColor(R.color.grey))
                btn4.setBackgroundColor(resources.getColor(R.color.grey))
            }
        }
        binding.btn3.setOnClickListener{
            if(binding.btn3.text==datalist[i].ans) score++
            binding.apply {
                btn1.isEnabled=false
                btn2.isEnabled=false
                btn3.isEnabled=false
                btn4.isEnabled=false
                btn2.setBackgroundColor(resources.getColor(R.color.grey))
                btn1.setBackgroundColor(resources.getColor(R.color.grey))
                btn4.setBackgroundColor(resources.getColor(R.color.grey))
            }
        }
        binding.btn4.setOnClickListener{
            if(binding.btn4.text==datalist[i].ans) score++
            binding.apply {
                btn1.isEnabled=false
                btn2.isEnabled=false
                btn3.isEnabled=false
                btn4.isEnabled=false
                btn2.setBackgroundColor(resources.getColor(R.color.grey))
                btn3.setBackgroundColor(resources.getColor(R.color.grey))
                btn1.setBackgroundColor(resources.getColor(R.color.grey))
            }
        }

        binding.next.setOnClickListener {
            i++
            binding.apply {
                btn1.isEnabled = true
                btn2.isEnabled = true
                btn3.isEnabled = true
                btn4.isEnabled = true

                btn1.setBackgroundColor(resources.getColor(R.color.blue))
                btn2.setBackgroundColor(resources.getColor(R.color.blue))
                btn3.setBackgroundColor(resources.getColor(R.color.blue))
                btn4.setBackgroundColor(resources.getColor(R.color.blue))
            }
            if(i>=datalist.size){
                val intent= Intent(applicationContext,GameOver::class.java)
                intent.putExtra("score",score.toString())
                startActivity(intent)
                finish()
            }
            else {
                binding.apply {
                    btn1.text = datalist[i].op1
                    btn2.text = datalist[i].op2
                    btn3.text = datalist[i].op3
                    btn4.text = datalist[i].op4
                    image.setImageResource(datalist[i].img)
                    counter.text=(i+1).toString()+"/4"
                }
            }

        }



    }
}