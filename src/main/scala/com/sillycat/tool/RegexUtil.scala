package com.sillycat.tool

/**
  * Created by carl on 4/19/16.
  */
object RegexUtil {

  def extractIndustry(source: String): String = {
    ///opt/data/minor/350000/350150-[Healthcare - Physician] Pathology.txt
    ///opt/data/major/660000-[Warehousing_Logistics].txt
    val regexMinor = """.*/[0-9]{6}/([0-9]{6})-.*"""r
    val regexMajor = """.*/([0-9]{6})-.*""".r
    val result = regexMinor.findFirstMatchIn(source).map(_ group 1) match{
      case Some(minor) if !minor.isEmpty => { minor }
      case _ => {
        regexMajor.findFirstMatchIn(source).map(_ group 1).getOrElse("")
      }
    }
    result
  }

}
