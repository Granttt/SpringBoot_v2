package com.fc.test;

import java.util.Arrays;

/**
 * @auther: 高希阳
 * @Date: 2018/10/24 16:14
 * @Description:计步排序
 * https://mp.weixin.qq.com/s?__biz=MzU1MDE4MzUxNA==&mid=2247484589&idx=1&sn=2ba5ef7cf1d64ceb105876eacc9c9881&chksm=fba53398ccd2ba8efb1a9cd84d85e46fd5cdbe86ce5f8f189b91a38454d2bb21174c53cf5504&mpshare=1&scene=1&srcid=1024olm8IJVcwjm3Q4duwyX9#rd
 */
public class StepSorting {

    /**
     * 功能描述：计步排序
     * @author gxy
     * @date 2018/10/24 16:58
     * @param
     * @return
     */
    public static int[] countSort(int[] array) {
        //1.得到数列的最大值
        int max = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        //2.根据数列最大值确定统计数组的长度
        int[] countArray = new int[max+1];
        //3.遍历数列，填充统计数组
        for(int i=0; i<array.length; i++){
            countArray[array[i]]++;
        }
        //[1, 1, 1, 1, 2, 2, 2, 1, 1, 0, 1]
        System.out.println(Arrays.toString(countArray));

        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for(int i=0; i<countArray.length; i++){
            for(int j=0; j<countArray[i]; j++){
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    /**
     * 功能描述：稳定排序
     * @author gxy
     * @date 2018/10/24 16:58
     * @param
     * @return
     */
    public static int[] countSort2(int[] array) {
        //1.得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素个数
        int[] countArray = new int[d+1];
        for(int i=0; i<array.length; i++) {
            countArray[array[i]-min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和
        int sum = 0;
        for(int i=0;i<countArray.length;i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for(int i=array.length-1;i>=0;i--) {
            sortedArray[countArray[array[i]-min]-1]=array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;
    }






    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortedArray = countSort(array);
//        System.out.println(Arrays.toString(sortedArray));

        //稳定排序
        int[] array2 = new int[] {95,94,91,98,99,90,99,93,91,92};
        int[] sortedArray2 = countSort2(array2);
        System.out.println(Arrays.toString(sortedArray2));


    }




}
