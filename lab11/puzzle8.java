import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class puzzle8 {
    int size = 3;
    int[] sequence;
    ArrayList<puzzle8State> explored = new ArrayList<>();
    Stack<puzzle8State> dfs = new Stack<>();
    int[] puzzleSequence;

    public puzzle8(int[] inputArray) {
        System.out.println(Arrays.toString(inputArray));
        int[] rawInput = makeSequence(inputArray);
        System.out.println(Arrays.toString(rawInput));
    
        if (rawInput.length != size * size) {
            System.out.println("Input array length should be " + (size * size));
            // Handle the error here if needed
        }
    
        sequence = new int[size * size];
        for (int i = 0; i < size * size; i++) {
            int row = i / size;
            int col = i % size;
            int newIndex = row * size + col;
            sequence[newIndex] = rawInput[i];
        }
    }
    public void generateNextMove() {
        int zeroIndex = -1; // Initialize to an invalid index
        int[] possibleMoves = new int[]{-3, 3, -1, 1}; // Up, Down, Left, Right
        // Find the index of the zero (empty) element in the sequence
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 0) {
                zeroIndex = i;
                break;
            }
        }
        if (zeroIndex == -1) {
            System.out.println("Invalid puzzle state: No empty space (0) found.");
            return;
        }
        int row = zeroIndex / size;
        int col = zeroIndex % size;
        System.out.println("Next possible moves are:");
        for (int move : possibleMoves) {
            int newRow = row + move / size;
            int newCol = col + move % size;
            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                int newIndex = newRow * size + newCol;
                // Swap the zero and the adjacent element to create a new state
                int[] newState = Arrays.copyOf(sequence, sequence.length);
                newState[zeroIndex] = sequence[newIndex];
                newState[newIndex] = 0;
                // Print the move and the resulting state
                if (move == -3) {
                    System.out.println("Pushing north(up) " + Arrays.toString(newState));
                } else if (move == 3) {
                    System.out.println("Pushing south(down) " + Arrays.toString(newState));
                } else if (move == -1) {
                    System.out.println("Pushing west(left) " + Arrays.toString(newState));
                } else if (move == 1) {
                    System.out.println("Pushing east(right) " + Arrays.toString(newState));
                }
            }
        }
    }
    
    

    public void nextMoveWithStack() {
        // Create a puzzle8State object for the initial state and add it to the stack
        puzzle8State initialState = new puzzle8State(sequence);
        dfs.push(initialState);
    
        // Create a set to keep track of explored states
        Set<String> exploredStates = new HashSet<>();
        exploredStates.add(Arrays.toString(sequence));
    
        while (!dfs.isEmpty()) {
            puzzle8State currentState = dfs.pop();
            int[] currentSeq = currentState.sequence;
    
            // Check if the current state is the goal state
            if (isGoal(currentSeq)) {
                System.out.println("Goal state reached:");
                for (int i = 0; i < size * size; i++) {
                    if (i % size == 0) {
                        System.out.println(); // Start a new row
                    }
                    System.out.print(currentSeq[i] + " ");
                }
                return;
            }
    
            // Generate and explore next possible moves
            int zeroIndex = -1;
    
            for (int i = 0; i < currentSeq.length; i++) {
                if (currentSeq[i] == 0) {
                    zeroIndex = i;
                    break;
                }
            }
    
            int row = zeroIndex / size;
            int col = zeroIndex % size;
    
            // Calculate the possible moves
            int[] possibleMoves = {-3, 3, -1, 1}; // North, South, West, East
    
            for (int move : possibleMoves) {
                int newRow = row + move / size;
                int newCol = col + move % size;
    
                if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                    int newIndex = newRow * size + newCol;
    
                    // Create a new state by swapping zero and the adjacent element
                    int[] newState = Arrays.copyOf(currentSeq, currentSeq.length);
                    newState[zeroIndex] = currentSeq[newIndex];
                    newState[newIndex] = 0;
    
                    // Check if the new state has been explored before
                    if (!exploredStates.contains(Arrays.toString(newState))) {
                        puzzle8State newStateObject = new puzzle8State(newState);
                        dfs.push(newStateObject);
                        exploredStates.add(Arrays.toString(newState));
                    }
                }
            }
        }
        System.out.println("Goal state is not reachable.");
    }
    


    public static boolean isGoal(int[] seq) {
        int[] goalState = {1, 2, 3, 4, 5, 6, 7, 8, 0};
    
        if (seq.length != goalState.length) {
            return false; // Not the same size, cannot be the goal state
        }

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] != goalState[i]) {
                return false; // Found a difference, not the goal state
            }
        }

        return true; // All elements match, it's the goal state
        
    }
    private int[] makeSequence(int[] rawInput) {
        int size = 3;
        int[] sequence = new int[size * size];
        int j = 0;
    
        for (int i = 0; i < rawInput.length; i++) {
            int element = rawInput[i];
            boolean isDuplicate = false;
    
            for (int k = 0; k < j; k++) {
                if (sequence[k] == element) {
                    isDuplicate = true;
                    break;
                }
            }
            if (element != 0 && !isDuplicate) {
                if (element == 9){
                    sequence [j] = 0;
                }
                else {
                    sequence[j] = element;
                }
                j++;
            }
            
        }
        return sequence;
    }

    public void displayBoard() {
        for (int i = 0; i < size * size; i++) {
            if (i % size == 0) {
                System.out.println(); // Start a new row
            }
            System.out.print(sequence[i] + " ");
        }
        System.out.println(); // Add a new line at the end
    }

    public static void demo1() {
        puzzle8 game = new puzzle8(new int[] { 9, 0, 0, 1, 0, 1, 3, 0, 2, 4, 1, 0, 2, 1, 1, 5, 1, 2, 7, 2, 0, 8, 2, 1, 6, 2, 2 });
        game.displayBoard();
        game.generateNextMove();
        System.out.println(isGoal(game.sequence));
        game.nextMoveWithStack();
        game.displayBoard();
        System.out.println(isGoal(game.sequence));
        
    }

    public static void main(String[] args) {
        demo1();
    }
}
