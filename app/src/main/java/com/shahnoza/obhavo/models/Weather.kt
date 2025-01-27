package com.shahnoza.obhavo.models

data class Weather(
    val cod:String,
    val message:Int,
    val cnt:Int,
    val `list`:List<ForSimpleList>,
    var city:City,
    val country:String,
    val population:Int,
    val timezone:Int,
    val sunrise:Double,
    val sunset:Double
)
