package com.sillycat.tool

/**
  * Created by carl on 4/19/16.
  */
object StringUtil {

  def convertSeq2ArrayString(list:Seq[String]): String = {
    list.map(item => "\"" + item + "\"") //add "" to each string
      .mkString("array(", "," ,")")  //contact the ele in seq and adding start and end constant
  }

}
