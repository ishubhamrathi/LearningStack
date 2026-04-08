package LLD.Logger;

import LLD.Logger.manager.Logger;
import LLD.Logger.processor.LoggerProcessor;

class Main {

    void  main() {
        IO.println("==Logger Implementation==");
        Logger logger = new Logger();
        logger.log(LoggerProcessor.INFO_LOGGER, "This is info log");
        logger.log(LoggerProcessor.DEBUG_LOGGER, "This is debug log");
        logger.log(LoggerProcessor.ERROR_LOGGER, "This is error log");
    }

}
