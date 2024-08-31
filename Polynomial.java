import java.util.ArrayList;

class Polynomial
{
  Node head;
  
  static class Node
  {
    private int coefficient;
    private int power;
    private Node next;
    
    Node(int c, int p)
    {
      coefficient = c;
      power = p;
      next = null;
    }
  }

  public void enqueue(int c, int p)
  {
    Node next = new Node(c, p);
    if(this.head == null)
    {
      this.head = next;
    }
    else
    {
      Node last = this.head;
      while(last.next != null)
      {
        last = last.next;
      }
      last.next = next;
    }
  }

  public String add(Polynomial other)
  {
    String returnStr  = "";
    ArrayList<Integer> usedPowers = new ArrayList<Integer>();
    Polynomial totalList = new Polynomial();
    Node counter = this.head;
    while(counter != null)
    {
      totalList.enqueue(counter.coefficient, counter.power);
      usedPowers.add(counter.power);
      counter = counter.next;
    }
    counter = other.head;
    while(counter != null)
    {
      int repeatedPowerIndex = -1;
      for(int i = 0; i < usedPowers.size(); i++)
      {
        if(counter.power == usedPowers.get(i))
        {
          repeatedPowerIndex = i;
        }
      }
      if(repeatedPowerIndex == -1)
      {
        totalList.enqueue(counter.coefficient, counter.power);
        usedPowers.add(counter.power);
      }
      else
      {
        Node changing = totalList.head;
        for(int i = 0; i < repeatedPowerIndex; i++)
        {
          changing = changing.next;
        }
        changing.coefficient += counter.coefficient;
      }
      counter = counter.next;
    }
    int fullSize = usedPowers.size();
    int greatestPowIndex = 0;
    Node selected = totalList.head;
    for(int o = 0; o < fullSize; o++)
    {
      greatestPowIndex = 0;
      for(int i = 1; i < usedPowers.size(); i++)
      {
        if(usedPowers.get(greatestPowIndex) < usedPowers.get(i))
        {
          greatestPowIndex = i;
        }
      }
      selected = totalList.head;
      for(int i = 0; i < greatestPowIndex; i++)
      {
        selected = selected.next;
      }
      if(selected.coefficient > 1)
      {
        returnStr += " + " + selected.coefficient;
      }
      else if(selected.coefficient < 0)
      {
        if(returnStr.equals(""))
        {
          returnStr = "   " + selected.coefficient;
        }
        else
        {
          returnStr += " - " + (selected.coefficient * -1);
        }
      }
      if(selected.power > 1 || selected.power < 0)
      {
        returnStr += "x^" + selected.power;
      }
      else if(selected.power == 1)
      {
        if(selected.coefficient == 1)
        {
          returnStr += " + ";
        }
        returnStr += "x";
      }
      if(selected.coefficient == 1 && selected.power == 0)
      {
        returnStr += " + 1";
      }
      usedPowers.set(greatestPowIndex, -1);
    }
    return returnStr.substring(3);
  }

  public int evaluate(int num)
  {
    int total = 0;
    Node adder = this.head;
    while(adder != null)
    {
      total += (Math.pow(num, adder.power)) * adder.coefficient;
      adder = adder.next;
    }
    return total;
  }
}