import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Spiel {
    private Collection<Bewegung> moves;
    private Spieler spielerA;
    private Spieler spielerB;

    public Spiel(){}

    public Spiel(Spieler spielerA, Spieler spielerB) {
        this.spielerA = spielerA;
        this.spielerB = spielerB;
        this.spielerA.setSpiel(this);
        this.spielerB.setSpiel(this);
        this.moves = new ArrayList<>();
    }

    public Collection<Bewegung> getMoves() {
        return moves;
    }

    public void setMoves(Collection<Bewegung> moves) {
        this.moves = moves;
    }

    public void setMoves(Bewegung[] moves) {
        this.moves = Arrays.asList(moves);
    }

    public Spieler getA() {
        return spielerA;
    }

    public void setA(Spieler spielerA) {
        this.spielerA = spielerA;
        this.spielerA.setSpiel(this);
    }

    public Spieler getB() {
        return spielerB;
    }

    public void setB(Spieler spielerB) {
        this.spielerB = spielerB;
        this.spielerB.setSpiel(this);

    }

    public boolean isValidMove(String move) {
        for (Bewegung b: this.getMoves()) {
            if (b.getAliases().contains(move)) return true;
        }
        return false;
    }

    public Spieler eval() {
        if (this.spielerA.getAktuelle().getSchlaegt().contains(this.spielerB.getAktuelle())) return spielerA;
        if (this.spielerB.getAktuelle().getSchlaegt().contains(this.spielerA.getAktuelle())) return spielerB;
        return null;
    }
}
