import java.util.*;


//This class converted the input, a integer number into its strong format.
// IE 101 = one hundred and one etc

public class IntegerToStringConverter {

    HashMap<Integer, String> words;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntegerToStringConverter intToString = new IntegerToStringConverter();
        System.out.println("Please enter a number");
        boolean isInputValid = false;
        int value = 0;
        while (!isInputValid) {
            String input = scan.nextLine();
            try {
                value = Integer.parseInt(input);
                isInputValid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }
        String output = intToString.parse(value);
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
        words.put(9, "nine ");
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
        words.put(90, "ninety ");
        // Keys are placeholders unlike previous entries
        words.put(100, "hundred ");
        words.put(200, "thousand ");
        words.put(300, "million ");
        words.put(400, "billion ");
    }


    public String parse(int value) {
        //Determine number of digits and sort digits into triplets
        ArrayList<Triplet> triplets = tripletParse(value);
        //TODO add string to output
        return wordParse(triplets);
    }


    //Parses digits into triplets
    public ArrayList<Triplet> tripletParse(int value) {
        ArrayList<Triplet> triplets = new ArrayList<>();
        int count = 0;
        boolean isTripletFull = false;
        Triplet triplet = new Triplet(0);
        do {
            isTripletFull = triplet.addNextDigit(value % 10);
            value = value / 10;
            if (isTripletFull || value == 0) {
                count++;
                triplets.add(triplets.size(), triplet);
                triplet = new Triplet(count);
            }
        } while (value != 0);
        //Reverse order for easier StringBuilder appending
        Collections.reverse(triplets);
        return triplets;
    }

    //Parse triplet data into string
    //Returns completed string
    public String wordParse(List<Triplet> triplets) {
        StringBuilder builder = new StringBuilder();
        for (Triplet triplet : triplets) {
            switch (triplet.getDigitCount()) {
                case 1:
                    builder.append(words.get(triplet.getDigitZero()));
                    break;
                case 2:
                    builder.append(appendAnd(triplet));
                    builder.append(appendTwoDigits(triplet));
                    break;
                case 3:
                    builder.append(appendThreeDigits(triplet));
                    break;
            }
            builder.append(appendPlace(triplet));
        }
        return builder.toString();
    }

    //Used if a triplet contains three digits
    public String appendThreeDigits(Triplet triplet) {
        StringBuilder builder = new StringBuilder();
        if (!isZero(triplet.getDigitTwo())) {
            builder.append(words.get(triplet.getDigitTwo()));
            //If digit two is present in any place hundred must be appended
            builder.append(words.get(100));
            builder.append(appendTwoDigits(triplet));
        } else {
            builder.append(appendTwoDigits(triplet));
        }
        return builder.toString();
    }

    //Used if a triplet contains two or more digits
    public String appendTwoDigits(Triplet triplet) {
        StringBuilder builder = new StringBuilder();
        if (!isZero(triplet.getDigitOne())) {
            builder.append(appendAnd(triplet));
            //Check if the triplet represents a "teen" number
            if (triplet.getDigitOne() == 1) {
                builder.append(words.get((triplet.getDigitOne() * 10) + triplet.getDigitZero()));
            } else {
                builder.append(words.get(triplet.getDigitOne() * 10));
                builder.append(appendOneDigit(triplet));
            }
        } else {
            builder.append(appendAnd(triplet));
            builder.append(appendOneDigit(triplet));
        }
        return builder.toString();
    }

    //Used if a triplet contains one or more digits
    public String appendOneDigit(Triplet triplet) {
        if (!isZero(triplet.getDigitZero())) {
            return words.get(triplet.getDigitZero());
        }
        return "";

    }

    //Appends the place of the triplet
    //IE Thousand, Million, or Billion
    public String appendPlace(Triplet triplet) {
        if (!isZero(triplet.getPlace()) && (!isZero(triplet.getDigitZero()) || !isZero(triplet.getDigitOne()) || !isZero(triplet.getDigitTwo()))) {
            return words.get((triplet.getPlace() + 1) * 100);
        }
        return "";
    }

    public String appendAnd(Triplet triplet) {
        //To append an "and" triplet must have non-zero digit one and zero, and be in place 0
        if ((!isZero(triplet.getDigitOne()) || !isZero(triplet.getDigitZero())) && isZero(triplet.getPlace()) && triplet.getDigitTwo() != null) {
            return "and ";
        }
        return "";
    }

    //Helper method
    public boolean isZero(Integer digit) {
        if (digit == 0) {
            return true;
        } else {
            return false;
        }
    }
}
