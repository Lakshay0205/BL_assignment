import java.util.*;

public class VotingSystem {

    private Map<String, Integer> votes;
    private TreeMap<String, Integer> sortedResults;
    private LinkedHashMap<String, Integer> voteOrder;

    public VotingSystem() {
        votes = new HashMap<>();
        sortedResults = new TreeMap<>();
        voteOrder = new LinkedHashMap<>();
    }

    public void castVote(String candidate) {
        if (!votes.containsKey(candidate)) {
            votes.put(candidate, 0);
        }
        votes.put(candidate, votes.get(candidate) + 1);
        voteOrder.put(candidate, votes.get(candidate));
    }

    public void displayResults() {
        sortedResults.clear();
        sortedResults.putAll(votes);

        System.out.println("--- Voting Results (Sorted by Candidate) ---");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n--- Vote Order ---");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");

        votingSystem.displayResults();

        votingSystem.castVote("David");
        votingSystem.castVote("Alice");

        votingSystem.displayResults();
    }
}