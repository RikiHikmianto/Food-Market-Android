package id.rikihikmianto.myfoodmarket.Page

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.rikihikmianto.myfoodmarket.Data.Food
import id.rikihikmianto.myfoodmarket.R

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_FOOD = "extra_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Food"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val imgPhoto = findViewById<ImageView>(R.id.img_photo)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvPrice = findViewById<TextView>(R.id.tv_price)
        val tvDetail = findViewById<TextView>(R.id.tv_detail)
        val tvRating = findViewById<TextView>(R.id.tv_rating)

        val food: Food = intent.getParcelableExtra<Food>(EXTRA_FOOD) as Food
        tvName.text = food.name
        tvPrice.text = food.price
        tvDetail.text = food.detail
        tvRating.text = food.rating
        imgPhoto.setImageResource(food.photo)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}