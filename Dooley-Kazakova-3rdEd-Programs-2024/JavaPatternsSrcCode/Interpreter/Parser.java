import java.util.*;

public class Parser implements Command
{
   Stack stk;
   Vector actionList;
   KidData kdata;
   Data data;
   //PrintTable ptable;
   JawtList ptable;

   public Parser(String line)
   {
      stk = new Stack();
      actionList = new Vector();

      StringTokenizer tok = new StringTokenizer(line);
      while(tok.hasMoreElements())
      {
         ParseObject token = tokenize(tok.nextToken());
         if(token != null)
            stk.push(token);
      }
   }           
   //----------------------------------------
   public void setData(KidData k, JawtList pt)
   {
      data = new Data(k.getData());
      ptable = pt;
   }
   //----------------------------------------
   //executes parse of command line
   public void Execute()
   {
    
    while(stk.hasMoreElements())
    {
     
     if(topStack(ParseObject.VAR, ParseObject.VAR))
     {
       //reduce (Var Var) to Multvar
       ParseVar v = (ParseVar)stk.pop();
       ParseVar v1 = (ParseVar)stk.pop();
       MultVar mv = new MultVar(v1, v);
       stk.push(mv);
       }
     //reduce MULTVAR VAR to MULTVAR
    if(topStack(ParseObject.MULTVAR, ParseObject.VAR))
    {
       MultVar mv =  new MultVar();
       MultVar mvo = (MultVar)stk.pop();
       ParseVar v = (ParseVar)stk.pop();
       mv.add(v);
       Vector mvec = mvo.getVector();
       for (int i = 0; i< mvec.size(); i++)
          mv.add((ParseVar)mvec.elementAt(i));
       stk.push(mv);
    }
    if(topStack(ParseObject.VAR, ParseObject.MULTVAR))
      {
     //reduce (Multvar Var) to Multvar
        ParseVar v = (ParseVar)stk.pop();
        MultVar mv = (MultVar)stk.pop();
        mv.add(v);
        stk.push(mv);
        }
     //reduce Verb Var to Verb containing vars
     if (topStack(ParseObject.VAR, ParseObject.VERB)) 
        {
        addArgsToVerb();
        }
     //reduce Verb MultVar to Verb containing vars
     if (topStack(ParseObject.MULTVAR, ParseObject.VERB)) 
        {
        addArgsToVerb();
        }
     //move top verb to action list
     if(stk.top().getType() == ParseObject.VERB)
     {
          actionList.addElement(stk.pop());
     }
     
    }//while
    //now execute the verbs
    //data.setData(kdata.getData());
    //for (int i = actionList.size() -1; i >= 0; i--)
    for (int i =0; i< actionList.size() ; i++)
    {
      Verb v = (Verb)actionList.elementAt(i);
      v.setData(data, ptable);
      v.Execute();
    }
   }
   //----------------------------------------
   private void addArgsToVerb()
   {
      ParseObject v = stk.pop();
        ParseVerb verb = (ParseVerb)stk.pop();
        verb.addArgs(v);
        stk.push(verb);
   }
   //----------------------------------------
   private boolean topStack(int c1, int c2)
   {
      return (stk.top().getType() == c1) && (stk.nextTop().getType()== c2);
   }
   //----------------------------------------
      private ParseObject tokenize(String s)
      {
         ParseObject obj = getVerb(s);
         if (obj == null)
            obj = getVar(s);
         return obj;
      }
//----------------------------------------
      private ParseVerb getVerb(String s)
      {
         ParseVerb v;
         v = new ParseVerb(s);
         if (v.isLegal()) 
            return v.getVerb(s);
        else
            return null;
      }
//----------------------------------------
      private ParseVar getVar(String s)
      {
         ParseVar v;
         v = new ParseVar(s);
         if (v.isLegal()) 
            return v;
         else
            return null;
      }
   
}
