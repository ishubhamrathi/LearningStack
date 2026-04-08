package LLD.Logger.manager;

import LLD.Logger.processor.LoggerProcessor;
import LLD.Logger.processor.impl.DebugLoggerProcessor;
import LLD.Logger.processor.impl.ErrorLoggerProcessor;
import LLD.Logger.processor.impl.InfoLoggerProcessor;

public class Logger extends LoggerProcessor {
    private static LoggerProcessor getLoggerProcessor() {
        return new InfoLoggerProcessor(new DebugLoggerProcessor( new ErrorLoggerProcessor(null)));
    }
    public Logger(){
        super(getLoggerProcessor());
    }
}
