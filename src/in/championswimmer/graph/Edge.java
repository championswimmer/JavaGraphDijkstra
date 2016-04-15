package in.championswimmer.graph;

/**
 * Created by championswimmer on 16/4/16.
 */
public class Edge {

    String id;
    Vertex source;
    Vertex destination;
    int weight = 1;


    public Edge(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " -> " + destination;
    }
}
