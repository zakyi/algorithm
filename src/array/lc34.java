package array;

import java.util.ArrayList;
import java.util.List;

public class lc34 {
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        int[] res = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        twoFind(nums, target, 0, nums.length - 1, res);
        if(res[2] == 1){
            return new int[]{res[0],res[1]};
        }else{
            return new int[]{-1,-1};
        }

    }


    public static void twoFind(int[] nums, int target, int L, int R, int[] res){
        if(L==R){
            if(nums[L] == target){
                res[1] = Math.max(res[1],L);
                res[0] = Math.min(res[0],L);
                res[2] = 1;
                return;
            }
            return;
        }
        int mid = L + ((R - L) >> 1);
        twoFind(nums,target,L,mid,res);
        twoFind(nums,target,mid+1,R,res);
        return;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,7,7,7};
        int target = 7;

        int[] res = searchRange(new int[]{} ,0);

    }
}
