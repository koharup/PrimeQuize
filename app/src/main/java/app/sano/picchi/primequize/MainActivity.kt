package app.sano.picchi.primequize

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //10問ってことだと思う
    companion object{
        private const val QUESTION_COUNT: Int = 10
    }
    //ランダム型のRandomをメソッドのランダムにしてる
    var random :Random = Random

    //Int型の配列questionCountをquestionとしている変数
    val questions :IntArray = IntArray(QUESTION_COUNT)
    //Int型のpoint変数
    var point: Int = 0
    var answerCount :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //int型をquestionカウントまで繰り返す
        for (i in 0 until QUESTION_COUNT){
            //numberはInt型で999までの乱数の変数
            val number = random.nextInt(1000)
            //ログをだすnumberってタグでquestion１とかって表示する
            Log.d("number","Question"+ number.toString())
            //配列の一つをnumberとする
            questions[i] = number
        }

        point = 0
        answerCount = 0

        //text型のtextViewにquestionのanswercount回目を表示
        textView.text = questions[answerCount].toString()
        textView.setTextColor(Color.BLACK)
    }

    //素数
    fun maru(view: View){
        //答えをtrueとする
        var answer = true

        val number = questions[answerCount]

        //number(questions[answerCount]だから10回中の答えた数ぶん毎回)
        for (i in 2 until number){
            //素数じゃない時はanswerをfalseにして終了
            if (number % i == 0){
                answer = false
                break
            }
        }
        //素数の時
        if (answer){
            Toast.makeText(this,"正解",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,"不正解",Toast.LENGTH_SHORT).show()
        }

//
//        if(answer){
//            point++
//            Log.d("maru","正解" + point.toString())
//        }else{
//            Log.d("maru","不正解")
//        }

        answerCount++

        if (answerCount == QUESTION_COUNT){
            textView.text= point.toString() + "点"
            textView.setTextColor(Color.RED)

            point = 0
            answerCount = 0
        }else{
            textView.text = questions[answerCount].toString()
            textView.setTextColor(Color.BLACK)
        }
    }

    fun batu(view: View){
        var answer = true

        val number = questions[answerCount]
        for (i in 2 until number){
            if (number % i == 0){
                answer = true
                break
            }
        }

        if (answer){
            Toast.makeText(this,"正解",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,"不正解",Toast.LENGTH_SHORT).show()
        }

        if(answer){
            point++
            Log.d("maru","正解" + point.toString())
        }else{
            Log.d("maru","不正解")
        }

        answerCount++

        if (answerCount == QUESTION_COUNT){
            textView.text= point.toString() + "点"
            textView.setTextColor(Color.RED)

            point = 0
            answerCount = 0
        }else{
            textView.text = questions[answerCount].toString()
            textView.setTextColor(Color.BLACK)
        }
    }



//    fun random (view: View){
//        var number = Random.nextInt(1000)
//        textView.text = number.toString()
//    }
}
