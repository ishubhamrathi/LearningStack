package LLD.Logger.processor;

public abstract class LoggerProcessor {
    public static int INFO_LOGGER = 1;
    public static int DEBUG_LOGGER = 2;
    public static int ERROR_LOGGER = 3;

    LoggerProcessor nextLoggerProcessor;

    public LoggerProcessor(LoggerProcessor nextLoggerProcessor) {
        this.nextLoggerProcessor = nextLoggerProcessor;
    }

    public void log(int logLevel, String msg) {
        if (nextLoggerProcessor!=null){
            nextLoggerProcessor.log(logLevel, msg);
        }
    }
}
