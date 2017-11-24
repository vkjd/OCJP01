package Chapter2;

public class ImmutableObjectPattern {
    public ImmutableObjectPattern(){
        System.out.println(">>> ImmutableObjectPattern");
        new ImmutableTest(42, "foo");
    }
}

final class ImmutableTest{
    private final int number;
    private final String name;

    ImmutableTest(int number, String name){
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
}