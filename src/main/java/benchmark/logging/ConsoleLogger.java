package benchmark.logging;

public class ConsoleLogger implements ILogger{
    public String writeTime(long value, TimeUnit unit){
        String str="";
        switch(unit){
            case NANO:
                str+=value+" ns";
                break;
            case MICRO:
                str+=value/Math.pow(10,3)+" microseconds";
                break;
            case MILI:
                str+=value/Math.pow(10,6)+" miliseconds";
                break;
            case SEC:
                str+=value/Math.pow(10,9)+" seconds";
                break;
        }
        return str;
    }
    public void close(){

    }
}
