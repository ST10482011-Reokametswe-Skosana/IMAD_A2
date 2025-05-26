package vcmsa.ci.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class feedback : AppCompatActivity() {

    private lateinit var reviewText: TextView
    private lateinit var exitButton: Button
    private lateinit var reviewButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feedback)


        reviewText = findViewById(R.id.reviewText)
        exitButton = findViewById(R.id.exitButton)
        reviewButton = findViewById(R.id.reviewButton)

        // **Retrieve questions and answers correctly**
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()


        val intent = Intent(this,reviewButton::class.java)


        reviewButton.setOnClickListener {
            val reviewBuilder = StringBuilder()

            if (questions.size == answers.size) {
                for (i in questions.indices) {
                    reviewBuilder.append("${i + 1}). ${questions[i]}\n")
                    reviewBuilder.append("  Answer: ${if (answers[i]) "True" else "False"}\n\n")
                }
        reviewText.text = reviewBuilder.toString()
    } else {
        reviewText.text = "Error: Question and answer count mismatch."
    }
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}