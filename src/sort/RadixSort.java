package sort;

public class RadixSort {
    public static void radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        radixSort(arr, 0, arr.length-1,maxBits(arr));
    }

    public static int maxBits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while(max !=0){
            res++;
            max /=10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digit){

        //基数是10
        int radix = 10;
        int i=0,j=0;
        int[] bucket = new int[R - L + 1];

        for(int d = 1; d<=digit; d++){
            //count只是针对某一位的，所以跳到下一位要更新为0
            int[] count = new int[radix];

            //count:第i位中的值表示，数组中所有数第d位有多少等于i的
            for(i = L;i <= R; i++){
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //count:第i位中的值表示，数组中所有数第d位有多少小于i的
            for(i = 1; i < radix; i++){
                count[i] = count[i-1] + count[i];
            }
            //为什么要从→往左遍历？看视频
            for(i = R; i >= L ; i--){
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for(i = L,j = 0; i <= R;i++,j++){
                arr[i] = bucket[j];
            }

        }



    }

    public static int getDigit(int num, int d){
        return ((num / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] arr = {3,3,5,5,5,2,2,2,2,1,4,4,4,4,4,4};

        radixSort(arr);
        for(int i:arr){
            System.out.print(i + " ");
        }
    }
}
