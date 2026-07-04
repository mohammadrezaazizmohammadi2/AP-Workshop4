package ap-workshop4;

import java.util.ArrayList;
import java.util.Objects;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }

    public Voting getVoting(int index){
        return votingList.get(index);
    }

    public ArrayList<Voting> getVotingList(){
        return votingList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VotingSystem that = (VotingSystem) o;
        return Objects.equals(votingList, that.votingList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(votingList);
    }


    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices){
        Voting newVoting = new Voting(type, question, isAnonymous);
        for(String choice : choices){
            newVoting.createdChoice(choice);
        }
        votingList.add(newVoting);
    }

    public void vote(int index, Person voter){
        getVoting(index).vote(voter);
    }

    public void vote(int index, Person voter, ArrayList<String> choices){
        getVoting(index).vote(voter, choices);
    }

    public void printResults(int index){
        Voting voting = getVoting(index);

        if (voting == null) {
            System.out.println("Invalid voting index!");
            return;
        }
        voting.printResults();
    }
    public void printVoters(int index){
        Voting voting = getVoting(index);

        if (voting == null) {
            System.out.println("Invalid voting index!");
            return;
        }
        voting.printVoters();
    }

    public void  printVoting(int index){
        Voting voting = getVoting(index);

        if (voting == null) {
            System.out.println("Invalid voting index!");
            return;
        }
        System.out.println("\n***");
        System.out.println("The question:");
        System.out.println(voting.getQuestion());
        System.out.println("The choices:");
        ArrayList<String> allChoices = voting.getChoices();
        int i = 0;
        for(String choice : allChoices){
            System.out.println((i+1) + ". " + choice);
        }
        System.out.println("\n***");
    }
}
