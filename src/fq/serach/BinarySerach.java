package fq.serach;

public class BinarySerach {
    public static void main(String[] args) {
        int[] arr={-43, -3, -2, 3, 32, 34, 43, 45, 78, 135};
        System.out.println(binser(arr,0,arr.length-1,135));
    }

    public static int binser(int[] arr,int left,int right,int val){
        int mid=(left+right)/2;
        if(left>right){
            return -1;
        }
        if(arr[mid]==val){
            return mid;
        }else if(arr[mid]>val){
            return binser(arr,left,mid-1,val);
        }else{
            return binser(arr,mid+1,right,val);
        }
    }
}
