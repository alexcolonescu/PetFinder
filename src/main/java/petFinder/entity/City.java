package petFinder.entity;

public enum City {
    ALBA("Alba"),
    ARAD("Arad"),
    ARGES("Arges");
    //Bacau, Bihor, BistritaNasaud, Botosani, Brasov, Braila, Bucuresti, Buzau, CarasSeverin, Calarasi, Cluj, Constanta, Covasna, Dambovita, Dolj, Galati, Giurgiu, Gorj, Harghita, Hunedoara, Ialomita, Iasi, Ilfov, Maramures, Mehedinti, Mures, Neamt, Olt, Prahova, SatuMare, Salaj, Sibiu, Suceava, Teleorman, Timis, Tulcea, Vaslui, Valcea, Vrancea;

    private final String displayEnum;

    City(String displayEnum){
        this.displayEnum = displayEnum;
    }

    public String getDisplayEnum(){
        return displayEnum;
    }

}
