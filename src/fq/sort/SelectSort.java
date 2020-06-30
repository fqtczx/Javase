package fq.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={-2,3,34,45,78,32,-43,43,-3};
        selectsort(arr);

        //排序完成后，进行数组的打印
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    public static void selectsort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            int min=arr[i];
            int index=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    index=j;
                }
            }
            arr[i]=min;
            arr[index]=temp;
        }
    }
}
