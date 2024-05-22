import java.util.*;

public class kidIter 
   implements Enumeration
{
   String clubMask;
   int index;
   Kid kid;
   Enumeration ke;
   KidData kdata;
//----------------------------------------
   public kidIter(KidData kd, String club)
   {
      clubMask = club;
      kdata = kd;
      index = 0;
      kid = null;
      ke = kdata.elements();
   }
//----------------------------------------
   public boolean hasMoreElements()
   {
      boolean found = false;
      while(ke.hasMoreElements() && ! found)
      {
      kid = (Kid)ke.nextElement();
      found = kid.getClub().equals(clubMask);
      }
      if(!found) kid = null;
      return found;
   }
//----------------------------------------
   public Object nextElement()
   {
      if(kid != null)
         return kid;
      else
         throw new NoSuchElementException();
   }
}

