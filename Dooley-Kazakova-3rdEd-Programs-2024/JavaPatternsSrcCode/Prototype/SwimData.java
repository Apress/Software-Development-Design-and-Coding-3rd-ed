import java.util.*;
import java.io.*;

public class SwimData
   implements Cloneable , Serializable
{
  protected Vector swimmers;
  public SwimData(String filename)
  {
     String s = "";
     swimmers = new Vector();
     InputFile f = new InputFile(filename);
     s= f.readLine();
     while(s != null)
     {
        swimmers.addElement(new Swimmer(s));
        s= f.readLine();
     }
     f.close();
  }
  //-------------------------------------------
  public int size()
  {
     return swimmers.size();
  }
 //-------------------------------------------
  public Swimmer getSwimmer(int i)
  {
     if ( (i >= 0) && (i<swimmers.size()) )
        return (Swimmer)swimmers.elementAt(i);
     else
        return  null;
  }
  //-------------------------------------------
  public void sortByTime()
  {
     Swimmer sw;
     int i, j;
     int max = swimmers.size();
     Swimmer sd[] = new Swimmer[max];
     for( i =0; i< max; i++)
        sd[i] = (Swimmer)swimmers.elementAt(i);
     for (i =0; i< max; i++) 
        {
        for(j = i; j <max; j++)
         {
           if (sd[i].getTime() > sd[j].getTime()) 
              {
              sw= sd[i];
              sd[i] = sd[j];
              sd[j]= sw;
              }
         }
        }    
  // swimmers = new Vector();
     swimmers.removeAllElements();
   for(i = 0; i < max; i++)
      swimmers.addElement(sd[i]);
  }
  //-------------------------------------------
  public Object deepClone()
  {
    try{
     ByteArrayOutputStream b = new ByteArrayOutputStream();
     
     ObjectOutputStream out = new ObjectOutputStream(b);
     
     out.writeObject(this);
     ByteArrayInputStream bIn = new ByteArrayInputStream(b.toByteArray());
     
     ObjectInputStream oi = new ObjectInputStream(bIn);
     
     return (oi.readObject());
    }
    catch (Exception e)
    {  System.out.println("exception:"+e.getMessage());
    e.printStackTrace();
    return null;
    }
    
  }
  //-------------------------------------------
  public Object clone()
  {
     try{
      return super.clone();
     }
     catch(Exception e)
     {System.out.println(e.getMessage());
     return null;
     }
  }
}
//==============================================
class Swimmer implements Serializable
{  String name;
   int age;
   String club;
   float time;
   boolean female;

   public Swimmer(String dataline)
   {
   StringTokenizer st = new StringTokenizer(dataline, ",");
   name = st.nextToken();
   age = new Integer(st.nextToken().trim()).intValue();
   club = st.nextToken().trim();
   time = new Float(st.nextToken().trim()).floatValue();
   //System.out.println(name+" "+time);
   String sx = st.nextToken().trim().toUpperCase();
   female = sx.equals("F");
   }
   public boolean isFemale()
   {
      return female;
   }
   public int getAge()
   {
      return age;
   }
   public float getTime()
   {
      return time;
   }
   public String getName()
   {
      return name;
   }
   public String getClub()
   {
      return club;
   }
}
