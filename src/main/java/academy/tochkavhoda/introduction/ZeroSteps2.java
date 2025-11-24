package academy.tochkavhoda.introduction;

import java.util.Random;

public class ZeroSteps2 {
    public int sumSquares(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
        }
        return sum;
    }

    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i += 2) {
            sum += i;
        }
        return sum;
    }

    public double sumInverses(int count) {
        double sum = 0.0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public long factorial(int count) {
        long result = 1;
        for (int i = 1; i <= count; i++) {
            result *= i;
        }
        return result;
    }

    public int prodDigits(int value) {
        int product = 1;
        String strValue = Integer.toString(value);
        for (char c : strValue.toCharArray()) {
            product *= Character.getNumericValue(c);
        }
        return product;
    }

    public int fibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= number; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    public long sum2Powers(int max) {
        long sum = 0;
        for (int i = 0; i <= max; i++) {
            sum += Math.pow(2, i);
        }
        return sum;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
            if (sum > barrier) {
                break;
            }
        }
        return sum;
    }

    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += i * j;
            }
        }
        return sum;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int product = i * j;
                if (product < barrier) {
                    sum += product;
                }
            }
        }

        return sum;
    }

    public double sumInversePairProd(int count1, int count2) {
        double sum = 0.0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }

    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }

    public double calculateE() {
        double e = 1.0;
        double factorial = 1.0;
        int n = 1;

        while (true) {
            factorial *= n;
            double term = 1.0 / factorial;
            if (term < 1E-6) {
                break;
            }
            e += term;
            n++;
        }

        return e;
    }

    public double calculatePi() {
        double pi = 0.0;
        int sign = 1;
        for (int i = 0; i < 1000000; i++) {
            pi += sign * (1.0 / (2 * i + 1));
            sign *= -1;
        }
        return 4 * pi;
    }

    public double calculateCircleSquare(double length, int count) {
        int k = 0;
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            double x = random.nextDouble() * length;
            double y = random.nextDouble() * length;

            double radius = length / 2;
            if (Math.pow(x - radius, 2) + Math.pow(y - radius, 2) <= Math.pow(radius, 2)) {
                k++;
            }
        }

        return (length * length * k) / count;
    }
}
