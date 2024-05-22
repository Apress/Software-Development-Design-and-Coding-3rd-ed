import java.net.URL;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class dbFrame extends Frame
   implements ActionListener, ItemListener
{
   Database db;
   List Tables, Columns, Data;
   TextArea query;
   Button Search, Quit;
   public dbFrame()
   {
      super("Database demonstration");
      setGUI();

      db = new Database("sun.jdbc.odbc.JdbcOdbcDriver");
      db.Open("jdbc:odbc:Grocery prices", null);
      
      String tnames[] = db.getTableNames();
      loadList(Tables, tnames);
      
      String queryText ="SELECT DISTINCTROW FoodName, StoreName, Price "+
      "FROM (Food INNER JOIN FoodPrice ON Food.FoodKey = FoodPrice.FoodKey) " +
      "INNER JOIN Stores ON FoodPrice.StoreKey = Stores.StoreKey "+
      "WHERE (((Food.FoodName)=\'Oranges\')) ORDER BY FoodPrice.Price;";

      query.setText(queryText);
    }
   //------------------------------------
   private void setGUI()
   {
      setBackground(Color.lightGray);
      setLayout(new BorderLayout());
      Panel pn = new Panel();
      add("North", pn);
      pn.setLayout(new GridLayout(1,3));
      pn.add(new Label("Tables"));
      pn.add(new Label("Columns"));
      pn.add(new Label("Data"));
      Panel pc = new Panel();
      add("Center", pc);
      pc.setLayout(new GridLayout(1,3));
      pc.add(Tables = new List(15));
      pc.add(Columns = new List(15));
      pc.add(Data = new List(15));
      Tables.addItemListener(this);
      Columns.addItemListener(this);

      Panel ps = new Panel();
      add("South", ps);
      ps.add(query = new TextArea("", 3,40));
      addPanel(ps, Search = new Button("Run Query"));
      addPanel(ps, Quit = new Button("Quit"));
      Search.addActionListener(this);
      Quit.addActionListener(this);
      setBounds(100, 100, 500, 300);
      setVisible(true);
   }
   //------------------------------------
   private void addPanel(Panel ps, Component c)
   {
      Panel p = new Panel();
      ps.add(p);
      p.add(c);
   }
   //------------------------------------
   private void loadList(List list, String[] s)
   {
    list.removeAll();
    for (int i=0; i< s.length; i++)
         list.add(s[i]);
   }
   //------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Object obj = e.getSource();
      if (obj == Quit) 
         System.exit(0);
      if (obj == Search) 
         clickedSearch();
   }
   //------------------------------------
   public void itemStateChanged(ItemEvent e)
   {
      Object obj = e.getSource();
      if (obj == Tables) 
         showColumns();
      if (obj == Columns)
         showData();
   }
   //------------------------------------
   private void showColumns()
   {
      String cnames[] = db.getColumnNames(Tables.getSelectedItem());
      loadList(Columns, cnames);
   }
   //------------------------------------
   private void showData()
   {
      String colname = Columns.getSelectedItem();
      String colval = db.getColumnValue(Tables.getSelectedItem(), colname);
      Data.setVisible(false);
      Data.removeAll();
      Data.setVisible(true);
     
      colval = db.getNextValue(Columns.getSelectedItem());
      
      while (colval.length()>0) 
         {
         Data.add(colval);
         colval = db.getNextValue(Columns.getSelectedItem());
         }
   }
   //------------------------------------
   private void clickedSearch()
   {
      resultSet rs = db.Execute(query.getText());
      String cnames[] = rs.getMetaData();
      Columns.removeAll();
      queryDialog q = new queryDialog(this, rs);
      q.show();
   }
   //------------------------------------
   static public void main(String argv[])
   {
      new dbFrame();
   }
}

