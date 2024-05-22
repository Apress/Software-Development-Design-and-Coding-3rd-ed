import java.io.*;
public class XFile extends File
{
  public XFile(String filename)
  {
    super(filename);
  }
  //---------------------------------------
  public String getRoot()
  {
     String name = getName();
     int i = name.lastIndexOf(".");
     if(i > 0)
        name = name.substring(0, i);
     
     return name;
  }
  //---------------------------------------
  public boolean matchRoot(String filename)
  {
     String root = getRoot().toLowerCase();
     String fname = filename.toLowerCase();
     return fname.equals(root);
  }
  //---------------------------------------
  public boolean matchName(String filename)
  {
       return filename.toLowerCase().equals(getName().toLowerCase());
  }
}
