package lab1;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(checkTriangle(args));
    }

    public static String checkTriangle(String[] args) {
        if (isCorrectInput(args)) {
            double[] doubleArray = new double[3];
            doubleArray[0] = Double.parseDouble(args[0]);
            doubleArray[1] = Double.parseDouble(args[1]);
            doubleArray[2] = Double.parseDouble(args[2]);
            if (isTriangleReal(doubleArray)) {
                return typeOfTriangle(doubleArray);
            } else {
                return "Ошибка";
            }
        } else {
            return "Ошибка";
        }
    }

    public static boolean isCorrectInput(String[] args) {
        if (args.length != 3) {
            return false;
        }
        return checkArgument(args[0]) && checkArgument(args[1]) && checkArgument(args[2]);
    }

    public static boolean isTriangleReal(double[] args) {
        return args[0] + args[1] > args[2] && args[0] + args[2] > args[1] && args[1] + args[2] > args[0];
    }

    public static String typeOfTriangle(double[] args) {
        if (args[0] == args[1] && args[0] == args[2]) {
            return "Равносторонний";
        } else if ((args[0] == args[1] && args[0] != args[2]) || (args[0] == args[2] && args[0] != args[1]) || (args[1] == args[2] && args[1] != args[0])) {
            return "Равнобедренный";
        } else {
            return "Обычный";
        }
    }

    private static boolean checkArgument(String arg) {
        if (isDigit(arg)) {
            double number = Double.parseDouble(arg);
            return 0 < number && number <= Double.MAX_VALUE;
        }
        return false;
    }

    private static boolean isDigit(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
