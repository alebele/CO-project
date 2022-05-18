package benchmark.bench;

public interface IBenchmark {
    void run();
    void initialize(Object noOfElements);
    void warmUp();
    void clean();
    void cancel();
    String getResult();
}
