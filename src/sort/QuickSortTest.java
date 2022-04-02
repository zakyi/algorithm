package sort;


public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {1,6,2,3,5,4,9,8,1,2,7,9,4,6,5,8,1,5,2,4,9,6,1,9,4};
        QuickSort.partition(arr,0, arr.length-1);
        for(int i:arr){
            System.out.print(i + " ");
        }
    }
}
