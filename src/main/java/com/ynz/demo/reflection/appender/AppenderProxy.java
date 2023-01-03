package com.ynz.demo.reflection.appender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppenderProxy implements IAppendable {
  private IAppendable appender;

  public AppenderProxy(IAppendable appender) {
    this.appender = appender;
  }

  @Override
  public void append() {
    doSomeBefore();
    appender.append();
    doSomeAfter();
  }

  private void doSomeBefore() {
    log.info("before method:");
  }

  private void doSomeAfter() {
    log.info("after method:");
  }
}
