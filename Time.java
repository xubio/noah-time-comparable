/*
 * AP CS MOOC
 * Term 2 - Assignment 1: Time
 * A class which represents the time of day in hours and seconds.
 */

public class Time
{
     private int hour;
     private int minute;

     /* Complete required constructors and methods here */

     /*
      *Default constructor that sets time to 1200.  
      */ 
     public Time()
     {
       this(12, 00);
     }

     /*
      * If h is between 1 and 23 inclusive, set the hour to h. 
      * Otherwise, set the hour to 0. If m is between 0 and 59 inclusive, 
      * set the minutes to m. Otherwise, set the minutes to 0. 
      */ 
     public Time(int h, int m)
     {
       hour = 0;
       minute = 0;

       if(h >= 1 && h <= 23)
         hour = h;

    if(m <= 59 && m >= 0)
      minute = m;
     }

     /* Returns the time as a String of length 4 in the format: 0819. 
      * Notice that if the hour or minute is one digit, it should 
      * print a zero first. For example, 6 should print as 06.
     */
     public String toString()
     {
       String temp = "";
       
       if(hour < 10)
       {
         if(hour == 0)
           temp = "00";
         else
           temp = "0" + hour;
       }
       else
       temp = "" + hour;
       
       if(minute < 10)
       {
         if(minute == 0)
           temp = temp + "00";
         else
           temp = temp + "0" + minute;
       }
       else
         temp = temp + minute;

       return temp;
     }

     /*
      * Returns the time as a String converted from military time 
      * to standard time. For example, 0545 becomes 5:45 am and 
      * 1306 becomes 1:06 pm.
      */ 
     public String convert()
     {
       String temp = "";

       if(minute < 10)
       {
         if(minute == 0)
           temp = ":" + "00";
         else
           temp = ":" + 0 + minute;
       }
       else
         temp = ":" + minute;

       if(hour == 0)
         temp = "" + 12 + temp + " am";
       else if(hour > 12)
         temp = "" + (hour - 12) + temp + " pm";
       else if(hour == 12)
         temp = "" + 12 + temp + " pm";
       else if(hour > 10)
         temp = "" + 0 + hour + temp + "am";
       else
         temp = "" + hour + temp + " am";
 /*   
       if (hour > 12)
         temp = "" + (hour - 12) + minute;
   */    
       return temp;
     }

    /*
     * Advances the time by one minute. 
     * Remember that 60 minutes = 1 hour. 
     * Therefore, if your time was 0359, and you add one minute, 
     * it becomes 0400. 2359 should increment to 0000.
     */ 
    public void increment()
    {
      minute++;

      if(minute == 60)
      {
        hour++;
        minute = 0;
      }

      if(hour == 24)
        hour = 0;
    }
    
    public int compareTo(Object other)
     {
      //int time = (hour*100) + minute;
      
      if(other > Time)
        return -1;
      
      if(other.equals(Time))
        return 0;
      
        return 1;
       //Returns -1 if current time is less than other.
       //Returns 0 if current time is equal to other.
       //Returns 1 if current time is greater than other.
     }
     
     String difference(Time t)
     {
       t.hour = t.hour - hour;
       t.minute = t.minute - minute;
       
       if(t.hour < 0)
         t.hour = t.hour + (t.hour * 2);
       
       if(t.minute < 0)
         t.minute = t.minute + (t.minute * 2);
       
       return t.toString();
       //Returns a String holding the difference between the current time and
       //the Time t passed in via parameter.  All values should be positive,
       //and in the format:
       //08:09
       //10:35
     }

}