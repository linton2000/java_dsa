package datastructures;

public class HashEntry {
    public String key;
    public String val;

    public HashEntry(String key, String val){
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString(){
        return String.format("(%s, %s)", this.key, this.val);
    }
}
