package datastructures;

public class HashMapTester {

    static int testCount = 1;

    public static void main(String[] args) {
        HashMap map = new HashMap();

        // Test 1: Simple insert + get
        map.insert("cat", "animal");
        expectEqual(map.get("cat").val, "animal", "insert/get simple");

        // Test 2: Non-existent key
        expectNull(map.get("dog"), "get nonexistent key");

        // Test 3: Overwrite via chaining (same hash index)
        map.insert("act", "reversed animal");  // Same ASCII sum as "cat"
        expectEqual(map.get("act").val, "reversed animal", "collision insert/get");

        // Test 4: Remove key
        map.remove("cat");
        expectNull(map.get("cat"), "remove key");

        // Test 5: Re-insert after remove
        map.insert("cat", "pet");
        expectEqual(map.get("cat").val, "pet", "reinsert after remove");

        // Test 6: Trigger resize (insert > 0.5 * capacity)
        map.insert("bat", "mammal");
        map.insert("rat", "rodent");
        map.insert("hat", "clothing");
        expectEqual(map.get("hat").val, "clothing", "resize insert/get");

        // Test 7: Remove and check downsizing works
        map.remove("bat");
        map.remove("rat");
        map.remove("hat");
        expectNull(map.get("bat"), "post-remove check for downsizing");
    }

    private static void expectEqual(String actual, String expected, String description) {
        if (expected.equals(actual)) {
            System.out.printf("Test %d passed! - %s\n", testCount++, description);
        } else {
            System.out.printf("Test %d failed - %s; Output: %s; Expected: %s\n",
                              testCount++, description, actual, expected);
        }
    }

    private static void expectNull(Object actual, String description) {
        if (actual == null) {
            System.out.printf("Test %d passed! - %s\n", testCount++, description);
        } else {
            System.out.printf("Test %d failed - %s; Output: %s; Expected: null\n",
                              testCount++, description, actual.toString());
        }
    }
}
