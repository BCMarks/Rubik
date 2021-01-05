package Models;

import java.util.ArrayList;

public class Piece {
    private Face frontFace = null;
    private Face backFace = null;
    private Face leftFace = null;
    private Face rightFace = null;
    private Face upFace = null;
    private Face downFace = null;
    private int desiredPieceNumber;
    private int currentPieceNumber;

    Piece(int number) {
        desiredPieceNumber = number;
        currentPieceNumber = number;
        switch (number) {
            case 1:
                frontFace = new Face("F");
                leftFace = new Face("L");
                upFace = new Face("U");
                break;
            case 2:
                frontFace = new Face("F");
                upFace = new Face("U");
                break;
            case 3:
                frontFace = new Face("F");
                rightFace = new Face("R");
                upFace = new Face("U");
                break;
            case 4:
                frontFace = new Face("F");
                leftFace = new Face("L");
                break;
            case 5:
                frontFace = new Face("F");
                break;
            case 6:
                frontFace = new Face("F");
                rightFace = new Face("R");
                break;
            case 7:
                frontFace = new Face("F");
                leftFace = new Face("L");
                downFace = new Face("D");
                break;
            case 8:
                frontFace = new Face("F");
                downFace = new Face("D");
                break;
            case 9:
                frontFace = new Face("F");
                rightFace = new Face("R");
                downFace = new Face("D");
                break;
            case 10:
                leftFace = new Face("L");
                upFace = new Face("U");
                break;
            case 11:
                upFace = new Face("U");
                break;
            case 12:
                rightFace = new Face("R");
                upFace = new Face("U");
                break;
            case 13:
                leftFace = new Face("L");
                break;
            case 15:
                rightFace = new Face("R");
                break;
            case 16:
                leftFace = new Face("L");
                downFace = new Face("D");
                break;
            case 17:
                downFace = new Face("D");
                break;
            case 18:
                rightFace = new Face("R");
                downFace = new Face("D");
                break;
            case 19:
                backFace = new Face("B");
                leftFace = new Face("L");
                upFace = new Face("U");
                break;
            case 20:
                backFace = new Face("B");
                upFace = new Face("U");
                break;
            case 21:
                backFace = new Face("B");
                rightFace = new Face("R");
                upFace = new Face("U");
                break;
            case 22:
                backFace = new Face("B");
                leftFace = new Face("L");
                break;
            case 23:
                backFace = new Face("B");
                break;
            case 24:
                backFace = new Face("B");
                rightFace = new Face("R");
                break;
            case 25:
                backFace = new Face("B");
                leftFace = new Face("L");
                downFace = new Face("D");
                break;
            case 26:
                backFace = new Face("B");
                downFace = new Face("D");
                break;
            case 27:
                backFace = new Face("B");
                rightFace = new Face("R");
                downFace = new Face("D");
                break;
            default:
                break;
        }
    }

