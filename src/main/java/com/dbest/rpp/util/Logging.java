/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dbest.rpp.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/** @author ftadewale */
public class Logging {

  private String className;

  public Logging(String className){
	this.className = className;
  }
  
  public void logInfo(String content){
      Logger.getLogger(this.className).log(Level.INFO, content);
  }

  public void logError(String content){
      Logger.getLogger(this.className).log(Level.SEVERE, content);
  }

  public void logWarning(String content){
      Logger.getLogger(this.className).log(Level.WARNING, content);
  }

}
