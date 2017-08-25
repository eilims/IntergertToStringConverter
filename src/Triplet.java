public class Triplet {

    Integer digitZero;
    Integer digitOne;
    Integer digitTwo;

    public Triplet(Integer digitZero){
        this.digitZero = digitZero;
        this.digitOne = null;
        this.digitTwo = null;
    }

    public Triplet(Integer digitOne, Integer digitZero){
        this.digitZero = digitZero;
        this.digitOne = digitOne;
        this.digitTwo = null;
    }

    public Triplet(Integer digitTwo, Integer digitOne, Integer digitZero){
        this.digitZero = digitZero;
        this.digitOne = digitOne;
        this.digitTwo = digitTwo;
    }

    public int getDigitCount(){
        //A triplet must always contain at least one number
        int count = 1;
        if (this.digitOne != null){
            count++;
        }
        if (this.digitTwo != null){
            count++;
        }
        return count;
    }

}
