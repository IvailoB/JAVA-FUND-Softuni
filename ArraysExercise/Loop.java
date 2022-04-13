package ArraysExercise;

public class Loop {

    private int number;

    public Loop(int number) {
        this.number = number;
    }

    public void method() {
        for (int i = 0; i < number; i++){
            System.out.println(i);
        }
    }
}
