import java.util.Random;
import java.util.Scanner;

/**
 * git
 */
public class git {
    
    private static int[] randomArray;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        boolean logout = true;
        
        boolean sizevalid = true;
        
        int size=0;
        

        while (sizevalid)
        {
            System.out.println("Enter the size of the array: ");

            if(in.hasNextInt())
            {
                size = in.nextInt();
                
                sizevalid= false;
            }
            else
            {
                System.out.println("Size must be a number!");
                in.nextLine();
            }
        }
        
        randomArray = new int[size];

        for(int i = 0; i<randomArray.length; i++)
        {
            randomArray[i] = random.nextInt(101); 
        }


        while(logout)
        {
            System.out.printf("1. Find minimum %n2. Find Maximum %n3. Find the average %n4. Find the difference of the elements from the average%n5. Find sum of odd and even indexes%n6. Exit%nPlease enter your choice: ");
            int choice = in.nextInt();
            if(choice == 1)
            {
                System.out.println("The minimum is: "+ findingMin(randomArray));
            }
            else if (choice == 2) 
            {
                System.out.println("The max is: " + findingMax(randomArray));
            }
            else if (choice == 3) {
                System.out.println("Average: " + findAverage());
            } 
            else if (choice == 4) 
            {
                displayDifferenceFromAverage(size);
            } 
            else if (choice == 5) 
            {
                 System.out.println("the even sum: " + oddEven(randomArray)[0] + "\n" + "the odd sum: " + oddEven( randomArray)[1]);
            } 
            else if (choice == 6) 
            {
                System.out.println("Exiting...");
                logout = false;
            }
            else
            {
                System.out.println("please enter a valid number.");
            }
        }
    
        in.close();
    }

        private static double findAverage()
        {
            int sum = 0;
            double average = 0;
            for(int j : randomArray)
            {
                sum += j;
            }
            average = sum / randomArray.length;
            return average;
        }

        private static void displayDifferenceFromAverage(int size)
        {
            double[] differenceDisplay = new double[size];
            double average = findAverage();
            for(int i = 0; i<differenceDisplay.length; i++)
            {
                differenceDisplay[i] = average - randomArray[i];
            }
            System.out.println("the differences are: "+ differenceDisplay);
        }

        public static int findingMax( int[] randomArray)
        {
            int biggest = randomArray[0];

            for ( int i = 1; i < randomArray.length; i++)
            {
                if ( biggest < randomArray[i])
                {
                    biggest = randomArray[i];
                }
            }

            return biggest;
        }

        public static int findingMin (int [] numbers)
        {
            int min = numbers[0];
        
            for (int i = 1; i < numbers.length; i++)
            {
                if (min > numbers[i])
                {
                    min = numbers[i];
                }
            }

            return min;
        }

        public static int[] oddEven( int[] randomArray)
        {
            int[] evenOddSum = new int[2];
            int evenSum = 0;
            int oddSum = 0;

            for ( int i = 0; i < randomArray.length; i++)
            {
                if ( randomArray[i]%2 == 0)
                {
                    evenSum += randomArray[i];
                }
                else
                {
                    oddSum += randomArray[i];
                }
            }

            evenOddSum[0] = evenSum;
            evenOddSum[1] = oddSum;

            return evenOddSum;

        }
    
}