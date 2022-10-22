package com.example.bigposmvvm.data.database.dao

import androidx.room.*
import com.example.bigposmvvm.data.database.entities.relations.PEDIDO_WITH_PRODUCT_P
import com.example.bigposmvvm.data.database.entities.M_USER
import com.example.bigposmvvm.data.database.entities.*

@Dao
interface BigPosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPedido(vararg pedido: M_PEDIDO): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductP(vararg productP: M_PRODUCT_P): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFPago(vararg mFormadepago: M_FORMADEPAGO): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTercero(vararg mTercero: M_TERCERO): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListPrice(vararg mListaprecio: M_LISTAPRECIO): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticulo(vararg mArticulo: M_ARTICULO): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSinonimo(vararg mSinonimo: M_SINONIMO): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVendedor(vararg mVendedor: M_VENDEDOR): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg mUser: M_USER): List<Long>

    @Query("SELECT * FROM M_USER WHERE NombreUsuario = :user")
    fun getUser(user:String): M_USER

    @Query("SELECT * FROM pedido")
    fun getAllPedido(): MutableList<M_PEDIDO>

    @Query("SELECT * FROM m_formadepago")
    fun getAllFPago(): List<M_FORMADEPAGO>

    @Query("SELECT * FROM m_tercero")
    fun getAllTercero(): List<M_TERCERO>

    @Query("SELECT * FROM m_listaprecio")
    fun getAllListaPrecio(): List<M_LISTAPRECIO>

    @Query("SELECT * FROM m_articulo")
    fun getAllArticles(): List<M_ARTICULO>

    @Query("SELECT * FROM m_sinonimo")
    fun getAllSinonimo(): List<M_SINONIMO>

    @Query("SELECT * FROM m_tercero WHERE NITCLI = :nit")
    fun get(nit: String): M_TERCERO

    @Query("SELECT * FROM m_vendedor WHERE CODVEN = :codVen")
    fun getVendedor(codVen: Int): M_VENDEDOR

    @Query("SELECT * FROM m_sinonimo WHERE REFER = :refer")
    fun getSinonimo(refer: String): M_SINONIMO

    @Query("SELECT * FROM pedido WHERE ID_Pedido = :idPedido")
    fun getPedidoForId(idPedido: Int): M_PEDIDO

    @Transaction
    @Query("SELECT * FROM pedido WHERE ID_Pedido = :ID_Pedido")
    suspend fun getPedidoWithProductP(ID_Pedido: Int): MutableList<PEDIDO_WITH_PRODUCT_P>

    /*@Query(
        "SELECT m_articulo.CODIGOREF, m_articulo.REFER, m_articulo.NOMREF, m_articulo.PORIVA ,m_listaprecio.precio " +
                "FROM m_articulo " +
                "LEFT JOIN m_listaprecio ON m_articulo.CODIGOREF = m_listaprecio.CODIGOREF " +
                "WHERE m_listaprecio.CODLP = :codlp AND m_articulo.ESTADO = 0"
    )
    fun getArticulosWithTercero(codlp: Int): MutableList<ArticlewithTercero>

    @Query("SELECT m_articulo.CODIGOREF, m_sinonimo.REFER, m_articulo.NOMREF, m_articulo.PORIVA ,m_listaprecio.precio " +
            "From m_articulo " +
            "JOIN m_sinonimo " +
            "ON m_articulo.CODIGOREF = m_sinonimo.CODIGOREF " +
            "LEFT JOIN m_listaprecio " +
            "ON m_articulo.CODIGOREF = m_listaprecio.CODIGOREF " +
            "WHERE m_listaprecio.CODLP = :codlp AND m_articulo.ESTADO = 0")
    fun getListSinonimo(codlp: Int): MutableList<ArticlewithTercero>*/

    @Query("SELECt * FROM m_vendedor")
    fun getAllVendedor(): List<M_VENDEDOR>

    @Delete
    fun deleteProductP(productP: M_PRODUCT_P)

    @Delete
    fun deletePedido(pedido: M_PEDIDO)

    @Query("UPDATE pedido SET total = :total WHERE ID_Pedido = :idPedido")
    fun updatePedidoTotal(total: Double, idPedido: Int)

    @Update
    fun update(pedido: M_PEDIDO)

    @Query("Select * from m_articulo where codigoRef = :cod")
    fun getOnlyArticle(cod: Int): M_ARTICULO

    @Query("Select * from M_TERCERO where NITCLI = :nit")
    fun getOnlyTercero(nit: String): M_TERCERO

    @Query("SELECT * FROM M_FORMADEPAGO WHERE FORPAG = :fpago")
    fun getOnlyFPago(fpago: String): M_FORMADEPAGO

    @Query("Select * from m_listaprecio where CODLP = :codlp and CODIGOREF = :codRef")
    fun getOnlyListaPrecio(codlp: String, codRef: Int): M_LISTAPRECIO

    @Query("Select * from m_sinonimo where REFER = :refer")
    fun getOnlySinonimo(refer: String): M_SINONIMO

    @Query("Select * from m_vendedor where CODVEN = :codVen")
    fun getOnlyVendedor(codVen: Int): M_VENDEDOR

    @Update
    fun updateArticle(articulo: M_ARTICULO)

    @Update
    fun updateTercero(tercero: M_TERCERO)

    @Update
    fun updateFPago(formadepago: M_FORMADEPAGO)

    @Update
    fun updateListaPrecio(listaprecio: M_LISTAPRECIO)

    @Update
    fun updateSinonimo(sinonimo: M_SINONIMO)

    @Update
    fun updateVendedor(vendedor: M_VENDEDOR)

    @Query("Delete from pedido where ID_Pedido = :id")
    fun deletePedido2(id: Int)


}