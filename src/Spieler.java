public class Spieler {
    private String name;
    private int punkte;
    private Bewegung aktuelleBewegung;
    private Spiel spiel;

    public Spieler (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public Spiel getSpiel() {
        return spiel;
    }

    public void setSpiel(Spiel spiel) {
        this.spiel = spiel;
    }

    public void spielen (Bewegung bewegung) {
        this.aktuelleBewegung = bewegung;
    }

    public void spielen (String bewegung) throws InvalidMoveException {
        for (Bewegung a: this.getSpiel().getMoves()) {
            if (a.getAliases().contains(bewegung) || a.getName().equals(bewegung)) {
                this.spielen(a);
                return;
            }
        }
        throw new InvalidMoveException(bewegung,this.getSpiel().getMoves());
    }

    public Bewegung getAktuelle () {
        return this.aktuelleBewegung;
    }
}
