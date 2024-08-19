public class Person implements Cloneable {
    private String name; // The name of the person
    private int id; // The unique ID of the person
    private Person friend; // The friend of the person

    /**
     * Constructs a person with a name, an ID, and a friend.
     * @param name the name of the person
     * @param id the unique ID of the person
     * @param friend the friend of the person
     */
    public Person(String name, int id, Person friend) {
        this.name = name;
        this.id = id;
        this.friend = friend;
    }

    /**
     * Returns the string representation of the person.
     * @return the name of the person
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Checks if this person is equal to another object.
     * @param obj the object to compare with
     * @return true if the objects are the same or have the same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return this.id == other.id; // Two people are equal if they have the same ID
    }

    /**
     * Returns the friend of the person.
     * @return the friend of the person
     */
    public Person getFriend() {
        return friend;
    }

    /**
     * Clones the person .
     * @return a clone of the person
     */
    @Override
    public Person clone() {
        try {
            Person clone = (Person) super.clone();
            clone.friend = this.friend.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
