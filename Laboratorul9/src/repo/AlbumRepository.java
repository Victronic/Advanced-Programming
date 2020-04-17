package repo;

import entity.Album;
import entity.AlbumsEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
//metoda create unde introduc date in tabela
public void create(String name, int artist_id, int release_year) throws ClassNotFoundException, SQLException {
    Connection conectam;
    String sql = "INSERT INTO Albums(id,name,artist_id,release_year) VALUES(?,?,?,?)";
    Class.forName("oracle.jdbc.driver.OracleDriver");
    //conectez la bd
    conectam = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDA", "SQL");

    try(Connection conn = conectam; PreparedStatement pstmt = conn.prepareStatement(sql)){
        Statement comanda = conectam.createStatement();
        ResultSet rezultat = comanda.executeQuery("Select max(id) from albums ");
        while(rezultat.next())
        pstmt.setInt(1, rezultat.getInt(1)+1);
        pstmt.setString(2, name);
        pstmt.setInt(3, artist_id);
        pstmt.setInt(4, release_year);
        pstmt.executeUpdate();
        System.out.println("\nAm reusit sa inserez in tabela Albums");

    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
//metoda findby id unde cu ajutorul unui querry select din tabela
public Album findById(int Id){
       Album album=new Album();
        try {
            Connection conectam;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conectam = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDA", "SQL");
            Statement comanda = conectam.createStatement();

            ResultSet rezultat = comanda.executeQuery("Select name, artist_id, release_year from Albums where id=" + Id);
            System.out.println("\nPentru id-ul "+Id+" am gasit urmatoarele intrari in tabela album:");
            while (rezultat.next()) {
                System.out.println(rezultat.getString(1) + "  " + rezultat.getInt(2) + "  " + rezultat.getInt(3));
                album = new Album(rezultat.getString(1), rezultat.getInt(2), rezultat.getInt(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
      return album;
}
//find by name unde fac un array ca sa mentin toate albumele
public List<Album> findByName(String name){
        List<Album> Albums = new ArrayList<Album>();
        Connection conectam;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conectam = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDA", "SQL");
            java.sql.Statement comanda = conectam.createStatement();
            ResultSet rezultat = comanda.executeQuery("Select name, artist_id, release_year from Albums where name like '" + name+"'");

            while (rezultat.next()) {
               Album album = new Album(rezultat.getString(1), rezultat.getInt(2), rezultat.getInt(3));
                Albums.add(album);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Albums;
    }
// find by artist am definit un array de albume unde vom tine rez pentru un artist
    public List<Album> findByArtist(int artist_id){
        List<Album> Albums = new ArrayList<Album>();
        Connection conectam;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conectam = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BDA", "SQL");
            java.sql.Statement comanda = conectam.createStatement();
            ResultSet rezultat = comanda.executeQuery("Select name, artist_id, release_year from Albums where artist_id like '" + artist_id+"'");
            while (rezultat.next()) {
                Album album = new Album(rezultat.getString(1), rezultat.getInt(2), rezultat.getInt(3));
                Albums.add(album);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Albums;
    }
}
