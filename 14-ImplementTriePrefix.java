class Trie {

    /**
     * Initialize your data structure here.
     */
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode temp = root;
        boolean contains = true;
        for (char ch : word.toCharArray()) {
            if (contains && temp.containsKey(ch)) {
                temp = temp.getKey(ch);
            } else {
                contains = false;
                TrieNode newNode = new TrieNode();
                temp.setKey(ch, newNode);
                temp = newNode;
            }
        }
        temp.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.containsKey(ch))
                return false;
            temp = temp.getKey(ch);
        }
        if (temp.isEnd)
            return true;
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (char ch : prefix.toCharArray()) {
            if (!temp.containsKey(ch))
                return false;
            temp = temp.getKey(ch);
        }
        return true;
    }
}


class TrieNode {
    TrieNode[] children;
    boolean isEnd = false;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        if (children[ch - 'a'] != null) return true;
        return false;
    }

    public void setKey(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public TrieNode getKey(char ch) {
        return children[ch - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */