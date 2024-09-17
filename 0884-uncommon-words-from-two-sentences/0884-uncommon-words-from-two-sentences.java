class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " +s2;
        Map<String, Integer> count = new HashMap<>();
        String[] w = s.split(" ");
        for(String str : w){
            count.put(str,count.getOrDefault(str,0)+1);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        return res.toArray(new String[0]);
    }
}