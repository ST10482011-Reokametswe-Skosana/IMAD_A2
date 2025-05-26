package vcmsa.ci.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class Score2 : AppCompatActivity() {

    private lateinit var scoreText: TextView
    private lateinit var feedText: TextView
    private lateinit var reviewText: TextView
    private lateinit var continueButton: Button

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score2)

        scoreText = findViewById(R.id.scoreText)
        feedText = findViewById(R.id.feedText)
        reviewText = findViewById(R.id.reviewText)
        continueButton = findViewById(R.id.continueButton)
        // **Retrieve score correctly**
        val score = intent.getIntExtra("score", 0)
        scoreText.text = "Your score: $score/10"

        // **Feedback based on score**
        val feedback = if (score >= 5) {
            "Amazing work!"
        } else {
            "Practice more!"
        }
        feedText.text = feedback

        continueButton.setOnClickListener {
            val intent = Intent (this, feedback::class.java)
            startActivity(intent)
        }

        // **Retrieve questions and answers correctly**
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()

    }
}




