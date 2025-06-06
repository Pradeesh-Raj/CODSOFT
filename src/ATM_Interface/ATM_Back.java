package ATM_Interface;

import java.sql.*;

public class ATM_Back {
    int cardNo;
    Connection con;
    PreparedStatement queries;
    ResultSet result;

    ATM_Back(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "pradeesh");
        }
        catch(Exception e){}
    }
    public String validateUser(int cardNo){
        try{
            this.cardNo = cardNo;
            queries = con.prepareStatement("SELECT * FROM USERS WHERE acc_num = ?");
            queries.setInt(1,cardNo);
            result = queries.executeQuery();
            if(result.next()){
                return ("Welcome " + result.getString(2));
            }
        } catch (Exception e) {}
        return "Invalid Card Number!";
    }

    public String withdraw(int amount){
        try{
            queries = con.prepareStatement("SELECT balance FROM USERS WHERE acc_num = ?");
            queries.setInt(1,cardNo);
            result = queries.executeQuery();
            result.next();
            if(amount > result.getInt("balance")){
                return "Insufficient Balance";
            }
            else{
                queries = con.prepareStatement("UPDATE USERS SET balance = balance - ? WHERE acc_num = ?");
                queries.setInt(1,amount);
                queries.setInt(2,cardNo);
                queries.executeUpdate();
                return (amount + " withdrawn successfully");
            }
        } catch (Exception e) {}
        return "";
    }

    public String deposit(int amount){
           try{
               if(amount > 0){
                   queries = con.prepareStatement("UPDATE USERS SET balance = balance + ? WHERE acc_num = ?");
                   queries.setInt(1,amount);
                   queries.setInt(2,cardNo);
                   queries.executeUpdate();
                   return (amount + " deposited successfully");
               }
               else{
                   return "Zero amount cannot be deposited";
               }
           } catch (Exception e) {}
           return "";
    }
}
