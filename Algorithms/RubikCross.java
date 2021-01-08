package Algorithms;

import java.util.ArrayList;
import Models.Cube;
import Models.Piece;

public class RubikCross {
    public static String[] crossPermutation(Cube dummy) {
        StringBuilder moves = new StringBuilder("");
        ArrayList<Piece> pieces = dummy.getAllPieces();
        Piece first = null;
        Piece second = null;
        Piece third = null;
        Piece fourth = null;
        for (Piece piece : pieces) {
            if (piece.getDesiredPieceNumber() == 8) {
                first = piece;
            } else if (piece.getDesiredPieceNumber() == 16) {
                second = piece;
            } else if (piece.getDesiredPieceNumber() == 18) {
                third = piece;
            } else if (piece.getDesiredPieceNumber() == 26) {
                fourth = piece;
            }
        }

        if (!first.inCorrectOrientation()) {
            String firstSequence = null;
            switch (first.getCurrentPieceNumber()) {
                case 2:
                    if (first.getFace("F").isMatch()) {
                        firstSequence = "F2,";
                    } else {
                        firstSequence = "F',L,D,";
                    }
                    break;
                case 4:
                    if (first.getFace("F").isMatch()) {
                        firstSequence = "F',";
                    } else {
                        firstSequence = "L,D,";
                    }
                    break;
                case 6:
                    if (first.getFace("F").isMatch()) {
                        firstSequence = "F,";
                    } else {
                        firstSequence = "R',D',";
                    }
                    break;
                case 8:
                    firstSequence = "F,L,D,";
                    break;
                case 10:
                    if (first.getFace("U").getDesiredSide().equals("D")) {
                        firstSequence = "L2,D,";
                    } else {
                        firstSequence = "L,F',";
                    }
                    break;
                case 12:
                    if (first.getFace("U").getDesiredSide().equals("D")) {
                        firstSequence = "R2,D',";
                    } else {
                        firstSequence = "R',F,";
                    }
                    break;
                case 16:
                    if (first.getFace("D").isMatch()) {
                        firstSequence = "D,";
                    } else {
                        firstSequence = "L',F',";
                    }
                    break;
                case 18:
                    if (first.getFace("D").isMatch()) {
                        firstSequence = "D',";
                    } else {
                        firstSequence = "R,F,";
                    }
                    break;
                case 20:
                    if (first.getFace("U").getDesiredSide().equals("D")) {
                        firstSequence = "U2,F2,";
                    } else {
                        firstSequence = "U,R',F,";
                    }
                    break;
                case 22:
                    if (first.getFace("B").getDesiredSide().equals("D")) {
                        firstSequence = "L',D,";
                    } else {
                        firstSequence = "L2,F',";
                    }
                    break;
                case 24:
                    if (first.getFace("B").getDesiredSide().equals("D")) {
                        firstSequence = "R,D',";
                    } else {
                        firstSequence = "R2,F,";
                    }
                    break;
                case 26:
                    if (first.getFace("D").isMatch()) {
                        firstSequence = "D2,";
                    } else {
                        firstSequence = "D,L',F',";
                    }
                    break;
                default:
                    break;
            }
            moves.append(firstSequence);
            dummy.moveSequence(firstSequence.split(","));
        }
        
        if (!second.inCorrectOrientation()) {
            String secondSequence = null;
            switch (second.getCurrentPieceNumber()) {
                case 2:
                    if (second.getFace("F").getDesiredSide().equals("D")) {
                        secondSequence = "F',L,F,";
                    } else {
                        secondSequence = "U,L2,";
                    }
                    break;
                case 4:
                    if (second.getFace("F").getDesiredSide().equals("D")) {
                        secondSequence = "L,";
                    } else {
                        secondSequence = "D,F',D',";
                    }
                    break;
                case 6:
                    if (second.getFace("F").getDesiredSide().equals("D")) {
                        secondSequence = "D2,R',D2,";
                    } else {
                        secondSequence = "D,F,D',";
                    }
                    break;
                case 10:
                    if (second.getFace("U").getDesiredSide().equals("D")) {
                        secondSequence = "L2,";
                    } else {
                        secondSequence = "D,L,F',D',";
                    }
                    break;
                case 12:
                    if (second.getFace("U").getDesiredSide().equals("D")) {
                        secondSequence = "U2,L2,";
                    } else {
                        secondSequence = "D',R,B',D,";
                    }
                    break;
                case 16:
                    secondSequence = "L,D',B,D,";
                    break;
                case 18:
                    if (second.getFace("D").isMatch()) {
                        secondSequence = "R',D2,R,D2,";
                    } else {
                        secondSequence = "R,D,F,D',";
                    }
                    break;
                case 20:
                    if (second.getFace("U").getDesiredSide().equals("D")) {
                        secondSequence = "U',L2,";
                    } else {
                        secondSequence = "U2,F',L,F,";
                    }
                    break;
                case 22:
                    if (second.getFace("B").getDesiredSide().equals("D")) {
                        secondSequence = "L',";
                    } else {
                        secondSequence = "D',B,D,";
                    }
                    break;
                case 24:
                    if (second.getFace("B").getDesiredSide().equals("D")) {
                        secondSequence = "B2,L',";
                    } else {
                        secondSequence = "D',B',D,";
                    }
                    break;
                case 26:
                    if (second.getFace("D").isMatch()) {
                        secondSequence = "D,L',D',L,";
                    } else {
                        secondSequence = "B',L',";
                    }
                    break;
                default:
                    break;
            }
            moves.append(secondSequence);
            dummy.moveSequence(secondSequence.split(","));
        }
        
        if (!third.inCorrectOrientation()) {
            String thirdSequence = null;
            switch (third.getCurrentPieceNumber()) {
                case 2:
                    if (third.getFace("F").getDesiredSide().equals("D")) {
                        thirdSequence = "F,R',F',";
                    } else {
                        thirdSequence = "U',R2,";
                    }
                    break;
                case 4:
                    if (third.getFace("F").getDesiredSide().equals("D")) {
                        thirdSequence = "D2,L,D2,";
                    } else {
                        thirdSequence = "D',F',D,";
                    }
                    break;
                case 6:
                    if (third.getFace("F").getDesiredSide().equals("D")) {
                        thirdSequence = "R',";
                    } else {
                        thirdSequence = "D',F,D,";
                    }
                    break;
                case 10:
                    if (third.getFace("U").getDesiredSide().equals("D")) {
                        thirdSequence = "U2,R2,";
                    } else {
                        thirdSequence = "U',F,R',F',";
                    }
                    break;
                case 12:
                    if (third.getFace("U").getDesiredSide().equals("D")) {
                        thirdSequence = "R2,";
                    } else {
                        thirdSequence = "U,F,R',F',";
                    }
                    break;
                case 18:
                    thirdSequence = "R,D',F,D,";
                    break;
                case 20:
                    if (third.getFace("U").getDesiredSide().equals("D")) {
                        thirdSequence = "U,R2,";
                    } else {
                        thirdSequence = "U2,F,R',F',";
                    }
                    break;
                case 22:
                    if (third.getFace("B").getDesiredSide().equals("D")) {
                        thirdSequence = "B2,R,";
                    } else {
                        thirdSequence = "D,B,D',";
                    }
                    break;
                case 24:
                    if (third.getFace("B").getDesiredSide().equals("D")) {
                        thirdSequence = "R,";
                    } else {
                        thirdSequence = "D,B',D',";
                    }
                    break;
                case 26:
                    if (third.getFace("D").isMatch()) {
                        thirdSequence = "D',R,D,R',";
                    } else {
                        thirdSequence = "B,R,";
                    }
                    break;
                default:
                    break;
            }
            moves.append(thirdSequence);
            dummy.moveSequence(thirdSequence.split(","));
        }

        if (!fourth.inCorrectOrientation()) {
            String fourthSequence = null;
            switch (fourth.getCurrentPieceNumber()) {
                case 2:
                    if (fourth.getFace("F").getDesiredSide().equals("D")) {
                        fourthSequence = "U',R,B',R',";
                    } else {
                        fourthSequence = "U2,B2,";
                    }
                    break;
                case 4:
                    if (fourth.getFace("F").getDesiredSide().equals("D")) {
                        fourthSequence = "D,L,D',";
                    } else {
                        fourthSequence = "D2,F',D2,";
                    }
                    break;
                case 6:
                    if (fourth.getFace("F").getDesiredSide().equals("D")) {
                        fourthSequence = "D',R',D,";
                    } else {
                        fourthSequence = "D2,F,D2,";
                    }
                    break;
                case 10:
                    if (fourth.getFace("U").getDesiredSide().equals("D")) {
                        fourthSequence = "U,B2,";
                    } else {
                        fourthSequence = "L',B,L,";
                    }
                    break;
                case 12:
                    if (fourth.getFace("U").getDesiredSide().equals("D")) {
                        fourthSequence = "U',B2,";
                    } else {
                        fourthSequence = "R,B',R',";
                    }
                    break;
                case 20:
                    if (fourth.getFace("U").getDesiredSide().equals("D")) {
                        fourthSequence = "B2,";
                    } else {
                        fourthSequence = "U,R,B',R',";
                    }
                    break;
                case 22:
                    if (fourth.getFace("B").getDesiredSide().equals("D")) {
                        fourthSequence = "D,L',D',";
                    } else {
                        fourthSequence = "B,";
                    }
                    break;
                case 24:
                    if (fourth.getFace("B").getDesiredSide().equals("D")) {
                        fourthSequence = "D',R,D,";
                    } else {
                        fourthSequence = "B',";
                    }
                    break;
                case 26:
                    fourthSequence = "B,D',R,D,";
                    break;
                default:
                    break;
            }
            
            moves.append(fourthSequence);
            dummy.moveSequence(fourthSequence.split(","));
        }
        return moves.toString().split(",");
    }
}