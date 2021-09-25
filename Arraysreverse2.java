package learn1;

public class Arraysreverse2 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int temp=0;
        int i,j;

        for(i=0;i<arr.length-1;i++){ //冒泡排序
            for(j=0;j<arr.length-1-i;j++) {
                temp = arr[j];
                arr[j] = arr[j+ 1];
                arr[j+ 1] = temp;
            }
        }
        for(i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
