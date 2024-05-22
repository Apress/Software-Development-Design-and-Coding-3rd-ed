import java.util.*;
public class Print extends Verb
{
   Kid[] kids;
   
 public Print(String s)
{
   super(s);
   value = PRINT;
}

//-----------------------------------
public void Execute()
{
   String pline;

   kids = data.getData();
   //ptable.setDims(kids.length, args.size());
   ptable.clear();

   for (int i=0; i < kids.length; i++) 
   {
      pline = "";    //line in output list
      for (int j = 0; j < args.size(); j++)
      {
         
         ParseVar v = (ParseVar)args.elementAt(j);
         if(v instanceof MultVar)
         {  
            MultVar mv = (MultVar)v;
            Vector vlist = mv.getVector();
            for(int k=0; k < vlist.size(); k++)
            {
            ParseVar pv = (ParseVar)vlist.elementAt(k);
            //System.out.print(kids[i].getData(pv.getValue())+"   ");
            pline+= kids[i].getData(pv.getValue()) + "   ";
            }
         }
         else
         {
        // System.out.print(kids[i].getData(v.getValue())+"   ");
         //ptable.setValueAt( kids[i].getData(v.getValue()), i, j);
         pline+= kids[i].getData(v.getValue()) + "   ";
         }
      }
      ptable.add(pline);
      //System.out.println();
   }
   ptable.validate();
   ptable.repaint();
}
//-----------------------------------

}
