/* Clasa DAO de unde controlez tabela albums
(la fel ca la artist nu am intels exact daca doriti modelul DAO sau doar o clasa
care sa se ocupe de operatii cu tabela respectiva)
Clasa are un constructor unde obtine connectorul la baza de date si 2 metode:
una care introduce un nou album cu datele sale unde folosesc un preparedStatement ca sa
utilizez parametrii functiiei in comanda sql
si inca o metoda care afiseaza albumele unui artist dupa id sau (exact cum sunt in tabela)
unde folossc din nou un preparedStatement si un ResultSet ca sa salvez datele obtinue
si sa le afisez
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController {
    Connection con;

    public AlbumController(Connection con) {
        this.con = con;
    }

    public void create(String name, int artistId, int releaseYear) throws SQLException {
        String sql="insert into albums (name,artist_id,release_year) values(?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setInt(2,artistId);
        pstmt.setInt(3,releaseYear);
        pstmt.execute();
    }

    public void findByArtist(int artistID) throws SQLException {
        String sql="Select * from albums where artist_id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,artistID);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("Albumele artistului cu id-ul: " + artistID);
        while(rs.next()){
            int resultId = rs.getInt("id");
            String resultName =rs.getString("name");
            int resultArtistId = rs.getInt("artist_id");
            String resultReleaseYear = rs.getString("release_year");
            System.out.println(resultId + ", " + resultName + ", " + resultArtistId + ", " + resultReleaseYear);
        }
        System.out.println();
    }
}
