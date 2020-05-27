class Solution {
    boolean ans = true;
    boolean[] visited;
    int N;
    int[] levels;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] adjMat = new int[N + 1][N + 1];
        this.visited = new boolean[N + 1];
        this.N = N;
        this.levels = new int[N + 1];
        int row = dislikes.length;
        if (row == 0) return true;


        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        //build the adjList
        for (int i = 0; i < row; i++) {
            int x = dislikes[i][0];
            int y = dislikes[i][1];
            ArrayList<Integer> xl = adjList.getOrDefault(x, new ArrayList<Integer>());
            ArrayList<Integer> yl = adjList.getOrDefault(y, new ArrayList<Integer>());
            xl.add(y);
            adjList.put(x, xl);
            yl.add(x);
            adjList.put(y, yl);
        }
        // System.out.print(adjList.toString());
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i])
                dfs(adjList, i, 0, 1);
        }
        return ans;

    }

    public void dfs(HashMap<Integer, ArrayList<Integer>> adjMat, int vertex, int parent, int level) {
        if (!ans) return;
        visited[vertex] = true;
        levels[vertex] = level;
        ArrayList<Integer> edges = adjMat.getOrDefault(vertex, new ArrayList<Integer>());
        for (int neighbour : edges) {
            if (neighbour == parent) continue;

            if (!visited[neighbour]) {
                dfs(adjMat, neighbour, vertex, level + 1);
            } else {
                if ((level - levels[neighbour]) % 2 == 0) {
                    ans = false;
                }
            }
        }
    }
}

// adjMat
// 0 0 0 0
// 0 0 1 1
// 0 1 0 1
// 0 1 1 0


// 1->2->3->4->5->1
