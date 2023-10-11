package fi.joni.backend.dto;

public class HenkiloDto {
    private String id;
    private String nimi;
    private String henkilotunnus;
    private String osoitetiedot;
    private String kansalaisuus;
    private String aidinkieli;
    private String perhesuhdetiedot;
    private String syntymaJaKuolintiedot;

    public HenkiloDto() {}

    
    public HenkiloDto( String nimi, String henkilotunnus, String osoitetiedot, String kansalaisuus,
                      String aidinkieli, String perhesuhdetiedot, String syntymaJaKuolintiedot) {
        this.nimi = nimi;
        this.henkilotunnus = henkilotunnus;
        this.osoitetiedot = osoitetiedot;
        this.kansalaisuus = kansalaisuus;
        this.aidinkieli = aidinkieli;
        this.perhesuhdetiedot = perhesuhdetiedot;
        this.syntymaJaKuolintiedot = syntymaJaKuolintiedot;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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