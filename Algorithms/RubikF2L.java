package Algorithms;

import java.util.ArrayList;

import Models.Cube;
import Models.Piece;

public class RubikF2L {
    public static String[] fillF2L(Cube dummy) {
        // https://solvethecube.com/algorithms#f2l
        // NB! not all possible positions are shown, therefore manipulate cube to closest position
        StringBuilder moves = new StringBuilder("");
        // CORNERS: 7 9 25 27, also possibly located in 1 3 19 21
        // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
        ArrayList<Piece> pieces = dummy.getAllPieces();
        Piece firstCorner = null;
        Piece secondCorner = null;
        Piece thirdCorner = null;
        Piece fourthCorner = null;
        for (Piece piece : pieces) {
            switch (piece.getDesiredPieceNumber()) {
                case 7:
                    fourthCorner = piece;
                    break;
                case 9:
                    firstCorner = piece;
                    break;
                case 25:
                    thirdCorner = piece;
                    break;
                case 27:
                    secondCorner = piece;
                    break;
                default:
                    break;
            }
        }
        // F R 9: as given on website, adjust as needed.
        String sequence = null;
        String sequence2 = null;
        switch (firstCorner.getCurrentPieceNumber()) {
            // CORNERS: 7 9 25 27, also possibly located in 1 3 19 21
            // algorithms require it to be in 3 or 9
            case 1:
                sequence = "U',";
                break;
            case 3:
                // corner already set for top
                break;
            case 7:
                sequence = "L',U',L,";
                break;
            case 9:
                // corner already set for bottom
                break;
            case 19:
                sequence = "U2,";
                break;
            case 21:
                sequence = "U,";
                break;
            case 25:
                sequence = "L,U2,L',";
                break;
            case 27:
                sequence = "B,U,B',";
                break;
            default:
                break;
        }

        if (sequence != null) {
            dummy.moveSequence(sequence.split(","));
            moves.append(sequence);
        }

        if (firstCorner.getFace("D") == null) {
            sequence2 = cornerTop(dummy);
        } else {
            sequence2 = cornerBottom(dummy);
        }

        if (sequence2 != null) {
            dummy.moveSequence(sequence2.split(","));
            moves.append(sequence2);
        }
        /*
        System.out.println("AFTER FIRST PAIR INSERT");
        System.out.println(sequence);
        System.out.println(sequence2);
        dummy.showCube();
        */

        // R B 27: y translation
            // NO NEED TO CHECK EDGE 6

        sequence = null;
        sequence2 = null;
        switch (secondCorner.getCurrentPieceNumber()) {
            // CORNERS: 7 9 25 27, also possibly located in 1 3 19 21
            // algorithms require it to be in 21 or 27
            case 3:
                sequence = "U',";
                break;
            case 21:
                // corner already set for top
                break;
            case 9:
                sequence = "L',U',L,";
                break;
            case 27:
                // corner already set for bottom
                break;
            case 1:
                sequence = "U2,";
                break;
            case 19:
                sequence = "U,";
                break;
            case 7:
                sequence = "L,U2,L',";
                break;
            case 25:
                sequence = "B,U,B',";
                break;
            default:
                break;
        }

        if (sequence != null) {
            sequence = Translator.sequenceTranslator(sequence.split(","), "y");
            dummy.moveSequence(sequence.split(","));
            moves.append(sequence);
        }

        if (secondCorner.getFace("D") == null) {
            sequence2 = cornerTop2(dummy);
        } else {
            sequence2 = cornerBottom2(dummy);
        }
        
        if (sequence2 != null) {
            sequence2 = Translator.sequenceTranslator(sequence2.split(","), "y");
            dummy.moveSequence(sequence2.split(","));
            moves.append(sequence2);
        }

        /*
        System.out.println("AFTER SECOND PAIR INSERT");
        System.out.println(sequence);
        System.out.println(sequence2);
        dummy.showCube();
        */

        // B L 25: y2 translation
            // NO NEED TO CHECK EDGES 6 AND 24

        sequence = null;
        sequence2 = null;
        switch (thirdCorner.getCurrentPieceNumber()) {
            // CORNERS: 7 9 25 27, also possibly located in 1 3 19 21
            // algorithms require it to be in 21 or 27
            case 21:
                sequence = "U',";
                break;
            case 19:
                // corner already set for top
                break;
            case 27:
                sequence = "L',U',L,";
                break;
            case 25:
                // corner already set for bottom
                break;
            case 3:
                sequence = "U2,";
                break;
            case 1:
                sequence = "U,";
                break;
            case 9:
                sequence = "L,U2,L',";
                break;
            case 7:
                sequence = "B,U,B',";
                break;
            default:
                break;
        }

        if (sequence != null) {
            sequence = Translator.sequenceTranslator(sequence.split(","), "y2");
            dummy.moveSequence(sequence.split(","));
            moves.append(sequence);
        }

        if (thirdCorner.getFace("D") == null) {
            sequence2 = cornerTop3(dummy);
        } else {
            sequence2 = cornerBottom3(dummy);
        }
        
        if (sequence2 != null) {
            sequence2 = Translator.sequenceTranslator(sequence2.split(","), "y2");
            dummy.moveSequence(sequence2.split(","));
            moves.append(sequence2);
        }

        /*
        System.out.println("AFTER THIRD PAIR INSERT");
        System.out.println(sequence);
        System.out.println(sequence2);
        dummy.showCube();
        */

        // L F 7: y' translation
            // NO NEED TO CHECK EDGES 6, 24 AND 22
        sequence = null;
        sequence2 = null;
        switch (fourthCorner.getCurrentPieceNumber()) {
            // CORNERS: 7 9 25 27, also possibly located in 1 3 19 21
            // algorithms require it to be in 21 or 27
            case 19:
                sequence = "U',";
                break;
            case 1:
                // corner already set for top
                break;
            case 25:
                sequence = "L',U',L,";
                break;
            case 7:
                // corner already set for bottom
                break;
            case 21:
                sequence = "U2,";
                break;
            case 3:
                sequence = "U,";
                break;
            case 27:
                sequence = "L,U2,L',";
                break;
            case 9:
                sequence = "B,U,B',";
                break;
            default:
                break;
        }

        if (sequence != null) {
            sequence = Translator.sequenceTranslator(sequence.split(","), "y'");
            dummy.moveSequence(sequence.split(","));
            moves.append(sequence);
        }

        if (fourthCorner.getFace("D") == null) {
            sequence2 = cornerTop4(dummy);
        } else {
            sequence2 = cornerBottom4(dummy);
        }
        
        if (sequence2 != null) {
            sequence2 = Translator.sequenceTranslator(sequence2.split(","), "y'");
            dummy.moveSequence(sequence2.split(","));
            moves.append(sequence2);
        }

        /*
        System.out.println("AFTER FOURTH PAIR INSERT");
        System.out.println(sequence);
        System.out.println(sequence2);
        dummy.showCube();
        */
        return moves.toString().split(",");
    }

