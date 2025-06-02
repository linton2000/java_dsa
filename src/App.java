import datastructures.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap map = new HashMap(1);
        
        for (int i = 0; i < 17; i++){
            System.out.printf("\n\nInserting %d...\n", i);
            String key = String.format("key%d", i);
            String val = String.format("val%d", i);
            map.insert(key, val);
        }
    }
}
