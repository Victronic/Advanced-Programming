/* Clasa DAO de unde controlez tabela artists
(NU am inteles din cerinta daca roiti modelul DAO, cu interfata, implementare si clasa
sau doar o clasa simpla care se ocupa de operatiile din cerinta, eu am ales a doua opriune din cele enuntate)
Clasa are un constructor unde obtine connectorul la baza de date si 2 metode:
una care introduce un nou artist cu datele sale unde folosesc un preparedStatement ca sa
utilizez parametrii functiiei in comanda sql
si inca o metoda care afiseaza un artist (exact cum e in tabela, randul sau)
unde folossc din nou un preparedStatement si un ResultSet ca sa salvez datele obtinue
si sa le afisez
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistController {
    Connection con;

    public ArtistController(Connection con) {
        this.con = con;
    }

    public void create(String name, String country) throws SQLException {
        String sql="insert into artists (name,country) values(?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,country);
        pstmt.execute();
    }
    public void findByName(String name) throws SQLException {
        String sql="Select * from artists where name=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,name);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("Datele artistului: " + name);
        while(rs.next()){
            int resultId = rs.getInt("id");
            String resultName =rs.getString("name");
            String resultCountry = rs.getString("country");
            System.out.println(resultId + ", " + resultName + ", " + resultCountry);
        }
        System.out.println();
    }
}
