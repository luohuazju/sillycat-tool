package com.sillycat.tool

import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
  * Created by carl on 4/19/16.
  */
class RegexUtilSpec extends FunSpec
  with Matchers
  with BeforeAndAfter
  with IncludeLogger
{

  describe("RegexUtil") {
    describe("#extractMinorIndustry") {
      it("extract the example 1") {
        val source = "/opt/data/minor/350000/350150-[Healthcare - Physician] Pathology.txt"
        val result = RegexUtil.extractIndustry(source)
        result should not be empty
        result should be ("350150")
      }
      it("extract the example 2"){
        val source = "/opt/data/minor/370000/370040-[Hospitality - Lodging_Resort_Travel] Flight Attendent.txt"
        val result = RegexUtil.extractIndustry(source)
        result should not be empty
        result should be ("370040")
      }
      it("extract the example 3"){
        val source = "/opt/data/major/660000-[Warehousing_Logistics].txt"
        val result = RegexUtil.extractIndustry(source)
        result should not be empty
        result should be ("660000")
      }
    }
  }

}
