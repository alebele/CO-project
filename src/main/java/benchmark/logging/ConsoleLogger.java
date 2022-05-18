package benchmark.logging;

public class ConsoleLogger implements ILogger{
    public void write(String s){
        System.out.println(s);
    }
    public void writeTime(long value, TimeUnit unit){
        switch(unit){
            case NANO:
                System.out.println("The time taken for the algorithm is "+value+" ns");
                break;
            case MICRO:
                System.out.println("The time taken for the algorithm is "+value/Math.pow(10,3)+" microseconds");
                break;
            case MILI:
                System.out.println("The time taken for the algorithm is "+value/Math.pow(10,6)+" miliseconds");
                break;
            case SEC:
                System.out.println("The time taken for the algorithm is "+value/Math.pow(10,9)+" seconds");
                break;
        }
    }
    public void writeTime( String str,long value, TimeUnit unit){
        switch(unit){
            case NANO:
                System.out.println(str+" "+value+" ns");
                break;
            case MICRO:
                System.out.println(str+" "+value/Math.pow(10,3)+" microseconds");
                break;
            case MILI:
                System.out.println(str+" "+value/Math.pow(10,6)+" miliseconds");
                break;
            case SEC:
                System.out.println(str+" "+value/Math.pow(10,9)+" seconds");
                break;
        }
    }
    public void close(){

    }
}
