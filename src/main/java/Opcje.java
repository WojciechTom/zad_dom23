public enum Opcje {
    OP1("Pokaż wszystkie książki", "OP1"),
    OP2("Dodaj książkę", "OP2"),
    OP3("Wyszukaj ksiażkę", "OP3"),
    OP4("Usuń książkę z bazy", "OP4"),
    OP5("Wyjdź", "OP5");

    private String desc;
    private String opcja;

    Opcje(String desc, String opcja) {
        this.desc = desc;
        this.opcja = opcja;
    }

    public String getDesc() {
        return desc;
    }

    public String getOpcja() {
        return opcja;
    }
}

