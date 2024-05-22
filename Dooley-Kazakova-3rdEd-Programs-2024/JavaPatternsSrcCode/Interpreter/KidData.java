import java.util.*;
public class KidData
{
   Vector kids;
//------------------------------------------   
   public KidData(String filename)
   {
      kids = new Vector();
      InputFile f = new InputFile(filename);
      String s = f.readLine();
      while(s != null)
      {
         if(s.trim().length() > 0)
         {
         Kid k = new Kid(s);
         kids.addElement(k);
         }
         s = f.readLine();
      }
   }
   //--------------------------------
   public Kid[] getData()
   {
      Kid[] kd = new Kid[kids.size()];
      for(int i=0; i< kids.size(); i++)
         kd[i] = (Kid)kids.elementAt(i);
   return kd;
   }
   //--------------------------------

   public int size()
   {
      return kids.size();
   }
   //--------------------------------
   public Kid getKid(int i)
   {
      return (Kid)kids.elementAt(i);
   }
   //--------------------------------
   public Vector getKidData(int key)
   {
      Vector v = new Vector();
      for (int i = 0; i < kids.size(); i++)
         v.addElement(getKid(i).getData(key));
   return v;
   }
   //--------------------------------
   public int getTableKey(String tabName)
   {
      int key = -1;
      tabName = tabName.toLowerCase();
      if(tabName.equals("frname")) key = ParseVar.FRNAME;
      if(tabName.equals("lname")) key =  ParseVar.LNAME;
      if(tabName.equals("age")) key =    ParseVar.AGE;
      if(tabName.equals("club")) key =   ParseVar.CLUB;
      if(tabName.equals("time")) key =   ParseVar.TIME;

      return key;
   }
   //----------------------------
   public String getTableName(int i)
   {
     String name = ""; 
      switch(i)
      {
      case ParseVar.FRNAME:
           name = "frname";
         case ParseVar.LNAME:
            name = "lname";
         case ParseVar.AGE:
            name="age";
         case ParseVar.CLUB:
            name="club";
         case ParseVar.TIME:
            name="time";
      }
    return name;
   }
   //----------------------------
  
}

