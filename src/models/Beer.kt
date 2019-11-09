package models

class Beer(val id: Int,
  val name: String,
  val manufacturer: String,
  val price: Double,
  val quantity: Int
) {

  companion object {
    var count: Int = 0
  }

  fun getNext() = if (id == count) 1 else id + 1
  fun getPrevious() = if (id == 1) count else id - 1
}