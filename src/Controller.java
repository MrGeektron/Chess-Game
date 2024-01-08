public class Controller {
    View view;
    Board board;

    public Controller(String boardType, String viewType) {
        view = new CommandLineView();
        if(boardType.equals("Pawn")) {
            board = new Board("Pawn");
        }
        else {
            board = new Board("");
        }
    }

    public void display() {
        view.display(board.toString());
    }
}
