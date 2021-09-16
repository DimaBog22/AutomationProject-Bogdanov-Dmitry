package Lectures.BuilderPattern;

public class PersonBuilder {

    String name;
    String lastname;
    Integer age;
    String sex;

    public static class Builder {

        private PersonBuilder personBuilder;

        public Builder() {
            personBuilder = new PersonBuilder();
        }

        public PersonBuilder build() {
            return personBuilder;
        }

    }

}
