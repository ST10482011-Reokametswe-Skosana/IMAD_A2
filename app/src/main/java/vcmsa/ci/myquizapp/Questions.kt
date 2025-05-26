package vcmsa.ci.myquizapp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Questions : AppCompatActivity() {

    private lateinit var questionsTextView: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var feedbackTextView: TextView
    private lateinit var btnNext: Button


    companion object {
        val questions = arrayOf(
            "A dog has four limps",
            "Humans can survive without oxygen",
            "The year has ten months",
            "Humans have superpowers",
            "The south african currency is rands",
            "Nelson Mandela spend five years in prison",
            "South Africa has 9 provinces",
            "Water and oil can mix",
            "A square has 3 sides",
            "Pigs can fly"
        )
        val answers = booleanArrayOf(true,false,false,false,true,false,true,false,false,false)
        private var currentQuestionIndex = 0
        private var scoreCounter = 0
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)


        questionsTextView = findViewById(R.id.questionsTextView)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        feedbackTextView = findViewById(R.id.feedBackTextView)
        btnNext = findViewById(R.id.btnNext)


        displayQuestions()

        btnTrue.setOnClickListener {checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }


        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size){
                displayQuestions()
                feedbackTextView.text = ""
                btnTrue.isEnabled =  true
                btnFalse.isEnabled =  true
            } else{
                feedbackTextView.text = "INVALID"
            }

        }
        btnNext.isEnabled = false

    }

    private fun displayQuestions(){
        questionsTextView.text = questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer ==correctAnswer){
            feedbackTextView.text = "correct!"
            scoreCounter++
        } else{
            feedbackTextView.text = "incorrect!"
        }
        btnTrue.isEnabled = false
        btnFalse.isEnabled =  false
        btnNext.isEnabled =  true

        val  intent = Intent(this,Score2::class.java)
        intent.putExtra("score", scoreCounter)
        startActivity(intent)
        finish()
    }


}
