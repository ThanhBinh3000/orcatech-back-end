package vn.com.gsoft.categories.util.system;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class NumToText {

    // Static
    private static final List<String> digitsName = Arrays.asList(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    );

    private static final List<String> thousandsName = Arrays.asList(
            "",
            "thousand",
            "million",
            "billion",
            "trillion",
            "quadrillion",
            "quintillion"
    );

    // Algorithm section

    /**
     * turn triplet digits into vietnamese words
     *
     * @param triplet         a string of 3 digit integer
     * @param showZeroHundred whether to show Zero hundred
     * @return vietnamese string represent the input number
     */
    private static String readTriple(String triplet, boolean showZeroHundred) {
        List<Integer> digitList = stringToInt(triplet);
        int a = digitList.get(0);
        int b = digitList.get(1);
        int c = digitList.get(2);
        if (a == 0) {
            if (b == 0 && c == 0) {
                return "";
            }
            if (showZeroHundred) {
                return "zero hundred " + readPair(b, c);
            }
            if (b == 0) {
                return digitsName.get(c);
            } else {
                return readPair(b, c);
            }
        }
        return digitsName.get(a) + " hundred " + readPair(b, c);
    }


    private static String readPair(int b, int c) {
        String temp;
        switch (b) {
            case 0:
                return c == 0 ? "" : "one " + digitsName.get(c);
            case 1:
                switch (c) {
                    case 0:
                        temp = " ";
                        break;
                    case 5:
                        temp = "five ";
                        break;
                    default:
                        temp = digitsName.get(c);
                        break;
                }
                return "ten " + temp;
            default:
                switch (c) {
                    case 0:
                        temp = "";
                        break;
                    case 1:
                        temp = "one ";
                        break;
                    case 4:
                        temp = "four ";
                        break;
                    case 5:
                        temp = "five ";
                        break;
                    default:
                        temp = digitsName.get(c);
                        break;
                }
                return digitsName.get(b) + " twenty " + temp;
        }
    }


    private static List<Integer> stringToInt(String triplet) {
        return triplet.chars()
                .map(NumToText::charToInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int charToInt(int c) {
        return c - '0';
    }

    public static String num2String(long num) {
        if (num == 0L) {
            return "zero";
        }
        if (num < 0L) {
            return "negative " + num2String(-num);
        }
        String str = Long.valueOf(num).toString();
        // zero padding in front of string to prepare for splitting
        switch (str.length() % 3) {
            case 1:
                str = "00" + str;
                break;
            case 2:
                str = "0" + str;
                break;
            default:
                break;
        }
        // Split into chunks of 3 digits each
        List<String> groupOfThousand = Arrays.asList(str.split("(?<=\\G.{3})"));
        boolean showZeroHundred = doShowZeroHundred(groupOfThousand);
        AtomicInteger index = new AtomicInteger();
        String result = groupOfThousand.stream()
                .map(triplet -> readTriple(triplet, showZeroHundred && index.get() > 0))
                .map(vnString -> vnString.trim().isEmpty()
                        ? ""
                        : vnString + " " + thousandsName.get(groupOfThousand.size() - 1 - index.get())
                )
                .peek(s -> index.getAndIncrement())
                .collect(Collectors.joining(" "))
                .replaceAll("\\s+", " ")
                .trim();
        return result;
    }

    /**
     * determine whether to show zero-hundred text
     * <p>
     * Explain: count the amount of consecutive "000" at the end of the number and
     * compare it with number length
     *
     * @param groupOfThousand number represented in group of 3 digits of each 1000^n
     * @return a boolean
     */
    private static boolean doShowZeroHundred(List<String> groupOfThousand) {
        int count = 0;
        int i = groupOfThousand.size() - 1;
        while (i >= 0 && groupOfThousand.get(i).equals("000")) {
            count++;
            i--;
        }
        return count < groupOfThousand.size() - 1;
    }
}