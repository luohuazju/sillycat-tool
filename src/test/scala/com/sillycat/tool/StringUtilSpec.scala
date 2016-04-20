package com.sillycat.tool

import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
  * Created by carl on 4/19/16.
  */
class StringUtilSpec
  extends FunSpec
    with Matchers
    with BeforeAndAfter
    with IncludeLogger
{

  describe("StringUtil") {
    describe("#convertSeq2ArrayString") {
      it("convert seq to array(\"a\", \"b\")") {
        val list = Seq("a", "b", "c")
        val result = StringUtil.convertSeq2ArrayString(list)
        result should not be empty
        result should be ("array(\"a\",\"b\",\"c\")")
      }
    }
  }

}
