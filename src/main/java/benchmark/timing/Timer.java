package benchmark.timing;

import benchmark.timing.ITimer;

public class Timer implements ITimer {
    static long totalTime;
    static long start,end;

    /**
     * Starts the timer, sets the total time on zero.
     */
    public void start(){
        start=System.nanoTime();
        totalTime=0;
    }

    /**
     * Stops the timer.
     * @return return the cumulated elapsed time from the beginning
     */
    public long stop(){
        end=System.nanoTime();
        totalTime+=end-start;
        return totalTime;
    }

    public void resume(){
        start=System.nanoTime();
    }

    public long pause(){
        end=System.nanoTime();
        totalTime+=end-start;
        return end-start;
    }
}