package hr.ferit.ivoojvan.lv7_exercise

import android.graphics.Color

data class Product(
    val id: Number,
    val brand: String,
    val name: String,
    val price: Number,
    val price_sign: String,
    val currency: String,
    val image_link: String,
    val product_link: String,
    val website_link: String,
    val description: String,
    val rating: Double,
    val category: String,
    val product_type: String,
    val tag_list: List<String>,
    val created_at: String,
    val updated_at: String,
    val product_api_url: String,
    val api_featured_image: String,
    //val product_colors: List<ColorData>
)

