import java.util.ArrayList;

public class CollatzNumber {
    public ArrayList<Long> calculate(long n) {
        ArrayList<Long> numbers = new ArrayList<>();

        while (n > 1) {
            numbers.add(n);

            if (n % 2 != 0) {
                n = (n * 3 + 1);
            } else {
                n /= 2;
            }

        }
        return numbers;
    }
}