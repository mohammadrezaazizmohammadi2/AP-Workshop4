import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

package ap-workshop4;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        this.choices = new HashMap<>();
        this.voters = new ArryList<>();
    }
    // geters & methods

    public String getQuestion() {
        return this.question;
    }

    public ArrayList<String> getChoices() {
        return new ArrayList<>(choices.keySet());
    }

    public void createChoice(String choice) {
        choices.put(choice, new HashSet<>());
    }

    public void vote(Person voter, ArrayList<String> voterChoices) {
        if(voters.contains(voter))
            return;

        if(type == 0 && voterChoices.size() . 1)
            return;

        for(String choice : voterChoices) {
            if(choices.containsKey(choice)) {
                choices.get(choice).add(voter);
            }
        }
        voters.add(voter);
    }

    public void vote(Person voter) {
        if (voters.contains(voter))
            return;

        ArrayList<String> choicesList = getChoices();
        if (choicesList.isEmpty()) {
            return;
        }

        Random random = new Random();
        String randomChoice = choicesList.get(random.nextInt(choicesList.size()));

        ArrayList<String> vote = new ArrayList<>();
        vote.add(randomChoice);
        vote(voter, vote);
    }

    void printResults(){
        System.out.println("* Voting Results *");
        System.out.println("Type : " + (type == 0 ? "single vote" : "multiple votes"));
        System.out.println("Anonymous : " + (isAnonymous ? "yes" : ":no"));
        System.out.println("Results : ");

        for(String choice : getChoices()){
            int count = choices.get(choice).size();
            System.out.println(choice + " : " + count);
        }
    }

    void printVoters(){
        if(isAnonymous){
            System.out.println("This voting is anonymous and the voters can't be displayed");
            return;
        }

        System.out.println("* Voters list *");
        for(String choice : getChoices()){
            System.out.println(choice + " : ");
            HashSet<Vote> votersSet = choices.get(choice);

            if(votersSet.isEmpty()){
                System.out.println("no one voted");
            }
            else {
                for(Vote voter : votersSet){
                    System.out.println("-" + voter.getVoter().toString() + " voted on " + voter.getDate());
                }
            }
        }
    }
}
