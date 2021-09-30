package id.rikihikmianto.myfoodmarket.Page

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import id.rikihikmianto.myfoodmarket.R

class SplashScreenActivity : AppCompatActivity() {
    val SPLASH_SCREEN: Long = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()

        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(
            {
                intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_SCREEN
        )
    }
}