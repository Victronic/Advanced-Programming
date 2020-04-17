package entity;
//clasa album care are valorile precum campurile din tabela
public class Album {
    public String name;
    public int artist_id;
    public int release_year;
    public Album(String name, int artist_id, int year){
        this.name=name;
        this.artist_id=artist_id;
        this.release_year=year;
    }

    public Album() {

    }
}
