package in.championswimmer.graph;

/**
 * Created by championswimmer on 16/4/16.
 */
public class Vertex {

    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
