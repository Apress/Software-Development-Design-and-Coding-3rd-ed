class Printer 
{
   //this is a prototype for a printer-spooler class
   //such that only one instance can ever exist
   static boolean instance_flag=false; //true if 1 instance

   public Printer() throws SingletonException
   {
      if (instance_flag) 
         throw new SingletonException("Only one printer allowed");    
      else
         instance_flag=true;     //set flag for 1 instance
      System.out.println("printer opened");
   }
   //-------------------------------------------
   public void finalize()
   {
      instance_flag = false;
   }
}                                                        
//===============================================
class SingletonException extends RuntimeException
{      
   //new exception type for singleton classes
   public SingletonException()
   {
      super();
   }
//-----------------------------------------------
   public SingletonException(String s)
   {
      super(s);
   }
}
//===============================================
public class singlePrinter
{
   static public void main(String argv[])
   {
      Printer pr1, pr2;
      //open one printer--this should always work
      System.out.println("Opening one printer");
      try{
      pr1 = new Printer();
      }
      catch (SingletonException e)
      {System.out.println(e.getMessage());}
      //try to open another printer --should fail
      System.out.println("Opening two printers");
      try{
      pr2 = new Printer();
      }
      catch (SingletonException e)
      {System.out.println(e.getMessage());}
   }
}

