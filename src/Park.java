public class Park {
    private String name;
    private AmusementRide[] rides;
    private static final int MAX_RIDES = 5;

    public Park(String name) {
        this.name = name;
        this.rides = new AmusementRide[MAX_RIDES];
    }

    public void add(AmusementRide ride) {
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] == null) {
                rides[i] = ride;
                return;
            }
        }
    }

    public void remove(AmusementRide ride) {
        int index = -1;
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] == ride) {
                rides[i] = null;
                index = i;
                break;
            }
        }

        for (int i = index; i < MAX_RIDES-1; i++) {
            rides[i] = rides[i+1];
            rides[i+1] = null;
        }
    }

    public void startRides() {
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] != null) {
                rides[i].startRide();
            }
        }
    }

    public void addPerson(AmusementRide ride, Person person) {
        for (int i = 0; i < MAX_RIDES; i++) {
            if (rides[i] == ride) {
                rides[i].getQueue().add(person, person.getFriend());
                return;
            }
        }
    }
}
