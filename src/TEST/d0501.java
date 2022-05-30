package TEST;

import java.util.HashMap;

public class d0501 {
    public static int reverse(int x) {
        boolean negFlag = false;
        if(x == 0){
            return x;
        }else if(x < 0){
            negFlag = true;
        }
        int[] digit = new int[20];
        int i=0;
        while(x != 0){
            digit[i] = Math.abs(x%10);
            x /=10;
            i++;
        }
        int res = 0;
        int j=0;
        if(i>=10 && digit[0]>2){
            return 0;
        }
        while(i > 0){
            int temp = digit[j] * (int)Math.pow(10 , i-1);
            if(temp > (Integer.MAX_VALUE - res)){
                return 0;
            }else{
                res += temp;
            }
            i--;
            j++;
        }
        if(negFlag){
            if(res == Integer.MAX_VALUE){
                return 0;
            }else{
                return res *(-1);
            }
        }
        return res;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> dict = new HashMap<>();
        for(int i=0;i<s.length();i++){
            dict.put(s.charAt(i),dict.getOrDefault(s.charAt(i),0) + 1);
        }
        HashMap<Character,Integer> dict2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            dict2.put(t.charAt(i),dict2.getOrDefault(t.charAt(i),0) + 1);
        }

        for(int i=0;i<s.length();i++){
            if(dict2.getOrDefault(s.charAt(i),-1) == -1){
                return false;
            }

            int s1 = 0;
            int t1 = 0;
            s1 = dict.get(s.charAt(i));
            t1 = dict.get(s.charAt(i));
            if(s1 == t1){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int j=s.length()-1;
        for(int i=0;i<j;i++){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(i) != Character.toLowerCase(j)){
                return false;
            }
            j--;
        }
        return true;
    }

    public static int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        int count=0;
        boolean posFlag = true;
        int i=0,len = s.length();
        char[] res = new char[11];
        while(i<len && s.charAt(i) == ' ' ){
            i++;
        }
        if(s.charAt(i) == '-'){
            posFlag = false;
            i++;
        }
        while(i<len && Character.isDigit(s.charAt(i))){
            res[count] = s.charAt(i);
            i++;
            count++;
        }
        int result = 0;
        for(int j=0; j < count;j++){
            int test = Integer.MAX_VALUE - result*10;
            if((result > Integer.MAX_VALUE/10) || (res[j]-'0' > test)){
                return posFlag?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result = (result * 10) + (res[j] - '0');
        }
        if(result == Integer.MIN_VALUE && posFlag){
            return Integer.MAX_VALUE;
        }
        return posFlag?result:result*(-1);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        int[] next = new int[needle.length()];
        getNext(needle, next);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j]; // j回到指定位置
            }
            if (j == needle.length())
                return i - j;
        }
        return -1;
    }

    private static void getNext(String p, int next[]) {
        int len = p.length();
        int i = 0;
        int j = -1;
        next[0] = -1;//这个默认的，
        while (i < len - 1) {
            //每次赋值操作之后紧跟着判断i和j指向的字符是否相等
            //相等给next赋值
            //不相等则j回溯，搞不懂为啥这样赋值，记住吧
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
            j = next[j];
        }
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<strs[0].length();j++){
            int flag =0;
            for(int i=0;i<strs.length-1;i++){
                if(j>=strs[i].length() || j>=strs[i+1].length()){
                    flag = 1;
                    break;
                }
                if(strs[i].charAt(j) == strs[i+1].charAt(j)){
                    continue;
                }else{
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                return sb.toString();
            }else{
                sb.append(strs[0].charAt(j));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
    }
}
