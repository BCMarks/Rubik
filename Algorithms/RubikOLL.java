package Algorithms;

import java.util.ArrayList;

import Models.Cube;
import Models.Piece;

public class RubikOLL {
    private static Piece piece19 = null;
    private static Piece piece20 = null;
    private static Piece piece21 = null;
    private static Piece piece10 = null;
    private static Piece piece12 = null;
    private static Piece piece1 = null;
    private static Piece piece2 = null;
    private static Piece piece3 = null;

    public static String[] orientateLastLayer(Cube dummy) {
        ArrayList<Piece> pieces = dummy.getAllPieces();
        /*
            19 20 21
            10 11 12
             1  2  3
        */
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

        int cornerOrientation = 0;
        // each digit represents orientation 1: U=U, 2: L/R=U, 3: F/B=U
        if (piece19.getFace("U").getDesiredSide().equals("U")) {
            cornerOrientation += 1000;
        } else if (piece19.getFace("L").getDesiredSide().equals("U")) {
            cornerOrientation += 2000;
        } else {
            cornerOrientation += 3000;
        }

        if (piece21.getFace("U").getDesiredSide().equals("U")) {
            cornerOrientation += 100;
        } else if (piece21.getFace("R").getDesiredSide().equals("U")) {
            cornerOrientation += 200;
        } else {
            cornerOrientation += 300;
        }

        if (piece1.getFace("U").getDesiredSide().equals("U")) {
            cornerOrientation += 10;
        } else if (piece1.getFace("L").getDesiredSide().equals("U")) {
            cornerOrientation += 20;
        } else {
            cornerOrientation += 30;
        }

        if (piece3.getFace("U").getDesiredSide().equals("U")) {
            cornerOrientation += 1;
        } else if (piece3.getFace("R").getDesiredSide().equals("U")) {
            cornerOrientation += 2;
        } else {
            cornerOrientation += 3;
        }

        String moves = edgeCheck(cornerOrientation);
        if (moves == null) {
            return "".split(",");
        } else {
            dummy.moveSequence(moves.split(","));
            return moves.split(",");
        }
    }

