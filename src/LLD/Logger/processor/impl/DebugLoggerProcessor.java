package LLD.Logger.processor.impl;

import LLD.Logger.processor.LoggerProcessor;

public class DebugLoggerProcessor extends LoggerProcessor {
    public DebugLoggerProcessor(LoggerProcessor nextLoggerProcessor) { super(nextLoggerProcessor); }

    @Override
    public void log(int logLevel, String msg) {
        if (logLevel == DEBUG_LOGGER) {
            IO.println("DEBUG: " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}
