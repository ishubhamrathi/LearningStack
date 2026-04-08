# Logger

Simple logger implementation that routes log messages through a chain of processors for different log levels.

## How To Run

Compile and run from the project root:

```bash
javac -cp src -d out src/LLD/Logger/Main.java src/LLD/Logger/manager/*.java src/LLD/Logger/processor/*.java src/LLD/Logger/processor/impl/*.java
java -cp out LLD.Logger.Main
```

Note:

- `Main.java` currently has `void main()` instead of `public static void main(String[] args)`.
- Update that method signature before running from the command line.

## Sample Test Case

Manual logging flow:

1. Create `Logger logger = new Logger();`
2. Call `logger.log(LoggerProcessor.INFO_LOGGER, "This is info log");`
3. Call `logger.log(LoggerProcessor.DEBUG_LOGGER, "This is debug log");`
4. Call `logger.log(LoggerProcessor.ERROR_LOGGER, "This is error log");`

Expected result:

- `INFO: This is info log`
- `DEBUG: This is debug log`
- `ERROR: This is error log`

Unknown level flow:

1. Call `logger.log(99, "Unknown");`

Expected result:

- No processor handles the request.
- The chain finishes without output.

## Design Principles Used

- Chain of Responsibility: log requests pass through `Info`, `Debug`, and `Error` processors until one handles the message.
- Open/Closed Principle: new log levels can be added by introducing a new processor in the chain.
- Single Responsibility Principle: each processor handles only one log level.
- Abstraction: `LoggerProcessor` defines the shared contract for all processors.

## LLD Design

Core entities:

- `LoggerProcessor` - Abstract base class with a reference to the next processor in the chain.
- `InfoLoggerProcessor` - Handles info messages.
- `DebugLoggerProcessor` - Handles debug messages.
- `ErrorLoggerProcessor` - Handles error messages.
- `Logger` - Builds the processor chain and exposes the top-level logger object.

Interaction flow:

1. Client code creates `Logger`.
2. `Logger` internally wires `Info -> Debug -> Error`.
3. A log request enters the first processor in the chain.
4. If the current processor supports the log level, it prints the message.
5. Otherwise, the request is forwarded to the next processor.
6. If no processor matches, the request ends without output.

## Files

- `Main.java` - Entry point for the logger example.
- `manager/Logger.java` - Logger coordinator that builds the processor chain.
- `processor/LoggerProcessor.java` - Base processor abstraction.
- `processor/impl/InfoLoggerProcessor.java` - Handles info logs.
- `processor/impl/DebugLoggerProcessor.java` - Handles debug logs.
- `processor/impl/ErrorLoggerProcessor.java` - Handles error logs.
