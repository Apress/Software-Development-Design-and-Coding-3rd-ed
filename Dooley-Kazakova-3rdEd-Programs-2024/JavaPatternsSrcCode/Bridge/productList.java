import java.util.*;

public class productList extends JawtList
{
   public productList(Vector products)
   {
      super(products.size());    //for compatibility
      for (int i = 0; i < products.size(); i++)
      {
         //take each strig apart and keep only
         //the product names, discarding the quntities
         String s = (String)products.elementAt(i);
         int index = s.indexOf("--");  //separate qty from name
         if(index > 0)
            add(s.substring(0, index));
         else
            add(s);
      }
   }
}
