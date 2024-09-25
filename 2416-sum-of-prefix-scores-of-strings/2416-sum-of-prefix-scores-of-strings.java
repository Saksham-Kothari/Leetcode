class TrieNode {
    TrieNode kids[] = new TrieNode[26];
    int freq = 0;
    
    void insert(String key) {
        TrieNode curr = this;
        for (var ch : key.toCharArray()) {
            int idx = ch - 'a';
            if (curr.kids[idx] == null) {
                curr.kids[idx] = new TrieNode();
            }
            curr.kids[idx].freq++;
            curr = curr.kids[idx];
        }
    }

    int getScore(String key) {
        TrieNode curr = this;
        int score = 0;
        for (var ch : key.toCharArray()) {
            int idx = ch - 'a';
            score += curr.kids[idx].freq;
            curr = curr.kids[idx];
        }
        return score;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (var word : words) {
            root.insert(word);
        }
        int n = words.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = root.getScore(words[i]);
        }
        return res;
    }
}
