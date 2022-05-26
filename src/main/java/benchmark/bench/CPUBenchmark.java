package benchmark.bench;

import benchmark.timing.ITimer;
import benchmark.timing.Timer;

public class CPUBenchmark implements IBenchmark{
    private boolean running;
    private int noOfElements;
    private String result;

    @Override
    public void initialize(int noOfElements, int cellsWritten) {

    }

    public void warmUp(){
        result="";
        int prevNo=0;
        int nextNo=1;
        int i=1;
        while(i<=10){
            result+=String.valueOf(prevNo)+" ";
            int sum=prevNo+nextNo;
            prevNo=nextNo;
            nextNo=sum;
            i++;
        }
    }

    public void run(int time){
        ITimer timer = new Timer();
        timer.start();
        long check;
        result="";
        int prevNo=0;
        int nextNo=1;
        int i=1;
        while(i<=noOfElements && running){
            check=timer.stop();
            if(check/Math.pow(10,9)>=time){
                running=false;
            }
            if(i%10==0){
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
