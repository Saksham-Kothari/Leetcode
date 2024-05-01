class Solution {
    public String reversePrefix(String word, char ch) {
        int firstOccure = word.indexOf(ch);
        if (firstOccure == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, firstOccure + 1)).reverse();
        if (firstOccure < word.length()) {
            sb.append(word.substring(firstOccure + 1));
        }
        return sb.toString();   
    }
}