/*metoda main unde am 3 obiecte un database cu care fac conexiunea la baza de date
si inca 2 pentru fieacre tabela din baza de date
folosesc metodele din obiecte ca sa construiesc 3 artisti si cateva albume
apoi tot cu ajutorul metodelor afisez date despe acestia
*/

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Database d = new Database();
        ArtistController artistController = new ArtistController(d.con);
        AlbumController albumController =new AlbumController(d.con);

        artistController.create("Victor","Romania");
        artistController.create("Irina","Belarus");
        artistController.create("Andra","Canada");

        artistController.findByName("Victor");
        artistController.findByName("Andra");

        albumController.create("Flower",1,2000);
        albumController.create("Rock",2,2012);
        albumController.create("Momentum",2,2014);
        albumController.create("Chance",3,1998);
        albumController.create("Waste",3,2001);

        albumController.findByArtist(1);
        albumController.findByArtist(3);
        d.con.close();
    }
}
