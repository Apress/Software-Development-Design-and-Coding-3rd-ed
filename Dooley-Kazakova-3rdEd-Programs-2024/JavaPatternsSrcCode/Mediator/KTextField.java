import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class KTextField extends JTextField
{
 Mediator med;
 public KTextField(Mediator md)
 {
    super(10);
    med = md;
    med.registerText(this);
 }
}
