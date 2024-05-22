import java.sql.*;
class resultSet
{
//this class is a higher level abstraction
//of the JDBC ResultSet object
   ResultSet rs;
   ResultSetMetaData rsmd;
   int numCols;

   public resultSet(ResultSet rset)
   {
      rs = rset;
      try
      {
      //get the meta data and column count at once
      rsmd = rs.getMetaData();
      numCols = rsmd.getColumnCount();
      }
      catch (Exception e)
      {System.out.println("resultset error"+e.getMessage());}
   }
   //-----------------------------------
   public String[] getMetaData()
   {
    //returns an array of all the column names
    //or other meta data
      String md[] = new String[numCols];
      try
         {
      for (int i=1; i<= numCols; i++) 
         md[i-1] = rsmd.getColumnName(i);
      }
      catch (Exception e)
      {System.out.println("meta data error"+e.getMessage());}
      return md;
   }
   //-----------------------------------
   public boolean hasMoreElements()
   {
      try{
      return rs.next();
      }
   catch(Exception e){
      System.out.println("next error "+e.getMessage());
      return false;}
   }
   //-----------------------------------
   public String[] nextElement()
   {
   //copies contents of row into string array
      String[] row = new String[numCols];
      try
      {
      for (int i = 1; i <= numCols; i++) 
            row[i-1] = rs.getString(i);
      }
      catch (Exception e)
      {System.out.println("next element error"+e.getMessage());}
    return row;
   }
   //-------------------------------------
   public String getColumnValue(String columnName)
   {
   String res = "";
     try 
     {
     res = rs.getString(columnName);
     }
   catch (Exception e)
   {System.out.println("Column value error:"+columnName+e.getMessage());}
   return res;
   }
   //-------------------------------------
   public String getColumnValue(int i)
   {
   String res = "";
     try 
     {
     res = rs.getString(i);
     }
   catch (Exception e)
   {System.out.println("Column value error: " + i + " " + e.getMessage());}
   return res;
   }
   //----------------------------------------------
   public void finalize()
   {
    try{rs.close();}
    catch (Exception e)
      {System.out.println(e.getMessage());}
   }
}
