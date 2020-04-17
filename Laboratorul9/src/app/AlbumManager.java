package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumManager {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //creez un obiec alumb si artist apoi apelez pentru fiecare metodele specifice
        AlbumRepository album=new AlbumRepository();
        ArtistRepository artist= new ArtistRepository();
        album.create("Flori", 2, 2009);
        artist.create("Victor","Romania");
        Album temp=album.findById(1);
        Artist temp1=artist.findById(1);
        System.out.println();
        List<Artist> listArt = new ArrayList<>(artist.findByName("Victor"));
        for (Artist art: listArt
             ) {
            System.out.println(art.name+" "+art.country);
        }
        System.out.println();
        List<Album> listAlbum=new ArrayList<Album>(album.findByName("Flori"));
        for (Album alb: listAlbum
             ) {System.out.println(alb.name + " "+alb.artist_id + " "+alb.release_year);
        }
        System.out.println();
        List<Album> listAlbums = new ArrayList<>(album.findByArtist(1));
        for (Album alb:listAlbums
             ) {
            System.out.println(alb.name + " " + alb.artist_id + " " + alb.release_year );

        }
    }
}
