/* singletonul de unde fac conexiunea cu baza de date din mysql
am folosit driverul mysql-connector-java pentru a face conexiunea
baza de date se numeste musicalbums (nu am reusit sa o fac cu litere mari)
am creat un cont cu numele dbs si parola sql pe care il folosesc la conectare
in cazul unei erori arunc un mesaj corespunzator cu ajutorul try,catch
*/


import java.sql.*;

public class Database {
    Connection con;
    public Database() {
        String url="jdbc:mysql://localhost/musicalbums";
        try{
            con = DriverManager.getConnection(url,"dba","sql");
        }catch(SQLException e){
            System.err.println("Cannot connect to DB: "+e);
        }
    }
}
