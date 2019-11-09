package tools

import models.Beer
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement


object BeerDAO {

    val connection = MySqlConnection.getConnection()



    fun get(): MutableList<Beer> {
        val query = "SELECT * FROM biere"
        val beers: MutableList<Beer> = mutableListOf()

        try {
            val statement: Statement = connection.createStatement()
            val result: ResultSet = statement.executeQuery(query)

            while (result.next()) {
                val id: Int = result.getInt("id")
                val name: String = result.getString("nom")
                val manufacturer: String = result.getString("fabricant")
                val price: Double = result.getDouble("prix")
                val quantity: Int = result.getInt("stock")
                beers.add(Beer(id, name, manufacturer, price, quantity))
            }
            Beer.count = beers.size
            statement.close()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
        return beers
    }

    // fun get(id: Int): Beer? {
    //     val query = "SELECT * FROM biere WHERE id=$id"
    //     val beer: Beer
    //
    //     try {
    //         val statement: Statement = connection.createStatement()
    //         val result: ResultSet = statement.executeQuery(query)
    //
    //
    //         val name: String = result.getString("nom")
    //         val manufacturer: String = result.getString("fabricant")
    //         val price: Double = result.getDouble("prix")
    //         beer = Beer(id, name, manufacturer, price)
    //
    //         statement.close()
    //     } catch (e: SQLException) {
    //         throw RuntimeException(e)
    //     }
    //     return beer
    // }
}