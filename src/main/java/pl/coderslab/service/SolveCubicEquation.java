package pl.coderslab.service;

public class SolveCubicEquation {

    public static String solve(double a, double b, double c) {
        String result;
        if (a == 0) {
            result = "To nie jest równanie kwadratowe";
            return result;
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            result = " Brak rozwiązania";
        } else if (delta == 0) {
            double x0 = -b / 2 / a;
            result = "1 rozwiązanie: " + x0;
        } else {
            double sqrt = Math.pow(delta, 0.5);
            double x1 = (-b - sqrt) / 2 / a;
            double x2 = (-b + sqrt) / 2 / a;
            result = "2 rozwiązania: " + x1 + " i " + x2;
        }
        return result;
    }

}