    public Piece(Piece original) {
        desiredPieceNumber = original.getDesiredPieceNumber();
        currentPieceNumber = original.getCurrentPieceNumber();
        switch (currentPieceNumber) {
            case 1:
                frontFace = new Face(original.getFace("F"));
                leftFace = new Face(original.getFace("L"));
                upFace = new Face(original.getFace("U"));
                break;
            case 2:
                frontFace = new Face(original.getFace("F"));
                upFace = new Face(original.getFace("U"));
                break;
            case 3:
                frontFace = new Face(original.getFace("F"));
                rightFace = new Face(original.getFace("R"));
                upFace = new Face(original.getFace("U"));
                break;
            case 4:
                frontFace = new Face(original.getFace("F"));
                leftFace = new Face(original.getFace("L"));
                break;
            case 5:
                frontFace = new Face(original.getFace("F"));
                break;
            case 6:
                frontFace = new Face(original.getFace("F"));
                rightFace = new Face(original.getFace("R"));
                break;
            case 7:
                frontFace = new Face(original.getFace("F"));
                leftFace = new Face(original.getFace("L"));
                downFace = new Face(original.getFace("D"));
                break;
            case 8:
                frontFace = new Face(original.getFace("F"));
                downFace = new Face(original.getFace("D"));
                break;
            case 9:
                frontFace = new Face(original.getFace("F"));
                rightFace = new Face(original.getFace("R"));
                downFace = new Face(original.getFace("D"));
                break;
            case 10:
                leftFace = new Face(original.getFace("L"));
                upFace = new Face(original.getFace("U"));
                break;
            case 11:
                upFace = new Face(original.getFace("U"));
                break;
            case 12:
                rightFace = new Face(original.getFace("R"));
                upFace = new Face(original.getFace("U"));
                break;
            case 13:
                leftFace = new Face(original.getFace("L"));
                break;
            case 15:
                rightFace = new Face(original.getFace("R"));
                break;
            case 16:
                leftFace = new Face(original.getFace("L"));
                downFace = new Face(original.getFace("D"));
                break;
            case 17:
                downFace = new Face(original.getFace("D"));
                break;
            case 18:
                rightFace = new Face(original.getFace("R"));
                downFace = new Face(original.getFace("D"));
                break;
            case 19:
                backFace = new Face(original.getFace("B"));
                leftFace = new Face(original.getFace("L"));
                upFace = new Face(original.getFace("U"));
                break;
            case 20:
                backFace = new Face(original.getFace("B"));
                upFace = new Face(original.getFace("U"));
                break;
            case 21:
                backFace = new Face(original.getFace("B"));
                rightFace = new Face(original.getFace("R"));
                upFace = new Face(original.getFace("U"));
                break;
            case 22:
                backFace = new Face(original.getFace("B"));
                leftFace = new Face(original.getFace("L"));
                break;
            case 23:
                backFace = new Face(original.getFace("B"));
                break;
            case 24:
                backFace = new Face(original.getFace("B"));
                rightFace = new Face(original.getFace("R"));
                break;
            case 25:
                backFace = new Face(original.getFace("B"));
                leftFace = new Face(original.getFace("L"));
                downFace = new Face(original.getFace("D"));
                break;
            case 26:
                backFace = new Face(original.getFace("B"));
                downFace = new Face(original.getFace("D"));
                break;
            case 27:
                backFace = new Face(original.getFace("B"));
                rightFace = new Face(original.getFace("R"));
                downFace = new Face(original.getFace("D"));
                break;
            default:
                break;
        }
    }

    public int getCurrentPieceNumber() {
        return currentPieceNumber;
    }

    public int getDesiredPieceNumber() {
        return desiredPieceNumber;
    }

    public void setCurrentPieceNumber(int number) {
        currentPieceNumber = number;
    }

    
    public boolean inCorrectPosition() {
        if (currentPieceNumber == desiredPieceNumber) {
            return true;
        }
        return false;
    }

    public boolean inCorrectOrientation() {
        if (leftFace != null && leftFace.getCurrentSide() != leftFace.getDesiredSide()) {
            return false;
        }
        if (rightFace != null && rightFace.getCurrentSide() != rightFace.getDesiredSide()) {
            return false;
        }
        if (upFace != null && upFace.getCurrentSide() != upFace.getDesiredSide()) {
            return false;
        }
        if (downFace != null && downFace.getCurrentSide() != downFace.getDesiredSide()) {
            return false;
        }
        if (frontFace != null && frontFace.getCurrentSide() != frontFace.getDesiredSide()) {
            return false;
        }
        if (backFace != null && backFace.getCurrentSide() != backFace.getDesiredSide()) {
            return false;
        }
        return true;
    }

    public Face getFace(String face) {
        switch (face) {
            case "F":
                return frontFace;
            case "B":
                return backFace;
            case "L":
                return leftFace;
            case "R":
                return rightFace;
            case "U":
                return upFace;
            case "D":
                return downFace;
            default:
                return null;
        }
    }

