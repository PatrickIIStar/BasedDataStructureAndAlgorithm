package main.java.com.patrick.algorithm.sort;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/11 15:28
 */
public class Sort {
    /**
     * @param arr 数组
     * @param i   元素的下标
     * @param j   元素的下标
     * @return void
     * @declaration 交换数组中的元素
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @param arr 数组
     * @return int   最大元素
     * @declaration 求数组中的最大元素
     */
    public static int max(int[] arr) {
        int max = arr[0];
        for (int item : arr) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    /**
     * @param arr 数组
     * @return int  最小元素
     * @declaration 求数组中的最小元素
     */
    public static int min(int[] arr) {

        int min = arr[0];
        for (int item : arr) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

////////////     冒泡排序   /////////////////

    /**
     * @param arr 要排序的数组
     * @return void
     * @declaration 冒泡排序, 每次从剩余的元素中找到最大的元素放到数组最后
     */
    public static void bubbleSort(int[] arr) {
        // 是否已经排好序的标志,默认为true
        boolean flag = true;
        // 每次从数组中找出最大的放到最后,剩最后一个数时说明已经排好序,一共进行arr.length-1轮大循环
        for (int i = 0; i < arr.length - 1; i++) {
            // 每轮大循环里进行小循环,比较相邻两个元素的大小,大大放后面,一直到已经找到的最大元素前面的元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 若在该轮循环中存在数据交换,说明还未完成排序,flag为false
                    flag = false;
                    // 交换数据
                    swap(arr, j, j + 1);
                }
            }
            // 如果该轮循环不存在数据交换,说明已经排好序,跳出循环,结束程序.
            if (flag) {
                break;
                // 存在数据交换,为完成排序,flag置为true,继续下轮循环
            } else {
                flag = true;
            }
        }
    }


////////////     选择排序   /////////////////

    /**
     * @param arr 要排序的数组
     * @return void
     * @declaration 选择排序, 每次从剩余的元素中找到最小的元素放到前面, 每轮循环交换一次数据
     */
    public static void selectSort(int[] arr) {
        int minIndex;  // 剩余元素中最小元素的下标
        // 同理,剩下最后一个元素时说明已经排好序
        for (int i = 0; i < arr.length - 1; i++) {
            // 存放最小元素的下标,默认为剩下的元素中第一个元素
            minIndex = i;
            // 从剩下的元素中的第二个元素开始遍历
            for (int j = i + 1; j < arr.length; j++) {
                // 如果碰到比第一个元素还小的元素,将下标存放至minIndex
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 遍历结束,将最小元素放置排头,开始下一轮循环
            swap(arr, i, minIndex);
        }
    }


////////////     插入排序   /////////////////

    /**
     * @param arr 要排序的数组
     * @return void
     * @declaration 插入排序, 数组分为两部分, 一部分为排好序的, 剩下为未排序, 每次从未排序的元素中拿一个放入排好序的部分, 插入到适当位置
     */
    public static void insertSort(int[] arr) {
        // 原数组无序,无没排序部分,从0号元素遍历,一直到结尾
        for (int i = 0; i < arr.length; i++) {
            // 从未排序的元素中拿第一个元素当作插入的元素
            int insertVal = arr[i];
            // 插入的位置,指向插入位置的前面
            int insertIndex = i - 1;
            // 如果插入位置为负,则该插入元素为最小元素,放到0号位置
            // 寻找插入的位置,元素后移方法,每碰到一个比插入元素大的元素,就将其后移,且插入的位置往前移,找到第一个比插入元素小的元素
            // 该元素的位置即为insertIndex的值
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //  insertIndex存放的是插入位置的前面,所以要+1
            arr[insertIndex + 1] = insertVal;
        }
    }


////////////     基数排序   /////////////////

    /**
     * @param arr 要排序的数组
     * @return void
     * @declaration 桶排序
     */
    @SuppressWarnings("unchecked")
    public static void radixSort(int[] arr) {
        // 得到数组的最小值
        int min = min(arr);
        // 如果最小值小于0,数组所有元素加上该值使所有元素变为非负,如果所有元素不为负.则+0;
        int add = 0;
        // 如果最小值为负
        if (min < 0) {
            add = Math.abs(min);  //  add为最小值的绝对值
            for (int i = 0; i < arr.length; i++) {
                arr[i] += add;
            }
        }

        // 求得最大元素
        int max = max(arr);
        // 将其转换为字符串,调用函数
        int length = ("" + max).length();

        // 除数,初始为1
        int n = 1;
        // 创建10个桶队列
        LinkedList<Integer>[] bucket = new LinkedList[10];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }

        // 一共循环length轮,一直取到最大元素的最高位
        for (int i = 0; i < length; i++, n *= 10) {
            for (int value : arr) {
                // 遍历数组,求每个元素的第i位
                int temp = value / n % 10;
                // 将每个元素加入 该元素第i位对应的桶中
                bucket[temp].add(value);
            }

            // 遍历结束后,再将每个桶里的数据按顺序依次取出,重新放回arr
            int index = 0;
            for (LinkedList<Integer> integers : bucket) {
                while (!integers.isEmpty()) {
                    arr[index++] = integers.pop();
                }
            }
        }

        // 因为最开始所有元素加了一个add使其变为非负
        // 这里要把add减去
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= add;
        }
    }


