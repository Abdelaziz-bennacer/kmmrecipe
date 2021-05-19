package fr.abdel.common.domain.domainmodel

import java.util.Collections.emptyList

//import dev.icerock.moko.parcelize.Parcelize
//import dev.icerock.moko.parcelize.Parcelable


//@Parcelize
data class Recipe(
    val id: Long,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Long? = 0,
    val sourceUrl: String? = null,
    val description: String? = null,
    val cookingInstructions: String? = null,
    val ingredients: List<String> = emptyList(),
    val dateAdded: String? = null,
    val dateUpdated: String? = null
    )//:Parcelable
