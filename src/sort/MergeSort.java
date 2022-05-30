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

    /*
    小和问题：
        在一个数组中，每一个数的 左边的数 比 当前数 小的数 累加起来， 就是数组的小和
     */
    public static int littleSumProcess(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        int mid  = L + ((R-L)>>1);
        return littleSumProcess(arr, L , mid )+littleSumProcess(arr, mid+1, R)+littleSumMerge(arr, L, mid, R);
    }

    public static int littleSumMerge(int[] arr, int L, int mid, int R){
        int[] help = new int[R-L+1];
        int P1 = L;
        int P2 = mid+1;
        int i=0;
        int res = 0;
        while(P1<=mid &&  P2<=R){
            res += arr[P1]<arr[P2]?(R - P2 + 1)*arr[P1]:0;
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
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {1,9,8,2,4,9,8,1,6,2,5,9,7,6,1,9,2,5,9,0,1,2,4,6};
//        process(arr,0, arr.length-1);
//        for (int i : arr){
//            System.out.print(i);
//        }
        System.out.println(littleSum());

    }

    public static int littleSum(){
        int[] arr = {1,3,4,2,5};
        int res = littleSumProcess(arr,0,arr.length-1);
        return res;
    }
}

