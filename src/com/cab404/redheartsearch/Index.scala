package com.cab404.redheartsearch

import java.io.File

/**
 *
 * @author cab404
 */
object Index {

  def crowl(path: File) = {
    if (!path.isDirectory)
      throw new RuntimeException(path.getAbsolutePath + ": Not a directory")
    path.listFiles filter ((b) => b.getName.endsWith(".desktop")) map (new DesktopEntry(_))
  }

}
