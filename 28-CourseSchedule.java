class Solution {
    HashMap<Integer, GraphNode> graph = new HashMap<>();

    public boolean canFinish(int n, int[][] preq) {
        if (preq.length == 0) return true;
        int totalCourses = preq.length;
        for (int[] edge : preq) {
            GraphNode prev = getOrCreate(edge[0]);
            GraphNode next = getOrCreate(edge[1]);
            prev.nodes.add(edge[1]);
            next.inCount += 1;
        }
        ArrayList<Integer> noPreqCourses = new ArrayList<>();
        for (Map.Entry<Integer, GraphNode> entry : graph.entrySet()) {
            GraphNode node = entry.getValue();
            if (node.inCount == 0)
                noPreqCourses.add(entry.getKey());
        }

        int coursesDone = 0;
        while (noPreqCourses.size() > 0) {
            int course = noPreqCourses.get(noPreqCourses.size() - 1);
            noPreqCourses.remove(noPreqCourses.size() - 1);
            for (int nextCourse : graph.get(course).nodes) {
                GraphNode child = graph.get(nextCourse);
                child.inCount -= 1;
                coursesDone++;
                if (child.inCount == 0)
                    noPreqCourses.add(nextCourse);
            }
        }
        if (totalCourses == coursesDone) return true;
        return false;

    }

    public GraphNode getOrCreate(int node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new GraphNode());
        }
        return graph.get(node);
    }
}

class GraphNode {
    int inCount;
    ArrayList<Integer> nodes = new ArrayList<Integer>();
}