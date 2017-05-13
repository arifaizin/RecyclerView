package id.co.imastudio.recyclerview;

/**
 * Created by idn on 5/13/2017.
 */

public class FilmModel {

    private String judulFilm;
    private String gambarFilm;

    public FilmModel() {
    }

    //bikin Constructor
    //Alt + Insert > Constructor

    public FilmModel(String judulFilm, String gambarFilm) {
        this.judulFilm = judulFilm;
        this.gambarFilm = gambarFilm;
    }

    //bikin Setter and Getter
    //Alt +Insert > Getter and setter


    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public String getGambarFilm() {
        return gambarFilm;
    }

    public void setGambarFilm(String gambarFilm) {
        this.gambarFilm = gambarFilm;
    }
}
