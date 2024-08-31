import java.util.Scanner;

class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    Polynomial list1 = new Polynomial();
    Polynomial list2 = new Polynomial();
    String polyString = "";
    System.out.println("Please enter two polynomials and two numbers to put into them, all variables must be a lowercase x, all numbers must be whole numbers, and a space should be placed before and after each + or - operator and only then.");
    //First Polynomial
    System.out.println("First polynomial");
    polyString = " " + scan.nextLine() + "  ";
    int plusOrMinus = 1;
    boolean noPow = true;
    for(int i = 0; i < polyString.length(); i++)
    {
      String tempCoe = "";
      String tempPow = "";
      if(polyString.substring(i, i + 1).equals("x"))
      {
        if(polyString.substring(i - 1, i).equals(" "))
        {
          tempCoe = "1";
        }
        if(polyString.substring(i - 1, i).equals("-"))
        {
          tempCoe = "-1";
        }
        else
        {
          int counter = i;
          while(!polyString.substring(counter - 1, counter).equals(" "))
          {
            tempCoe = polyString.substring(counter - 1, counter) + tempCoe;
            counter--;
          }
        }
        if(polyString.substring(i + 1, i + 2).equals(" "))
        {
          tempPow = "1";
        }
        else
        {
          int counter = i;
          while(!polyString.substring(counter + 2, counter + 3).equals(" "))
          {
            tempPow += polyString.substring(counter + 2, counter + 3);
            counter++;
          }
        }
        list1.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
        noPow = false;
      }
      if(polyString.substring(i, i + 1).equals("+"))
      {
        if(noPow == true)
        {
          int counter = i;
          while(!polyString.substring(counter - 2, counter - 1).equals(" "))
          {
            tempCoe = polyString.substring(counter - 2, counter - 1) + tempCoe;
            counter--;
          }
          tempPow = "0";
          list1.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
        }
        noPow = true;
        plusOrMinus = 1;
      }
      if(polyString.substring(i, i + 1).equals("-") && polyString.substring(i + 1, i + 2).equals(" "))
      {
        if(noPow == true)
        {
          int counter = i;
          while(!polyString.substring(counter - 2, counter - 1).equals(" "))
          {
            tempCoe = polyString.substring(counter - 2, counter - 1) + tempCoe;
            counter--;
          }
          tempPow = "0";
          list1.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
        }
        noPow = true;
        plusOrMinus = -1;
      }
      if(i == polyString.length() - 1 && noPow == true)
      {
        int counter = i;
        while(!polyString.substring(counter - 2, counter - 1).equals(" "))
        {
          tempCoe = polyString.substring(counter - 2, counter - 1) + tempCoe;
          counter--;
        }
        tempPow = "0";
        list1.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
      }
    }
    //Second Polynomial
    System.out.println("Second polynomial");
    polyString = " " + scan.nextLine() + "  ";
    plusOrMinus = 1;
    noPow = true;for(int i = 0; i < polyString.length(); i++)
    {
      String tempCoe = "";
      String tempPow = "";
      if(polyString.substring(i, i + 1).equals("x"))
      {
        if(polyString.substring(i - 1, i).equals(" "))
        {
          tempCoe = "1";
        }
        if(polyString.substring(i - 1, i).equals("-"))
        {
          tempCoe = "-1";
        }
        else
        {
          int counter = i;
          while(!polyString.substring(counter - 1, counter).equals(" "))
          {
            tempCoe = polyString.substring(counter - 1, counter) + tempCoe;
            counter--;
          }
        }
        if(polyString.substring(i + 1, i + 2).equals(" "))
        {
          tempPow = "1";
        }
        else
        {
          int counter = i;
          while(!polyString.substring(counter + 2, counter + 3).equals(" "))
          {
            tempPow += polyString.substring(counter + 2, counter + 3);
            counter++;
          }
        }
        list2.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
        noPow = false;
      }
      if(polyString.substring(i, i + 1).equals("+"))
      {
        if(noPow == true)
        {
          int counter = i;
          while(!polyString.substring(counter - 2, counter - 1).equals(" "))
          {
            tempCoe = polyString.substring(counter - 2, counter - 1) + tempCoe;
            counter--;
          }
          tempPow = "0";
          list2.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
        }
        noPow = true;
        plusOrMinus = 1;
      }
      if(polyString.substring(i, i + 1).equals("-") && polyString.substring(i + 1, i + 2).equals(" "))
      {
        if(noPow == true)
        {
          int counter = i;
          while(!polyString.substring(counter - 2, counter - 1).equals(" "))
          {
            tempCoe = polyString.substring(counter - 2, counter - 1) + tempCoe;
            counter--;
          }
          tempPow = "0";
          list2.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
        }
        noPow = true;
        plusOrMinus = -1;
      }
      if(i == polyString.length() - 1 && noPow == true)
      {
        int counter = i;
        while(!polyString.substring(counter - 2, counter - 1).equals(" "))
        {
          tempCoe = polyString.substring(counter - 2, counter - 1) + tempCoe;
          counter--;
        }
        tempPow = "0";
        list2.enqueue(Integer.valueOf(tempCoe) * plusOrMinus, Integer.valueOf(tempPow));
      }
    }
    //Numbers & calling
    System.out.println("First number");
    int num1 = scan.nextInt();
    System.out.println("Second number");
    int num2 = scan.nextInt();
    System.out.println("\nThe polynomials add together into the polynomial: " + list1.add(list2));
    System.out.println("The first polynomial with the first number equates to " + list1.evaluate(num1));
    System.out.println("The first polynomial with the second number equates to " + list1.evaluate(num2));
    System.out.println("The second polynomial with the first number equates to " + list2.evaluate(num1));
    System.out.println("The second polynomial with the second number equates to " + list2.evaluate(num2));
  }
}