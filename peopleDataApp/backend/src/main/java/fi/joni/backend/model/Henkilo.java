package fi.joni.backend.model;

public class Henkilo {
    private String nimi;
    private String henkilotunnus;
    private String osoitetiedot;
    private String kansalaisuus;
    private String aidinkieli;
    private String perhesuhdetiedot;
    private String syntymaJaKuolintiedot;

    public Henkilo() {
    }

    public Henkilo(String nimi, String henkilotunnus, String osoitetiedot, String kansalaisuus,
                   String aidinkieli, String perhesuhdetiedot, String syntymaJaKuolintiedot) {
        this.nimi = nimi;
        this.henkilotunnus = henkilotunnus;
        this.osoitetiedot = osoitetiedot;
        this.kansalaisuus = kansalaisuus;
        this.aidinkieli = aidinkieli;
        this.perhesuhdetiedot = perhesuhdetiedot;
        this.syntymaJaKuolintiedot = syntymaJaKuolintiedot;
    }

    // Getter and Setter methods (you can generate these using your IDE)

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getHenkilotunnus() {
        return henkilotunnus;
    }

    public void setHenkilotunnus(String henkilotunnus) {
        this.henkilotunnus = henkilotunnus;
    }

    public String getOsoitetiedot() {
        return osoitetiedot;
    }

    public void setOsoitetiedot(String osoitetiedot) {
        this.osoitetiedot = osoitetiedot;
    }

    public String getKansalaisuus() {
        return kansalaisuus;
    }

    public void setKansalaisuus(String kansalaisuus) {
        this.kansalaisuus = kansalaisuus;
    }

    public String getAidinkieli() {
        return aidinkieli;
    }

    public void setAidinkieli(String aidinkieli) {
        this.aidinkieli = aidinkieli;
    }

    public String getPerhesuhdetiedot() {
        return perhesuhdetiedot;
    }

    public void setPerhesuhdetiedot(String perhesuhdetiedot) {
        this.perhesuhdetiedot = perhesuhdetiedot;
    }

    public String getSyntymaJaKuolintiedot() {
        return syntymaJaKuolintiedot;
    }

    public void setSyntymaJaKuolintiedot(String syntymaJaKuolintiedot) {
        this.syntymaJaKuolintiedot = syntymaJaKuolintiedot;
    }
}
