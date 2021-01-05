package Models;

public class Face {
    private String colour;
    private String currentSide;
    private String desiredSide;

    Face(String side) {
        colour = setColour(side);
        currentSide = side;
        desiredSide = side;
    }

    Face(Face original) {
        colour = original.getColour();
        currentSide = original.getCurrentSide();
        desiredSide = original.getDesiredSide();
    }

    private String setColour(String side) {
        switch (side) {
            case "F":
                return "BLUE";
            case "B":
                return "GREEN";
            case "L":
                return "ORANGE";
            case "R":
                return "RED";
            case "U":
                return "YELLOW";
            case "D":
                return "WHITE";
            default:
                return "BLACK";
        }
    }

    public void setCurrentSide(String newSide) {
        currentSide = newSide;
    }

    public String getColour() {
        return colour;
    }

    public String getCurrentSide() {
        return currentSide;
    }

    public String getDesiredSide() {
        return desiredSide;
    }

    public boolean isMatch() {
        if (currentSide.equals(desiredSide)) {
            return true;
        }
        return false;
    }
}
