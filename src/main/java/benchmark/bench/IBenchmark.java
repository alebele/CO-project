package benchmark.bench;

public interface IBenchmark {
    void run(int time);
    void initialize(int noOfElements);
    void initialize(int noOfElements,int cellsWritten);
    void warmUp();
    void clean();
    void cancel();
    String getResult();
}
