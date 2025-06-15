package dev.java10x.CadastroDeNinjas.Ninjas;

public enum NinjaRank {
    GENIN("Genin", "Junior ninja (lowest rank).",
     "Perform D/C-rank missions, train under a jonin instructor."),

    CHUNIN("Chunin", "Intermediate ninja (field leaders).",
      "Lead small teams, handle B-rank missions, oversee genin."),

    JONIN("Jonin", "Elite ninja (combat experts).",
     "Execute A/S-rank missions, mentor genin teams, protect the village."),

    ANBU("Anbu", "Black ops (shadow operatives).",
    "Covert missions (assassination, espionage) report directly to the Kage."),

    SANIN("Sanin", "Legendary ninja (Jiraiya, Tsunade, Orochimaru)",
     "Above Jonin, but below Kage."),

    KAGE("Kage", "Village leader (strongest ninja).",
    "Govern the village, strategize in wars, defend against existential threats.");

    private String rank;
    private String title;
    private String description;

    NinjaRank() {
    }

    NinjaRank(String rank, String title, String description) {
        this.rank = rank;
        this.title = title;
        this.description = description;
    }

    public String displayFullInfo() {
        return
                "Rank: " + rank + '\n' +
                "Title: " + title + '\n' +
                "Description: " + description;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

