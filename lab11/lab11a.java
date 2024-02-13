import java.util.ArrayList;

public class lab11a {
    //final static int inf = Integer.MAX_VALUE;
    static void q2() {
                            // A B C D E
        int[][] thisGraph = { { 0, 3, 0, 0, 2 },
                            { 3, 0, 1, 0, 0 },
                            { 0, 1, 0, 4, 0 },
                            { 0, 0, 4, 0, 5 },
                            { 2, 0, 0, 5, 0 } };
        System.out.println("computing dfs");
        q2_dfs(thisGraph);
    }
    private static void q2_dfs(int[][] thisGraph) {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>(); // Store the path

        stack.add(0); // root is at A, we'll suffix the next city
        path.add(0); // Initialize the path

        while (notEmpty(stack)) {
            int parent = stack.remove(stack.size() - 1);
            visited.add(parent);
            //System.out.println("Visited: " + parent);

            for (int x = 0; x < thisGraph.length; x++) {
                if (0 < thisGraph[parent][x] && /* code 1a */!visited.contains(x)) {
                    stack.add(x);
                    /*code 1b */
                    path.add(x); // Add the node to the path
                    System.out.println("Edge " + parent + ", " + x);
                }
            }
        }
        System.out.println("Path: " + path.toString()); // Print the path
    }
    private static boolean notEmpty(ArrayList<Integer> stack) {
        return !stack.isEmpty();
    }

    public static String toString(ArrayList<Integer> stack) {
        StringBuffer sb = new StringBuffer();
        sb.append("top->");
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append("[");
            sb.append(stack.get(i)); // Access elements from the original stack
            sb.append("]->");
        }
        sb.append("bottom");
        return sb.toString();
    }
    

    public static void main(String[] args) {
        q2();
    }

}
