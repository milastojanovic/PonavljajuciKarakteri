import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        if (inputString == "") {
            throw new IllegalArgumentException("Illegal argument: empty string");
        }

        String resultingString = "";

        List<Character> chars = new ArrayList<>();
        List<Integer> successiveCharOccurrences = new ArrayList<>();
        int j = 0;
        chars.add(0, inputString.charAt(0));
        successiveCharOccurrences.add(0, 1);
        for (int i = 1; i < inputString.length(); i++) {
            Character ch = inputString.charAt(i);
            if (ch == chars.get(j)) {
                successiveCharOccurrences.add(j, successiveCharOccurrences.get(j) + 1);
            } else {
                j++;
                chars.add(j, ch);
                successiveCharOccurrences.add(j, 1);
            }
        }

        for (int i = 0; i < chars.size(); i++) {
            if ((chars.get(i) >= 48) && (chars.get(i) <= 57)) { // numbers
                resultingString += chars.get(i);
            } else {
                if (successiveCharOccurrences.get(i) == 1) {
                    resultingString += chars.get(i).toString();
                } else {
                    resultingString += chars.get(i).toString() + successiveCharOccurrences.get(i);
                }
            }
        }

        if (resultingString.length() == inputString.length()) {
            resultingString = inputString;
        }

        System.out.println(resultingString);
    }
}
