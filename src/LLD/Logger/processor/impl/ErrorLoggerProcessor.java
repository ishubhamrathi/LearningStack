package LLD.Logger.processor.impl;

import LLD.Logger.processor.LoggerProcessor;

public class ErrorLoggerProcessor extends LoggerProcessor {
    public ErrorLoggerProcessor(LoggerProcessor nextLoggerProcessor) { super(nextLoggerProcessor); }

    @Override
    public void log(int logLevel, String msg) {
        if (logLevel == ERROR_LOGGER) {
            IO.println("ERROR: " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}
