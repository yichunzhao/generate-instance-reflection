package com.ynz.demo.reflection.appender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Appender implements IAppendable {

  public void append() {
    log.info(this + " ...appending...");
  }
}
