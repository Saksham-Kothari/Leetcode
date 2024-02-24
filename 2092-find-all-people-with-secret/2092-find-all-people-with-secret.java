class UnionFind {
    private int[] rank;
    private int[] parent;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]); // doing path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX != parentY) {
            if(rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else if(rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else {
                parent[parentY] = parentX;
                rank[parentX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void reset(int x) {
        parent[x] = x;
        rank[x] = 0;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind graph = new UnionFind(n);
        graph.union(firstPerson, 0);

        Map<Integer, List<int[]>> sameTimeMeetings = new TreeMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            if(!sameTimeMeetings.containsKey(t)) {
                sameTimeMeetings.put(t, new ArrayList<>());
            }
            sameTimeMeetings.get(t).add(new int[]{x, y});
        }

        for (int t : sameTimeMeetings.keySet()) {
            // Unite two persons taking part in a meeting
            for (int[] meeting : sameTimeMeetings.get(t)) {
                int x = meeting[0], y = meeting[1];
                graph.union(x, y);
            }
            
            // If any one knows the secret, both will be connected to 0.
            // If no one knows the secret, then reset both.
            for (int[] meeting : sameTimeMeetings.get(t)) {
                int x = meeting[0], y = meeting[1];
                if (!graph.connected(x, 0)) {
                    // No need to check for y since x and y were united
                    graph.reset(x);
                    graph.reset(y);
                }
            }
        }

        // Al those who are connected to 0 will know the secret
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (graph.connected(i, 0)) {
                ans.add(i);
            }
        }
        return ans;

    }
}
