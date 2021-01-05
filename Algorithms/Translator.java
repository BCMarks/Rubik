package Algorithms;

public class Translator {
    public static String sequenceTranslator(String[] sequence, String translation) {
        StringBuilder translatedSequence = new StringBuilder("");
        for (String string : sequence) {
            switch (translation) {
                case "x":
                    translatedSequence.append(Translator.xTranslation(string));
                    break;
                case "x'":
                    translatedSequence.append(Translator.xInvertedTranslation(string));
                    break;
                case "x2":
                    translatedSequence.append(Translator.xTranslation(Translator.xTranslation(string)));
                    break;
                case "y":
                    translatedSequence.append(Translator.yTranslation(string));
                    break;
                case "y'":
                    translatedSequence.append(Translator.yInvertedTranslation(string));
                    break;
                case "y2":
                    translatedSequence.append(Translator.yTranslation(Translator.yTranslation(string)));
                    break;
                case "z":
                    translatedSequence.append(Translator.zTranslation(string));
                    break;
                case "z'":
                    translatedSequence.append(Translator.zInvertedTranslation(string));
                    break;
                default:
                    translatedSequence.append(string);
                    break;
            }
            translatedSequence.append(",");
        }
        return translatedSequence.toString();
    }

    public static String xTranslation(String initial) {
        switch (initial) {
            case "F":
                return "D";
            case "F'":
                return "D'";
            case "F2":
                return "D2";
            case "U":
                return "F";
            case "U'":
                return "F'";
            case "U2":
                return "F2";
            case "B":
                return "U";
            case "B'":
                return "U'";
            case "B2":
                return "U2";
            case "D":
                return "B";
            case "D'":
                return "B'";
            case "D2":
                return "B2";
            default:
                return initial;
        }
    }

    public static String xInvertedTranslation(String initial) {
        switch (initial) {
            case "F":
                return "U";
            case "F'":
                return "U'";
            case "F2":
                return "U2";
            case "U":
                return "B";
            case "U'":
                return "B'";
            case "U2":
                return "B2";
            case "B":
                return "D";
            case "B'":
                return "D'";
            case "B2":
                return "D2";
            case "D":
                return "F";
            case "D'":
                return "F'";
            case "D2":
                return "F2";
            default:
                return initial;
        }
    }

    public static String yTranslation(String initial) {
        switch (initial) {
            case "F":
                return "R";
            case "F'":
                return "R'";
            case "F2":
                return "R2";
            case "L":
                return "F";
            case "L'":
                return "F'";
            case "L2":
                return "F2";
            case "B":
                return "L";
            case "B'":
                return "L'";
            case "B2":
                return "L2";
            case "R":
                return "B";
            case "R'":
                return "B'";
            case "R2":
                return "B2";
            default:
                return initial;
        }
    }

    public static String yInvertedTranslation(String initial) {
        switch (initial) {
            case "F":
                return "L";
            case "F'":
                return "L'";
            case "F2":
                return "L2";
            case "L":
                return "B";
            case "L'":
                return "B'";
            case "L2":
                return "B2";
            case "B":
                return "R";
            case "B'":
                return "R'";
            case "B2":
                return "R2";
            case "R":
                return "F";
            case "R'":
                return "F'";
            case "R2":
                return "F2";
            default:
                return initial;
        }
    }
    
    public static String zTranslation(String initial) {
        switch (initial) {
            case "U":
                return "L";
            case "U'":
                return "L'";
            case "U2":
                return "L2";
            case "L":
                return "D";
            case "L'":
                return "D'";
            case "L2":
                return "D2";
            case "D":
                return "R";
            case "D'":
                return "R'";
            case "D2":
                return "R2";
            case "R":
                return "U";
            case "R'":
                return "U'";
            case "R2":
                return "U2";
            default:
                return initial;
        }
    }

    public static String zInvertedTranslation(String initial) {
        switch (initial) {
            case "U":
                return "R";
            case "U'":
                return "R'";
            case "U2":
                return "R2";
            case "L":
                return "U";
            case "L'":
                return "U'";
            case "L2":
                return "U2";
            case "D":
                return "L";
            case "D'":
                return "L'";
            case "D2":
                return "L2";
            case "R":
                return "D";
            case "R'":
                return "D'";
            case "R2":
                return "D2";
            default:
                return initial;
        }
    }
}