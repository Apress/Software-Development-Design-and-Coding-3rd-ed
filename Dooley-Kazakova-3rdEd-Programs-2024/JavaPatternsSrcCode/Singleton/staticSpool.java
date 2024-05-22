final class Spooler
{
 //a static class implementation of Singleton pattern
 static public void print(String s)
 {
 System.out.println(s);
 }
}
//==============================
public class staticSpool
{
   public static void main(String argv[])
   {
      Printer.print("here it is");
   }
}
