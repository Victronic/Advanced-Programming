package repo;

import entity.Artist;
import entity.ArtistsEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
    int id=1;
    //metoda create unde introduc date in tabela
    public void create(String name, String country) throws ClassNotFoundException, SQLException {
        Connection conectam;
        String sql = "INSERT INTO Artists(id,name,country) VALUES(?,?,?)";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //conectez la bd
        conectam = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDA", "SQL");

        try(Connection conn = conectam; PreparedStatement pstmt = conn.prepareStatement(sql)){
            Statement comanda = conectam.createStatement();
            ResultSet rezultat = comanda.executeQuery("Select max(id) from artists ");
            while(rezultat.next()) pstmt.setInt(1, rezultat.getInt(1)+1);
            pstmt.setString(2, name);
            pstmt.setString(3,country);
            id++;
            pstmt.executeUpdate();
            System.out.println("\nAm reusit sa inserez in tabela Artists");

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //metoda findby id unde cu ajutorul unui querry select din tabela
    public Artist findById(int Id){
        Artist artist=new Artist();
        try {
            Connection conectam;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conectam = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDA", "SQL");
            Statement comanda = conectam.createStatement();

            ResultSet rezultat = comanda.executeQuery("Select name, country from Artists where id=" + Id);
            System.out.println("\nPentru id-ul "+Id+" am gasit urmatoarele intrari in tabela artists:");
            while (rezultat.next()) {
                System.out.println(rezultat.getString(1) + "  " + rezultat.getString(2) );
                artist = new Artist(rezultat.getString(1), rezultat.getString(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }
    //find by name unde fac exact ca mai sus doar ca un al querry
    public List<Artist> findByName(String name){
        List<Artist> Artists = new ArrayList<Artist>();
        Connection conectam;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conectam = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDA", "SQL");
            java.sql.Statement comanda = conectam.createStatement();
            ResultSet rezultat = comanda.executeQuery("Select name, country from Artists where name like '" + name+"'");

            while (rezultat.next()) {
                Artist artist = new Artist(rezultat.getString(1), rezultat.getString(2));
                Artists.add(artist);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Artists;
    }
}
