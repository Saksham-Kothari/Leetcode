class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int n : set1) {
            if (set2.contains(n)) {
                resultList.add(n);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
