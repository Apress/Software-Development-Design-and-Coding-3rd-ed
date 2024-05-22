import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PickedKidsList extends JawtList
{
   Mediator med;
   public PickedKidsList(Mediator md)
   {
      super(20);
      med = md;
      med.registerPicked(this);
   }
}
