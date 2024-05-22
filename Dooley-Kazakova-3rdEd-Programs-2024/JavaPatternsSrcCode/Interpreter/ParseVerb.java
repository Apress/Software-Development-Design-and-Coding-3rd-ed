import java.util.*;

public class ParseVerb extends ParseObject
{
   static public final int PRINT=100, SORTBY=110, THENBY=120;
   protected Vector args;
   
public ParseVerb(String s)
{
   args = new Vector();
   s = s.toLowerCase();
   value = -1;
   type = VERB;
   if (s.equals("print")) value = PRINT;
   if (s.equals("sortby")) value = SORTBY;
}
//-----------------------------------
public ParseVerb getVerb(String s)
{
   switch(value)
   {
   case PRINT:
        return new Print(s);
      case SORTBY:
         return new Sort(s);
   }
return null;
}
//-----------------------------------
public void addArgs(MultVar mv)
{
   args = mv.getVector();;
}
//-----------------------------------
public void addArgs(ParseObject p)
{
   args.addElement(p);
}
//-----------------------------------
public boolean isLegal()
{
   return (value >= 0);
}

//-----------------------------------
}
