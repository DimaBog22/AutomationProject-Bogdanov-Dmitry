package Lectures.BuilderPattern;

public class LectureTests {

    public static void main(String[] args) {

        PersonBuilder myPerson1 = new PersonBuilder.Builder()
                .withName("Dmitry")
                .withLastName("Bogdanov")
                .withSex("male")
                .withAge(27)
                .build();

        System.out.println(myPerson1.toString());
        
    }

}