    // WARNING STRICTLY FOR FIRST PAIR: F R D
    private static String cornerTop(Cube dummy) {
        /*
            Compares orientation of corner located in position 3 (desired 9) with matching edge piece (desired 6)
        */
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 6:
                    edge = piece;
                    break;
                case 9:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
            // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 2:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "U',F',U,F,"; // 1-4 U' F' U F
                    } else {
                        moves = "U,F',U2,F,U',R,U,R',"; // 2-5 d (R' U2 R) d' (R U R')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "F',U2,F,U,F',U',F,"; // 3-2 (F' U2 F U) (F' U' F)
                    } else {
                        moves = "R,U,R',U2,R,U,R',U',R,U,R',"; // 3-7 (R U R' U') U' (R U R' U') (R U R')
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "U,F',U,F,U',F',U',F,"; // 2-2 (U F' U) (F U' F') U' F
                    } else {
                        moves = "F',U,F,U2,R,U,R',"; // 2-8 (F' U F U') d' (F U F')
                    }
                }
                break;
            case 4:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "L',U',L,R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L',U',L,U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "L',U',L,U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L',U',L,F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "L',U',L,R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L',U',L,U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            case 6:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "U,F',U,F,U,F',U2,F,"; // 4-1 (U F' U F) (U F' U2 F)
                    } else {
                        moves = "U,F',U',F,U',R,U,R',"; // 4-3 (U F' U' F) (d' F U F')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "R,U,R',U',R,U,R',U',R,U,R',"; // 4-6 (R U R' U') (R U R' U') (R U R')
                    } else {
                        moves = "R,U',R',U,F',U,F,"; // 4-5 (R U' R') (d R' U R)
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "U',R,U',R',U',R,U2,R',"; // 4-2 (U' R U' R') (U' R U2 R')
                    } else {
                        moves = "U',R,U,R',U,F',U',F,"; // 4-4 (U' R U R') (d R' U' R)
                    }
                }
                break;
            case 10:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "U,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U2,R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "U',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            case 12:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U',R,U',R',U,R,U,R',"; // 2-1 (U' R U') (R' U R) U R'
                    } else {
                        moves = "R,U',R',U2,F',U',F,"; // 2-7 (R U' R' U) d (R' U' R)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "R,U2,R',U',R,U,R',"; // 3-1 (R U2 R' U') (R U R')
                    } else {
                        moves = "F',U',F,U2,F',U',F,U,F',U',F,"; // 3-8 y' (R' U' R U) U (R' U' R U) (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U,R,U',R',"; // 1-3 U R U' R'
                    } else {
                        moves = "U',R,U2,R',U,F',U',F,"; // 2-6 U' (R U2 R') d (R' U' R)
                    }
                }
                break;
            case 20:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "U,F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U,R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "U2,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U',R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "U,F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            case 22:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("B").getDesiredSide().equals("F")) {
                        moves = "L,U',L',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L,U',L',U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("B").getDesiredSide().equals("F")) {
                        moves = "L,U',L',U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L,U',L',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("F")) {
                        moves = "L,U',L',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L,U',L',U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            case 24:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("R").getDesiredSide().equals("F")) {
                        moves = "B,U,B',U',R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "B,U,B',F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("R").getDesiredSide().equals("F")) {
                        moves = "B,U,B',R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "B,U,B',U,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("F")) {
                        moves = "B,U,B',U2,R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "B,U,B',F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            default:
                break;
        }
        return moves;
    }

    private static String cornerBottom(Cube dummy) {
        /*
            Compares orientation of corner located in position 9 (desired 9) with matching edge piece (desired 6)
        */
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 6:
                    edge = piece;
                    break;
                case 9:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
        // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 2:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 4:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "L',U',L,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L',U',L,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "L',U',L,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L',U',L,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "L',U',L,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L',U',L,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 6:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        return null; // ALREADY IN PLACE SILLY
                    } else {
                        moves = "R,U',R',U,F',U2,F,U,F',U2,F,"; // 6-5 (R U' R' d R' U2 R) (U R' U2 R)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "R,U',R',U,R,U2,R',U,R,U',R',"; // 6-1 (R U' R' U) R U2 R' (U R U' R')
                    } else {
                        moves = "R,U,R',U',R,U',R',U2,F',U',F,"; // 6-3 (R U R' U') (R U' R') U d (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("F")) {
                        moves = "R,U',R',U',R,U,R',U',R,U2,R',"; // 6-2 (R U' R' U') (R U R' U') (R U2 R') 
                    } else {
                        moves = "R,U',R',U,F',U',F,U',F',U',F,"; // 6-4 (R U' R') d (R' U' R U') (R' U' R)
                    }
                }
                break;
            case 10:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "U',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U2,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "U',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U2,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 12:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "U',F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    } else {
                        moves = "U2,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    } else {
                        moves = "U,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("F")) {
                        moves = "R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    } else {
                        moves = "U,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F)
                    }
                }
                break;
            case 20:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("B").getDesiredSide().equals("F")) {
                        moves = "U',R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("B").getDesiredSide().equals("F")) {
                        moves = "U2,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("F")) {
                        moves = "U2,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 22:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "L,U',L',U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L,U',L',U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "L,U',L',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L,U',L',U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("F")) {
                        moves = "L,U',L',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L,U',L',U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 24:
                if (corner.getFace("F").getDesiredSide().equals("F")) {
                    if (edge.getFace("R").getDesiredSide().equals("F")) {
                        moves = "R',U,R,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "R',U,R,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("F").getDesiredSide().equals("R")) {
                    if (edge.getFace("R").getDesiredSide().equals("F")) {
                        moves = "R',U,R,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "R',U,R,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("F")) {
                        moves = "R',U,R,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "R',U,R,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            default:
                break;
        }
        return moves;
    }

    // WARNING STRICTLY FOR SECOND PAIR: R B D
    private static String cornerTop2(Cube dummy) {
        /*
            Compares orientation of corner located in position 21 (desired 27) with matching edge piece (desired 24)
        */
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 24:
                    edge = piece;
                    break;
                case 27:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
            // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 12:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "U',F',U,F,"; // 1-4 U' F' U F
                    } else {
                        moves = "U,F',U2,F,U',R,U,R',"; // 2-5 d (R' U2 R) d' (R U R')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "F',U2,F,U,F',U',F,"; // 3-2 (F' U2 F U) (F' U' F)
                    } else {
                        moves = "R,U,R',U2,R,U,R',U',R,U,R',"; // 3-7 (R U R' U') U' (R U R' U') (R U R')
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "U,F',U,F,U',F',U',F,"; // 2-2 (U F' U) (F U' F') U' F
                    } else {
                        moves = "F',U,F,U2,R,U,R',"; // 2-8 (F' U F U') d' (F U F')
                    }
                }
                break;
            /* NO NEED TO CHECK SINCE IT HAS BEEN SOLVED
            case 6:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "L',U',L,R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L',U',L,U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "L',U',L,U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L',U',L,F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "L',U',L,R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L',U',L,U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            */
            case 24:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "U,F',U,F,U,F',U2,F,"; // 4-1 (U F' U F) (U F' U2 F)
                    } else {
                        moves = "U,F',U',F,U',R,U,R',"; // 4-3 (U F' U' F) (d' F U F')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "R,U,R',U',R,U,R',U',R,U,R',"; // 4-6 (R U R' U') (R U R' U') (R U R')
                    } else {
                        moves = "R,U',R',U,F',U,F,"; // 4-5 (R U' R') (d R' U R)
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "U',R,U',R',U',R,U2,R',"; // 4-2 (U' R U' R') (U' R U2 R')
                    } else {
                        moves = "U',R,U,R',U,F',U',F,"; // 4-4 (U' R U R') (d R' U' R)
                    }
                }
                break;
            case 2:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "U,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U2,R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "U',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            case 20:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U',R,U',R',U,R,U,R',"; // 2-1 (U' R U') (R' U R) U R'
                    } else {
                        moves = "R,U',R',U2,F',U',F,"; // 2-7 (R U' R' U) d (R' U' R)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "R,U2,R',U',R,U,R',"; // 3-1 (R U2 R' U') (R U R')
                    } else {
                        moves = "F',U',F,U2,F',U',F,U,F',U',F,"; // 3-8 y' (R' U' R U) U (R' U' R U) (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U,R,U',R',"; // 1-3 U R U' R'
                    } else {
                        moves = "U',R,U2,R',U,F',U',F,"; // 2-6 U' (R U2 R') d (R' U' R)
                    }
                }
                break;
            case 10:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "U,F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U,R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "U2,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U',R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "U,F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            case 4:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("L").getDesiredSide().equals("R")) {
                        moves = "L,U',L',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L,U',L',U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("L").getDesiredSide().equals("R")) {
                        moves = "L,U',L',U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L,U',L',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("R")) {
                        moves = "L,U',L',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L,U',L',U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            case 22:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("B").getDesiredSide().equals("R")) {
                        moves = "B,U,B',U',R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "B,U,B',F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("B").getDesiredSide().equals("R")) {
                        moves = "B,U,B',R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "B,U,B',U,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("R")) {
                        moves = "B,U,B',U2,R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "B,U,B',F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            default:
                break;
        }
        return moves;
    }

    private static String cornerBottom2(Cube dummy) {
        /*
            Compares orientation of corner located in position 27 (desired 27) with matching edge piece (desired 24)
        */
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 24:
                    edge = piece;
                    break;
                case 27:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
        // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 12:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            /*
            case 6:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "L',U',L,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L',U',L,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "L',U',L,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L',U',L,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "L',U',L,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L',U',L,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            */
            case 24:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        return null; // ALREADY IN PLACE SILLY
                    } else {
                        moves = "R,U',R',U,F',U2,F,U,F',U2,F,"; // 6-5 (R U' R' d R' U2 R) (U R' U2 R)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "R,U',R',U,R,U2,R',U,R,U',R',"; // 6-1 (R U' R' U) R U2 R' (U R U' R')
                    } else {
                        moves = "R,U,R',U',R,U',R',U2,F',U',F,"; // 6-3 (R U R' U') (R U' R') U d (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("R")) {
                        moves = "R,U',R',U',R,U,R',U',R,U2,R',"; // 6-2 (R U' R' U') (R U R' U') (R U2 R') 
                    } else {
                        moves = "R,U',R',U,F',U',F,U',F',U',F,"; // 6-4 (R U' R') d (R' U' R U') (R' U' R)
                    }
                }
                break;
            case 2:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "U',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U2,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "U',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U2,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 20:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "U',F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    } else {
                        moves = "U2,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    } else {
                        moves = "U,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("R")) {
                        moves = "R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    } else {
                        moves = "U,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F)
                    }
                }
                break;
            case 10:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("L").getDesiredSide().equals("R")) {
                        moves = "U',R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("L").getDesiredSide().equals("R")) {
                        moves = "U2,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("R")) {
                        moves = "U2,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 4:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "L,U',L',U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L,U',L',U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "L,U',L',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L,U',L',U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("R")) {
                        moves = "L,U',L',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L,U',L',U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 22:
                if (corner.getFace("R").getDesiredSide().equals("R")) {
                    if (edge.getFace("B").getDesiredSide().equals("R")) {
                        moves = "R',U,R,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "R',U,R,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("R").getDesiredSide().equals("B")) {
                    if (edge.getFace("B").getDesiredSide().equals("R")) {
                        moves = "R',U,R,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "R',U,R,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("R")) {
                        moves = "R',U,R,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "R',U,R,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            default:
                break;
        }
        return moves;
    }

    // WARNING STRICTLY FOR THIRD PAIR: B L D
    private static String cornerTop3(Cube dummy) {
        /*
            Compares orientation of corner located in position 3 (desired 9) with matching edge piece (desired 6)
        */
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 22:
                    edge = piece;
                    break;
                case 25:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
            // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 20:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "U',F',U,F,"; // 1-4 U' F' U F
                    } else {
                        moves = "U,F',U2,F,U',R,U,R',"; // 2-5 d (R' U2 R) d' (R U R')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "F',U2,F,U,F',U',F,"; // 3-2 (F' U2 F U) (F' U' F)
                    } else {
                        moves = "R,U,R',U2,R,U,R',U',R,U,R',"; // 3-7 (R U R' U') U' (R U R' U') (R U R')
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "U,F',U,F,U',F',U',F,"; // 2-2 (U F' U) (F U' F') U' F
                    } else {
                        moves = "F',U,F,U2,R,U,R',"; // 2-8 (F' U F U') d' (F U F')
                    }
                }
                break;
            /*
            case 24:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "L',U',L,R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L',U',L,U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "L',U',L,U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L',U',L,F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "L',U',L,R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L',U',L,U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            */
            case 22:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "U,F',U,F,U,F',U2,F,"; // 4-1 (U F' U F) (U F' U2 F)
                    } else {
                        moves = "U,F',U',F,U',R,U,R',"; // 4-3 (U F' U' F) (d' F U F')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "R,U,R',U',R,U,R',U',R,U,R',"; // 4-6 (R U R' U') (R U R' U') (R U R')
                    } else {
                        moves = "R,U',R',U,F',U,F,"; // 4-5 (R U' R') (d R' U R)
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "U',R,U',R',U',R,U2,R',"; // 4-2 (U' R U' R') (U' R U2 R')
                    } else {
                        moves = "U',R,U,R',U,F',U',F,"; // 4-4 (U' R U R') (d R' U' R)
                    }
                }
                break;
            case 12:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "U,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U2,R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "U',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            case 10:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U',R,U',R',U,R,U,R',"; // 2-1 (U' R U') (R' U R) U R'
                    } else {
                        moves = "R,U',R',U2,F',U',F,"; // 2-7 (R U' R' U) d (R' U' R)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "R,U2,R',U',R,U,R',"; // 3-1 (R U2 R' U') (R U R')
                    } else {
                        moves = "F',U',F,U2,F',U',F,U,F',U',F,"; // 3-8 y' (R' U' R U) U (R' U' R U) (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U,R,U',R',"; // 1-3 U R U' R'
                    } else {
                        moves = "U',R,U2,R',U,F',U',F,"; // 2-6 U' (R U2 R') d (R' U' R)
                    }
                }
                break;
            case 2:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "U,F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U,R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "U2,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U',R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "U,F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            /*
            case 6:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("F").getDesiredSide().equals("B")) {
                        moves = "L,U',L',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L,U',L',U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("F").getDesiredSide().equals("B")) {
                        moves = "L,U',L',U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L,U',L',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("B")) {
                        moves = "L,U',L',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L,U',L',U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            */
            case 4:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("L").getDesiredSide().equals("B")) {
                        moves = "B,U,B',U',R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "B,U,B',F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("L").getDesiredSide().equals("B")) {
                        moves = "B,U,B',R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "B,U,B',U,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("B")) {
                        moves = "B,U,B',U2,R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "B,U,B',F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            default:
                break;
        }
        return moves;
    }

    private static String cornerBottom3(Cube dummy) {
        /*
            Compares orientation of corner located in position 9 (desired 9) with matching edge piece (desired 6)
        */
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 22:
                    edge = piece;
                    break;
                case 25:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
        // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 20:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            /*
            case 24:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "L',U',L,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L',U',L,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "L',U',L,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L',U',L,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "L',U',L,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L',U',L,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            */
            case 22:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        return null; // ALREADY IN PLACE SILLY
                    } else {
                        moves = "R,U',R',U,F',U2,F,U,F',U2,F,"; // 6-5 (R U' R' d R' U2 R) (U R' U2 R)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "R,U',R',U,R,U2,R',U,R,U',R',"; // 6-1 (R U' R' U) R U2 R' (U R U' R')
                    } else {
                        moves = "R,U,R',U',R,U',R',U2,F',U',F,"; // 6-3 (R U R' U') (R U' R') U d (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("B")) {
                        moves = "R,U',R',U',R,U,R',U',R,U2,R',"; // 6-2 (R U' R' U') (R U R' U') (R U2 R') 
                    } else {
                        moves = "R,U',R',U,F',U',F,U',F',U',F,"; // 6-4 (R U' R') d (R' U' R U') (R' U' R)
                    }
                }
                break;
            case 12:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "U',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U2,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "U',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U2,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 10:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "U',F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    } else {
                        moves = "U2,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    } else {
                        moves = "U,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("B")) {
                        moves = "R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    } else {
                        moves = "U,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F)
                    }
                }
                break;
            case 2:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("F").getDesiredSide().equals("B")) {
                        moves = "U',R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("F").getDesiredSide().equals("B")) {
                        moves = "U2,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("B")) {
                        moves = "U2,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            /*
            case 6:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "L,U',L',U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L,U',L',U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "L,U',L',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L,U',L',U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("B")) {
                        moves = "L,U',L',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L,U',L',U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            */
            case 4:
                if (corner.getFace("B").getDesiredSide().equals("B")) {
                    if (edge.getFace("L").getDesiredSide().equals("B")) {
                        moves = "R',U,R,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "R',U,R,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("B").getDesiredSide().equals("L")) {
                    if (edge.getFace("L").getDesiredSide().equals("B")) {
                        moves = "R',U,R,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "R',U,R,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("B")) {
                        moves = "R',U,R,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "R',U,R,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            default:
                break;
        }
        return moves;
    }

    // WARNING STRICTLY FOR FOURTH PAIR: L F D
    private static String cornerTop4(Cube dummy) {
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 4:
                    edge = piece;
                    break;
                case 7:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
            // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 10:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "U',F',U,F,"; // 1-4 U' F' U F
                    } else {
                        moves = "U,F',U2,F,U',R,U,R',"; // 2-5 d (R' U2 R) d' (R U R')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "F',U2,F,U,F',U',F,"; // 3-2 (F' U2 F U) (F' U' F)
                    } else {
                        moves = "R,U,R',U2,R,U,R',U',R,U,R',"; // 3-7 (R U R' U') U' (R U R' U') (R U R')
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "U,F',U,F,U',F',U',F,"; // 2-2 (U F' U) (F U' F') U' F
                    } else {
                        moves = "F',U,F,U2,R,U,R',"; // 2-8 (F' U F U') d' (F U F')
                    }
                }
                break;
            /*
            case 22:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "L',U',L,R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L',U',L,U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "L',U',L,U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L',U',L,F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "L',U',L,R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L',U',L,U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            */
            case 4:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "U,F',U,F,U,F',U2,F,"; // 4-1 (U F' U F) (U F' U2 F)
                    } else {
                        moves = "U,F',U',F,U',R,U,R',"; // 4-3 (U F' U' F) (d' F U F')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "R,U,R',U',R,U,R',U',R,U,R',"; // 4-6 (R U R' U') (R U R' U') (R U R')
                    } else {
                        moves = "R,U',R',U,F',U,F,"; // 4-5 (R U' R') (d R' U R)
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "U',R,U',R',U',R,U2,R',"; // 4-2 (U' R U' R') (U' R U2 R')
                    } else {
                        moves = "U',R,U,R',U,F',U',F,"; // 4-4 (U' R U R') (d R' U' R)
                    }
                }
                break;
            case 20:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "U,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U2,R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "U',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            case 2:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U',R,U',R',U,R,U,R',"; // 2-1 (U' R U') (R' U R) U R'
                    } else {
                        moves = "R,U',R',U2,F',U',F,"; // 2-7 (R U' R' U) d (R' U' R)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "R,U2,R',U',R,U,R',"; // 3-1 (R U2 R' U') (R U R')
                    } else {
                        moves = "F',U',F,U2,F',U',F,U,F',U',F,"; // 3-8 y' (R' U' R U) U (R' U' R U) (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U,R,U',R',"; // 1-3 U R U' R'
                    } else {
                        moves = "U',R,U2,R',U,F',U',F,"; // 2-6 U' (R U2 R') d (R' U' R)
                    }
                }
                break;
            case 12:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "U,F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U,R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "U2,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U',R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "U,F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            /*
            case 24:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("R").getDesiredSide().equals("L")) {
                        moves = "L,U',L',R,U,R',U,R,U,R',"; // 2-3 (U' R U) (R' U R) U R'
                    } else {
                        moves = "L,U',L',U2,F',U',F,U,F',U2,F,"; // 2-11 (U F' U' F) (U F' U2 F)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("R").getDesiredSide().equals("L")) {
                        moves = "L,U',L',U',R,U,R',U,R,U',R',"; // 3-5 U2 (R U R' U) (R U' R')
                    } else {
                        moves = "L,U',L',F',U2,F,U',F',U,F,"; // 3-4 (U' F' U2 F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("L")) {
                        moves = "L,U',L',R,U2,R',U',R,U2,R',"; // 2-10 (U' R U2 R') (U' R U2 R')
                    } else {
                        moves = "L,U',L',U,F',U',F,"; // 1-2 F' U' F
                    }
                }
                break;
            */
            /*
            case 6:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("F").getDesiredSide().equals("L")) {
                        moves = "B,U,B',U',R,U,R',"; // 1-1 R U R'
                    } else {
                        moves = "B,U,B',F',U2,F,U,F',U2,F,"; // 2-9 (U F' U2 F) (U F' U2 F)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("F").getDesiredSide().equals("L")) {
                        moves = "B,U,B',R,U2,R',U,R,U',R',"; // 3-3 (U R U2 R') (U R U' R')
                    } else {
                        moves = "B,U,B',U,F',U',F,U',F',U,F,"; // 3-6 U2 (F' U' F U') (F' U F)
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("L")) {
                        moves = "B,U,B',U2,R,U,R',U',R,U2,R',"; // 2-12 (U' R U R') (U' R U2 R')
                    } else {
                        moves = "B,U,B',F',U',F,U',F',U',F,"; // 2-4 (U F' U') (F U' F') U' F
                    }
                }
                break;
            */
            default:
                break;
        }
        return moves;
    }

    private static String cornerBottom4(Cube dummy) {
        Piece corner = null;
        Piece edge = null;
        for (Piece piece : dummy.getAllPieces()) {
            switch (piece.getDesiredPieceNumber()) {
                case 4:
                    edge = piece;
                    break;
                case 7:
                    corner = piece;
                    break;
                default:
                    break;
            }
        }
        String moves = null;
        int edgeLocation = edge.getCurrentPieceNumber();

        switch (edgeLocation) {
        // EDGES: 4 6 22 24, also possibly located in 2 10 12 20
            case 10:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            /*
            case 22:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "L',U',L,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L',U',L,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "L',U',L,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L',U',L,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "L',U',L,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L',U',L,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            */
            case 4:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        return null; // ALREADY IN PLACE SILLY
                    } else {
                        moves = "R,U',R',U,F',U2,F,U,F',U2,F,"; // 6-5 (R U' R' d R' U2 R) (U R' U2 R)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "R,U',R',U,R,U2,R',U,R,U',R',"; // 6-1 (R U' R' U) R U2 R' (U R U' R')
                    } else {
                        moves = "R,U,R',U',R,U',R',U2,F',U',F,"; // 6-3 (R U R' U') (R U' R') U d (R' U' R)
                    }
                } else { // D
                    if (edge.getFace("L").getDesiredSide().equals("L")) {
                        moves = "R,U',R',U',R,U,R',U',R,U2,R',"; // 6-2 (R U' R' U') (R U R' U') (R U2 R') 
                    } else {
                        moves = "R,U',R',U,F',U',F,U',F',U',F,"; // 6-4 (R U' R') d (R' U' R U') (R' U' R)
                    }
                }
                break;
            case 20:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "U,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "U',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U2,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "U',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U2,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            case 2:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "U',F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    } else {
                        moves = "U2,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    } else {
                        moves = "U,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    }
                } else { // D
                    if (edge.getFace("U").getDesiredSide().equals("L")) {
                        moves = "R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    } else {
                        moves = "U,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F)
                    }
                }
                break;
            case 12:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("R").getDesiredSide().equals("L")) {
                        moves = "U',R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("R").getDesiredSide().equals("L")) {
                        moves = "U2,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "U,R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("R").getDesiredSide().equals("L")) {
                        moves = "U2,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "U,R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            /*
            case 24:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "L,U',L',U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "L,U',L',U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "L,U',L',F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "L,U',L',U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("B").getDesiredSide().equals("L")) {
                        moves = "L,U',L',F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "L,U',L',U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            */
            /*
            case 6:
                if (corner.getFace("L").getDesiredSide().equals("L")) {
                    if (edge.getFace("F").getDesiredSide().equals("L")) {
                        moves = "R',U,R,U,R,U',R',U',F',U,F,"; // 5-1 (U R U' R') (U' F' U F)
                    } else {
                        moves = "R',U,R,U2,F',U,F,U,R,U',R',"; // 5-2 (U' F' U F) (U R U' R')
                    }
                } else if (corner.getFace("L").getDesiredSide().equals("F")) {
                    if (edge.getFace("F").getDesiredSide().equals("L")) {
                        moves = "R',U,R,F',U,F,U',F',U,F,"; // 5-3 (F' U F) (U' F' U F)
                    } else {
                        moves = "R',U,R,U',R,U,R',U',R,U,R',"; // 5-5 (R U R') (U' R U R')
                    }
                } else { // D
                    if (edge.getFace("F").getDesiredSide().equals("L")) {
                        moves = "R',U,R,F',U',F,U,F',U',F,"; // 5-6 (F' U' F) (U F' U' F) 
                    } else {
                        moves = "R',U,R,U',R,U',R',U,R,U',R',"; // 5-4 (R U' R') (U R U' R')
                    }
                }
                break;
            */
            default:
                break;
        }
        return moves;
    }
}
