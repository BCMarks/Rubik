package Algorithms;

import java.util.ArrayList;
import Models.Cube;
import Models.Piece;

public class RubikSimplePLL {
    private static Piece piece19 = null;
    private static Piece piece20 = null;
    private static Piece piece21 = null;
    private static Piece piece10 = null;
    private static Piece piece12 = null;
    private static Piece piece1 = null;
    private static Piece piece2 = null;
    private static Piece piece3 = null;
    public static String[] permutateLastLayer(Cube dummy) {
        // at this point up face is completely solid but the sides are wonky
        // find where all the pieces are once again and apply algorithms
        ArrayList<Piece> pieces = dummy.getAllPieces();
        /*
            19 20 21
            10 11 12
             1  2  3
        */
        String cornerSequence = "";
        if (!dummy.isCornersOrientated()) {
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

            if (piece19.getFace("B").getDesiredSide().equals(piece21.getFace("B").getDesiredSide())) {
                cornerSequence = "R',F,R',B2,R,F',R',B2,R2,"; // l' U R' D2 R U' R' D2 R2
            } else if (piece1.getFace("L").getDesiredSide().equals(piece19.getFace("L").getDesiredSide())) {
                cornerSequence = Translator.sequenceTranslator("R',F,R',B2,R,F',R',B2,R2,".split(","), "y");
            } else if (piece3.getFace("F").getDesiredSide().equals(piece1.getFace("F").getDesiredSide())) {
                cornerSequence = Translator.sequenceTranslator("R',F,R',B2,R,F',R',B2,R2,".split(","), "y2");
            } else if (piece21.getFace("R").getDesiredSide().equals(piece3.getFace("R").getDesiredSide())) {
                cornerSequence = Translator.sequenceTranslator("R',F,R',B2,R,F',R',B2,R2,".split(","), "y'");
            } else {
                cornerSequence = "R,B',R',F,R,B,R',F',R,B,R',F,R,B',R',F',"; // x' [R U' R' D] [R U R' D'] [R U R' D] [R U' R' D']
            }
        }
        
        dummy.moveSequence(cornerSequence.split(","));
        
        String edgeSequence = "";
        if (!dummy.isSolved()) {
            for (Piece piece : pieces) {
                if (piece.getCurrentPieceNumber() == 19) {
                        piece19 = piece;
                        break;
                }
            }
            String singleTurn = "";
            String reverseTurn = "";
            switch (piece19.getDesiredPieceNumber()) {
                case 21:
                    singleTurn = "U";
                    reverseTurn = "U'";
                    break;
                case 1:
                    singleTurn = "U'";
                    reverseTurn = "U";
                    break;
                case 3:
                    singleTurn = "U2";
                    reverseTurn = "U2";
                    break;
                default:
                    break;
            }
            dummy.makeMove(singleTurn);
            if (dummy.isSolved()) {
                edgeSequence = singleTurn;
            } else {
                dummy.makeMove(reverseTurn);

                for (Piece piece : pieces) {
                    switch (piece.getCurrentPieceNumber()) {
                        case 19:
                            piece19 = piece;
                            break;
                        case 20:
                            piece20 = piece;
                            break;
                        case 21:
                            piece21 = piece;
                            break;
                        case 10:
                            piece10 = piece;
                            break;
                        case 12:
                            piece12 = piece;
                            break;
                        case 1:
                            piece1 = piece;
                            break;
                        case 2:
                            piece2 = piece;
                            break;
                        case 3:
                            piece3 = piece;
                            break;
                        default:
                            break;
                    }
                }

                if (piece20.getFace("B").getDesiredSide().equals(piece19.getFace("B").getDesiredSide())) {
                    if (piece10.getFace("L").getDesiredSide().equals(piece3.getFace("R").getDesiredSide())) {
                        edgeSequence = "R2,U,R,U,R',U',R',U',R',U,R',"; // R2 U R U R' U' R' U' R' U R'
                    } else {
                        edgeSequence = "R,U',R,U,R,U,R,U',R',U',R2,"; // [R U' R] U R U R U' R' U' R2
                    }
                } else if (piece10.getFace("L").getDesiredSide().equals(piece19.getFace("L").getDesiredSide())) {
                    if (piece2.getFace("F").getDesiredSide().equals(piece19.getFace("B").getDesiredSide())) {
                        edgeSequence = Translator.sequenceTranslator("R2,U,R,U,R',U',R',U',R',U,R',".split(","), "y"); // Ub y
                    } else {
                        edgeSequence = Translator.sequenceTranslator("R,U',R,U,R,U,R,U',R',U',R2,".split(","), "y"); // Ua y
                    }
                } else if (piece12.getFace("R").getDesiredSide().equals(piece3.getFace("R").getDesiredSide())) {
                    if (piece20.getFace("B").getDesiredSide().equals(piece3.getFace("F").getDesiredSide())) {
                        edgeSequence = Translator.sequenceTranslator("R2,U,R,U,R',U',R',U',R',U,R',".split(","), "y'"); // Ub y'
                    } else {
                        edgeSequence = Translator.sequenceTranslator("R,U',R,U,R,U,R,U',R',U',R2,".split(","), "y'"); // Ua y'
                    }
                } else if (piece2.getFace("F").getDesiredSide().equals(piece3.getFace("F").getDesiredSide())) {
                    if (piece12.getFace("R").getDesiredSide().equals(piece19.getFace("L").getDesiredSide())) {
                        edgeSequence = Translator.sequenceTranslator("R2,U,R,U,R',U',R',U',R',U,R',".split(","), "y2"); // Ub y2
                    } else {
                        edgeSequence = Translator.sequenceTranslator("R,U',R,U,R,U,R,U',R',U',R2,".split(","), "y2"); // Ua y2
                    }
                } else if (piece20.getFace("B").getDesiredSide().equals(piece3.getFace("F").getDesiredSide()) &&
                    piece2.getFace("F").getDesiredSide().equals(piece19.getFace("B").getDesiredSide())) {
                    edgeSequence = "L2,R2,D,L2,R2,U2,L2,R2,D,L2,R2,"; // M2 U M2 U2 M2 U M2
                } else if (piece20.getFace("B").getDesiredSide().equals(piece19.getFace("L").getDesiredSide()) &&
                    piece10.getFace("L").getDesiredSide().equals(piece19.getFace("B").getDesiredSide())) {
                    edgeSequence = "L2,R2,D,L2,R2,U,L,R',F2,L2,R2,B2,L,R',U2,"; // M2 U M2 U M' U2 M2 U2 M' U2
                } else if (piece20.getFace("B").getDesiredSide().equals(piece3.getFace("R").getDesiredSide())
                    && piece12.getFace("R").getDesiredSide().equals(piece19.getFace("B").getDesiredSide())) {
                    edgeSequence = Translator.sequenceTranslator("L2,R2,D,L2,R2,U,L,R',F2,L2,R2,B2,L,R',U2,".split(","), "y"); // Z y
                }

                dummy.moveSequence(edgeSequence.split(","));
                String finalMove = "";
                for (Piece piece : pieces) {
                    if (piece.getCurrentPieceNumber() == 19) {
                            piece19 = piece;
                            break;
                    }
                }
                switch (piece19.getDesiredPieceNumber()) {
                    case 21:
                        finalMove = "U";
                        break;
                    case 1:
                        finalMove = "U'";
                        break;
                    case 3:
                        finalMove = "U2";
                        break;
                    default:
                        break;
                }
                dummy.makeMove(finalMove);
                edgeSequence = edgeSequence.concat(finalMove);
            }
        }

        cornerSequence = cornerSequence.concat(edgeSequence);
        return cornerSequence.split(",");
    }
}
