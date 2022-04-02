package sort;

public class QuickSort {

    public static void main(String[] args){
        int[] arr = {1,6,2,3,5,4,9,8,1,2,7,9,4,6,5,8,1,5,2,4,9,6,1,9,4};
        quickSort(arr);
        for(int i:arr){
            System.out.print(i + " ");
        }

    }

    public static void quickSort(int[] arr){
        //边界条件, arr等于空或者arr长度等于1或0
        if(arr.length <2 || arr==null){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * 递归
     * @param arr
     * @param L 数组左边界
     * @param R 数组右边界
     */
    public static void quickSort(int[] arr, int L ,int R){
        if(L<R){
            //随机选择一个数作为划分值
            //划分值位于数组的最右方
            swap(arr, L+(int)(Math.random()*(R-L+1)), R);
            int[] mid = partition(arr, L, R);
            quickSort(arr, L, mid[0]);
            quickSort(arr, mid[1]+1, R);
        }
    }

    /**
     * 将一个数组分成三个部分, 小于划分值的位于数组左边, 大于划分值的位于数组右边, 等于划分值的位于数组中间
     * @param L 当前数
     * @param R 划分值
     * 返回值: 二元数组, 第一个元素是中间部分的左边界, 第二个元素是中间部分的右边界
     */
    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1;//小于区的右边界
        int more = R;//大于区的左边界
        while(L<more){//当前数一直遍历, 直到与大于区左边界相见
            if(arr[L] < arr[R]){ //当前数小于划分值
                swap(arr, ++less, L++);//当前数和小于区的右边的数交换, 小于区右移, 当前数右移
            }
            else if(arr[L] > arr[R]){
                swap(arr, --more, L);//当前数和大于区的左边数交换, 当前数不动
            }else{
                L++;
            }
        }
        //划分值和大于区的右边界交换

        swap(arr, more, R);

        //more指向的数等于划分值
        //less指向的数小于划分值
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }


}
