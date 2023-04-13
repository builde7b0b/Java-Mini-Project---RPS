public abstract class Player {


    private String name;

    public Player(String name) {
    }

    public String getName() {
        return name;

    }

    public abstract int choose();

    public abstract void getChoice();

}
