public class FlyTest
{
public FlyTest()
{
   Integer five = new Integer(5);
   Integer myfive = new Integer(5);
   System.out.println(five == myfive);
   String fred=new String("fred");
   String fred1 = new String("fred");
   System.out.println(fred == fred1);
}
static public void main(String[] argv)
{
   new FlyTest();
}
}
