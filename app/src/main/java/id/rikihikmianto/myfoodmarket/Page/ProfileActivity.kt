package id.rikihikmianto.myfoodmarket.Page

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.rikihikmianto.myfoodmarket.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.title = "My Profile"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}