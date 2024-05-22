import java.util.*;

public class Kid
{
   String frname, lname, club;
   int age;
   float time;
//-------------------------------------
 public Kid(String line)
 {
   StringTokenizer tok = new StringTokenizer(line);
   
   String lnum = tok.nextToken();
   frname=tok.nextToken();
   lname = tok.nextToken();
   age = new Integer(tok.nextToken()).intValue();
   club = tok.nextToken();
   time = new Float(tok.nextToken()).floatValue();
 }
 //-------------------------------
 public Object getData(int key)
 {
    switch(key)
    {
    case ParseVar.FRNAME:
         return frname;
    case ParseVar.LNAME:
         return lname;
    case ParseVar.CLUB:
         return club;
    case ParseVar.AGE:
         return new Integer(age);
    case ParseVar.TIME:
         return new Float(time);
    }

  return null;
 }
 //--------------------------------
 public int getAge() { return age;}
 public float getTime() {return time;}
 public String getFrname() {return frname;}
 public String getLname(){return lname;}
 public String getClub() {return club;}
}
