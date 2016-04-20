package com.sillycat.tool

import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}
import java.io.File

/**
  * Created by carl on 4/19/16.
  */
class FileServiceSpec extends FunSpec
  with Matchers
  with BeforeAndAfter
  with IncludeLogger
{

  describe("FileService") {
    describe("#readFileContent2Seq") {
      it("Read the Lines to Seq") {
        val filePath = "/opt/data/minor/660000/660050-[Warehousing_Logistics] Warehouse_Logistics Operations.txt"
        val file = new File(filePath)
        val keywords = FileService.readFileContent2Seq(file)
        keywords should not be empty
        logger.info("The keywords = " + keywords.last)
      }
    }

    describe("#writeSeq2File"){
      it("Write the lines to File"){
        val filePath = "/opt/data/test1.txt"
        val lines = Seq("line1", "line2", "line3")
        FileService.writeSeq2File(filePath, lines)
      }
    }
  }

}

