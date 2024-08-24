package com.shahnoza.obhavo.models

data class ForSimpleList(
    val dt:Long,
    val main:MainObj,
    val `weather`:List<SecondWheather>,
    val clouds:Clouds,
    val wind:Wind,
    val visibility:Long,
    val pop:Double,
    val rain:Rain,
    val sys:Sys,
    val dt_txt:String
)
