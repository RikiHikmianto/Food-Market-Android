package id.rikihikmianto.myfoodmarket.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.rikihikmianto.myfoodmarket.Data.Food
import id.rikihikmianto.myfoodmarket.R

class CardAdapter(private val cardFood: ArrayList<Food>) :
    RecyclerView.Adapter<CardAdapter.CardAdapterViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class CardAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tv_item_name)
        val tvPrice = itemView.findViewById<TextView>(R.id.tv_item_price)
        val imgPhoto = itemView.findViewById<ImageView>(R.id.img_item_photo)
        val tvRating = itemView.findViewById<TextView>(R.id.tv_item_rating)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapterViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_food_market, parent, false)
        return CardAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardAdapterViewHolder, position: Int) {
        val food = cardFood[position]

        Glide.with(holder.itemView.context).load(food.photo)
            .apply(RequestOptions().override(400, 200)).into(holder.imgPhoto)

        holder.tvName.text = food.name
        holder.tvPrice.text = food.price
        holder.tvRating.text = food.rating

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(cardFood[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return cardFood.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Food)
    }
}