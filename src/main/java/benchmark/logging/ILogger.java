package benchmark.logging;

public interface ILogger {

    void close();
    String writeTime(long value, TimeUnit unit);
}
