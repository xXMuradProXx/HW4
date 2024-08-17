public class AmusementRide {
    private String name; // The name of the amusement ride
    private IsraeliQueue<Person> queue; // The queue of people waiting for the ride
    private final int capacity; // The maximum capacity of the ride

    /**
     * Constructs an amusement ride with a name and a capacity.
     * @param name the name of the ride
     * @param capacity the capacity of the ride
     */
    public AmusementRide(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.queue = new IsraeliQueue<>();
    }

    /**
     * Starts the ride and prints the name of each person that enters the ride and removes them from the queue.
     * If the queue is empty, it prints "Ride is empty."
     */
    public void startRide() {
        if (this.queue.size() == 0) {
            System.out.println("Ride is empty.");
            return;
        }
        System.out.println("Currently using the ride:");
        int size = queue.size();
        for (int i = 0; i < size && i < capacity; i++) {
            System.out.println(queue.remove().toString());
        }
    }

    /**
     * Returns the queue of the ride.
     * @return the queue of the ride
     */
    public IsraeliQueue<Person> getQueue() {
        return queue;
    }
}
