package ap-workshop4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        ArrayList<String> choices1 = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
        votingSystem.createVoting("Best programming language?", true, 0, choices1);

        ArrayList<String> choices2 = new ArrayList<>(Arrays.asList("Music", "Movie", "Sport"));
        votingSystem.createVoting("Favorite hobby?", false, 1, choices2);

        Person alice = new Person("Alice", "Smith");
        Person bob = new Person("Bob", "Johnson");
        Person carol = new Person("Carol", "Davis");

        System.out.println("=== Voting Started ===\n");

        System.out.println("--- Voting 0: Best language ---");
        votingSystem.vote(0, alice, new ArrayList<>(Arrays.asList("Java")));
        votingSystem.vote(0, bob, new ArrayList<>(Arrays.asList("Python")));
        votingSystem.vote(0, carol);

        System.out.println("Duplicate vote attempt:");
        votingSystem.vote(0, alice, new ArrayList<>(Arrays.asList("Java")));

        System.out.println("\n--- Voting 1: Favorite hobby ---");
        votingSystem.vote(1, alice, new ArrayList<>(Arrays.asList("Music", "Movie")));
        votingSystem.vote(1, bob, new ArrayList<>(Arrays.asList("Sport")));
        votingSystem.vote(1, carol, new ArrayList<>(Arrays.asList("Music", "Sport")));

        System.out.println("\n=== Final Results ===\n");

        for (int i = 0; i < votingSystem.getVotingList().size(); i++) {
            System.out.println("---------- Voting " + i + " ----------");
            votingSystem.printVoting(i);
            votingSystem.printResults(i);
            votingSystem.printVoters(i);
            System.out.println();
        }
    }
}
