package badDrum.equationPuzzle;


public class PuzzleState {

    public static int attemptCount;
    public static int punishLevel;
    public boolean puzzleSolved;

    void main() throws Exception {
        startPuzzle();
    }

    public void startPuzzle() throws Exception {
        PuzzleLogic Logic = new PuzzleLogic();
        PuzzleDialog Dialog = new PuzzleDialog();
        attemptCount = 0;
        puzzleSolved = false;
        Logic.generateVars();
        iteratePuzzle(Logic, Dialog);
    }

    public void iteratePuzzle(PuzzleLogic Logic, PuzzleDialog Dialog) throws Exception {
        try {
            Dialog.ask(Logic);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int signal = Dialog.getSignal();
        // for some reason the code stops at this point
        boolean solved = getPuzzleState(signal);
        System.out.println("Puzzle solved: "+ puzzleSolved+ ". signal = " + signal);
        if (puzzleSolved) {
            Dialog.showSolvedMassage();
        } else {
            attemptCount++;
            punishment(attemptCount);
            switch (signal){
                case 0: int ans = Dialog.showWrongAnsMassage();
                    System.out.println(ans);
                    break;
                case -1: Dialog.showErrorMassage();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + signal);
            }
            if(!puzzleSolved) retry(Logic, Dialog);
        }
    }
    private void retry(PuzzleLogic Logic, PuzzleDialog Dialog) throws Exception {
        iteratePuzzle(Logic, Dialog);
    }

    public boolean getPuzzleState(int signal) {
        System.out.println("Signal passed to State = " + signal);
        if (signal == 1) this.puzzleSolved = true;
        System.out.println("Getting puzzle state..." + puzzleSolved);
        return puzzleSolved;
    }

    public static void punishment(int error){
        switch (error) {
            case 0: punishLevel = 0;
                break;
            case 1: punishLevel = 1;
                break;
            case 2: punishLevel = 2;
                break;
            default: punishLevel = 3;
            System.out.println("Punishment level = " + punishLevel);
        }
    }

    public static int getAttemptCount() {
        System.out.println("Attempt count = " + attemptCount);
        return attemptCount;
    }
}
