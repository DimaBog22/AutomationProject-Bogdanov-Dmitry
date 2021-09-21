package Lectures.LombokAndLogsLecture;

import org.testng.annotations.Test;

public class LombokTests {

    @Test
    public void test1() {

        Car audi = new Car();
        audi.setModel("Audi");
        audi.setEngine(2.8);
        audi.setMaxSpeed(270);
        System.out.println(audi); //Car(model=Audi, engine=2.8, maxSpeed=270)
        // to receive such view of output we should override toString method
        // with lombok we can do it just left @ToString annotation

    }
    @Test
    public void test2() {

        Pet pet = new Pet.PetBuilder()
                .name("Charli")
                .type("Pug")
                .age(4)
                .build();
        System.out.println(pet); // Pet(name=Charli, type=Pug, age=4)

    }

}
