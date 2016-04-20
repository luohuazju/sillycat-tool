package com.sillycat.tool

import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

/**
  * Created by carl on 4/19/16.
  */
class DirectoryServiceSpec
  extends FunSpec
    with Matchers
    with BeforeAndAfter
    with IncludeLogger
{

  describe("DirectoryService") {
    describe("#listAllFilesInMinor") {
      it("ListAllFilesInMinor") {
        val files = DirectoryService.listAllFilesInMinor("/opt/data/minor")
        files should not be empty
        logger.info("The files path = " + files.get.last.getPath)
      }
    }
  }

}
