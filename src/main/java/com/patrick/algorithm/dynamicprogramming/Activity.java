package main.java.com.patrick.algorithm.dynamicprogramming;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/25 16:34
 * @declaration
 */
public class Activity {

    public final int startTime;
    public final int endTime;
    public final int activityValue;

    public Activity(int startTime, int endTime, int activityValue) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityValue = activityValue;
    }
}
