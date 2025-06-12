import java.util.*;

public class TreeSetOperation {
    public  static  void   main(String []args){
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(1,2);
        map.put(2,3);
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        String A = "12.13.2";
        List<String> list = Arrays.asList(A.split("."));

        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        boolean s = set.contains(1);
    }
}
