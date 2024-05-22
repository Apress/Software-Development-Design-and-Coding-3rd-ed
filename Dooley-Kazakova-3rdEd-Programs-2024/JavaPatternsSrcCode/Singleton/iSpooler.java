class iSpooler 
{
   //this is a prototype for a printer-spooler class
   //such that only one instance can ever exist
   static boolean instance_flag = false; //true if 1 instance

   private iSpooler() 
   {
   }
   static public iSpooler Instance()
   {
      if (! instance_flag)
      {
         instance_flag = true;
         return new iSpooler();
      }
      else
         return null;      
   }
   //-------------------------------------------
   public void finalize()
   {
      instance_flag = false;
   }
}                                                        

