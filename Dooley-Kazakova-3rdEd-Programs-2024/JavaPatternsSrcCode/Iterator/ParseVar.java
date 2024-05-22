public class ParseVar extends ParseObject
{
   static final int FRNAME=0, LNAME=1, AGE=2, CLUB=3, TIME=4, tabMAX=5;
   
public ParseVar(String s)
{
   s = s.toLowerCase();
   value = -1;
   type = VAR;
   if (s.equals("frname")) value = FRNAME;
   if (s.equals("lname")) value = LNAME;
   if (s.equals("age")) value = AGE;
   if (s.equals("club")) value = CLUB;
   if (s.equals("time")) value = TIME;
}
//--------------------------------------
public boolean isLegal()
{
   return (value >= 0);
}
}
