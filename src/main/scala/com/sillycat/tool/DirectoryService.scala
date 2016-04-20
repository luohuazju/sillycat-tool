package com.sillycat.tool

import java.io.File

/**
  * Created by carl on 4/19/16.
  */
object DirectoryService
  extends IncludeLogger
{

  def listAllFilesInMajor(path: String):Option[Seq[File]] = {
    val root = new File(path)
    root match {
      case root if root.exists() && root.isDirectory => {
        val files = root.listFiles().filter(_.isFile)
        Some(files)
      }
      case _ => {
        logger.error("The path is wrong, check the path = " + path)
        None
      }
    }
  }

  def listAllFilesInMinor(path: String):Option[Seq[File]] = {
    val root = new File(path)
    root match {
      case root if root.exists() && root.isDirectory => {
        val subs = root.listFiles
        val paths = subs.flatMap{
          case sub:File if sub.isDirectory => {
            val filePaths = sub.listFiles().filter(_.isFile)
            filePaths
          }
        }
        Some(paths.toSeq)
      }
      case _ => {
        logger.error("The path is wrong, check the path = " + path)
        None
      }
    }

  }

}
