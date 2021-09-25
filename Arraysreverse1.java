package learn1;

public class Arraysreverse1 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        System.out.println("转换前：");
        printArry(arr);
        reverse(arr);
        System.out.println("转换后：");
        printArry(arr);
    }

    public static void reverse(int[] arr){ //交换顺序
        for(int start=0,end=arr.length-1;start<=end;start++,end--){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
    }
    public static void printArry(int[] arr){  //输出数组
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
