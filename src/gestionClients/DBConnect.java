package gestionClients;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBConnect{
    private static DBConnect instance;
    Connection con;
    Statement stm;
    ResultSet rst;
    ResultSet columnsString;
    public DBConnect() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","20030722");
            stm = con.createStatement();
            System.out.println("Connexion au DB bien établie");
        } catch(Exception e) {
            System.out.println("Erreur de chargement de pilote:"+e);
        }
    }
    public static synchronized DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }
    
    public List<List> getData(String table) {
        List<List> data = new ArrayList<List>();
        try{
            /**/
            /*changement du conteneur a ORCLPDB*/
            String sql1 = "ALTER SESSION SET CONTAINER = ORCLPDB";
            stm.addBatch(sql1);
            stm.executeBatch();
            /*extraction des colonnes*/
            String columnsQuery = "SELECT COLUMN_NAME FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = '" + table + "' AND OWNER = 'GESTIONSHOP'";
            columnsString = stm.executeQuery(columnsQuery);
            List<Object> columnsList = new ArrayList<>();
            List<Object> adminColumnsList = new ArrayList<>();
            
            if(table.equals("GESTIONNAIRES")){
                adminColumnsList.add("ADMIN_ID");
                adminColumnsList.add("NOM");
                adminColumnsList.add("PRENOM");
                adminColumnsList.add("EMAIL");
                adminColumnsList.add("TELEPHONE");
                data.add(adminColumnsList);
            } else {
                while(columnsString.next()) {
                    String col = columnsString.getString("COLUMN_NAME");
                    columnsList.add(col);
                }
                String query = "SELECT * from GESTIONSHOP."+ table+" ORDER BY " + columnsList.get(0);//limit pour limiter la selection //
                rst = stm.executeQuery(query);
                data.add(columnsList);
            }
            /*extraction des donnees depuis le tableau*/
            
            if (table.equals("GESTIONNAIRES")) {
                String adminQuery = "SELECT * from GESTIONSHOP."+ table+" ORDER BY " + adminColumnsList.get(0);//limit pour limiter la selection //
                rst = stm.executeQuery(adminQuery);         
                while(rst.next()){                    
                    List<Object> row = new ArrayList<Object>();
                    int id = rst.getInt("ADMIN_ID");
                    row.add(id);
                    String firstName = rst.getString("NOM");
                    row.add(firstName);
                    String secondName = rst.getString("PRENOM");
                    row.add(secondName);
                    String email = rst.getString("EMAIL");
                    row.add(email);
                    String tel = rst.getString("TELEPHONE");
                    row.add(tel);
                    data.add(row);
                }
            } else if(table.equals("CLIENTS")) {
                while(rst.next()){
                    List<Object> row = new ArrayList<Object>();
                    int id = rst.getInt("CLIENT_ID");
                    row.add(id);
                    String firstName = rst.getString("NOM");
                    row.add(firstName);
                    String secondName = rst.getString("PRENOM");
                    row.add(secondName);
                    String adresse = rst.getString("ADRESSE");
                    row.add(adresse);
                    String email = rst.getString("EMAIL");
                    row.add(email);
                    String tel = rst.getString("TELEPHONE");
                    row.add(tel);
                    data.add(row);
                }
            } else if(table.equals("PRODUITS")) {
                while(rst.next()){
                    List<Object> row = new ArrayList<Object>();
                    int productId = rst.getInt("PRODUIT_ID");
                    row.add(productId);
                    String productName = rst.getString("NOM_PRODUIT");
                    row.add(productName);
                    String desc = rst.getString("DESCRIPTION");
                    row.add(desc);
                    String price = rst.getString("PRIX");
                    row.add(price);
                    int stock = rst.getInt("STOCK");
                    row.add(stock);
                    data.add(row);
                }
            } else if(table.equals("COMMANDES")) {
                while(rst.next()) {
                    List<Object> row = new ArrayList<Object>();
                    int id = rst.getInt("COMMANDE_ID");
                    row.add(id);
                    int clientId = rst.getInt("CLIENT_ID");
                    row.add(clientId);
                    int productId = rst.getInt("PRODUIT_ID");
                    row.add(productId);
                    String orderDate = rst.getString("DATE_COMMANDE");
                    row.add(orderDate);
                    int quantity = rst.getInt("QUANTITE");
                    row.add(quantity);
                    String totalPrice = rst.getString("PRIX_TOTAL");
                    row.add(totalPrice);
                    data.add(row);
                }
            }
        } catch(Exception e) {
            System.out.println("Erreur:"+ e);
        }
        return data;
    }
    public boolean verifyAdminPassword(String adminPassword, int adminId){
        List<List> data = new ArrayList<List>();
        try{
            /*changement du conteneur a ORCLPDB*/
            String sql1 = "ALTER SESSION SET CONTAINER = ORCLPDB";
            stm.addBatch(sql1);
            stm.executeBatch();
            
            String columnsQuery = "SELECT COLUMN_NAME FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'GESTIONNAIRES' AND OWNER = 'GESTIONSHOP'";
            columnsString = stm.executeQuery(columnsQuery);
            List<Object> columnsList = new ArrayList<>();
            
            while(columnsString.next()) {
                String col = columnsString.getString("COLUMN_NAME");
                columnsList.add(col);
            }
            String query = "SELECT * from GESTIONSHOP.GESTIONNAIRES WHERE ADMIN_ID = " + adminId;//limit pour limiter la selection //
            rst = stm.executeQuery(query);
            data.add(columnsList);
            
            while(rst.next()) {
                List<Object> row = new ArrayList<Object>();
                int id = rst.getInt("ADMIN_ID");
                row.add(id);
                String password = rst.getString("MOT_DE_PASSE");
                row.add(password);
                String firstName = rst.getString("NOM");
                row.add(firstName);
                String secondName = rst.getString("PRENOM");
                row.add(secondName);
                String email = rst.getString("EMAIL");
                row.add(email);
                String tel = rst.getString("TELEPHONE");
                row.add(tel);
                data.add(row);
            }
        } catch(Exception e){
            System.out.println("Erreur:"+ e);
        }
        if(data.size() < 2){
            return false;
        } else {
            return adminPassword.equals(data.get(1).get(1));
        }
    }
    public void addClient(int id, String nom, String prenom, String adresse, String email, String tel){
        try{
            String insertQuery = "INSERT INTO GESTIONSHOP.CLIENTS VALUES (" + id + ",'" + nom + "', '" + prenom+ "', '" + adresse+ "', '" + email+ "', '" + tel + "')";
            stm.executeUpdate(insertQuery);
            this.commitChanges();
        } catch(Exception e) {}
    }
    public void addProduct(int id, String nom, String desc, String price, int stock){
        try{
            String insertQuery = "INSERT INTO GESTIONSHOP.PRODUITS  VALUES (" + id + ",'" + nom + "', '" + desc+ "', '" + price+ "', " + stock + ")";
            stm.executeUpdate(insertQuery);
            this.commitChanges();
        } catch(Exception e) {
            System.out.println("Erreur:"+e);
        }
    }
    public void addOrder(int id, int clientId, int productId, String orderDate, int quantity, String totalPrice){
        try{
            String insertQuery = "INSERT INTO GESTIONSHOP.COMMANDES  VALUES (" + id + ", "+ clientId + ", " + productId + ", TO_DATE('" + orderDate + "', 'YYYY-MM-DD'), " +quantity+ ", '"+ totalPrice + "')";
            stm.executeUpdate(insertQuery);
            this.commitChanges();
        } catch(Exception e) {
            System.out.println("Erreur:"+e);
        }
    }
    public void addAdmin(String password, String firstName, String lastName, String email, String tel){
        try{
            String insertQuery = "INSERT INTO GESTIONSHOP.GESTIONNAIRES" + " VALUES (GESTIONSHOP.admin_id_seq.nextval, '" + password + "', '"+ firstName + "', '" + lastName + "', '" + email+ "', '" + tel + "')";
            stm.executeUpdate(insertQuery);
            this.commitChanges();
        } catch(Exception e) {
            System.out.println("Erreur:"+e);
        }
    }
    public void deleteClient(int id){
        try{
            String query="DELETE FROM GESTIONSHOP.CLIENTS WHERE CLIENT_ID = " + id;
            stm.executeUpdate(query);
            this.commitChanges();                      
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Client ne peut pas être supprimé !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteProduct(int id){
        try{
            String query="DELETE FROM GESTIONSHOP.PRODUITS WHERE PRODUIT_ID = " + id;
            stm.executeUpdate(query);
            this.commitChanges();                      
        } catch(Exception e){
           System.out.println("Erreur:"+e);
        }
    }
    public void deleteOrder(int id){
        try{
            String query="DELETE FROM GESTIONSHOP.COMMANDES WHERE COMMANDE_ID = " + id;
            stm.executeUpdate(query);
            this.commitChanges();                     
        }catch(Exception e){
           System.out.println("Erreur:"+ e);
        }
    }
    public void deleteAdmin(int id){
        try{
            String query="DELETE FROM GESTIONSHOP.GESTIONNAIRES WHERE ADMIN_ID = " + id;
            stm.executeUpdate(query);
            this.commitChanges();                     
        }catch(Exception e){
            System.out.println("Erreur: "+ e);
        }
    }
    public List<List> find(String table, int id){
        List<List> result = new ArrayList<List>();

        try{
            /*extraction des colonnes*/
            List<Object> columnsList = new ArrayList<>();
            if(table.equals("GESTIONNAIRES")) {
                columnsList.add("ADMIN_ID");
                columnsList.add("NOM");
                columnsList.add("PRENOM");
                columnsList.add("EMAIL");
                columnsList.add("TELEPHONE");
            } else {
                String columnsQuery = "SELECT COLUMN_NAME FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = '" + table + "' AND OWNER = 'GESTIONSHOP'";
                columnsString = stm.executeQuery(columnsQuery);
                while(columnsString.next()) {
                    String col = columnsString.getString("COLUMN_NAME");
                    columnsList.add(col);
                }
            }
            
            result.add(columnsList);
            
            List<List> data = this.getData(table);
            for(int i=1; i<data.size(); i++){
                if (id == (int)data.get(i).get(0)) {
                    result.add(data.get(i));
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Erreur:"+e);
        }
        return result;
    }
    public void modifyClient(int id, String nom, String prenom, String adresse, String email, String tel){
        try{
            String updateQuery = "UPDATE GESTIONSHOP.CLIENTS SET NOM = '" + nom + "', PRENOM='"+ prenom +"', ADRESSE='"+ adresse +"', TELEPHONE = '"+ tel + "' WHERE CLIENT_ID = " + id;
            stm.executeUpdate(updateQuery);
            this.commitChanges();
        } catch(Exception e) {
            System.out.println("Erreur:"+e);
        }
    }
    public void modifyAdmin(int id, String password, String firstName, String lastName, String email, String tel) {
        try{
            String updateQuery = "UPDATE GESTIONSHOP.GESTIONNAIRES SET MOT_DE_PASSE = '"+ password +"', NOM = '"+ firstName +"', PRENOM='"+ lastName +"', EMAIL='"+ email +"', TELEPHONE = '"+ tel + "' WHERE ADMIN_ID = " + id;
            stm.executeUpdate(updateQuery);
            this.commitChanges();
        } catch(Exception e) {
            System.out.println("Erreur:"+e);
        }
    }
    public void modifyOrder(int id, int clientId, int productId, String orderDate, int quantity, String totalPrice){
        try{
            String updateQuery = "UPDATE GESTIONSHOP.COMMANDES SET CLIENT_ID = '"+ clientId +"', PRODUIT_ID='"+ productId +"', DATE_COMMANDE=TO_DATE('"+ orderDate +"', 'YYYY-MM-DD'), QUANTITE = '"+ quantity + "', PRIX_TOTAL = '"+ totalPrice+"' WHERE COMMANDE_ID = " + id;
            stm.executeUpdate(updateQuery);
            this.commitChanges();
        } catch(Exception e) {
            System.out.println("Erreur:"+e);
        }
    }
    public void modifyProduct(int id, String nom, String desc, String price, int stock){
        try{
            String updateQuery = "UPDATE GESTIONSHOP.PRODUITS SET NOM_PRODUIT = '"+ nom +"', DESCRIPTION='"+ desc +"', PRIX='"+ price +"', STOCK= "+ stock + " WHERE PRODUIT_ID = " + id;
            stm.executeUpdate(updateQuery);
            this.commitChanges();
        } catch(Exception e) {
            System.out.println("Erreur:"+e);
        }
    }
    public void commitChanges(){
        try {
            String commit = "COMMIT";
            stm.addBatch(commit);
            stm.executeBatch();
        } catch(Exception e){
            System.out.println("Erreur:"+e);
        }
    }
    public void quitter(){
        try {
            this.stm.close();
            this.con.close();
            System.out.println("Fermeture de la connexion");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        List<List> data = connect.getData("GESTIONNAIRES");
        //connect.addAdmin("12344", "Chaabi", "Hicham", "chaabihicham165@gmail.com", "0778905472");
        //connect.addClient("CLIENTS", 13, "Chegra", "Abdeljalil", "Ait melloul", "asdgasgd@gmail.com", "0778905472");
        //connect.addProduct(1, "Laptop", "High-performance laptop with SSD", "1200.00", 50);
        //connect.addProduct(2, "Smartphone", "Latest smartphone with dual cameras", "800.00", 100);
        //connect.addProduct(3, "Headphones", "Wireless over-ear headphones", "150.00", 30);
        //connect.addProduct(4, "Coffee Maker", "Programmable coffee maker with grinder", "75.00", 20);
        //connect.addOrder(1, 1, 1, "2023-03-10", 1, "250.25");
        //connect.deleteAdmin(22);
        //List res = connect.find("GESTIONNAIRES", 26);
        //connect.modifyAdmin(26, "124", "Chaabi", "Hicham", "chaabihicham087@gmail.com", "0778905472");
        connect.verifyAdminPassword("20030722", 132);
        
        connect.quitter();
    }*/
}