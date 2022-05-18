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
            //System.out.print(prevNo+" ");
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
        while(i<=noOfElements){
            //System.out.print(prevNo+" ");
            result+=String.valueOf(prevNo)+" ";
            int sum=prevNo+nextNo;
            prevNo=nextNo;
            nextNo=sum;
            i++;
        }
    }

    public void initialize(Object noOfElements){
        if((Integer)noOfElements>=0){
            this.noOfElements=(Integer)noOfElements;
            running=true;
        }
        else{
            System.out.println("Wrong input!");
            running=false;
        }
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
