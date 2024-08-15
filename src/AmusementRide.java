public class AmusementRide {
    private String name;
    private IsraeliQueue<Person> queue;
    private final int capacity;

    public AmusementRide(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.queue = new IsraeliQueue<>();
    }

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

    public IsraeliQueue<Person> getQueue() {
        return queue;
    }
}
