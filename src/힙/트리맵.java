package 힙;

import java.util.Map;
import java.util.TreeMap;

public class 트리맵 {

    public static void main(String[] args) {
        solution();
        System.out.println();

    }

    public static void solution() {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(0, 0);
        map.put(1, 6);
        map.put(1, 7);

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println();

    }

}