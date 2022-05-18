package benchmark.logging;

public interface ILogger {

    void write(String s);

    void close();
    void writeTime(long value, TimeUnit unit);
    void writeTime(String str,long value, TimeUnit unit);
}
