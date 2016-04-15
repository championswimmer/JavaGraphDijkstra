package in.championswimmer;

import in.championswimmer.graph.DijkstraAlgorithm;
import in.championswimmer.graph.Edge;
import in.championswimmer.graph.Graph;
import in.championswimmer.graph.Vertex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("How many nodes in the graph ? ");
        int num;
        try {
            num = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            num = 5;
        }
        List<Vertex> persons = new ArrayList<>(num);

        for (int i = 0; i< num; i++) {
            System.out.println("Name of Person " + i + " ? ");
            Vertex person = new Vertex("person_"+i, br.readLine());
            persons.add(person);
        }

        List<Edge> friendships = new ArrayList<>(num*2);
        for (int i = 0; i< (num*2); i++) {
            Random r = new Random();
            System.out.println(String.valueOf(r.nextInt(num)));
            friendships.add(makeFriendShip(r.nextInt(num), r.nextInt(num), i, persons));
        }

        printFriendShips(friendships);

        Graph graph = new Graph(persons, friendships);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(persons.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(persons.get(num-1));

        System.out.println("Path from " + persons.get(0) + " to " + persons.get(num-1));

        try {
            for (Vertex vertex : path) {
                System.out.println(vertex);
            }
        } catch (NullPointerException e) {
            System.out.println("No Path Exists");
            e.printStackTrace();
        }

    }

    public static Edge makeFriendShip(int person1, int person2, int id, List<Vertex> persons) {
        return new Edge("friendship"+id, persons.get(person1), persons.get(person2), 1);
    }

    private static void printFriendShips(List<Edge> friendships) {
        for (Edge friendship: friendships) {
            System.out.println(friendship.toString());
        }
    }
}
