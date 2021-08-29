package Day_2;

public class For_Loop {
    public static void main(String[] args) {
//set up dynamic arrays
        String[] zipcode;

        zipcode = new String[5];
        zipcode[0] = "11034";
        zipcode[1] = "11554";
        zipcode[2] = "10434";
        zipcode[3] = "15984";
        zipcode[4] = "11774";

        int[] street_number;
        street_number = new int[5];
        street_number[0] = 111;
        street_number[1] = 222;
        street_number[2] = 333;
        street_number[3] = 444;
        street_number[4] = 555;



        for (int i = 0; i < zipcode.length; i++) {
            System.out.println("My Zipcode is" + " " + zipcode[i] + " " + "So my street number is"
                    + " " + street_number[i]);

        }//end of loop
    }//end of mm
}//end of class
