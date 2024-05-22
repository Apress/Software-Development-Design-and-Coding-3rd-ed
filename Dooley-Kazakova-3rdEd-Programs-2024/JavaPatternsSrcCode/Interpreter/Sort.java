import java.util.*;

public class Sort extends Verb
{
   Kid[] kids;
   int pindex;
public Sort(String s)
{
   super(s);
   value = SORTBY;
}
//-----------------------------------

public void Execute()
{
int sortKey;

kids = data.getData();

for(int a=0; a< args.size(); a++)
   {   
   ParseVar v = (ParseVar)args.elementAt(a);
   if(v instanceof MultVar)
   {
      MultVar mv = (MultVar)v;
      Vector mvec = mv.getVector();
      for (int k = mvec.size()-1; k >=0; k--)
      {
         ParseVar pv = (ParseVar)mvec.elementAt(k);
         sortKey =pv.getValue();
         sortByKey(sortKey);
      }
   }
   else
   {
   sortKey = v.getValue();
   sortByKey(sortKey);
   }                                                        
  }
   
} 
//----------------------------------------
private void sortByKey(int sortkey)
{
System.out.println(sortkey);
 for(int i = 0; i < kids.length; i++)
   for(int j = i + 1; j < kids.length; j++)
     if (compare(i, j, sortkey))
        {
        Kid tmp = kids[i];
        kids[i] =kids[j];
        kids[j] = tmp;
        }
}
//----------------------------------------
private boolean compare(int i, int j, int key)
{
   boolean cval;

   switch(key)
   {
   case ParseVar.FRNAME:
      cval = kids[i].getFrname().compareTo(kids[j].getFrname()) > 0;
      break;
   case ParseVar.LNAME:
      cval = kids[i].getLname().compareTo(kids[j].getLname()) > 0;
      break;
   case ParseVar.CLUB:
      cval = kids[i].getClub().compareTo(kids[j].getClub()) > 0;
      break;
   case ParseVar.AGE:
      cval = kids[i].getAge() > kids[j].getAge();
      break;
   case ParseVar.TIME:
      cval = kids[i].getTime() > kids[j].getTime();
      break;
   default:
      cval=false;
   }
 return cval;
}


}
