package com.sillycat.tool

/**
  * Created by carl on 4/19/16.
  */
object GenerateKeywordsMap
  extends App
   with IncludeLogger
{
   val minorPath = "/opt/data/minor"
   val majorPath = "/opt/data/major"
   val outputPath = "/opt/data/result.txt"

   val minorsOpt = DirectoryService.listAllFilesInMinor(minorPath)
   val majorsOpt = DirectoryService.listAllFilesInMajor(majorPath)

   val results = minorsOpt match {
      case Some(minors) if !minors.isEmpty => {

         logger.debug("System get some minor files, size = " + minors.size)

         majorsOpt match {
            case Some(majors) if !majors.isEmpty => {

               logger.debug("System get some major files, size = " + majors.size)

               val files = majors ++ minors

               val lines = files.map { file =>
                  val key = "$g_sub_industries_keyword[" + RegexUtil.extractIndustry(file.getPath) + "]"
                  val lines = FileService.readFileContent2Seq(file)
                  val value = StringUtil.convertSeq2ArrayString(lines)
                  key + "=" + value
               }

               logger.debug("System get some lines, size = " + lines.size)
               lines
            }
            case _ => {
               logger.error("The major path is wrong, path = " + majorPath )
               Seq.empty
            }
         }
      }
      case _ => {
         logger.error("The minor path is wrong, path = " + minorPath )
         Seq.empty
      }
   }

   FileService.writeSeq2File(outputPath, results)

}
