package LLD.Logger.processor.impl;

import LLD.Logger.processor.LoggerProcessor;

public class InfoLoggerProcessor extends LoggerProcessor {

    public InfoLoggerProcessor(LoggerProcessor nextLoggerProcessor) {
        super(nextLoggerProcessor);
    }

    @Override
    public void log(int logLevel, String msg) {
        if (logLevel == INFO_LOGGER) {
            IO.println("INFO: " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}
