
package praxe;

public class Rate {
    private String tema;
    private int rok;
    private String spleni;
    private String kvalita;
    private String spokojenost_s_pristupem;
    private String slovni_hodnoceni;

    public Rate(String tema, int rok, String spleni, String kvalita, String spokojenost_s_pristupem, String slovni_hodnoceni) {
        this.tema = tema;
        this.rok = rok;
        this.spleni = spleni;
        this.kvalita = kvalita;
        this.spokojenost_s_pristupem = spokojenost_s_pristupem;
        this.slovni_hodnoceni = slovni_hodnoceni;
    }
    
    public Rate(Rate r) {
        this.tema = r.tema;
        this.rok = r.rok;
        this.spleni = r.spleni;
        this.kvalita = r.kvalita;
        this.spokojenost_s_pristupem = r.spokojenost_s_pristupem;
        this.slovni_hodnoceni = r.slovni_hodnoceni;
    }
    
    public Rate(){
        
    }

    public String getTema() {
        return tema;
    }

    public int getRok() {
        return rok;
    }

    public String getSpleni() {
        return spleni;
    }

    public String getKvalita() {
        return kvalita;
    }

    public String getSpokojenost_s_pristupem() {
        return spokojenost_s_pristupem;
    }

    public String getSlovni_hodnoceni() {
        return slovni_hodnoceni;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public void setSpleni(String spleni) {
        this.spleni = spleni;
    }

    public void setKvalita(String kvalita) {
        this.kvalita = kvalita;
    }

    public void setSpokojenost_s_pristupem(String spokojenost_s_pristupem) {
        this.spokojenost_s_pristupem = spokojenost_s_pristupem;
    }

    public void setSlovni_hodnoceni(String slovni_hodnoceni) {
        this.slovni_hodnoceni = slovni_hodnoceni;
    }
    
    
}
