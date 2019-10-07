import java.util.ArrayList;
import java.util.List;


public class Number {

    private Integer number;

    public Number() {

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public List<Integer> createNumberVariations(Integer userNumber) {
        List<Integer> listOfNumber = new ArrayList<>();
        listOfNumber.add(userNumber);
        String[] loopSize = separateDigitsOfNumber(userNumber);

        setNumber(userNumber);
        for (int i = 0; i < loopSize.length - 1; i++) {

            String[] digits = separateDigitsOfNumber(getNumber());
            List<String> newOrder = changeTheOrderOfDigits(digits);
            setNumber(Integer.parseInt(String.join("", newOrder)));
            listOfNumber.add(getNumber());

        }
        return listOfNumber;

    }

    public String[] separateDigitsOfNumber(Integer number) {

        String num = String.valueOf(number);
        String[] digits = num.split("(?<=.)");

        return digits;
    }


    public List<String> changeTheOrderOfDigits(String[] number) {
        List<String> newOrder = new ArrayList<>();
        String firstDigit = number[0];
        for (int i = 0; i < (number.length) - 1; i++) {
            number[i] = number[i + 1];
            newOrder.add(number[i]);
        }
        newOrder.add(number[number.length - 1] = firstDigit);
        return newOrder;
    }

    public void checkIfTheNumberIsMagical(Integer userNumber) {
        List<Integer> list = createNumberVariations(userNumber);

        String[] digits = separateDigitsOfNumber(userNumber);

        int someNumber = 0;
        for (int i = 1; i < digits.length + 1; i++) {
            if (!list.contains(userNumber * i)) {
                someNumber = 1;
                break;
            }
        }

        if(someNumber == 1){
            System.out.println("This number is MUGGLE!");
        }

        if(someNumber == 0){
            System.out.println("This number is MAGIC!");
        }


    }
}