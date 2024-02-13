public class puzzle8State {
    int[] sequence;

    public puzzle8State(int[] sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        puzzle8State otherState = (puzzle8State) obj;
        
        // Compare the sequence arrays element by element
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != otherState.sequence[i]) {
                return false;
            }
        }
        
        return true;
    }

}
