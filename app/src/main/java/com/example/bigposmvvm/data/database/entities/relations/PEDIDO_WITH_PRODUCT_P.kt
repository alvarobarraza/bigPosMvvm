package com.example.bigposmvvm.data.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.bigposmvvm.data.database.entities.M_PEDIDO
import com.example.bigposmvvm.data.database.entities.M_PRODUCT_P

data class PEDIDO_WITH_PRODUCT_P(

    @Embedded val pedido: M_PEDIDO,

    @Relation(
        parentColumn = "ID_Pedido",
        entityColumn = "ID_Pedido"
    )
    val productP: MutableList<M_PRODUCT_P>

)