    public void moveFront(int to) {
        switch (currentPieceNumber) {
            case 1:
                rightFace = upFace;
                rightFace.setCurrentSide("R");
                upFace = leftFace;
                upFace.setCurrentSide("U");
                leftFace = null;
                break;
            case 2:
                rightFace = upFace;
                rightFace.setCurrentSide("R");
                upFace = null;
                break;
            case 3:
                downFace = rightFace;
                downFace.setCurrentSide("D");
                rightFace = upFace;
                rightFace.setCurrentSide("R");
                upFace = null;
                break;
            case 4:
                upFace = leftFace;
                upFace.setCurrentSide("U");
                leftFace = null;
                break;
            case 6:
                downFace = rightFace;
                downFace.setCurrentSide("D");
                rightFace = null;
                break;
            case 7:
                upFace = leftFace;
                upFace.setCurrentSide("U");
                leftFace = downFace;
                leftFace.setCurrentSide("L");
                downFace = null;
                break;
            case 8:
                leftFace = downFace;
                leftFace.setCurrentSide("L");
                downFace = null;
                break;
            case 9:
                leftFace = downFace;
                leftFace.setCurrentSide("L");
                downFace = rightFace;
                downFace.setCurrentSide("D");
                rightFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveFrontInverted(int to) {
        switch (currentPieceNumber) {
            case 1:
                downFace = leftFace;
                downFace.setCurrentSide("D");
                leftFace = upFace;
                leftFace.setCurrentSide("L");
                upFace = null;
                break;
            case 2:
                leftFace = upFace;
                leftFace.setCurrentSide("L");
                upFace = null;
                break;
            case 3:
                leftFace = upFace;
                leftFace.setCurrentSide("L");
                upFace = rightFace;
                upFace.setCurrentSide("U");
                rightFace = null;
                break;
            case 4:
                downFace = leftFace;
                downFace.setCurrentSide("D");
                leftFace = null;
                break;
            case 6:
                upFace = rightFace;
                upFace.setCurrentSide("U");
                rightFace = null;
                break;
            case 7:
                rightFace = downFace;
                rightFace.setCurrentSide("R");
                downFace = leftFace;
                downFace.setCurrentSide("D");
                leftFace = null;
                break;
            case 8:
                rightFace = downFace;
                rightFace.setCurrentSide("R");
                downFace = null;
                break;
            case 9:
                upFace = rightFace;
                upFace.setCurrentSide("U");
                rightFace = downFace;
                rightFace.setCurrentSide("R");
                downFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveBack(int to) {
        switch (currentPieceNumber) {
            case 21:
                leftFace = upFace;
                leftFace.setCurrentSide("L");
                upFace = rightFace;
                upFace.setCurrentSide("U");
                rightFace = null;
                break;
            case 20:
                leftFace = upFace;
                leftFace.setCurrentSide("L");
                upFace = null;
                break;
            case 19:
                downFace = leftFace;
                downFace.setCurrentSide("D");
                leftFace = upFace;
                leftFace.setCurrentSide("L");
                upFace = null;
                break;
            case 24:
                upFace = rightFace;
                upFace.setCurrentSide("U");
                rightFace = null;
                break;
            case 22:
                downFace = leftFace;
                downFace.setCurrentSide("D");
                leftFace = null;
                break;
            case 27:
                upFace = rightFace;
                upFace.setCurrentSide("U");
                rightFace = downFace;
                rightFace.setCurrentSide("R");
                downFace = null;
                break;
            case 26:
                rightFace = downFace;
                rightFace.setCurrentSide("R");
                downFace = null;
                break;
            case 25:
                rightFace = downFace;
                rightFace.setCurrentSide("R");
                downFace = leftFace;
                downFace.setCurrentSide("D");
                leftFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveBackInverted(int to) {
        switch (currentPieceNumber) {
            case 21:
                downFace = rightFace;
                downFace.setCurrentSide("D");
                rightFace = upFace;
                rightFace.setCurrentSide("R");
                upFace = null;
                break;
            case 20:
                rightFace = upFace;
                rightFace.setCurrentSide("R");
                upFace = null;
                break;
            case 19:
                rightFace = upFace;
                rightFace.setCurrentSide("R");
                upFace = leftFace;
                upFace.setCurrentSide("U");
                leftFace = null;
                break;
            case 24:
                downFace = rightFace;
                downFace.setCurrentSide("D");
                rightFace = null;
                break;
            case 22:
                upFace = leftFace;
                upFace.setCurrentSide("U");
                leftFace = null;
                break;
            case 27:
                leftFace = downFace;
                leftFace.setCurrentSide("L");
                downFace = rightFace;
                downFace.setCurrentSide("D");
                rightFace = null;
                break;
            case 26:
                leftFace = downFace;
                leftFace.setCurrentSide("L");
                downFace = null;
                break;
            case 25:
                upFace = leftFace;
                upFace.setCurrentSide("U");
                leftFace = downFace;
                leftFace.setCurrentSide("L");
                downFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveLeft(int to) {
        switch (currentPieceNumber) {
            case 19:
                frontFace = upFace;
                frontFace.setCurrentSide("F");
                upFace = backFace;
                upFace.setCurrentSide("U");
                backFace = null;
                break;
            case 10:
                frontFace = upFace;
                frontFace.setCurrentSide("F");
                upFace = null;
                break;
            case 1:
                downFace = frontFace;
                downFace.setCurrentSide("D");
                frontFace = upFace;
                frontFace.setCurrentSide("F");
                upFace = null;
                break;
            case 22:
                upFace = backFace;
                upFace.setCurrentSide("U");
                backFace = null;
                break;
            case 4:
                downFace = frontFace;
                downFace.setCurrentSide("D");
                frontFace = null;
                break;
            case 25:
                upFace = backFace;
                upFace.setCurrentSide("U");
                backFace = downFace;
                backFace.setCurrentSide("B");
                downFace = null;
                break;
            case 16:
                backFace = downFace;
                backFace.setCurrentSide("B");
                downFace = null;
                break;
            case 7:
                backFace = downFace;
                backFace.setCurrentSide("B");
                downFace = frontFace;
                downFace.setCurrentSide("D");
                frontFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveLeftInverted(int to) {
        switch (currentPieceNumber) {
            case 19:
                downFace = backFace;
                downFace.setCurrentSide("D");
                backFace = upFace;
                backFace.setCurrentSide("B");
                upFace = null;
                break;
            case 10:
                backFace = upFace;
                backFace.setCurrentSide("B");
                upFace = null;
                break;
            case 1:
                backFace = upFace;
                backFace.setCurrentSide("B");
                upFace = frontFace;
                upFace.setCurrentSide("U");
                frontFace = null;
                break;
            case 22:
                downFace = backFace;
                downFace.setCurrentSide("D");
                backFace = null;
                break;
            case 4:
                upFace = frontFace;
                upFace.setCurrentSide("U");
                frontFace = null;
                break;
            case 25:
                frontFace = downFace;
                frontFace.setCurrentSide("F");
                downFace = backFace;
                downFace.setCurrentSide("D");
                backFace = null;
                break;
            case 16:
                frontFace = downFace;
                frontFace.setCurrentSide("F");
                downFace = null;
                break;
            case 7:
                upFace = frontFace;
                upFace.setCurrentSide("U");
                frontFace = downFace;
                frontFace.setCurrentSide("F");
                downFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveRight(int to) {
        switch (currentPieceNumber) {
            case 3:
                backFace = upFace;
                backFace.setCurrentSide("B");
                upFace = frontFace;
                upFace.setCurrentSide("U");
                frontFace = null;
                break;
            case 12:
                backFace = upFace;
                backFace.setCurrentSide("B");
                upFace = null;
                break;
            case 21:
                downFace = backFace;
                downFace.setCurrentSide("D");
                backFace = upFace;
                backFace.setCurrentSide("B");
                upFace = null;
                break;
            case 6:
                upFace = frontFace;
                upFace.setCurrentSide("U");
                frontFace = null;
                break;
            case 24:
                downFace = backFace;
                downFace.setCurrentSide("D");
                backFace = null;
                break;
            case 9:
                upFace = frontFace;
                upFace.setCurrentSide("U");
                frontFace = downFace;
                frontFace.setCurrentSide("F");
                downFace = null;
                break;
            case 18:
                frontFace = downFace;
                frontFace.setCurrentSide("F");
                downFace = null;
                break;
            case 27:
                frontFace = downFace;
                frontFace.setCurrentSide("F");
                downFace = backFace;
                downFace.setCurrentSide("D");
                backFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveRightInverted(int to) {
        switch (currentPieceNumber) {
            case 3:
                downFace = frontFace;
                downFace.setCurrentSide("D");
                frontFace = upFace;
                frontFace.setCurrentSide("F");
                upFace = null;
                break;
            case 12:
                frontFace = upFace;
                frontFace.setCurrentSide("F");
                upFace = null;
                break;
            case 21:
                frontFace = upFace;
                frontFace.setCurrentSide("F");
                upFace = backFace;
                upFace.setCurrentSide("U");
                backFace = null;
                break;
            case 6:
                downFace = frontFace;
                downFace.setCurrentSide("D");
                frontFace = null;
                break;
            case 24:
                upFace = backFace;
                upFace.setCurrentSide("U");
                backFace = null;
                break;
            case 9:
                backFace = downFace;
                backFace.setCurrentSide("B");
                downFace = frontFace;
                downFace.setCurrentSide("D");
                frontFace = null;
                break;
            case 18:
                backFace = downFace;
                backFace.setCurrentSide("B");
                downFace = null;
                break;
            case 27:
                upFace = backFace;
                upFace.setCurrentSide("U");
                backFace = downFace;
                backFace.setCurrentSide("B");
                downFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveUp(int to) {
        switch (currentPieceNumber) {
            case 19:
                rightFace = backFace;
                rightFace.setCurrentSide("R");
                backFace = leftFace;
                backFace.setCurrentSide("B");
                leftFace = null;
                break;
            case 20:
                rightFace = backFace;
                rightFace.setCurrentSide("R");
                backFace = null;
                break;
            case 21:
                frontFace = rightFace;
                frontFace.setCurrentSide("F");
                rightFace = backFace;
                rightFace.setCurrentSide("R");
                backFace = null;
                break;
            case 10:
                backFace = leftFace;
                backFace.setCurrentSide("B");
                leftFace = null;
                break;
            case 12:
                frontFace = rightFace;
                frontFace.setCurrentSide("F");
                rightFace = null;
                break;
            case 1:
                backFace = leftFace;
                backFace.setCurrentSide("B");
                leftFace = frontFace;
                leftFace.setCurrentSide("L");
                frontFace = null;
                break;
            case 2:
                leftFace = frontFace;
                leftFace.setCurrentSide("L");
                frontFace = null;
                break;
            case 3:
                leftFace = frontFace;
                leftFace.setCurrentSide("L");
                frontFace = rightFace;
                frontFace.setCurrentSide("F");
                rightFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveUpInverted(int to) {
        switch (currentPieceNumber) {
            case 19:
                frontFace = leftFace;
                frontFace.setCurrentSide("F");
                leftFace = backFace;
                leftFace.setCurrentSide("L");
                backFace = null;
                break;
            case 20:
                leftFace = backFace;
                leftFace.setCurrentSide("L");
                backFace = null;
                break;
            case 21:
                leftFace = backFace;
                leftFace.setCurrentSide("L");
                backFace = rightFace;
                backFace.setCurrentSide("B");
                rightFace = null;
                break;
            case 10:
                frontFace = leftFace;
                frontFace.setCurrentSide("F");
                leftFace = null;
                break;
            case 12:
                backFace = rightFace;
                backFace.setCurrentSide("B");
                rightFace = null;
                break;
            case 1:
                rightFace = frontFace;
                rightFace.setCurrentSide("R");
                frontFace = leftFace;
                frontFace.setCurrentSide("F");
                leftFace = null;
                break;
            case 2:
                rightFace = frontFace;
                rightFace.setCurrentSide("R");
                frontFace = null;
                break;
            case 3:
                backFace = rightFace;
                backFace.setCurrentSide("B");
                rightFace = frontFace;
                rightFace.setCurrentSide("R");
                frontFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveDown(int to) {
        switch (currentPieceNumber) {
            case 7:
                rightFace = frontFace;
                rightFace.setCurrentSide("R");
                frontFace = leftFace;
                frontFace.setCurrentSide("F");
                leftFace = null;
                break;
            case 8:
                rightFace = frontFace;
                rightFace.setCurrentSide("R");
                frontFace = null;
                break;
            case 9:
                backFace = rightFace;
                backFace.setCurrentSide("B");
                rightFace = frontFace;
                rightFace.setCurrentSide("R");
                frontFace = null;
                break;
            case 16:
                frontFace = leftFace;
                frontFace.setCurrentSide("F");
                leftFace = null;
                break;
            case 18:
                backFace = rightFace;
                backFace.setCurrentSide("B");
                rightFace = null;
                break;
            case 25:
                frontFace = leftFace;
                frontFace.setCurrentSide("F");
                leftFace = backFace;
                leftFace.setCurrentSide("L");
                backFace = null;
                break;
            case 26:
                leftFace = backFace;
                leftFace.setCurrentSide("L");
                backFace = null;
                break;
            case 27:
                leftFace = backFace;
                leftFace.setCurrentSide("L");
                backFace = rightFace;
                backFace.setCurrentSide("B");
                rightFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void moveDownInverted(int to) {
        switch (currentPieceNumber) {
            case 7:
                backFace = leftFace;
                backFace.setCurrentSide("B");
                leftFace = frontFace;
                leftFace.setCurrentSide("L");
                frontFace = null;
                break;
            case 8:
                leftFace = frontFace;
                leftFace.setCurrentSide("L");
                frontFace = null;
                break;
            case 9:
                leftFace = frontFace;
                leftFace.setCurrentSide("L");
                frontFace = rightFace;
                frontFace.setCurrentSide("F");
                rightFace = null;
                break;
            case 16:
                backFace = leftFace;
                backFace.setCurrentSide("B");
                leftFace = null;
                break;
            case 18:
                frontFace = rightFace;
                frontFace.setCurrentSide("F");
                rightFace = null;
                break;
            case 25:
                rightFace = backFace;
                rightFace.setCurrentSide("R");
                backFace = leftFace;
                backFace.setCurrentSide("B");
                leftFace = null;
                break;
            case 26:
                rightFace = backFace;
                rightFace.setCurrentSide("R");
                backFace = null;
                break;
            case 27:
                frontFace = rightFace;
                frontFace.setCurrentSide("F");
                rightFace = backFace;
                rightFace.setCurrentSide("R");
                backFace = null;
                break;
            default:
                break;
        }
        currentPieceNumber = to;
    }

    public void printPieceDetails() {
        System.out.println("Desired Piece Number: "+String.valueOf(desiredPieceNumber));
        System.out.println("Current Piece Number: "+String.valueOf(currentPieceNumber));

        if (frontFace != null) {
            System.out.println("Front Face: "+frontFace.getColour());
            System.out.println("Current Orientation: "+frontFace.getCurrentSide());
            System.out.println("Desired Orientation: "+frontFace.getDesiredSide());
        }

        if (backFace != null) {
            System.out.println("Back Face: "+backFace.getColour());
            System.out.println("Current Orientation: "+backFace.getCurrentSide());
            System.out.println("Desired Orientation: "+backFace.getDesiredSide());
        }

        if (leftFace != null) {
            System.out.println("Left Face: "+leftFace.getColour());
            System.out.println("Current Orientation: "+leftFace.getCurrentSide());
            System.out.println("Desired Orientation: "+leftFace.getDesiredSide());
        }

        if (rightFace != null) {
            System.out.println("Right Face: "+rightFace.getColour());
            System.out.println("Current Orientation: "+rightFace.getCurrentSide());
            System.out.println("Desired Orientation: "+rightFace.getDesiredSide());
        }

        if (upFace != null) {
            System.out.println("Up Face: "+upFace.getColour());
            System.out.println("Current Orientation: "+upFace.getCurrentSide());
            System.out.println("Desired Orientation: "+upFace.getDesiredSide());
        }

        if (downFace != null) {
            System.out.println("Down Face: "+downFace.getColour());
            System.out.println("Current Orientation: "+downFace.getCurrentSide());
            System.out.println("Desired Orientation: "+downFace.getDesiredSide());
        }
    }
}
