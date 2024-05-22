import java.util.*;
public class Stack
{
   Vector stk;
public Stack()
   {
     stk = new Vector();
   }
//----------------------------------------
public void push(Object obj)
{
   stk.addElement(obj);
}
//----------------------------------------
public ParseObject pop()
{
   ParseObject obj = (ParseObject)stk.lastElement();
   int i = stk.size() - 1;
   stk.removeElementAt(i);
   return obj;
}
//----------------------------------------
public void dump(String s)
{
   System.out.println(s);
   dump();
}
//----------------------------------------

public void dump()
{
   for(int i=0; i< stk.size(); i++)
   {
      ParseObject p =(ParseObject)stk.elementAt(i);
      System.out.println(i+" "+p.getType());
   }
}
//----------------------------------------
public ParseObject top()
{
   return (ParseObject)stk.lastElement();
}
//----------------------------------------
public boolean hasMoreElements()
{
   return (stk.size() >0);
}
//----------------------------------------
public ParseObject nextTop()
{
   int i = stk.size();
   if (i > 1) 
      {
      return (ParseObject)stk.elementAt(i - 2);
      }
   else
      return null;
}
//----------------------------------------
public void pop2Push(ParseObject p)
 {
  int i = stk.size();
  if(i >=2)
  {
     pop();
     pop();
     push(p);
  }
  else
     push(p);
 }
}

