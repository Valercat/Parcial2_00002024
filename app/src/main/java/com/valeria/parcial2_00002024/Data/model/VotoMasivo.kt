package com.valeria.parcial2_00002024.Data.model

 class VotoMasivoOptions(
    val id: Int,
    val value: String,
    val votes: Int
)

 class VotoMasivo(
    val id: Int,
    val text: String,
    val options: List<VotoMasivoOptions>
)

class Vote(
    val questionId: Int,
    val optionId: Int
)