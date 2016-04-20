package com.sillycat.tool

import org.slf4j.LoggerFactory

/**
  * Created by carl on 4/19/16.
  */
trait IncludeLogger {

  val loggerName = this.getClass.getName

  protected val logger = LoggerFactory.getLogger(loggerName)

}
