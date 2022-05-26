package benchmark.bench;

public class CPUBenchmark implements IBenchmark{
    private boolean running;
    private int noOfElements;
    private String result;

    public void warmUp(){
        result="";
        int prevNo=0;
        int nextNo=1;
        int i=1;
        while(i<=50){
            result+=String.valueOf(prevNo)+" ";
            int sum=prevNo+nextNo;
            prevNo=nextNo;
            nextNo=sum;
            i++;
        }
    }

    public void run(){
        result="";
        int prevNo=0;
        int nextNo=1;
        int i=1;
        while(i<=noOfElements && running){
            if(i%17==0){
                result+=String.valueOf(prevNo)+"\n";
            }
            else{
                result+=String.valueOf(prevNo)+", ";
            }
            int sum=prevNo+nextNo;
            prevNo=nextNo;
            nextNo=sum;
            i++;
        }
    }

    public void initialize(int noOfElements){
            this.noOfElements=noOfElements;
            running=true;
    }

    public void clean(){

    }

    public void cancel(){
        running=false;
    }

    public String getResult(){
        return result;
    }
}
