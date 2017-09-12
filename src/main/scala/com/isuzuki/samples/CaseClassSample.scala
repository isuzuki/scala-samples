package com.isuzuki.samples

case class Item(
  id:         Int,
  categoryId: Int
)

object CaseClassSample extends App {
  // grouping samples
  def grouping: Unit = {
    val items = Seq(
      Item(1, 1),
      Item(2, 1),
      Item(3, 1),
      Item(4, 2),
      Item(5, 2),
      Item(6, 3)
    )

    println(items.groupBy(_.categoryId).mapValues(_.map(_.id)))
    println(items.groupBy(_.categoryId).mapValues(_.foldRight(Nil: List[Int])(_.id :: _)))
    println(items.groupBy(_.categoryId).map { case (k, v) => (k, v.map(_.id)) })
    println(items.groupBy(_.categoryId).transform { case (_, v) => v.map(_.id) })
  }

  grouping
}
