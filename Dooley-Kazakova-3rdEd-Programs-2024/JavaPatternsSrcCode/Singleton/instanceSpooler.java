public class instanceSpooler
{
   static public void main(String argv[])
   {
      iSpooler pr1, pr2;
      //open one printer--this should always work
      System.out.println("Opening one spooler");
      pr1 = iSpooler.Instance();
      if(pr1 != null)
         System.out.println("got 1 spooler");
      //try to open another printer --should fail
      System.out.println("Opening two spoolers");
      
      pr2 = iSpooler.Instance();
      if(pr2 == null)
         System.out.println("no instance available");
      //fails because constructor is privatized
      //iSpooler pr3 = new iSpooler(); 
   }
}


