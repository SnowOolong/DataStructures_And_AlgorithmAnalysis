/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @Author zc
 * @Date 2020/4/6 22:34
 * @Version 1.0
 */

package aa;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,4,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 冒泡排序第一版
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                int temp = 0;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序第二版（增加有序标志）
     */
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    //因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序第三版（记录最后交换位置）
     */
    public static void sort3(int[] array) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    //因为有元素交换，所以不是有序的，标记为false
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }

            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序
     */
    public static void sort4(int[] array) {
        int temp = 0;
        for (int i = 0; i<array.length/2; i++) {
            //有序标志，每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j=i; j<array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            //在偶数轮之前，将isSorted重新标记位true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j=array.length-i-1; j>i; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }
}
