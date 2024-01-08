import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<ChessPiece>> board;

    public Board(String boardType) {
        ArrayList<ArrayList<ChessPiece>> pieces = new ArrayList<>();
        board = new ArrayList<>();
        if(boardType.equals("Pawn")) {
            for(int i = 0; i < 4; i++) {
                pieces.add(new ArrayList<>());
                for(int j = 0; j < 8; j++) {
                    pieces.get(i).add(new Pawn());
                }
            }
            createBoard(pieces);
        }
        else {
            createBoard(pieces);
        }
    }

    /**
     * Populates the board with the provided pieces placed on the top and bottom two rows.
     * @param pieces two sets of pieces one for black player and one for white player
     */
    private void createBoard(ArrayList<ArrayList<ChessPiece>> pieces) {
        if(pieces.size() == 4) {
            board.add(pieces.get(0));
            board.add(pieces.get(1));
            board.add(new ArrayList<>());
            board.add(new ArrayList<>());
            board.add(new ArrayList<>());
            board.add(new ArrayList<>());
            board.add(pieces.get(2));
            board.add(pieces.get(3));
        }
        else {
            for(int i = 0; i < 8; i++) {
                board.add(new ArrayList<>());
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        int boardNumber = 8;
        for (ArrayList<ChessPiece> chessPieces : board) {
            if (chessPieces != null) {
                builder.append(boardNumber--).append(" ");
                if (!chessPieces.isEmpty()) {
                    for (int length = 0; length < chessPieces.size() - 1; length++) {
                        builder.append("[");
                        builder.append(chessPieces.get(length));
                        builder.append("]");
                    }
                    builder.append("[");
                    builder.append(chessPieces.get(chessPieces.size() - 1));
                    builder.append("]\n");
                } else {
                    builder.append("[ ]".repeat(7));
                    builder.append("[ ]\n");
                }
            } else {
                builder.append("[ ]".repeat(8));
                builder.append("[ ]\n");
            }
        }
        builder.append("   a  b  c  d  e  f  g  h\n");
        return builder.toString();
    }
}
