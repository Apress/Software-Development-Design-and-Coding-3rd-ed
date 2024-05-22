public class Verb extends ParseVerb implements Command
{
   protected Data data;
   protected JawtList ptable;

   public Verb(String s)
   {
      super(s);
   }
   public void Execute()
   {
   }
   public void setData(Data dt, JawtList pt)
   {
      data = dt;
      ptable = pt;
   }
}
