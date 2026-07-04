public class Vote {
    private final Person voter;
    private final String date;

    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }

    public Person getVoter() {
        return this.voter;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
