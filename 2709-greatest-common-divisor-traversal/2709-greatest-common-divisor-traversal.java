class Solution {
    int[] parents;
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        parents = new int[n];
        Arrays.fill(parents, -1);
        Map<Integer, List<Integer>> factorToIndexes = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Integer> primeFactors = getPrimeFactors(nums[i]);
            for(int f : primeFactors){
                factorToIndexes.computeIfAbsent(f, k -> new ArrayList<>()).add(i);
            }
        }
        for(List<Integer> indexes : factorToIndexes.values()){
            indexes.forEach(x -> union(indexes.get(0), x));
        }
        return IntStream.range(0, n).map(this::find).distinct().count() == 1;
    }

    List<Integer> getPrimeFactors(int n){
        List<Integer> factors = new ArrayList<>();
        for(int f = 2; f * f <= n; f++){
            if(n % f == 0){
                factors.add(f);    
                while(n % f == 0){
                    n /= f;
                }
            }
        }
        if(n != 1){
            factors.add(n);    
        }
        return factors;
    }

    int find(int x){
        if(parents[x] == -1){
            return x;
        }
        parents[x] = find(parents[x]);
        return parents[x];
    }

    void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            parents[px] = py;
        }
    }
}
