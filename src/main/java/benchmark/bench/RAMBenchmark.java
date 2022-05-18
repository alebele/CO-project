package benchmark.bench;

public class RAMBenchmark implements IBenchmark {
    private boolean running;
    private int cellsWritten = 10000;
    private String flag;
    private double cycles;
    private byte bytearray[];

    public void warmUp() {
        int k = 0;
        while (k <=5 ) {
            if (k % 2 == 0) {
                for (int i = 0; i < cellsWritten; i++) {
                    if (bytearray[i] != 1) {
                        flag = "Problems with the memory accurancy";
                    }
                    bytearray[i] = 0;
                }
            } else {
                for (int i = cellsWritten - 1; i >= 0; i--) {
                    if (bytearray[i] != 0) {
                        flag = "Problems with the memory accurancy";
                    }
                    bytearray[i] = 1;
                }
            }
            k++;
        }
    }



    public void run(){
        int k=0;
        while(k<cycles){
            if(k%2==0){
                for(int i=0;i<cellsWritten && running;i++){
                    if(bytearray[i]!=1){
                        flag="Problems with the memory accurancy";
                    }
                    bytearray[i]=0;
                }
            }
            else{
                for(int i=cellsWritten-1;i>=0 && running;i--){
                    if(bytearray[i]!=0){
                        flag="Problems with the memory accurancy";
                    }
                    bytearray[i]=1;
                }
            }
            k++;
        }
    }

    public void initialize(int noOfElements){
        double y;
        y=((Number)noOfElements).doubleValue();
        cycles=Math.pow(10,y);
        bytearray=new byte[cellsWritten];
        for(int i=0;i<cellsWritten;i++){
            bytearray[i]=1;
        }
        flag="Okay with the memory accurancy";
        running=true;
    }

    public void clean(){

    }

    public void cancel(){
        running=false;
    }

    public String getResult(){
        return flag;
    }
}