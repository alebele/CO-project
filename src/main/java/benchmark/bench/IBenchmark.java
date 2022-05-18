package benchmark.bench;

public interface IBenchmark {
    void run();
    void initialize(int noOfElements);
    void warmUp();
    void clean();
    void cancel();
    String getResult();
}
