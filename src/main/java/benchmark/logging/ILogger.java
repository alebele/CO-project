package benchmark.logging;

public interface ILogger {

    void close();
    String writeTime(long value, TimeUnit unit);
    /*String writeTime(String str,long value, TimeUnit unit);*/
}
