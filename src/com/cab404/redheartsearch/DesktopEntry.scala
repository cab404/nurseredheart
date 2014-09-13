package com.cab404.redheartsearch

import java.io.File

import scala.io.Source

/**
 *
 * @author cab404
 */
class DesktopEntry(file: File) extends Runnable {

  val lines = Source.fromFile(file).getLines()

  val parsed = {
    lines filter (_ contains '=') map ((s) => s splitAt (s indexOf '=')) map ((t) => (t._1, t._2 substring 1))
  }

  val title = {
    val potential = parsed filter (_._1 contains "Name") map (_._2)
    if (potential.isEmpty) file.getName else potential next()
  }

  val command = {
    val potential = parsed filter (_._1 contains "Exec") map (_._2)
    if (potential.isEmpty) "" else potential next()
  }

  val keywords = {
    val all = parsed filter (_._1 startsWith "Keywords") map (_._2)
    if (all.nonEmpty) all reduce (_ + _) else ""
  }


  def matches(query: String): Boolean = {
    (query split ' ' filter ((part) => (title contains part) || (keywords contains part))).nonEmpty
  }

  def run(): Unit = Runtime.getRuntime.exec(command)


}
