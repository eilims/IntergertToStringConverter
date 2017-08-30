public class Triplet {

    private Integer digitZero;
    private Integer digitOne;
    private Integer digitTwo;
    private int place;

    //Triplet has one digit
    public Triplet(int place) {
        this.digitZero = null;
        this.digitOne = null;
        this.digitTwo = null;
        this.place = place;
    }

    public Triplet(Integer digitZero, int place) {
        this.digitZero = digitZero;
        this.digitOne = null;
        this.digitTwo = null;
        this.place = place;
    }

    //Digit has two digits
    public Triplet(Integer digitOne, Integer digitZero, int place) {
        this.digitZero = digitZero;
        this.digitOne = digitOne;
        this.digitTwo = null;
        this.place = place;
    }

    //Digit has three digits
    public Triplet(Integer digitTwo, Integer digitOne, Integer digitZero, int place) {
        this.digitZero = digitZero;
        this.digitOne = digitOne;
        this.digitTwo = digitTwo;
        this.place = place;
    }

    //Adds the digit to the appropriate slot
    //Returns true when triplet is full
    public boolean addNextDigit(int digit){
        if (this.digitZero == null){
            setDigitZero(digit);
            return false;
        } else if (this.digitOne == null){
            setDigitOne(digit);
            return false;
        } else if (this.digitTwo == null){
            setDigitTwo(digit);
            return true;
        } else {
            return true;
        }
    }

    //Returns number of digits in triplet that are not null
    public int getDigitCount() {
        //A triplet must always contain at least one number
        int count = 1;
        if (this.digitOne != null) {
            count++;
        }
        if (this.digitTwo != null) {
            count++;
        }
        return count;
    }

    public Integer getDigitZero() {
        return digitZero;
    }

    public Integer getDigitOne() {
        return digitOne;
    }

    public Integer getDigitTwo() {
        return digitTwo;
    }

    public int getPlace() {
        return this.place;
    }

    public void setDigitZero(Integer digitZero) {
        this.digitZero = digitZero;
    }

    public void setDigitOne(Integer digitOne) {
        this.digitOne = digitOne;
    }

    public void setDigitTwo(Integer digitTwo) {
        this.digitTwo = digitTwo;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
