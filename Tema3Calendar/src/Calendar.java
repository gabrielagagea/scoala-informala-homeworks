
import java.util.Scanner;

/**
 * Am importat o librarie java numita scanner care ne permite sa introducem de la tastatura date
 */
public class Calendar {


    public static void main(String[] args) {
        int year, month, day;
        /**
         * Am folosit 3 variabile de tip integer pentru an, luna si zi si o variabila tip string pentru a putea face swich
         */
        day = 0;
        String Name;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year:");


        year = scanner.nextInt();
        System.out.print("Enter the month:");
        month = scanner.nextInt();

        scanner.close();


        switch(month)
        {
            case 1 : Name = "January";
                day = 31;
                break;

            case 2 : Name = "February";
                if ((year % 4 == 0) && year % 100 != 0)
                {
                    day = 29;
                }
                else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))
                {
                    day = 29;
                }
                else
                {
                    day = 28;
                }

              break;

            case 3 : Name = "March";
                day = 31;
                break;

            case 4 : Name = "April";
                day = 30;
                break;
            case 5 : Name ="May";
                day = 31;
                break;
            case 6 : Name = "June";
                day = 30;
                break;
            case 7 : Name = "July";
                day = 31;
                break;
            case 8 : Name = "August";
                day = 31;
                break;
            case 9 : Name = "September";
                day = 30;
                break;
            case 10 : Name = "Octomber";
                day =31;
                break;
            case 11 : Name = "November";
                day = 30;
                break;
            case 12 : Name = "December";
                day = 31;
                break;

        }
        System.out.println(month + " " + year + " " + "are"  + " " + day +" " + "zile");
    }

}


