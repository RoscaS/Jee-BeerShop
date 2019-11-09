package tools

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object MySqlConnection {

    private val URL = "jdbc:mysql://localhost:3306/beershop"
    private val OPT = "?useSSL=false&autoReconnect=true"
    private val USER = "root"
    private val PASS = "root"

    private var connection: Connection

    init {
        try {
            Class.forName("com.mysql.jdbc.Driver")
            connection = DriverManager.getConnection(URL + OPT, USER, PASS)
            println("\u001B[32mMYSQL connection initialized.\u001B[0m")
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } catch (e: ClassNotFoundException) {
            throw RuntimeException(e)
        }
    }

    fun getConnection(): Connection {
        return connection
    }

    fun closeConnection() {
        try {
            connection.close()
            println("\u001B[32mMYSQL connection closed.\u001B[0m")
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
    }
}