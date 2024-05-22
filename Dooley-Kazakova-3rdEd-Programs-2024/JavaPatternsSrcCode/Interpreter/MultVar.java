import java.util.*;
public class MultVar extends ParseVar
{
 Vector multVec;
 
public MultVar(ParseObject v1, ParseObject v2)
{
   super("");
   multVec = new Vector();
   multVec.addElement(v1);
   multVec.addElement(v2);
   type = MULTVAR;
}   
public MultVar()
{
   super("");
   multVec = new Vector();
   type = MULTVAR;
 
}
public void add(ParseObject v1)
{
   multVec.addElement(v1);
}
public Vector getVector()
{
   return multVec;
}

}
