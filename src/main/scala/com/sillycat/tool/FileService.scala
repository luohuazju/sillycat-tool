package com.sillycat.tool


import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * Created by carl on 4/19/16.
  */
object FileService {

  def readFileContent2Seq(file: File):Seq[String] = {
    Source.fromFile(file).getLines().toSeq
  }

  def writeSeq2File(filePath: String, lines: Seq[String]) = {
    val writer = new PrintWriter(new File(filePath))
    lines.foreach { line =>
      writer.write(line)
      writer.write("\n")
    }
    writer.close()
  }

}
