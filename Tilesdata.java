package e.margi.qbapp;

import java.util.ArrayList;

public class Tilesdata
{
    public Tilesdata(String tilesno, String availtiles) {
    }

    public Tilesdata(ArrayList<Tilesdata> list) {

    }

    public Tilesdata() {

    }

    public String getTilesno() {
        return tilesno;
    }

    public void setTilesno(String tilesno) {
        this.tilesno = tilesno;
    }

    public String getAvailabletiles() {
        return availabletiles;
    }

    public void setAvailabletiles(String availabletiles) {
        this.availabletiles = availabletiles;
    }

    private String tilesno;
    private String availabletiles;


}