    private static String edgeCheck(int cornerOrientation) {
        //System.out.println("corners: "+String.valueOf(cornerOrientation));
        if (piece20.getFace("U").getDesiredSide().equals("U") && piece10.getFace("U").getDesiredSide().equals("U") &&
            piece12.getFace("U").getDesiredSide().equals("U") && piece2.getFace("U").getDesiredSide().equals("U")) {
            // A
            switch (cornerOrientation) {
                case 1111:
                    return null; // ALREADY ORIENTATED
                case 2222:
                    return "R,U,R',U,R,U',R',U,R,U2,R',"; // 21 (R U R') U (R U' R') U (R U2 R')
                case 3333:
                    return Translator.sequenceTranslator("R,U,R',U,R,U',R',U,R,U2,R',".split(","), "y'"); // 21-y' (R U R') U (R U' R') U (R U2 R')
                case 2323:
                    return "R,U2,R2,U',R2,U',R2,U2,R,"; // 22 R U2 (R2' U' R2 U') (R2' U2 R)
                case 3322:
                    return Translator.sequenceTranslator("R,U2,R2,U',R2,U',R2,U2,R,".split(","), "y'"); // 22-y' R U2 (R2' U' R2 U') (R2' U2 R)
                case 3232:
                    return Translator.sequenceTranslator("R,U2,R2,U',R2,U',R2,U2,R,".split(","), "y2"); // 22-y2 R U2 (R2' U' R2 U') (R2' U2 R)
                case 2233:
                    return Translator.sequenceTranslator("R,U2,R2,U',R2,U',R2,U2,R,".split(","), "y"); // 22-y R U2 (R2' U' R2 U') (R2' U2 R)
                case 3221:
                    return "R',U2,R,U,R',U,R,"; // 27 (R' U2 R) U (R' U R)
                case 3213:
                    return Translator.sequenceTranslator("R',U2,R,U,R',U,R,".split(","), "y'"); // 27-y' (R' U2 R) U (R' U R)
                case 1223:
                    return Translator.sequenceTranslator("R',U2,R,U,R',U,R,".split(","), "y2"); // 27-y2 (R' U2 R) U (R' U R)
                case 3123:
                    return Translator.sequenceTranslator("R',U2,R,U,R',U,R,".split(","), "y"); // 27-y (R' U2 R) U (R' U R)
                case 2132:
                    return "R,U2,R',U',R,U',R',"; // 26 (R U2 R') U' (R U' R')
                case 2331:
                    return Translator.sequenceTranslator("R,U2,R',U',R,U',R',".split(","), "y'"); // 26-y' (R U2 R') U' (R U' R')
                case 2312:
                    return Translator.sequenceTranslator("R,U2,R',U',R,U',R',".split(","), "y2"); // 26-y2 (R U2 R') U' (R U' R')
                case 1332:
                    return Translator.sequenceTranslator("R,U2,R',U',R,U',R',".split(","), "y"); // 26-y (R U2 R') U' (R U' R')
                case 1321:
                    return Translator.sequenceTranslator("F',L,F,R',F',L',F,R,".split(","), "y'"); // 25-y' F' (r U R' U') (r' F R)
                case 3112:
                    return Translator.sequenceTranslator("F',L,F,R',F',L',F,R,".split(","), "y2"); // 25-y2 F' (r U R' U') (r' F R)
                case 1231:
                    return Translator.sequenceTranslator("F',L,F,R',F',L',F,R,".split(","), "y"); // 25-y F' (r U R' U') (r' F R)
                case 2113:
                    return "F',L,F,R',F',L',F,R,"; // 25 F' (r U R' U') (r' F R)
                case 3311:
                    return Translator.sequenceTranslator("R2,D,R',U2,R,D',R',U2,R',".split(","), "y2"); // 23-y2 R2 D (R' U2 R) D' (R' U2 R')
                case 1212:
                    return Translator.sequenceTranslator("R2,D,R',U2,R,D',R',U2,R',".split(","), "y"); // 23-y R2 D (R' U2 R) D' (R' U2 R')
                case 1133:
                    return "R2,D,R',U2,R,D',R',U2,R',"; // 23 R2 D (R' U2 R) D' (R' U2 R')
                case 2121:
                    return Translator.sequenceTranslator("R2,D,R',U2,R,D',R',U2,R',".split(","), "y'"); // 23-y' R2 D (R' U2 R) D' (R' U2 R')
                case 1122:
                    return Translator.sequenceTranslator("L,F,R',F',L',F,R,F',".split(","), "y"); // 24-y (r U R' U') (r' F R F')
                case 3131:
                    return "L,F,R',F',L',F,R,F',"; // 24 (r U R' U') (r' F R F')
                case 2211:
                    return Translator.sequenceTranslator("L,F,R',F',L',F,R,F',".split(","), "y'"); // 24-y' (r U R' U') (r' F R F')
                case 1313:
                    return Translator.sequenceTranslator("L,F,R',F',L',F,R,F',".split(","), "y2"); // 24-y2 (r U R' U') (r' F R F')
                default:
                    return null;
            }
        } else if (piece20.getFace("U").getDesiredSide().equals("U") && piece10.getFace("U").getDesiredSide().equals("U") &&
            !piece12.getFace("U").getDesiredSide().equals("U") && !piece2.getFace("U").getDesiredSide().equals("U")) {
            // D
            switch (cornerOrientation) {
                case 1111:
                    return Translator.sequenceTranslator("L,R',F',L',R,U2,L,R',F',L',R,".split(","), "y'"); // 28-y' M' U' M U2' M' U' M 
                case 2222:
                    return "R',F',L,F',L',F,L,F',L',F2,R,"; // 53 (l' U' L U') (L' U L U') L' U2 l
                case 3333:
                    return Translator.sequenceTranslator("L,F,R',F,R,F',R',F,R,F2,L',".split(","), "y"); // 54-y (r U R' U) (R U' R' U) R U2' r'
                case 2323:
                    return "F,R,U,R',U',R,U,R',U',F',"; // 48 F (R U R' U') (R U R' U') F'
                case 3322:
                    return Translator.sequenceTranslator("F',L',U',L,U,L',U',L,U,F,".split(","), "y"); // 47-y F' (L' U' L U) (L' U' L U) F
                case 3232:
                    return "R',F,R2,B',R2,F',R2,B,R',"; // 50 R' F R2 B' R2' F' R2 B R'
                case 2233:
                    return Translator.sequenceTranslator("R',F,R',F',R2,U2,B',R,B,R',".split(","), "y"); // 49-y (R' F R' F') R2 U2 y (R' F R F')
                case 3221:
                    return Translator.sequenceTranslator("R,U,R',U,R',F,R,F',R,U2,R',".split(","), "y'"); // 10-y' (R U R' U) (R' F R F') R U2 R'
                case 3213:
                    return "L,F,R',F,R,F2,L',"; // 7 (r U R' U) R U2 r'
                case 1223:
                    return Translator.sequenceTranslator("L',B2,R,B,R',B,L,".split(","), "y2"); // 5-y2 r' U2 (R U R' U) r
                case 3123:
                    return Translator.sequenceTranslator("F',L',U',L,U,F,R,B,U,B',U',R',".split(","), "y'"); // 11-y' F' (L' U' L U) F y F (R U R' U') F'
                case 2132:
                    return Translator.sequenceTranslator("L',B',R,B',R',B2,L,".split(","), "y'"); // 8-y' r' U' R U' R' U2 r
                case 2331:
                    return "R,U,R',U',R',F,R2,U,R',U',F',"; // 9 (R U R' U') R' F R2 U R' U' F'
                case 2312:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',U,F,R,U,R',U',F',".split(","), "y2"); // 12-y2 F (R U R' U') F' U F (R U R' U') F'
                case 1332:
                    return Translator.sequenceTranslator("L,F2,R',F',R,F',L',".split(","), "y"); // 6-y r U2 R' U' R U' r'
                case 1321:
                    return Translator.sequenceTranslator("R,U2,R2,F,R,F',R,U2,R',".split(","), "y2"); // 35-y (R U2 R') (R' F R F') (R U2 R')
                case 3112:
                    return "R,U,R',U,R,U',R',U',R',F,R,F',"; // 38 (R U R' U) (R U' R' U') (R' F R F')
                case 1231:
                    return "F,R',F',R,U,R,U',R',"; // 37 F R' F' R U R U' R'
                case 2113:
                    return Translator.sequenceTranslator("L',U',L,U',L',U,L,U,L,F',L',F,".split(","), "y"); // 36-y (L' U' L U') (L' U L U) (L F' L' F)
                case 3311:
                    return "R,U,R',U,R,U2,R',F,R,U,R',U',F',"; // 41 (R U R' U) R U2 R' F (R U R' U') F'
                case 1212:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',".split(","), "y2"); // 44-y2 f (R U R' U') f'
                case 1133:
                    return Translator.sequenceTranslator("B',U',R',U,R,B,".split(","), "y'"); // 43-y' f' (L' U' L U) f
                case 2121:
                    return "R',F,R,F',R',F,R,F',R,U,R',U',R,U,R',"; // 42 (R' F R F') (R' F R F') (R U R' U') (R U R')
                case 1122:
                    return Translator.sequenceTranslator("R',U',F,U,R,U',R',F',R,".split(","), "y"); // 31-y R' U' F U R U' R' F' R
                case 3131:
                    return "R,U,R',U',R,U',R',F',U',F,R,U,R',"; // 29 (R U R' U') R U' R' F' U' (F R U R')
                case 2211:
                    return "L,F',L',F,L',U2,L,U,F,U,F',"; // 30 (L F' L' F) L' U2 L d (R U R')
                case 1313:
                    return "F,U,R,U',F',L,F,R',F',L',"; // 32 F U R U' F' r U R' U' r'
                default:
                    return null;
            }
        } else if (piece20.getFace("U").getDesiredSide().equals("U") && !piece10.getFace("U").getDesiredSide().equals("U") &&
            piece12.getFace("U").getDesiredSide().equals("U") && !piece2.getFace("U").getDesiredSide().equals("U")) {
            // F
            switch (cornerOrientation) {
                case 1111:
                    return Translator.sequenceTranslator("L,R',F',L',R,U2,L,R',F',L',R,".split(","), "y2"); // 28-y2 M' U' M U2' M' U' M
                case 2222:
                    return "L,F,R',F,R,F',R',F,R,F2,L',"; // 54 (r U R' U) (R U' R' U) R U2' r'
                case 3333:
                    return Translator.sequenceTranslator("R',F',L,F',L',F,L,F',L',F2,R,".split(","), "y'"); // 53-y' (l' U' L U') (L' U L U') L' U2 l
                case 2323:
                    return "R',F,R',F',R2,U2,B',R,B,R',"; // 49 (R' F R' F') R2 U2 y (R' F R F')
                case 3322:
                    return Translator.sequenceTranslator("F,R,U,R',U',R,U,R',U',F',".split(","), "y'"); // 48-y' F (R U R' U') (R U R' U') F'
                case 3232:
                    return "F',L',U',L,U,L',U',L,U,F,"; // 47 F' (L' U' L U) (L' U' L U) F
                case 2233:
                    return Translator.sequenceTranslator("R',F,R2,B',R2,F',R2,B,R',".split(","), "y'"); // 50-y' R' F R2 B' R2' F' R2 B R'
                case 3221:
                    return Translator.sequenceTranslator("F',L',U',L,U,F,R,B,U,B',U',R',".split(","), "y2"); // 11-y2 F' (L' U' L U) F y F (R U R' U') F'
                case 3213:
                    return Translator.sequenceTranslator("R,U,R',U,R',F,R,F',R,U2,R',".split(","), "y2"); // 10-y2 (R U R' U) (R' F R F') R U2 R'
                case 1223:
                    return Translator.sequenceTranslator("L,F,R',F,R,F2,L',".split(","), "y'"); // 7-y' (r U R' U) R U2 r'
                case 3123:
                    return Translator.sequenceTranslator("L',B2,R,B,R',B,L,".split(","), "y"); // 5-y r' U2 (R U R' U) r
                case 2132:
                    return "L,F2,R',F',R,F',L',"; // 6 r U2 R' U' R U' r'
                case 2331:
                    return Translator.sequenceTranslator("L',B',R,B',R',B2,L,".split(","), "y2"); // 8-y2 r' U' R U' R' U2 r
                case 2312:
                    return Translator.sequenceTranslator("R,U,R',U',R',F,R2,U,R',U',F',".split(","), "y'"); // 9-y' (R U R' U') R' F R2 U R' U' F'
                case 1332:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',U,F,R,U,R',U',F',".split(","), "y"); // 12-y F (R U R' U') F' U F (R U R' U') F'
                case 1321:
                    return "L',U',L,U',L',U,L,U,L,F',L',F,"; // 36 (L' U' L U') (L' U L U) (L F' L' F)
                case 3112:
                    return Translator.sequenceTranslator("R,U2,R2,F,R,F',R,U2,R',".split(","), "y"); // 35-y (R U2 R') (R' F R F') (R U2 R')
                case 1231:
                    return Translator.sequenceTranslator("R,U,R',U,R,U',R',U',R',F,R,F',".split(","), "y'"); // 38-y' (R U R' U) (R U' R' U') (R' F R F')
                case 2113:
                    return Translator.sequenceTranslator("F,R',F',R,U,R,U',R',".split(","), "y'"); // 37-y' F R' F' R U R U' R'
                case 3311:
                    return Translator.sequenceTranslator("R',F,R,F',R',F,R,F',R,U,R',U',R,U,R',".split(","), "y'"); // 42-y' (R' F R F') (R' F R F') (R U R' U') (R U R')
                case 1212:
                    return Translator.sequenceTranslator("R,U,R',U,R,U2,R',F,R,U,R',U',F',".split(","), "y'"); // 41-y' (R U R' U) R U2 R' F (R U R' U') F'
                case 1133:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',".split(","), "y"); // 44-y f (R U R' U') f'
                case 2121:
                    return Translator.sequenceTranslator("B',U',R',U,R,B,".split(","), "y2"); // 43-y2 f' (L' U' L U) f
                case 1122:
                    return Translator.sequenceTranslator("F,U,R,U',F',L,F,R',F',L',".split(","), "y'"); // 32-y' F U R U' F' r U R' U' r'
                case 3131:
                    return "R',U',F,U,R,U',R',F',R,"; // 31 R' U' F U R U' R' F' R
                case 2211:
                    return Translator.sequenceTranslator("R,U,R',U',R,U',R',F',U',F,R,U,R',".split(","), "y'"); // 29-y' (R U R' U') R U' R' F' U' (F R U R')
                case 1313:
                    return Translator.sequenceTranslator("L,F',L',F,L',U2,L,U,F,U,F',".split(","), "y'"); // 30-y' (L F' L' F) L' U2 L d (R U R')
                default:
                    return null;
            }
        } else if (piece20.getFace("U").getDesiredSide().equals("U") && !piece10.getFace("U").getDesiredSide().equals("U") &&
            !piece12.getFace("U").getDesiredSide().equals("U") && piece2.getFace("U").getDesiredSide().equals("U")) {
            // G
            switch (cornerOrientation) {
                case 1111:
                    return Translator.sequenceTranslator("R,U,R',U',L,R',F,R,F',L',".split(","), "y'"); // 57-y' (R U R' U') M' (U R U' r')
                case 2222:
                    return "R,U2,R2,U',R,U',R',U2,F,R,F',"; // 55 R U2 R2 (U' R U' R') U2 (F R F')
                case 3333:
                    return Translator.sequenceTranslator("F,R,U,R',U',R,F',L,F,R',F',L',".split(","), "y'"); // 56-y' F (R U R' U') R F' (r U R' U') r'
                case 2323:
                    return Translator.sequenceTranslator("R,U,R',U,R,U',B,U',B',R',".split(","), "y2"); // 52-y2 (R U R' U) R d' R U' R' F'
                case 3322:
                    return Translator.sequenceTranslator("B,U,L,U',L',U,L,U',L',B',".split(","), "y'"); // 51-y' f (R U R' U') (R U R' U') f'
                case 3232:
                    return "R,U,R',U,R,U',B,U',B',R',"; // 52 (R U R' U) R d' R U' R' F'
                case 2233:
                    return Translator.sequenceTranslator("B,U,L,U',L',U,L,U',L',B',".split(","), "y"); // 51-y f (R U R' U') (R U R' U') f'
                case 3221:
                    return Translator.sequenceTranslator("F,U,R,U',R2,F',R,U,R,U',R',".split(","), "y"); // 13-y F (U R U' R2) F' (R U R U' R')
                case 3213:
                    return Translator.sequenceTranslator("R',F',R,L',U',L,U,R',F,R,".split(","), "y"); // 15-y l' U' l (L' U' L U) l' U l
                case 1223:
                    return Translator.sequenceTranslator("F,U,R,U',R2,F',R,U,R,U',R',".split(","), "y'"); // 13-y' F (U R U' R2) F' (R U R U' R')
                case 3123:
                    return Translator.sequenceTranslator("R',F',R,L',U',L,U,R',F,R,".split(","), "y'"); // 15-y' l' U' l (L' U' L U) l' U l
                case 2132:
                    return Translator.sequenceTranslator("R',F,R,U,R',F',R,F,U',F',".split(","), "y"); // 14-y (R' F R) U (R' F' R) y' (R U' R')
                case 2331:
                    return Translator.sequenceTranslator("L,F,L',R,U,R',U',L,F',L',".split(","), "y'"); // 16-y' r U r' (R U R' U') r U' r'
                case 2312:
                    return Translator.sequenceTranslator("R',F,R,U,R',F',R,F,U',F',".split(","), "y'"); // 14-y' (R' F R) U (R' F' R) y' (R U' R')
                case 1332:
                    return Translator.sequenceTranslator("L,F,L',R,U,R',U',L,F',L',".split(","), "y"); // 16-y r U r' (R U R' U') r U' r'
                case 1321:
                    return Translator.sequenceTranslator("L,F',L',U',L,U,F,U',L',".split(","), "y"); // 39-y L F' (L' U' L U) F U' L'
                case 3112:
                    return Translator.sequenceTranslator("R',F,R,U,R',U',F',U,R,".split(","), "y'"); // 40-y' R' F (R U R' U') F' U R
                case 1231:
                    return Translator.sequenceTranslator("L,F',L',U',L,U,F,U',L',".split(","), "y'"); // 39-y' L F' (L' U' L U) F U' L'
                case 2113:
                    return Translator.sequenceTranslator("R',F,R,U,R',U',F',U,R,".split(","), "y"); // 40-y R' F (R U R' U') F' U R
                case 3311:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',".split(","), "y'"); // 45-y' F (R U R' U') F'
                case 1212:
                    return "R',U',R',F,R,F',U,R,"; // 46 R' U' (R' F R F') U R
                case 1133:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',".split(","), "y"); // 45-y F (R U R' U') F'
                case 2121:
                    return Translator.sequenceTranslator("R',U',R',F,R,F',U,R,".split(","), "y2"); // 46-y2 R' U' (R' F R F') U R
                case 1122:
                    return Translator.sequenceTranslator("R,U,R',U',R',F,R,F',".split(","), "y"); // 33-y (R U R' U') (R' F R F')
                case 3131:
                    return Translator.sequenceTranslator("R,U,R',U',B',R',F,R,F',B,".split(","), "y"); // 34-y (R U R' U') x D' R' U R U' D x'
                case 2211:
                    return Translator.sequenceTranslator("R,U,R',U',R',F,R,F',".split(","), "y'"); // 33-y' (R U R' U') (R' F R F')
                case 1313:
                    return Translator.sequenceTranslator("R,U,R',U',B',R',F,R,F',B,".split(","), "y'"); // 34-y' (R U R' U') x D' R' U R U' D x'
                default:
                    return null;
            }
        } else if (!piece20.getFace("U").getDesiredSide().equals("U") && piece10.getFace("U").getDesiredSide().equals("U") &&
            piece12.getFace("U").getDesiredSide().equals("U") && !piece2.getFace("U").getDesiredSide().equals("U")) {
            // J
            switch (cornerOrientation) {
                case 1111:
                    return "R,U,R',U',L,R',F,R,F',L',"; // 57 (R U R' U') M' (U R U' r')
                case 2222:
                    return "F,R,U,R',U',R,F',L,F,R',F',L',"; // 56 F (R U R' U') R F' (r U R' U') r'
                case 3333:
                    return Translator.sequenceTranslator("R,U2,R2,U',R,U',R',U2,F,R,F',".split(","), "y'"); // 55-y' R U2 R2 (U' R U' R') U2 (F R F')
                case 2323:
                    return "B,U,L,U',L',U,L,U',L',B',"; // 51 f (R U R' U') (R U R' U') f'
                case 3322:
                    return Translator.sequenceTranslator("R,U,R',U,R,U',B,U',B',R',".split(","), "y"); // 52-y (R U R' U) R d' R U' R' F'
                case 3232:
                    return Translator.sequenceTranslator("B,U,L,U',L',U,L,U',L',B',".split(","), "y2"); // 51-y2 f (R U R' U') (R U R' U') f'
                case 2233:
                    return Translator.sequenceTranslator("R,U,R',U,R,U',B,U',B',R',".split(","), "y'"); // 52-y' (R U R' U) R d' R U' R' F'
                case 3221:
                    return Translator.sequenceTranslator("R',F',R,L',U',L,U,R',F,R,".split(","), "y2"); // 15-y2 l' U' l (L' U' L U) l' U l
                case 3213:
                    return "F,U,R,U',R2,F',R,U,R,U',R',"; // 13 F (U R U' R2) F' (R U R U' R')
                case 1223:
                    return "R',F',R,L',U',L,U,R',F,R,"; // 15 l' U' l (L' U' L U) l' U l
                case 3123:
                    return Translator.sequenceTranslator("F,U,R,U',R2,F',R,U,R,U',R',".split(","), "y2"); // 13-y2 F (U R U' R2) F' (R U R U' R')
                case 2132:
                    return "L,F,L',R,U,R',U',L,F',L',"; // 16 r U r' (R U R' U') r U' r'
                case 2331:
                    return "R',F,R,U,R',F',R,F,U',F',"; // 14 (R' F R) U (R' F' R) y' (R U' R')
                case 2312:
                    return Translator.sequenceTranslator("L,F,L',R,U,R',U',L,F',L',".split(","), "y2"); // 16-y2 r U r' (R U R' U') r U' r'
                case 1332:
                    return Translator.sequenceTranslator("R',F,R,U,R',F',R,F,U',F',".split(","), "y2"); // 14-y2 (R' F R) U (R' F' R) y' (R U' R')
                case 1321:
                    return "R',F,R,U,R',U',F',U,R,"; // 40 R' F (R U R' U') F' U R
                case 3112:
                    return "L,F',L',U',L,U,F,U',L',"; // 39 L F' (L' U' L U) F U' L'
                case 1231:
                    return Translator.sequenceTranslator("R',F,R,U,R',U',F',U,R,".split(","), "y2"); // 40-y2 R' F (R U R' U') F' U R
                case 2113:
                    return Translator.sequenceTranslator("L,F',L',U',L,U,F,U',L',".split(","), "y2"); // 39-y2 L F' (L' U' L U) F U' L'
                case 3311:
                    return Translator.sequenceTranslator("R',U',R',F,R,F',U,R,".split(","), "y"); // 46-y R' U' (R' F R F') U R
                case 1212:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',".split(","), "y2"); // 45-y2 F (R U R' U') F'
                case 1133:
                    return Translator.sequenceTranslator("R',U',R',F,R,F',U,R,".split(","), "y'"); // 46-y' R' U' (R' F R F') U R
                case 2121:
                    return "F,R,U,R',U',F',"; // 45 F (R U R' U') F'
                case 1122:
                    return Translator.sequenceTranslator("R,U,R',U',B',R',F,R,F',B,".split(","), "y2"); // 34-y2 (R U R' U') x D' R' U R U' D x'
                case 3131:
                    return "R,U,R',U',R',F,R,F',"; // 33 (R U R' U') (R' F R F')
                case 2211:
                    return "R,U,R',U',B',R',F,R,F',B,"; // 34 (R U R' U') x D' R' U R U' D x'
                case 1313:
                    return Translator.sequenceTranslator("R,U,R',U',R',F,R,F',".split(","), "y2"); // 33-y2 (R U R' U') (R' F R F')
                default:
                    return null;
            }
        } else if (!piece20.getFace("U").getDesiredSide().equals("U") && piece10.getFace("U").getDesiredSide().equals("U") &&
            !piece12.getFace("U").getDesiredSide().equals("U") && piece2.getFace("U").getDesiredSide().equals("U")) {
            // K
            switch (cornerOrientation) {
                case 1111:
                    return "L,R',F',L',R,U2,L,R',F',L',R,"; // 28 M' U' M U2' M' U' M
                case 2222:
                    return Translator.sequenceTranslator("L,F,R',F,R,F',R',F,R,F2,L',".split(","), "y2"); // 54-y2 (r U R' U) (R U' R' U) R U2' r'
                case 3333:
                    return Translator.sequenceTranslator("R',F',L,F',L',F,L,F',L',F2,R,".split(","), "y"); // 53-y (l' U' L U') (L' U L U') L' U2 l
                case 2323:
                    return Translator.sequenceTranslator("F',L',U',L,U,L',U',L,U,F,".split(","), "y2"); // 47-y2 F' (L' U' L U) (L' U' L U) F
                case 3322:
                    return Translator.sequenceTranslator("R',F,R2,B',R2,F',R2,B,R',".split(","), "y"); // 50-y R' F R2 B' R2' F' R2 B R'
                case 3232:
                    return Translator.sequenceTranslator("R',F,R',F',R2,U2,B',R,B,R',".split(","), "y2"); // 49-y2 (R' F R' F') R2 U2 y (R' F R F')
                case 2233:
                    return Translator.sequenceTranslator("F,R,U,R',U',R,U,R',U',F',".split(","), "y"); // 48-y F (R U R' U') (R U R' U') F'
                case 3221:
                    return Translator.sequenceTranslator("L,F,R',F,R,F2,L',".split(","), "y"); // 7-y (r U R' U) R U2 r'
                case 3213:
                    return Translator.sequenceTranslator("L',B2,R,B,R',B,L,".split(","), "y'"); // 5-y' r' U2 (R U R' U) r
                case 1223:
                    return "F',L',U',L,U,F,R,B,U,B',U',R',"; // 11 F' (L' U' L U) F y F (R U R' U') F'
                case 3123:
                    return "R,U,R',U,R',F,R,F',R,U2,R',"; // 10 (R U R' U) (R' F R F') R U2 R'
                case 2132:
                    return Translator.sequenceTranslator("R,U,R',U',R',F,R2,U,R',U',F',".split(","), "y"); // 9-y (R U R' U') R' F R2 U R' U' F'
                case 2331:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',U,F,R,U,R',U',F',".split(","), "y'"); // 12-y' F (R U R' U') F' U F (R U R' U') F'
                case 2312:
                    return Translator.sequenceTranslator("L,F2,R',F',R,F',L',".split(","), "y2"); // 6-y2 r U2 R' U' R U' r'
                case 1332:
                    return "L',B',R,B',R',B2,L,"; // 8 r' U' R U' R' U2 r
                case 1321:
                    return Translator.sequenceTranslator("R,U,R',U,R,U',R',U',R',F,R,F',".split(","), "y"); // 38-y (R U R' U) (R U' R' U') (R' F R F')
                case 3112:
                    return Translator.sequenceTranslator("F,R',F',R,U,R,U',R',".split(","), "y"); // 37-y F R' F' R U R U' R'
                case 1231:
                    return Translator.sequenceTranslator("L',U',L,U',L',U,L,U,L,F',L',F,".split(","), "y2"); // 36-y2 (L' U' L U') (L' U L U) (L F' L' F)
                case 2113:
                    return Translator.sequenceTranslator("R,U2,R2,F,R,F',R,U2,R',".split(","), "y'"); // 35-y' (R U2 R') (R' F R F') (R U2 R')
                case 3311:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',".split(","), "y'"); // 44-y' f (R U R' U') f'
                case 1212:
                    return "B',U',R',U,R,B,"; // 43 f' (L' U' L U) f
                case 1133:
                    return Translator.sequenceTranslator("R',F,R,F',R',F,R,F',R,U,R',U',R,U,R',".split(","), "y"); // 42-y (R' F R F') (R' F R F') (R U R' U') (R U R')
                case 2121:
                    return Translator.sequenceTranslator("R,U,R',U,R,U2,R',F,R,U,R',U',F',".split(","), "y"); // 41-y (R U R' U) R U2 R' F (R U R' U') F'
                case 1122:
                    return Translator.sequenceTranslator("R,U,R',U',R,U',R',F',U',F,R,U,R',".split(","), "y"); // 29-y (R U R' U') R U' R' F' U' (F R U R')
                case 3131:
                    return Translator.sequenceTranslator("L,F',L',F,L',U2,L,U,F,U,F',".split(","), "y"); // 30-y (L F' L' F) L' U2 L d (R U R')
                case 2211:
                    return Translator.sequenceTranslator("F,U,R,U',F',L,F,R',F',L',".split(","), "y"); // 32-y F U R U' F' r U R' U' r'
                case 1313:
                    return Translator.sequenceTranslator("R',U',F,U,R,U',R',F',R,".split(","), "y2"); // 31-y2 R' U' F U R U' R' F' R
                default:
                    return null;
            }
        } else if (!piece20.getFace("U").getDesiredSide().equals("U") && !piece10.getFace("U").getDesiredSide().equals("U") &&
            piece12.getFace("U").getDesiredSide().equals("U") && piece2.getFace("U").getDesiredSide().equals("U")) {
            // M
            switch (cornerOrientation) {
                case 1111:
                    return Translator.sequenceTranslator("L,R',F',L',R,U2,L,R',F',L',R,".split(","), "y"); // 28-y M' U' M U2' M' U' M
                case 2222:
                    return Translator.sequenceTranslator("R',F',L,F',L',F,L,F',L',F2,R,".split(","), "y2"); // 53-y2 (l' U' L U') (L' U L U') L' U2 l
                case 3333:
                    return Translator.sequenceTranslator("L,F,R',F,R,F',R',F,R,F2,L',".split(","), "y'"); // 54-y' (r U R' U) (R U' R' U) R U2' r'
                case 2323:
                    return Translator.sequenceTranslator("R',F,R2,B',R2,F',R2,B,R',".split(","), "y2"); // 50-y2 R' F R2 B' R2' F' R2 B R'
                case 3322:
                    return Translator.sequenceTranslator("R',F,R',F',R2,U2,B',R,B,R',".split(","), "y'"); // 49-y' (R' F R' F') R2 U2 y (R' F R F')
                case 3232:
                    return Translator.sequenceTranslator("F,R,U,R',U',R,U,R',U',F',".split(","), "y2"); // 48-y2 F (R U R' U') (R U R' U') F'
                case 2233:
                    return Translator.sequenceTranslator("F',L',U',L,U,L',U',L,U,F,".split(","), "y'"); // 47-y' F' (L' U' L U) (L' U' L U) F
                case 3221:
                    return "L',B2,R,B,R',B,L,"; // 5 r' U2 (R U R' U) r
                case 3213:
                    return Translator.sequenceTranslator("F',L',U',L,U,F,R,B,U,B',U',R',".split(","), "y"); // 11-y F' (L' U' L U) F y F (R U R' U') F'
                case 1223:
                    return Translator.sequenceTranslator("R,U,R',U,R',F,R,F',R,U2,R',".split(","), "y"); // 10-y (R U R' U) (R' F R F') R U2 R'
                case 3123:
                    return Translator.sequenceTranslator("L,F,R',F,R,F2,L',".split(","), "y2"); // 7-y2 (r U R' U) R U2 r'
                case 2132:
                    return "F,R,U,R',U',F',U,F,R,U,R',U',F',"; // 12 F (R U R' U') F' U F (R U R' U') F'
                case 2331:
                    return Translator.sequenceTranslator("L,F2,R',F',R,F',L',".split(","), "y'"); // 6-y' r U2 R' U' R U' r'
                case 2312:
                    return Translator.sequenceTranslator("L',B',R,B',R',B2,L,".split(","), "y"); // 8-y r' U' R U' R' U2 r
                case 1332:
                    return Translator.sequenceTranslator("R,U,R',U',R',F,R2,U,R',U',F',".split(","), "y2"); // 9-y2 (R U R' U') R' F R2 U R' U' F'
                case 1321:
                    return Translator.sequenceTranslator("F,R',F',R,U,R,U',R',".split(","), "y2"); // 37-y2 F R' F' R U R U' R'
                case 3112:
                    return Translator.sequenceTranslator("L',U',L,U',L',U,L,U,L,F',L',F,".split(","), "y'"); // 36-y' (L' U' L U') (L' U L U) (L F' L' F)
                case 1231:
                    return "R,U2,R2,F,R,F',R,U2,R',"; // 35 (R U2 R') (R' F R F') (R U2 R')
                case 2113:
                    return Translator.sequenceTranslator("R,U,R',U,R,U',R',U',R',F,R,F',".split(","), "y2"); // 38-y2 (R U R' U) (R U' R' U') (R' F R F')
                case 3311:
                    return Translator.sequenceTranslator("B',U',R',U,R,B,".split(","), "y"); // 43-y f' (L' U' L U) f
                case 1212:
                    return Translator.sequenceTranslator("R',F,R,F',R',F,R,F',R,U,R',U',R,U,R',".split(","), "y2"); // 42-y2 (R' F R F') (R' F R F') (R U R' U') (R U R')
                case 1133:
                    return Translator.sequenceTranslator("R,U,R',U,R,U2,R',F,R,U,R',U',F',".split(","), "y2"); // 41-y2 (R U R' U) R U2 R' F (R U R' U') F'
                case 2121:
                    return "B,U,L,U',L',B',"; // 44 f (R U R' U') f'
                case 1122:
                    return Translator.sequenceTranslator("L,F',L',F,L',U2,L,U,F,U,F',".split(","), "y2"); // 30-y2 (L F' L' F) L' U2 L d (R U R')
                case 3131:
                    return Translator.sequenceTranslator("F,U,R,U',F',L,F,R',F',L',".split(","), "y2"); // 32-y2 F U R U' F' r U R' U' r'
                case 2211:
                    return Translator.sequenceTranslator("R',U',F,U,R,U',R',F',R,".split(","), "y'"); // 31-y' R' U' F U R U' R' F' R
                case 1313:
                    return Translator.sequenceTranslator("R,U,R',U',R,U',R',F',U',F,R,U,R',".split(","), "y2"); // 29-y2 (R U R' U') R U' R' F' U' (F R U R')
                default:
                    return null;
            }
        } else if (!piece20.getFace("U").getDesiredSide().equals("U") && !piece10.getFace("U").getDesiredSide().equals("U") &&
            !piece12.getFace("U").getDesiredSide().equals("U") && !piece2.getFace("U").getDesiredSide().equals("U")) {
            // P
            switch (cornerOrientation) {
                case 1111:
                    return "L',R,B,R,B,R',B',L2,R2,F,R,F',L',"; // 20 M U (R U R' U') M2 (U R U' r')
                case 2222:
                    return "R,U2,R2,F,R,F',U2,R',F,R,F',"; // 1 (R U2 R') (R' F R F') U2 (R' F R F')
                case 3333:
                    return Translator.sequenceTranslator("R,U2,R2,F,R,F',U2,R',F,R,F',".split(","), "y'"); // 1-y' (R U2 R') (R' F R F') U2 (R' F R F')
                case 2323:
                    return "F,R,U,R',U',F',B,U,L,U',L',B',"; // 2 F (R U R' U') F' f (R U R' U') f'
                case 3322:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',B,U,L,U',L',B',".split(","), "y'"); // 2-y' F (R U R' U') F' f (R U R' U') f'
                case 3232:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',B,U,L,U',L',B',".split(","), "y2"); // 2-y2 F (R U R' U') F' f (R U R' U') f'
                case 2233:
                    return Translator.sequenceTranslator("F,R,U,R',U',F',B,U,L,U',L',B',".split(","), "y"); // 2-y F (R U R' U') F' f (R U R' U') f'
                case 3221:
                    return "B,U,L,U',L',B',U',F,R,U,R',U',F',"; // 3 f (R U R' U') f' U' F (R U R' U') F'
                case 3213:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',U',F,R,U,R',U',F',".split(","), "y'"); // 3-y' f (R U R' U') f' U' F (R U R' U') F'
                case 1223:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',U',F,R,U,R',U',F',".split(","), "y2"); // 3-y2 f (R U R' U') f' U' F (R U R' U') F'
                case 3123:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',U',F,R,U,R',U',F',".split(","), "y"); // 3-y f (R U R' U') f' U' F (R U R' U') F'
                case 2132:
                    return "B,U,L,U',L',B',U,F,R,U,R',U',F',"; // 4 f (R U R' U') f' U F (R U R' U') F'
                case 2331:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',U,F,R,U,R',U',F',".split(","), "y'"); // 4-y' f (R U R' U') f' U F (R U R' U') F'
                case 2312:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',U,F,R,U,R',U',F',".split(","), "y2"); // 4-y2 f (R U R' U') f' U F (R U R' U') F'
                case 1332:
                    return Translator.sequenceTranslator("B,U,L,U',L',B',U,F,R,U,R',U',F',".split(","), "y"); // 4-y f (R U R' U') f' U F (R U R' U') F'
                case 1321:
                    return "R,U,R',U,R',F,R,F',U2,R',F,R,F',"; // 17 (R U R' U) (R' F R F') U2 (R' F R F')
                case 3112:
                    return Translator.sequenceTranslator("R,U,R',U,R',F,R,F',U2,R',F,R,F',".split(","), "y'"); // 17-y' (R U R' U) (R' F R F') U2 (R' F R F')
                case 1231:
                    return Translator.sequenceTranslator("R,U,R',U,R',F,R,F',U2,R',F,R,F',".split(","), "y2"); // 17-y2 (R U R' U) (R' F R F') U2 (R' F R F')
                case 2113:
                    return Translator.sequenceTranslator("R,U,R',U,R',F,R,F',U2,R',F,R,F',".split(","), "y"); // 17-y (R U R' U) (R' F R F') U2 (R' F R F')
                case 3311:
                    return "F,R,U,R',U,F',U2,F',L,F,L',"; // 18 F (R U R' U) y' R' U2 (R' F R F')
                case 1212:
                    return Translator.sequenceTranslator("F,R,U,R',U,F',U2,F',L,F,L',".split(","), "y'"); // 18-y' F (R U R' U) y' R' U2 (R' F R F')
                case 1133:
                    return Translator.sequenceTranslator("F,R,U,R',U,F',U2,F',L,F,L',".split(","), "y2"); // 18-y2 F (R U R' U) y' R' U2 (R' F R F')
                case 2121:
                    return Translator.sequenceTranslator("F,R,U,R',U,F',U2,F',L,F,L',".split(","), "y"); // 18-y F (R U R' U) y' R' U2 (R' F R F')
                case 1122:
                    return "L',R,B,R,B,R',B',L,R2,F,R,F',"; // 19 M U (R U R' U') M' (R' F R F')
                case 3131:
                    return Translator.sequenceTranslator("L',R,B,R,B,R',B',L,R2,F,R,F',".split(","), "y'"); // 19-y' M U (R U R' U') M' (R' F R F')
                case 2211:
                    return Translator.sequenceTranslator("L',R,B,R,B,R',B',L,R2,F,R,F',".split(","), "y2"); // 19-y2 M U (R U R' U') M' (R' F R F')
                case 1313:
                    return Translator.sequenceTranslator("L',R,B,R,B,R',B',L,R2,F,R,F',".split(","), "y"); // 19-y M U (R U R' U') M' (R' F R F')
                default:
                    return null;
            }
        } else {
            // ILLEGAL
            return null;
        }
    }
}
