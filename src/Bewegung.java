import java.util.ArrayList;
import java.util.Collection;

public class Bewegung {
    private Collection<Bewegung> schlaegt;
    private String name;
    private ArrayList<String> aliases;

    public Bewegung(String name) {
        this.name = name;
        this.schlaegt = new ArrayList<>();
        this.aliases = new ArrayList<>();
    }

    public Collection<Bewegung> getSchlaegt() {
        return schlaegt;
    }

    public void setSchlaegt(Collection<Bewegung> schlaegt) {
        this.schlaegt = schlaegt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<String> aliases) {
        this.aliases = aliases;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
