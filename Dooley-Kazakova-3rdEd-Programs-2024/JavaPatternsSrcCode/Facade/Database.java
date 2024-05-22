import java.sql.*;
import java.util.*;

class Database
{
Connection con;
resultSet results;
ResultSetMetaData rsmd;
DatabaseMetaData dma;
String catalog;
String types[];
String database_url;

   public Database(String driver)
   {
    types = new String[1];
    types[0] = "TABLES";         //initialize type array
    try{Class.forName(driver);}  //load the Bridge driver
    catch (Exception e)
    {System.out.println(e.getMessage());}
   }
   //-----------------------------------
   public void close()
   { 
      try{
      con.close();}
      catch (Exception e)
      {System.out.println("close error");}
      
   }
   //-----------------------------------

   public void Open(String url, String cat)
   {
    catalog = cat;
    database_url = url;
    try {con = DriverManager.getConnection(url);
    dma =con.getMetaData();   //get the meta data
    }
    catch (Exception e)
    {System.out.println(e.getMessage());}
   }
   //-----------------------------------
   public void reOpen()
   {                                     
     try {con = DriverManager.getConnection(database_url);
    dma =con.getMetaData();   //get the meta data
    }
    catch (Exception e)
    {System.out.println(e.getMessage());}
   }
   //-----------------------------------
   public String[] getTableNames()
   {
    String[] tbnames = null;
    Vector tname = new Vector();
    //add the table names to a Vector
    //since we don't know how many there are
    try {
      results = new resultSet(dma.getTables(catalog, null, "%", types));
      }
     catch (Exception e) {System.out.println(e);} 
      
     while (results.hasMoreElements())
         tname.addElement(results.getColumnValue("TABLE_NAME"));
      
     
     //copy the table names into a String array
      tbnames = new String[tname.size()];
      for (int i=0; i< tname.size(); i++) 
         tbnames[i] = (String)tname.elementAt(i);
      return tbnames;
   }
   //-----------------------------------
   public String[] getTableMetaData()
   {
      // return the table type information
      results = null;
      try{
      results = new resultSet(dma.getTables(catalog, null, "%", types));
      }
      catch (Exception e)
      {System.out.println(e.getMessage());}
      return results.getMetaData();
   }
   //-----------------------------------
   public String[] getColumnMetaData(String tablename)
   {
    //return the data on a column
    results = null;
    try {
    results = new resultSet(dma.getColumns(catalog, null, tablename, null));
    }
    catch (Exception e)
   {System.out.println(e.getMessage());}
    return results.getMetaData();
   }
   //-----------------------------------
   public String[] getColumnNames(String table)
   {
   //return an array of Column names
   String[] tbnames = null;
   Vector tname = new Vector();

   try {
    results = new resultSet(dma.getColumns(catalog, null, table, null));
    while (results.hasMoreElements() )
       tname.addElement(results.getColumnValue("COLUMN_NAME"));  
      }
   catch (Exception e) {System.out.println(e);}

   tbnames = new String[tname.size()];
   for (int i=0; i< tname.size(); i++) 
      tbnames[i] = (String)tname.elementAt(i);
   return tbnames;
   } 
//-----------------------------------
   public String getColumnValue(String table, String columnName)
   {
   //return the value of a given column 
   String res = null;
   try 
     {
      if (table.length()>0) 
         results = Execute("Select "+columnName+" from "+table+" order by "+columnName);
      if (results.hasMoreElements())
         res = results.getColumnValue(columnName);
     }
   catch (Exception e)
   {System.out.println("Column value error" +columnName+ e.getMessage());}

   return res;
   }
//-----------------------------------
   public String getNextValue(String columnName)
   {
   // return the next value in that column
   //using the remembered resultSet
      String res = "";
   try 
     {
      if (results.hasMoreElements())
         res = results.getColumnValue(columnName);
     }
   catch (Exception e)
   {System.out.println("next value error"+columnName+ e.getMessage());}

   return res;
 }
//-----------------------------------
   public resultSet Execute(String sql)
   {
   //execute an SQL query on this database
   results = null;
   try
      {
      Statement stmt = con.createStatement();
      results = new resultSet(stmt.executeQuery(sql));
    }
    catch (Exception e)
      {System.out.println("execute error: "+e.getMessage());}
   return results;
   }
}

