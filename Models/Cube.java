package Models;

import java.util.ArrayList;

public class Cube {
    private String[] validMoves = {
        "F", "F'", "F2",
        "B", "B'", "B2",
        "L", "L'", "L2",
        "R", "R'", "R2",
        "U", "U'", "U2",
        "D", "D'", "D2",
    };
    private ArrayList<Piece> pieces;
    private ArrayList<String> solution;
    private String mix = "";

    public Cube() {
        pieces = new ArrayList<Piece>();
        solution = new ArrayList<String>();
        for (int i = 1; i < 28 ; i++) {
            if (i == 14) {
                continue;
            }
            pieces.add(new Piece(i));            
        }
    }

    public Cube(Cube original) {
        pieces = new ArrayList<Piece>();
        solution = new ArrayList<String>();
        for (String string : original.solution) {
            solution.add(string);
        }
        for (Piece piece : original.getAllPieces()) {
            pieces.add(new Piece(piece));
        }
    }

    public void mixCube(String[] mix) {
        for (String string : mix) {
            makeMove(string);
            this.mix = this.mix.concat(string).concat(" ");
        }
    }

    public void mixCubeRandom(int length) {
        ArrayList<String> redundantMoves = new ArrayList<String>();
        ArrayList<String> previousMoves = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            int nextMoveIndex = (int) Math.floor(Math.random() * 17);
            String nextMove = validMoves[nextMoveIndex];
            while (redundantMoves.contains(nextMove)) {
                nextMoveIndex = (int) Math.floor(Math.random() * 17);
                nextMove = validMoves[nextMoveIndex];
            }
            if (nextMoveIndex < 3) {
                redundantMoves = handleRedundancy(redundantMoves, 3, 0);
            } else if (nextMoveIndex < 6) {
                redundantMoves = handleRedundancy(redundantMoves, 0, 3);
            } else if (nextMoveIndex < 9) {
                redundantMoves = handleRedundancy(redundantMoves, 9, 6);
            } else if (nextMoveIndex < 12) {
                redundantMoves = handleRedundancy(redundantMoves, 6, 9);
            } else if (nextMoveIndex < 15) {
                redundantMoves = handleRedundancy(redundantMoves, 15, 12);
            } else {
                redundantMoves = handleRedundancy(redundantMoves, 12, 15);
            }
            previousMoves.add(nextMove);
            makeMove(nextMove);
            mix = mix.concat(nextMove).concat(" ");
        }
    }

    private ArrayList<String> handleRedundancy(ArrayList<String>  redundantMoves, int remainBanned, int newBanned) {
        ArrayList<String> formerRedundantMoves = new ArrayList<String>();
        for (String move :  redundantMoves) {
            if (!(move.equals(validMoves[remainBanned]) || move.equals(validMoves[remainBanned + 1]) || move.equals(validMoves[remainBanned + 2]))) {
                formerRedundantMoves.add(move);
            }
        }
        redundantMoves.removeAll(formerRedundantMoves);
        redundantMoves.add(validMoves[newBanned]);
        redundantMoves.add(validMoves[newBanned + 1]);
        redundantMoves.add(validMoves[newBanned + 2]);
        return redundantMoves;
    }

    public boolean isSolved() {
        for (Piece piece : pieces) {
            if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                return false;
            }
        }
        return true;
    }

    public boolean isCrossSolved() {
        for (Piece piece : pieces) {
            if (piece.getDesiredPieceNumber() == 8) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            } else if (piece.getDesiredPieceNumber() == 16) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            } else if (piece.getDesiredPieceNumber() == 18) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            } else if (piece.getDesiredPieceNumber() == 26) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFirstPairSolved() {
        if (!isCrossSolved()) {
            return false;
        }

        for (Piece piece : pieces) {
            if (piece.getDesiredPieceNumber() == 6) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            } else if (piece.getDesiredPieceNumber() == 9) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSecondPairSolved() {
        if (!isCrossSolved()) {
            return false;
        }

        for (Piece piece : pieces) {
            if (piece.getDesiredPieceNumber() == 24) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            } else if (piece.getDesiredPieceNumber() == 27) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isThirdPairSolved() {
        if (!isCrossSolved()) {
            return false;
        }

        for (Piece piece : pieces) {
            if (piece.getDesiredPieceNumber() == 22) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            } else if (piece.getDesiredPieceNumber() == 25) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFourthPairSolved() {
        if (!isCrossSolved()) {
            return false;
        }

        for (Piece piece : pieces) {
            if (piece.getDesiredPieceNumber() == 4) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            } else if (piece.getDesiredPieceNumber() == 7) {
                if (!piece.inCorrectPosition() || !piece.inCorrectOrientation()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCornersOrientated() {
        Piece piece19 = null;
        Piece piece21 = null;
        Piece piece1 = null;
        Piece piece3 = null;
        for (Piece piece : pieces) {
            switch (piece.getCurrentPieceNumber()) {
                case 19:
                    piece19 = piece;
                    break;
                case 21:
                    piece21 = piece;
                    break;
                case 1:
                    piece1 = piece;
                    break;
                case 3:
                    piece3 = piece;
                    break;
                default:
                    break;
            }
        }

        if (piece19.getFace("B").getDesiredSide().equals(piece21.getFace("B").getDesiredSide()) &&
            piece1.getFace("L").getDesiredSide().equals(piece19.getFace("L").getDesiredSide()) &&
            piece3.getFace("F").getDesiredSide().equals(piece1.getFace("F").getDesiredSide()) &&
            piece21.getFace("R").getDesiredSide().equals(piece3.getFace("R").getDesiredSide())) {
            return true;
        } else {
            return false;
        }
    }

    private Piece getPiece(int number) {
        for (Piece piece : pieces) {
            if (piece.getCurrentPieceNumber() == number) {
                return piece;
            }
        }

        return null;
    }

    public ArrayList<Piece> getAllPieces() {
        return pieces;
    }

    public String getInitialMix() {
        return mix;
    }

    public void displayPieces() {
        for (Piece piece : pieces) {
            if (piece.getDesiredPieceNumber() == 7 || piece.getDesiredPieceNumber() == 8 || piece.getDesiredPieceNumber() == 9 ||
                piece.getDesiredPieceNumber() == 16 || piece.getDesiredPieceNumber() == 17 || piece.getDesiredPieceNumber() == 18 ||
                piece.getDesiredPieceNumber() > 24) {
                piece.printPieceDetails();
                System.out.println("=========================================================================");
            }
        }
    }

    public void showCube() {
        System.out.println();
        System.out.println("    "+getPiece(19).getFace("U").getDesiredSide()+getPiece(20).getFace("U").getDesiredSide()+getPiece(21).getFace("U").getDesiredSide());
        System.out.println("    "+getPiece(10).getFace("U").getDesiredSide()+getPiece(11).getFace("U").getDesiredSide()+getPiece(12).getFace("U").getDesiredSide());
        System.out.println("    "+getPiece(1).getFace("U").getDesiredSide()+getPiece(2).getFace("U").getDesiredSide()+getPiece(3).getFace("U").getDesiredSide());
        System.out.println(getPiece(19).getFace("L").getDesiredSide()+getPiece(10).getFace("L").getDesiredSide()+getPiece(1).getFace("L").getDesiredSide()+" "+
            getPiece(1).getFace("F").getDesiredSide()+getPiece(2).getFace("F").getDesiredSide()+getPiece(3).getFace("F").getDesiredSide()+" "+
            getPiece(3).getFace("R").getDesiredSide()+getPiece(12).getFace("R").getDesiredSide()+getPiece(21).getFace("R").getDesiredSide()+" "+
            getPiece(21).getFace("B").getDesiredSide()+getPiece(20).getFace("B").getDesiredSide()+getPiece(19).getFace("B").getDesiredSide());
        System.out.println(getPiece(22).getFace("L").getDesiredSide()+getPiece(13).getFace("L").getDesiredSide()+getPiece(4).getFace("L").getDesiredSide()+" "+
            getPiece(4).getFace("F").getDesiredSide()+getPiece(5).getFace("F").getDesiredSide()+getPiece(6).getFace("F").getDesiredSide()+" "+
            getPiece(6).getFace("R").getDesiredSide()+getPiece(15).getFace("R").getDesiredSide()+getPiece(24).getFace("R").getDesiredSide()+" "+
            getPiece(24).getFace("B").getDesiredSide()+getPiece(23).getFace("B").getDesiredSide()+getPiece(22).getFace("B").getDesiredSide());
        System.out.println(getPiece(25).getFace("L").getDesiredSide()+getPiece(16).getFace("L").getDesiredSide()+getPiece(7).getFace("L").getDesiredSide()+" "+
            getPiece(7).getFace("F").getDesiredSide()+getPiece(8).getFace("F").getDesiredSide()+getPiece(9).getFace("F").getDesiredSide()+" "+
            getPiece(9).getFace("R").getDesiredSide()+getPiece(18).getFace("R").getDesiredSide()+getPiece(27).getFace("R").getDesiredSide()+" "+
            getPiece(27).getFace("B").getDesiredSide()+getPiece(26).getFace("B").getDesiredSide()+getPiece(25).getFace("B").getDesiredSide());
        System.out.println("    "+getPiece(7).getFace("D").getDesiredSide()+getPiece(8).getFace("D").getDesiredSide()+getPiece(9).getFace("D").getDesiredSide());
        System.out.println("    "+getPiece(16).getFace("D").getDesiredSide()+getPiece(17).getFace("D").getDesiredSide()+getPiece(18).getFace("D").getDesiredSide());
        System.out.println("    "+getPiece(25).getFace("D").getDesiredSide()+getPiece(26).getFace("D").getDesiredSide()+getPiece(27).getFace("D").getDesiredSide());
        System.out.println();
    }

    public void moveSequence(String[] sequence) {
        for (String move : sequence) {
            makeMove(move);
        }
    }
    
    public void makeMove(String move) {
        switch (move) {
            case "F":
                moveFront();
                break;
            case "F'":
                moveFrontInverted();
                break;
            case "F2":
                moveFrontDouble();
                break;
            case "B":
                moveBack();
                break;
            case "B'":
                moveBackInverted();
                break;
            case "B2":
                moveBackDouble();
                break;
            case "L":
                moveLeft();
                break;
            case "L'":
                moveLeftInverted();
                break;
            case "L2":
                moveLeftDouble();
                break;
            case "R":
                moveRight();
                break;
            case "R'":
                moveRightInverted();
                break;
            case "R2":
                moveRightDouble();
                break;
            case "U":
                moveUp();
                break;
            case "U'":
                moveUpInverted();
                break;
            case "U2":
                moveUpDouble();
                break;
            case "D":
                moveDown();
                break;
            case "D'":
                moveDownInverted();
                break;
            case "D2":
                moveDownDouble();
                break;
            default:
                break;
        }
    }

    private void moveFront() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 1:
                    piece.moveFront(3);
                    break;
                case 2:
                    piece.moveFront(6);
                    break;
                case 3:
                    piece.moveFront(9);
                    break;
                case 4:
                    piece.moveFront(2);
                    break;
                case 6:
                    piece.moveFront(8);
                    break;
                case 7:
                    piece.moveFront(1);
                    break;
                case 8:
                    piece.moveFront(4);
                    break;
                case 9:
                    piece.moveFront(7);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveFrontInverted() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 1:
                    piece.moveFrontInverted(7);
                    break;
                case 2:
                    piece.moveFrontInverted(4);
                    break;
                case 3:
                    piece.moveFrontInverted(1);
                    break;
                case 4:
                    piece.moveFrontInverted(8);
                    break;
                case 6:
                    piece.moveFrontInverted(2);
                    break;
                case 7:
                    piece.moveFrontInverted(9);
                    break;
                case 8:
                    piece.moveFrontInverted(6);
                    break;
                case 9:
                    piece.moveFrontInverted(3);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveFrontDouble() {
        moveFront();
        moveFront();
    }

    private void moveBack() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 21:
                    piece.moveBack(19);
                    break;
                case 20:
                    piece.moveBack(22);
                    break;
                case 19:
                    piece.moveBack(25);
                    break;
                case 24:
                    piece.moveBack(20);
                    break;
                case 22:
                    piece.moveBack(26);
                    break;
                case 27:
                    piece.moveBack(21);
                    break;
                case 26:
                    piece.moveBack(24);
                    break;
                case 25:
                    piece.moveBack(27);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveBackInverted() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 21:
                    piece.moveBackInverted(27);
                    break;
                case 20:
                    piece.moveBackInverted(24);
                    break;
                case 19:
                    piece.moveBackInverted(21);
                    break;
                case 24:
                    piece.moveBackInverted(26);
                    break;
                case 22:
                    piece.moveBackInverted(20);
                    break;
                case 27:
                    piece.moveBackInverted(25);
                    break;
                case 26:
                    piece.moveBackInverted(22);
                    break;
                case 25:
                    piece.moveBackInverted(19);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveBackDouble() {
        moveBack();
        moveBack();
    }

    private void moveLeft() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 19:
                    piece.moveLeft(1);
                    break;
                case 10:
                    piece.moveLeft(4);
                    break;
                case 1:
                    piece.moveLeft(7);
                    break;
                case 22:
                    piece.moveLeft(10);
                    break;
                case 4:
                    piece.moveLeft(16);
                    break;
                case 25:
                    piece.moveLeft(19);
                    break;
                case 16:
                    piece.moveLeft(22);
                    break;
                case 7:
                    piece.moveLeft(25);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveLeftInverted() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 19:
                    piece.moveLeftInverted(25);
                    break;
                case 10:
                    piece.moveLeftInverted(22);
                    break;
                case 1:
                    piece.moveLeftInverted(19);
                    break;
                case 22:
                    piece.moveLeftInverted(16);
                    break;
                case 4:
                    piece.moveLeftInverted(10);
                    break;
                case 25:
                    piece.moveLeftInverted(7);
                    break;
                case 16:
                    piece.moveLeftInverted(4);
                    break;
                case 7:
                    piece.moveLeftInverted(1);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveLeftDouble() {
        moveLeft();
        moveLeft();
    }

    private void moveRight() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 3:
                    piece.moveRight(21);
                    break;
                case 12:
                    piece.moveRight(24);
                    break;
                case 21:
                    piece.moveRight(27);
                    break;
                case 6:
                    piece.moveRight(12);
                    break;
                case 24:
                    piece.moveRight(18);
                    break;
                case 9:
                    piece.moveRight(3);
                    break;
                case 18:
                    piece.moveRight(6);
                    break;
                case 27:
                    piece.moveRight(9);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveRightInverted() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 3:
                    piece.moveRightInverted(9);
                    break;
                case 12:
                    piece.moveRightInverted(6);
                    break;
                case 21:
                    piece.moveRightInverted(3);
                    break;
                case 6:
                    piece.moveRightInverted(18);
                    break;
                case 24:
                    piece.moveRightInverted(12);
                    break;
                case 9:
                    piece.moveRightInverted(27);
                    break;
                case 18:
                    piece.moveRightInverted(24);
                    break;
                case 27:
                    piece.moveRightInverted(21);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveRightDouble() {
        moveRight();
        moveRight();
    }

    private void moveUp() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 19:
                    piece.moveUp(21);
                    break;
                case 20:
                    piece.moveUp(12);
                    break;
                case 21:
                    piece.moveUp(3);
                    break;
                case 10:
                    piece.moveUp(20);
                    break;
                case 12:
                    piece.moveUp(2);
                    break;
                case 1:
                    piece.moveUp(19);
                    break;
                case 2:
                    piece.moveUp(10);
                    break;
                case 3:
                    piece.moveUp(1);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveUpInverted() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 19:
                    piece.moveUpInverted(1);
                    break;
                case 20:
                    piece.moveUpInverted(10);
                    break;
                case 21:
                    piece.moveUpInverted(19);
                    break;
                case 10:
                    piece.moveUpInverted(2);
                    break;
                case 12:
                    piece.moveUpInverted(20);
                    break;
                case 1:
                    piece.moveUpInverted(3);
                    break;
                case 2:
                    piece.moveUpInverted(12);
                    break;
                case 3:
                    piece.moveUpInverted(21);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveUpDouble() {
        moveUp();
        moveUp();
    }

    private void moveDown() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 7:
                    piece.moveDown(9);
                    break;
                case 8:
                    piece.moveDown(18);
                    break;
                case 9:
                    piece.moveDown(27);
                    break;
                case 16:
                    piece.moveDown(8);
                    break;
                case 18:
                    piece.moveDown(26);
                    break;
                case 25:
                    piece.moveDown(7);
                    break;
                case 26:
                    piece.moveDown(16);
                    break;
                case 27:
                    piece.moveDown(25);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveDownInverted() {
        for (Piece piece : pieces) {
            int current = piece.getCurrentPieceNumber();
            switch (current) {
                case 7:
                    piece.moveDownInverted(25);
                    break;
                case 8:
                    piece.moveDownInverted(16);
                    break;
                case 9:
                    piece.moveDownInverted(7);
                    break;
                case 16:
                    piece.moveDownInverted(26);
                    break;
                case 18:
                    piece.moveDownInverted(8);
                    break;
                case 25:
                    piece.moveDownInverted(27);
                    break;
                case 26:
                    piece.moveDownInverted(18);
                    break;
                case 27:
                    piece.moveDownInverted(9);
                    break;
                default:
                    break;
            }
        }
    }

    private void moveDownDouble() {
        moveDown();
        moveDown();
    }
}