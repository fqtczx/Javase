package fq.recursion;

public class MiGong {
    public static void main(String[] args) {
        //使用递归回溯寻找迷宫的路径
        int[][] map=new int[8][7];//定义整体的地图，以一个二维数组表示

        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;//将迷宫外围全部设为1，即为墙
        }
        map[3][2]=1;
        map[3][1]=1;//在迷宫内部设置障碍

        //输出地图
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归回溯来给小球找路径
        System.out.println("--------------------");
        setWay(map,1,1);//寻找路径的方法

        //输出找到路径的地图
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //i,j表示出发的起点，能到右下角表示到达终点，则返回true，最后一层即可进行回溯
    //约定：map[i][j]=0时表示该点没有走过，为1时为墙，为2时表示通路可以走，为3时表示该路已经走过，但是走不通
    //走迷宫时的策略：下右上左，如果走不通，则回溯
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            //判断是否走到迷宫终点,这里进行最内层的回溯
            return true;
        }else{
            if(map[i][j]==0){//如果这个点未走过
                map[i][j]=2;//先尝试将这个点标记为可以走通
                if(setWay(map,i+1,j)){//尝试向下走
                    return true;
                }else if(setWay(map,i,j+1)){//尝试向右走
                    return true;
                }else if(setWay(map,i-1,j)){//尝试向上走
                    return true;
                }else if(setWay(map,i,j-1)){//尝试向左走
                    return true;
                }else{//如果四个方向都没有走通的话，就将这个点标记为走不通
                    map[i][j]=3;
                    return false;//并且返回false
                }
            }else{//如果这个点是其他情况：墙，走过，走过但不通，就直接返回false即可
                return false;
            }
        }
    }

    //采用第二种策略，上右下左进行尝试
    public static boolean setWay2(int[][] map,int i,int j){
        if(map[6][5]==2){
            //判断是否走到迷宫终点
            return true;
        }else{
            if(map[i][j]==0){//
                map[i][j]=2;
                if(setWay2(map,i-1,j)){
                    return true;
                }else if(setWay2(map,i,j+1)){
                    return true;
                }else if(setWay2(map,i+1,j)){
                    return true;
                }else if(setWay2(map,i,j-1)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
