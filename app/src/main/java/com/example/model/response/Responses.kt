package com.example.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(public val categories: List<MealResponse>)

//coverting Json -> data classes through process of Gson deserilization
data class MealResponse
    (
    @SerializedName("idCategory")  public val  id: String,
    @SerializedName ("strCategory") public val  name: String,
    @SerializedName ("strCategoryDescription") public val  description: String,
    @SerializedName  ("strCategoryThumb") public val  imageUrl: String
    )



