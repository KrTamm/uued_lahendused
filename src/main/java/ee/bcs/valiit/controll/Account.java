package ee.bcs.valiit.controll;

public class Account {
    private String kontoNr;
    private String kontoOmanikuNimi;
    private int balanss = 0;
    private boolean kasLukustatud = false;
    private int history;

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public String getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(String kontoNr) {
        this.kontoNr = kontoNr;
    }

    public String getKontoOmanikuNimi() {
        return kontoOmanikuNimi;
    }

    public void setKontoOmanikuNimi(String kontoOmanikuNimi) {
        this.kontoOmanikuNimi = kontoOmanikuNimi;
    }

    public int getBalanss() {
        return balanss;
    }

    public void setBalanss(int balanss) {
        this.balanss = balanss;
    }

    public boolean getKasLukustatud() {
        return kasLukustatud;
    }

    public void setKasLukustatud(boolean kasLukustatud) {
        this.kasLukustatud = kasLukustatud;
    }
}
