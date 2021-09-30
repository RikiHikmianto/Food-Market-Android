package id.rikihikmianto.myfoodmarket.Page

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.rikihikmianto.myfoodmarket.Adapter.CardAdapter
import id.rikihikmianto.myfoodmarket.Data.Food
import id.rikihikmianto.myfoodmarket.Data.FoodData
import id.rikihikmianto.myfoodmarket.R

class MainActivity : AppCompatActivity() {
    private lateinit var rvFoodMarket: RecyclerView
    private var list: ArrayList<Food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Food Market"

        rvFoodMarket = findViewById(R.id.rv_food_market)
        rvFoodMarket.setHasFixedSize(true)

        list.addAll(FoodData.listData)
        showRecyclerlist()
    }

    private fun showRecyclerlist() {
        rvFoodMarket.layoutManager = GridLayoutManager(this, 2)
        val cardAdapter = CardAdapter(list)
        rvFoodMarket.adapter = cardAdapter

        cardAdapter.setOnItemClickCallback(object : CardAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        })
    }

    private fun showSelectedFood(data: Food) {
        val moveData = Intent(this@MainActivity, DetailActivity::class.java)
        moveData.putExtra(DetailActivity.EXTRA_FOOD, data)
        startActivity(moveData)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.action_profile -> {
                showMyProfile()
            }
        }
    }

    private fun showMyProfile() {
        intent = Intent(this@MainActivity, ProfileActivity::class.java)
        startActivity(intent)
    }
}