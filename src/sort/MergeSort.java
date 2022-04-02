package sort;

public class MergeSort {
    public static void process(int[] arr, int L, int R ){
        if (L == R){
            return;
        }
        int mid  = L + ((R-L)>>1);
        process(arr, L , mid );
        process(arr, mid+1, R);
        merge(arr, L, mid, R);
    }
    public static void merge(int[] arr, int L ,int mid , int R){
        int[] help = new int[R-L+1];
        int P1 = L;
        int P2 = mid+1;
        int i=0;
        while(P1<=mid &&  P2<=R){
            help[i++] = arr[P1] <= arr[P2] ? arr[P1++] : arr[P2++];
        }
        while(P1<=mid){
            help[i++] = arr[P1++];
        }
        while(P2<=R){
            help[i++] = arr[P2++];
        }
        //注意arr是一整个长数组，而help是小数组
        for(i=0;i<help.length;i++){
            arr[L+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,8,2,4,9,8,1,6,2,5,9,7,6,1,9,2,5,9,0,1,2,4,6};
        process(arr,0, arr.length-1);
        for (int i : arr){
            System.out.print(i);
        }

    }
}

