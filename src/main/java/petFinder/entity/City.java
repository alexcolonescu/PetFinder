package petFinder.entity;

public enum City {
    ALBA("Alba"),
    ARAD("Arad"),
    ARGES("Arges"),
    BACAU("Bacau"),
    BIHOR("Bihor"),
    BISTRITANASAUD("BistritaNasaud"),
    BOTOSANI("Botosani"),
    BRASOV("Brasov"),
    BRAILE("Braila"),
    BUCUREST("Bucuresti"),
    BUZAU("Buzau"),
    CARASSEVERIN("CarasSeverin"),
    CALARASI("Calarasi"),
    CLUJ("Cluj"),
    CONSTANTA("Constanta"),
    COVASNA("Covasna"),
    DAMBOVITA("Dambovita"),
    DOLJ("Dolj"),
    GALATI("Galati"),
    GIURGIU("Giurgiu"),
    GORJ("Gorj"),
    HARGHITA("Harghita"),
    HUNEDOARA("Hunedoara"),
    IALOMITA("Ialomita"),
    IASI("Iasi"),
    ILFOV("Ilfov"),
    MARAMURES("Maramures"),
    MEHEDINTI("Mehedinti"),
    MURES("Mures"),
    NEAMT("Neamt"),
    OLT("Olt"),
    PRAHOVA("Prahova"),
    SATUMARE("SatuMare"),
    SALAJ("Salaj"),
    SIBIU("Sibiu"),
    SUCEAVA("Suceava"),
    TELEORMAN("Teleorman"),
    TIMIS("Timis"),
    TULCEA("Tulcea"),
    VASLUI("Vaslui"),
    VALCEA("Valcea"),
    VRANCEA("Vrancea");

    private final String displayEnum;

    City(String displayEnum){
        this.displayEnum = displayEnum;
    }

    public String getDisplayEnum(){
        return displayEnum;
    }

}
