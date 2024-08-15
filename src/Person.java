public class Person {
    private String name;
    private int id;
    private Person friend;

    public Person(String name, int id, Person friend) {
        this.name = name;
        this.id = id;
        this.friend = friend;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person other)) return false;
        return this.id == other.id;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }
}
