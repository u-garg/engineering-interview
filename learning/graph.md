
## Trees BFS template vs Graph BFS template

![image info](../resources/bst1.jpg)

![image info](../resources/bfs-2.jpg)

![image info](../resources/bst-3.jpg)



## DFS

### Graph DFS

![image info](../resources/graph-dfs.jpg)

### Tree DFS
![image info](../resources/tree-dfs.jpg)



#### Is Graph Bipartite?
##### BFS Solution (https://leetcode.com/problems/is-graph-bipartite/description/):

```java
class Solution {
    public boolean isBipartite(int[][] graph) {
        int vCount = graph.length;
        int[] color = new int[vCount];

        Arrays.fill(color, -1);
        for (int i=0; i<vCount; i++){
            if (color[i] == -1){
                if (!bfs(i, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int source, int[] color, int[][] graph){

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        color[source] = 1;

        while (!q.isEmpty()){
            int node = q.poll();
            for (int neighbor : graph[node]){
                if (color[neighbor] == -1){
                    if (color[node] == 0){
                        color[neighbor] = 1;
                    } else {
                        color[neighbor] = 0;
                    }
                    q.add(neighbor);
                } else {
                    if (color[neighbor] == color[node])
                        return false;
                }

            }
        }
        return true;
    }
}
```

### Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
https://leetcode.com/problems/number-of-islands/solutions/?orderBy=newest_to_oldest


```java
class Solution {
    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

         int numIslands = 0;

         for (int i=0; i<nr; i++){
             for (int j=0; j<nc; j++){
                 if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    numIslands++;

                 }
             }
         }
         return numIslands;
    }

    private void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if (r<0 || c<0 || r>=nr || c>=nc || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r, c+1);
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
    }
}
```

