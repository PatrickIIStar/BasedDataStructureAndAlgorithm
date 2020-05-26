package main.java.com.patrick.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/25 16:01
 * @declaration 动态规划 活动选择问题
 */

public class ActivitySelect {
    // 假定是排好序的
    private final Activity[] activities;
    private final int[] selectionValue;
    private final int[] selection;

    public ActivitySelect(Activity[] activities) {
        this.activities = activities;
        this.selectionValue = new int[activities.length];
        this.selection = new int[activities.length];
    }

    public void activitySelect() {
        activitySelect(activities, selectionValue, selection);
    }

    public List<Integer> selectionOfMaxValue() {
        return getSelection(activities, selectionValue, selection);
    }

    public int maxValue() {
        return selectionValue[selectionValue.length - 1];
    }


    private void activitySelect(Activity[] activities, int[] selectionValue, int[] selection) {
        Map<Integer, Integer> pre = getPre(activities, selectionValue);
        for (int i = 1; i < activities.length; i++) {
            if (selectionValue[i - 1] < activities[i].activityValue + selectionValue[pre.get(i)]) {
                selectionValue[i] = activities[i].activityValue + selectionValue[pre.get(i)];
                selection[i] = 1;
            } else {
                selectionValue[i] = selectionValue[i - 1];
            }
        }
    }

    private Map<Integer, Integer> getPre(Activity[] activities, int[] selectionValue) {
        Map<Integer, Integer> pre = new HashMap<>();
        for (int i = 0; i < selectionValue.length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (activities[j].endTime <= activities[i].startTime) {
                    pre.put(i, j);
                    break;
                } else {
                    j--;
                }
            }
        }
        return pre;
    }

    private List<Integer> getSelection(Activity[] activities, int[] selectionValue, int[] selection) {
        Map<Integer, Integer> pre = getPre(activities, selectionValue);
        List<Integer> selectionList = new ArrayList<>();
        int i = selectionValue.length - 1;
        while (i > 0) {
            if (selection[i] != 0) {
                selectionList.add(i);
                i = pre.get(i);
            } else {
                i--;
            }
        }
        return selectionList;
    }
}
