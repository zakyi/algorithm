package sort;

public class DumpSort {

    //将index节点向上移动
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1 ) /2);
            index = (index - 1) / 2;
        }
    }


    //将index节点向下移动
    //循环次数是堆的高度，每次循环是O(1)
    //所以时间复杂度就是H
    //N = 2 ^ (H - 1)   ->>>  H = log(N) + 1
    public static void heapify(int[] arr, int index, int heapSize){
        int left = (index * 2) + 1;
        //一直向下遍历直到左孩子超出堆容量
        while(left < heapSize){
            //任务：比较左右孩子大小
            //比较：1、右孩子是否超过堆容量。2、右孩子是否大于左孩子的值
            //赋值：是则赋值右孩子，否则赋值左孩子
            int largest = left + 1 < heapSize && arr[left + 1]> arr[left] ? left + 1: left;
            largest = arr[index] > arr[largest] ? index:largest;

            if(largest == index){
                break;
            }
            //交换，交换后index的值最大，largest指向需要操作的节点
            swap(arr, largest, index);

            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int num1, int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length<2){
            return;
        }
        //将数组变成大根堆，此时根节点为整个数组的最大值
        for(int i = arr.length - 1; i>=0;i--){ //O(N)
            heapify(arr, i, arr.length);   //O(logN)
        }
        int heapSize = arr.length;
        //将最大值放到数组的右边界，数组右边界左移
        //堆右下方节点放到根节点
        swap(arr, 0, --heapSize);
        while( heapSize>0 ){                //O(N)
            //对根节点进行下移
            heapify(arr, 0, heapSize);  //O(logN)
            //再次将最大值移动到右边界，右边界左移
            swap(arr, 0, --heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,8,2,4,9,8,1,6,2,5,9,7,6,1,9,2,5,9,0,1,2,4,6};
        heapSort(arr);
        for (int i : arr){
            System.out.print(i);
        }

    }
}
