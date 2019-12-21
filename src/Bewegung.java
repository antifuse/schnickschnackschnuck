import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Bewegung {
    private Collection<Bewegung> schlaegt;
    private String name;
    private Collection<String> aliases;

    public Bewegung(String name) {
        this.name = name;
        this.schlaegt = new ArrayList<>();
        this.aliases = new ArrayList<>();
        this.aliases.add(this.name);
    }

    public Collection<Bewegung> getSchlaegt() {
        return schlaegt;
    }

    public void setSchlaegt(Collection<Bewegung> schlaegt) {
        this.schlaegt = schlaegt;
    }

    public void setSchlaegt(Bewegung[] schlaegt) {
        this.schlaegt = Arrays.asList(schlaegt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<String> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<String> aliases) {
        this.aliases = aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases.addAll(Arrays.asList(aliases));
        this.aliases.add(this.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
