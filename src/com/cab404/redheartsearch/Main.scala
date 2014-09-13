package com.cab404.redheartsearch

import java.io.File

/**
 *
 * @author cab404
 */
class Main extends App {
  val index = Array(
    Index.crowl(new File("/home/cab404/.local/share/applications")),
    Index.crowl(new File("/usr/share/applications"))
  )
}
