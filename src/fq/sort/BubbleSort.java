package fq.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={-2,3,34,45,-43,43,-3};
        bubblesort(arr);
        //排序完成后，进行数组的打印
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));

        int[] array=new int[80000];
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*8000000);
        }
        SimpleDateFormat sp1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1=new Date();
        String datestr1=sp1.format(d1);
        System.out.println(datestr1);
        bubblesort(array);

        Date d2=new Date();
        String datestr2=sp1.format(d2);
        System.out.println(datestr2);
        System.out.println();
    }

    public static void bubblesort(int[] arr){
        int temp=0;//进行交换的中间变量
        boolean flag=false;//定义标识变量，表示是否进行过交换
        //每次从开头开始，进行相邻两个变量的比较，如果后面的变量比前面的变量大，就叫唤位置
        //每进行一次，就将大的数交换至末尾
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;//进行了交换，就将其置为true
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

            if(!flag){//一趟比较下来，未进行交换，说明有序，直接退出循环
                break;
            }else{
                flag=false;//这里记得要重置一下
            }
        }


    }
}
