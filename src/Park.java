public class Park {
    private String name; // The name of the park
    private AmusementRide[] rides; // The array of amusement rides in the park
    private static final int MAX_RIDES = 5; // The maximum number of rides in the park

    /**
     * Constructs a park with a name and initializes the rides array.
     * @param name the name of the park
     */
    public Park(String name) {
        this.name = name;
        this.rides = new AmusementRide[MAX_RIDES];
    }

    /**
     * Adds a ride to the park.
     * @param ride the ride to be added
     */
    public void add(AmusementRide ride) {
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] == null) {
                rides[i] = ride;
                return;
            }
        }
    }

    /**
     * Removes a ride from the park and shifts the array to fill the gap.
     * @param ride the ride to be removed
     */
    public void remove(AmusementRide ride) {
        int index = -1; // index of the ride to be removed
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] == ride) {
                rides[i] = null;
                index = i; // saves the index of the removed ride
                break;
            }
        }

        // shifts the rides array to the left to fill the gap
        for (int i = index; i < MAX_RIDES-1; i++) {
            rides[i] = rides[i+1];
            rides[i+1] = null;
        }
    }

    /**
     * Starts all rides in the park in the order that they were added in.
     */
    public void startRides() {
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] != null) {
                rides[i].startRide();
            }
        }
    }

    /**
     * Adds a person to the queue of a specific ride.
     * @param ride the ride to add the person to
     * @param person the person to be added to the queue
     */
    public void addPerson(AmusementRide ride, Person person) {
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] == ride) {
                rides[i].getQueue().add(person, person.getFriend()); // adds the person to the queue
                return;
            }
        }
    }
}
