package hr.ferit.ivoojvan.lv7_exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Call

class ProductRecyclerAdapter(private val items: List<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ProductViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ProductViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val photoImage: ImageView = itemView.findViewById(R.id.imageViewProduct)
        private val productName: TextView = itemView.findViewById(R.id.tvProductName)
        private val productPrice: TextView = itemView.findViewById(R.id.tvPrice)
        private val productRating: TextView = itemView.findViewById(R.id.tvRating)
        private val productDesc: TextView = itemView.findViewById(R.id.tvDescribtion)
        fun bind(products: Product) {
            Glide
                .with(itemView.context)
                .load(products.image_link)
                .centerCrop()
                .into(photoImage)
            productName.text = products.name
            productRating.text = products.rating.toString()
            productPrice.text = products.price.toString()
            productDesc.text = products.description
        }
    }
}