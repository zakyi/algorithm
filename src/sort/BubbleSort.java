package sort;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i=1; i<arr.length; i++){
            for(int j = 0; j<arr.length-i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,6,2,3,5,4,9,8,1,2,7,9,4,6,5,8,1,5,2,4,9,6,1,9,4};
        bubbleSort(arr);
        for(int i:arr){
            System.out.print(i + " ");
        }

    }

}