////////////     归并排序   /////////////////

    /**
     * @param arr   要排序的数组
     * @param left  起始位置
     * @param right 结束位置
     * @return void
     * @declaration 该部分为分 兼并 治,递归的方法
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // 临时数组,大小与arr一样
        int[] temp = new int[arr.length];
        // 将数组分开,直到只剩下一个元素,开始合并
        if (left < right) {
            // 从数组中间将数组分为两部分
            int mid = (left + right) / 2;
            // 左半部分
            mergeSort(arr, left, mid);
            // 右半部分
            mergeSort(arr, mid + 1, right);
            // 每部分都只剩下一个元素,开始合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr   要排序的数组
     * @param left  起始位置
     * @param mid   中间位置
     * @param right 结束位置
     * @param temp  临时数组,合并排好序的数组[left,mid] [mid+1,right]
     * @return void
     * @declaration 归并排序, 分治的思想, 该部分为 治 ,也就是将排好序的数组合并
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 数组被分为两部分,两部分都已排好序
        // [left,mid]为左半部分
        // [mid+1,right]为右半部分
        int l = left;
        int r = mid + 1;
        // 临时数组下标
        int k = 0;
        // 同时遍历两个数组,且都未遍历结束
        while (l <= mid && r <= right) {
            // 如果左边数组的下标为l的元素小,放入temp中,同时指针后移,右半部分指针位置不变,
            if (arr[l] < arr[r]) {
                temp[k++] = arr[l++];
                // 否则,将右半部分数组的下标为r的元素放入temp,指针后移,左半部分指针位置不变
            } else {
                temp[k++] = arr[r++];
            }
        }
        // 如果有一个数组已经遍历结束
        // 如果右半部分数组遍历结束,说明左半部分数组还有剩余元素,将剩余元素逐个加到temp中
        while (l <= mid) {
            temp[k++] = arr[l++];
        }
        // 左半部分已经插入,将右半部分数组元素逐个加入temp
        while (r <= right) {
            temp[k++] = arr[r++];
        }

        // 将temp中的元素覆盖arr的[left,right],因为arr是从left到right排序的
        // 所以覆盖时也要从arr[left]开始,到arr[right]结束
        int t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }


////////////     快速排序   /////////////////

    /**
     * @param arr  要排序的数组
     * @param head 起始位置
     * @param rear 结束位置
     * @return int  本轮排序结束后所指向的下标
     * @declaration 快速排序, 找一个基准, 基准元素的左边都比其小, 右边都比其大
     */
    public static int portion(int[] arr, int head, int rear) {
        // 随机选取一个基准元素
        Random random = new Random();
        int i = random.nextInt(rear - head + 1) + head;
        // 将其放到起始位置
        swap(arr, head, i);

        // 基准元素为起始位置的元素
        int key = arr[head];

        //  start指向起始位置
        int start = head;
        // end 指向结束位置
        int end = rear;

        // 如果起始位置大于结束位置,结束
        if (head >= rear) {
            return start;
        }

        // 如果start在end坐边
        while (start < end) {
            // 从后往前找,找到比基准元素小的或着相等的就停
            while (start < end && arr[end] > key) {
                end--;
            }
//            arr[start] = arr[end];
            // 从前往后找,找到比基准元素大的就停
            while (start < end && arr[start] <= key) {
                start++;
            }
//            arr[end] = arr[start];
//            int temp = arr[start];
//            arr[start] = arr[end];
//            arr[end] = temp;

            // 交换两个元素
            swap(arr, start, end);
        }

        //sort(arr,end+1,length)
        //sort(arr,0,end)
        //arr[head] = arr[end];
        //arr[start] = key;

        // 如果start等于end,结束循环,start和end指向的位置一定不大于基准元素
        // 所以将其交换位置,这样就可使基准元素左边都小于或等于基准,右边都大于基准
        swap(arr, head, end);
//        System.out.print(key+" ");
//        System.out.println(key);
//        System.out.println(end+Arrays.toString(arr));
        //quickSort(arr, 0, end - 1);
        //quickSort(arr, end + 1, rear);
        //System.out.println(Arrays.toString(arr) + end);

        // 返回start或end的下标,从该下表将数组分为左右两部分
        return end;
    }

    /**
     * @param arr  要排序的数组
     * @param head 起始位置
     * @param rear 结束位置
     * @return void
     * @declaration 递归快排
     */
    public static void quickSort(int[] arr, int head, int rear) {
        // 如果只剩下一个元素,就停止
        if (head < rear) {
            // 从该位置将数组分为两部分
            int mid = portion(arr, head, rear);
            // 左半部分
            quickSort(arr, 0, mid - 1);
            // 右半部分
            quickSort(arr, mid + 1, rear);
//            head = mid + 1;
        }
    }


////////////     希尔排序   /////////////////

    /**
     * @param arr 要排序的数组
     * @return void
     * @declaration 交换希尔排序.对没部分使用交换的方式
     */
    public static void swapShellSort(int[] arr) {
        // 将数组分组,跨元素分组,步长为step,初始为length/2,一直到步长为1
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 遍历每组元素
            for (int i = step; i < arr.length; i++) {
                // 对每组元素进行冒泡排序(类似)
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        swap(arr, j, j + step);
                    }
                }
            }
        }
    }

    /**
     * @param arr 要排序的数组
     * @return void
     * @declaration 插入希尔排序, 对每部分使用插入排序的方式
     */
    public static void insertShellSort(int[] arr) {
        // 同理,不同之处是对每组元素进行插入排序
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int insertIndex = i - step;
                int insertVal = arr[i];
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                    arr[insertIndex + step] = arr[insertIndex];
                    insertIndex -= step;
                }
                arr[insertIndex + step] = insertVal;
            }
        }
    }


    public static void heapSort(int[] arr) {
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }

        for (int i = arr.length-1; i >0 ; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        for (int k = 2*i+1; k < length; k = 2*k+1) {
            if (k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i] = arr[k];
                arr[k] = temp;
                i = k;
            }else {
                break;
            }
        }
    }
}
