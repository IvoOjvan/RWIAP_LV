package hr.ferit.ivoojvan.lv_8

import com.google.firebase.firestore.DocumentId

data class Person(
    var id: String = "",
    val imageUrl: String? = null,
    var name: String? = null,
    var description: String? = null
)