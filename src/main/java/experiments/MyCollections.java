package experiments;

import java.util.*;

public class MyCollections {

    public static void main(String[] args) {
        //listCollections();
        //setCollections();
        mapCollections();
    }

    public static void mapCollections(){
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "one");
        map.put(2, "one");
        map.put(33, "three");
        map.put(4, "two");
        map.put(9, "nine");
        System.out.println(map);
        //{1=one, 33=three, 2=one, 4=two, 9=nine} Hash
        //{1=one, 2=one, 33=three, 4=two, 9=nine} LinkedHash
        //{1=one, 2=one, 4=two, 9=nine, 33=three} Tree
    }
    public static void setCollections(){
        Set<String> intSet = new HashSet<>();
        intSet.add("123");
        intSet.add("234");
        intSet.add("2");
        intSet.add("3");
        intSet.add("4");
        intSet.add("2");
        intSet.add("11");
        intSet.add("12");
        intSet.remove("2");
        System.out.println("int set --> "+intSet);
        //==================================
        Set<String> treedSet = new TreeSet<>();
        treedSet.add("123");
        treedSet.add("234");
        treedSet.add("2");
        treedSet.add("3");
        treedSet.add("4");
        treedSet.add("2");
        treedSet.add("11");
        treedSet.add("12");
        System.out.println("linked set --> "+treedSet);
        //===================================

    }
    public static void listCollections() {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");
        System.out.println("list --> " + stringList);
        stringList.add(2,"new");
        System.out.println("list --> " + stringList);
        System.out.println("size --> "+ stringList.size());
        System.out.println("--> "+stringList.isEmpty());
        System.out.println("second --> "+stringList.get(1));
        System.out.println("remove --> "+stringList.remove(4));
        stringList.set(1, "newTwo");
        System.out.println("--> "+stringList);
        //=============================================
        List<Integer> listInt = new LinkedList<>();
    }
}
