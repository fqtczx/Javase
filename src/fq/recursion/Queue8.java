package fq.recursion;

public class Queue8 {
    int max=8;//这个数代表的是棋盘的大小。即为一个8x8的棋盘矩阵
    int[] array=new int[max];//创建一维数组，代表每行棋子所放的位置
    static int count=0;//记录总的解法个数

    public static void main(String[] args) {
        Queue8 q=new Queue8();
        q.check(0);//从第一个棋子开始放置
        System.out.println(count);
    }

    //将一维数组打印出来，即代表一种解法
    public void print(){
        count++;//记录总的解法个数
        for(int i=0;i<array.length;i++){
           System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    //判断这种解法是否可行
    //这里的n代表放第几个棋子，注意这里的下标是从0开始的，即0,1,2,3,4,5,6,7
    public boolean judge(int n){
        for (int i=0;i<n;i++){//进行判断，n=0,即放第一个棋子时，并没有进入这个循环
            if(array[i]==array[n] ||Math.abs(n-i)==Math.abs(array[n]-array[i])){//判断是否在同一列或是在同一斜线的位置上
                return false;
            }
        }
        return true;
    }

    //放置的方法，这里的n代表第几个棋子，同样下标是从0开始的
    public void check(int n){
        if(n==8){//说明8个棋子已经全部放置完毕，直接将其打印出来，并返回
            print();
            return;
        }
        for (int i=0;i<max;i++){//这个循环有回溯的作用在里面
            array[n]=i;//保证每层都能遍历到，进行逐个位置的放置
            if(judge(n)){//这个位置可以放置的话
                check(n+1);//进行下一行的放置
            }
        }
    }
}
