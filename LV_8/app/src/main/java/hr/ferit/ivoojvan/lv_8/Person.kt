package hr.ferit.ivoojvan.lv_8

data class Person(
    var id: String,
    val imageUrl: String,
    var name: String,
    var description: String
){
    constructor():this("","","","")
}