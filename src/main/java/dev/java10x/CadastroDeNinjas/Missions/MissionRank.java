package dev.java10x.CadastroDeNinjas.Missions;

public enum MissionRank {
    D("D","Low risk mission"),
    C("C","Low/Moderate risk mission"),
    B("B","Moderate risk mission"),
    A("A","High risk mission"),
    S("S","Kage/Sannin level mission"),
    ;

    private String rank;
    private String description;

    MissionRank(String rank, String description) {
        this.rank = rank;
        this.description = description;
    }

    public String getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }
}
