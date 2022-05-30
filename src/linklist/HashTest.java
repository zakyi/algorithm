package linklist;

import java.util.HashMap;
import java.util.HashSet;

public class HashTest {
    public static void test1(){
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(1);
        System.out.println(hashSet1.contains(1));
        hashSet1.remove(1);
        System.out.println(hashSet1.contains(1));
        System.out.println("=====test1=====");
    }

    public static void test2(){
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1,"zhang");
        integerStringHashMap.put(1,"yi");
        integerStringHashMap.put(2,"123");

        System.out.println(integerStringHashMap.containsKey(1));
        System.out.println(integerStringHashMap.get(1));
        System.out.println(integerStringHashMap.get(4));
        System.out.println("=====test2=====");
    }


    public static void main(String[] args){
        test1();
        test2();
    }
}
