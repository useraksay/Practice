import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Given a 2D array with values as ‘S’, ‘D’, ‘1’ and ‘0’.
- S is the Source
- D is the Destination
- 1 marks the valid path
- 0 marks the obstacle
Find the shortest distance from S to D avoiding all the obstacles.
*
* Approach:
Starting from the source ‘S’, add it to the queue
Remove the first node from the queue and mark it visited so that it should not be processed again.
For the node just removed from the queue in step 2, check all the neighboring nodes
If the x & y value of the node is within the values of given matrix and the node has not been marked visited yet, add it to the queue along with the distance of this node from the source ‘S’
repeat steps 2 to 4 until you reach to the node which is equal to ‘D’ (Destination)
If there is a path available from S to D, the distance will be displayed, otherwise it will print ‘-1’

* https://medium.com/@manpreetsingh.16.11.87/shortest-path-in-a-2d-array-java-653921063884
* */
public class ShortestCellPath {
    public static void main(String[] args) {
        char[][] matrix = {
                {'S', '1', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int path = bfs(matrix, visited);
        System.out.println(path);
    }

    private static int bfs(char[][] matrix, boolean[][] visited){
        Node source = new Node(0, 0, 0);
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(source);

        while(!queue.isEmpty()){
            Node currNode = queue.poll();

            if(matrix[currNode.x][currNode.y] == 'D' ) {
                return currNode.distanceFromSource;
            }else{
                // mark the currNode as visited
                visited[currNode.x][currNode.y] = true;
                List<Node> neighbourList = addNeighbours(currNode, matrix, visited);
                queue.addAll(neighbourList);
            }
        }
        return -1;
    }

    private static List<Node> addNeighbours(Node currNode, char[][] matrix, boolean[][] visited) {
        List<Node> list = new LinkedList<>();

        if((currNode.x - 1 >= 0 && currNode.x - 1 < matrix.length) && matrix[currNode.x - 1][currNode.y] != '0' && !visited[currNode.x - 1][currNode.y]) {
            list.add(new Node(currNode.x - 1, currNode.y, currNode.distanceFromSource + 1));
        }
        if((currNode.x + 1 >= 0 && currNode.x + 1 < matrix.length) && matrix[currNode.x + 1][currNode.y] != '0' && !visited[currNode.x + 1][currNode.y]) {
            list.add(new Node(currNode.x + 1, currNode.y, currNode.distanceFromSource + 1));
        }
        if((currNode.y - 1 >= 0 && currNode.y - 1 < matrix.length) && matrix[currNode.x][currNode.y - 1] != '0' && !visited[currNode.x][currNode.y - 1]) {
            list.add(new Node(currNode.x, currNode.y - 1, currNode.distanceFromSource + 1));
        }
        if((currNode.y + 1 >= 0 && currNode.y + 1 < matrix.length) && matrix[currNode.x][currNode.y + 1] != '0' && !visited[currNode.x][currNode.y + 1]) {
            list.add(new Node(currNode.x, currNode.y + 1, currNode.distanceFromSource + 1));
        }

        return list;
    }
}

class Node{
    int x;
    int y;
    int distanceFromSource;

    Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.distanceFromSource = dis;
    }
}
