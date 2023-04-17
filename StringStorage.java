import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isEndOfWord = false;
    }
}

public class StringStorage {
    private TrieNode root;

    public StringStorage() {
        root = new TrieNode();
    }

    public void addString(String key, String value) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
        // Set any associated data with the string here
    }

    public String getString(String key) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        if (node.isEndOfWord) {
            // Get any associated data with the string here
            return "some value";
        }
        return null;
    }
}
