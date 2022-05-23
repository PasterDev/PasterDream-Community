package io.github.pd.pasterdream.util

import net.minecraft.client.Minecraft

import java.io.{File, FileOutputStream, IOException}

object ResourcePackUtil {
  def fetchPack(): Unit = {
    try {
      val resourcePacks = Minecraft.getMinecraft.getResourcePackRepository.getDirResourcepacks.getCanonicalFile
      val pack = new File(resourcePacks + "/")
      if (!pack.exists()) pack.mkdirs()
      generateFile("data/pasterdream/resourcepacks/paster.zip", "paster.zip", pack.getAbsolutePath)
    } catch {
      case e: IOException => e.printStackTrace()
    }

  }

  def generateFile(input: String, name: String, path: String): Unit = {
    try {
      val file = new File(path + "/" + name)
      if (!file.exists) {
        val inputStream = this.getClass.getClassLoader.getResourceAsStream(input)
        val outputStream = new FileOutputStream(file)
        if (inputStream != null) {
          var i = 0
          while ( {
            i = inputStream.read();
            i != -1
          }) outputStream.write(i)
          inputStream.close()
          outputStream.close()
        }
      }
    } catch {
      case _: IOException =>
    }
  }
}
