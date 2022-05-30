package array;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k==0){
            return;
        }

        int gcd = greatestCommonDivisor(nums.length,k);
        if(gcd != 0){
            int tmp = 0;
            for(int i=0;i<gcd;i++){
                int tmp1 = nums[i];
                int tmp2 = 0;
                int pnt = i;
                int len = nums.length;
                for(int count=0;count<len/gcd;count++){
                    tmp2 = nums[(pnt + k) % len];
                    nums[(pnt + k) % len] = tmp1;
                    pnt = (pnt + k) % len;
                    tmp1 = tmp2;
                }
            }
        }else{
            int tmp1 = nums[0];
            int tmp2 = 0;
            int pnt = 0;
            int len = nums.length;
            for(int count=0;count<len;count++){
                tmp2 = nums[(pnt + k) % len];
                nums[(pnt + k) % len] = tmp1;
                pnt = (pnt + k) % len;
                tmp1 = tmp2;
            }
        }


    }


    public static int greatestCommonDivisor(int a,int b){
        do{
            int temp = a%b;
            a = b;
            b = temp;
        }while(b!=0);
        return a;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int k = 2;
        rotate(nums,k);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
