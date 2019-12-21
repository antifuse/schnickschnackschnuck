import java.util.Collection;

public class InvalidMoveException extends Exception {
    private String triedMove;
    private Collection<Bewegung> possibleMoves;
    public InvalidMoveException(String triedMove, Collection<Bewegung> possibleMoves) {
        super();
        this.triedMove = triedMove;
        this.possibleMoves = possibleMoves;
    }
    public InvalidMoveException() {
        super();
    }

    public String getTriedMove() {
        return triedMove;
    }

    public void setTriedMove(String triedMove) {
        this.triedMove = triedMove;
    }

    public Collection<Bewegung> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(Collection<Bewegung> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
}
