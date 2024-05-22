import java.util.*;

public class kidClub
   implements Enumeration
{
   String clubMask;     //name of club
   Kid kid;             //next kid to return
   Enumeration ke;      //gets all kids
   KidData kdata;       //class containing kids
//----------------------------------------
   public kidClub(KidData kd, String club)
   {
      clubMask = club;     //save the club
      kdata = kd;          //copy the class
      kid = null;          //default
      ke = kdata.elements();  //get Enumerator
   }
//----------------------------------------
   public boolean hasMoreElements()
   {
   //return true if there are any more kids 
   //belonging to the specified club
   boolean found = false;
   while(ke.hasMoreElements() && ! found)
      {
      kid = (Kid)ke.nextElement();
      found = kid.getClub().equals(clubMask);
      }
   if(! found) 
      kid = null;    //set to null if none left
   return found;
   }
//----------------------------------------
   public Object nextElement()
   {
      if(kid != null)
         return kid;
      else
         //throw exception if access past end
         throw new NoSuchElementException();
   }
}

