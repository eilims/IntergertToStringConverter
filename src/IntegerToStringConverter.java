import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


//This class converted the input, a integer number into its strong format.
// IE 101 = one hundred and one etc

public class IntegerToStringConverter {

    HashMap<Integer, String> words;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntegerToStringConverter intToString = new IntegerToStringConverter();
        System.out.println("Please enter a number");
        //TODO add try/catch support
        //TODO add limit for number size
        String output = intToString.parse(scan.nextInt());
        System.out.println("The string format of the number is: " + output);
    }


    public IntegerToStringConverter() {
        words = new HashMap<Integer, String>();
        words.put(0, "zero ");
        words.put(1, "one ");
        words.put(2, "two ");
        words.put(3, "three ");
        words.put(4, "four ");
        words.put(5, "five ");
        words.put(6, "six ");
        words.put(7, "seven ");
        words.put(8, "eight ");
        words.put(10, "ten ");
        words.put(11, "eleven ");
        words.put(12, "twelve ");
        words.put(13, "thirteen ");
        words.put(14, "fourteen ");
        words.put(15, "fifteen ");
        words.put(16, "sixteen ");
        words.put(17, "seventeen ");
        words.put(18, "eighteen ");
        words.put(19, "nineteen ");
        words.put(20, "twenty ");
        words.put(30, "thirty ");
        words.put(40, "fourty ");
        words.put(50, "fifty ");
        words.put(60, "sixty ");
        words.put(70, "seventy ");
        words.put(80, "eighty ");
        words.put(90, "ninty ");
        // Keys are placeholders unlike previous entries
        words.put(100, "hundred ");
        words.put(200, "thousand ");
        words.put(300, "million ");
        words.put(400, "billion ");
    }


    public String parse(int value) {
        ArrayList<Integer> digits = new ArrayList();
        //Determine number of digits and sort digits into list
        digitParse(value, digits);
        //TODO add string to output
        return wordParse(digits);
    }


    public void digitParse(int value, ArrayList<Integer> digits) {
        int count = 0;
        boolean isParsed = false;
        while (value != 0 || !isParsed) {
            if (count != 1) {
                digits.add(value % 10);
            } else {
                digits.add((value % 10) * 10);
            }
            isParsed = true;
            value = value / 10;
            count++;
            count = count % 3;
        }
    }


    public String wordParse(ArrayList<Integer> digits) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        boolean isAllZero = false;

        for (int index = digits.size() - 1; index >= 0 && !isAllZero; index--) {

            boolean tripletIsAllZero = true;

            //TODO clean up if statments IE digits.get calls

            //Parse in Triplets I.E. 100,001 => 100 and 001
            //Starting from most significant number
            if (index % 3 == 2) {

                //Triplet contains three digits
                //Do not skip appending of tens and ones place due to zero
                if (digits.get(index) != 0) {
                    builder.append(words.get(digits.get(index)));
                    builder.append(words.get(100));
                    tripletIsAllZero = false;
                }

                //Append "and" only in last triplet if digits are not zero
                if ((digits.get(index - 1) != 0 || digits.get(index - 2) != 0) && index - 2 == 0) {
                    builder.append("and ");
                }

                appendTens(index - 1, digits, builder);
                index = index - 2;

            } else if (index % 3 == 1) {

                //Triplet contains two digits
                if ((digits.get(index) != 0 || digits.get(index - 1) != 0)) {
                    tripletIsAllZero = false;
                }
                appendTens(index, digits, builder);
                index = index - 1;

            } else {
                //Triplet contains one digit
                if (digits.get(index) != 0 || index - 2 == 0) {
                    tripletIsAllZero = false;
                    builder.append(words.get(digits.get(index)));
                }
            }


            if (index - 1 > 0 && !tripletIsAllZero) {
                appendPlace(count, digits.size(), builder);
            }
            count++;

            //Ensure that following numbers are not all zero, breakout if this is the case
            isAllZero = true;
            for (int i = index - 1; i >= 0; i--) {
                if (digits.get(i) != 0) {
                    isAllZero = false;
                }
            }
        }

        return builder.toString();
    }


    public void appendTens(int index, ArrayList<Integer> digits, StringBuilder builder) {

        //Check if values are zero ahead of time
        boolean tenIsZero = digits.get(index) == 0;
        boolean oneIsZero = digits.get(index - 1) == 0;


        if (digits.get(index) == 10) {
            //"teen" number
            builder.append(words.get(digits.get(index) + digits.get(index - 1)));

        } else {

            //not a "teen" number
            if (!tenIsZero) {
                builder.append(words.get(digits.get(index)));
            }

            if (!oneIsZero) {
                builder.append(words.get(digits.get(index - 1)));
            }
        }
    }

    public void appendPlace(int count, int size, StringBuilder builder) {
        // Use double to round up for correct indexing
        builder.append(words.get((int) ((Math.ceil((double) size / 3) - count) * 100)));
    }
}
