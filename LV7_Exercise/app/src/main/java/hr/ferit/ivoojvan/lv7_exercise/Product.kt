package hr.ferit.ivoojvan.lv7_exercise

data class Product(
    val id: Int,
    val brand: String,
    val name: String,
    val price: Float,
    val price_sign: String,
    val currency: String,
    val image_link: String,
    val product_link: String,
    val website_link: String,
    val description: String,
    val rating: Float,
    val category: String,
    val product_type: String,
    val tag_list: List<String>,
    val created_at: String,
    val updated_at: String,
    val product_api_url: String,
    val api_featured_image: String,
    val product_colors: List<String>
)

data class ResponseData(
    val status: String,
    val code: String,
    val total: Number,
    val data: ArrayList<Product>
)
