package Day_2;

public class Dynamic_Array {

    public static void main(String[] args) {

        //set up zip codes for dynamic array

        String [] zipcode;
        zipcode = new String[5];
        zipcode[0] = "11034";
        zipcode[1] = "11554";
        zipcode[2] = "10434";
        zipcode[3] = "15984";
        zipcode[4] = "11774";


        String[] countries;
        countries = new String[5];

        countries[0] = "Pakistan";
        countries[1] = "Turkey";
        countries[2] = "U.A.E";
        countries[3] = "Germany";
        countries[4] = "England";

        System.out.println("My Zipcode is" + " "  + zipcode[0]);

        System.out.println("My zipcode length is" + " " + zipcode.length);

        System.out.println("The Country I am in is" + " " + countries[1]);
    }
}
