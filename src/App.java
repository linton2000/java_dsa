import datastructures.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap map = new HashMap();
        map.insert("key1", "val1");
        System.out.println(map.get("key1"));
    }
}
