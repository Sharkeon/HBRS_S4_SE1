import java.util.List;

public interface sequenceIF {
    public List<String> anfangenmit();
    public boolean korrekteSequenz (String[] sequence);
    public boolean weitermit (String a, List<String> gelesen);
    public boolean isWellSorted( String[] sequence );
}
