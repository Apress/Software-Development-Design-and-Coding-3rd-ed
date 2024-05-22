import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public abstract class ActionButton extends AbstractAction
{
   Hashtable properties;

   public ActionButton(String caption, Icon img)
   {
      properties = new Hashtable();
      properties.put(DEFAULT, caption);
      properties.put(NAME, caption);
      properties.put(SHORT_DESCRIPTION, caption);
      
      properties.put(SMALL_ICON, img);
   }
   public void putValue(String key, Object value)
   {
      properties.put(key, value);
   }
   public Object getValue(String key)
   {
      return properties.get(key);
   }
   public abstract void actionPerformed(ActionEvent e);
}
