package Lectures.BuilderPattern;

public class PersonBuilder {

    String name;
    String lastname;
    Integer age;
    String sex;

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static class Builder {

        private PersonBuilder personBuilder;

        public Builder() {
            personBuilder = new PersonBuilder();
        }

        public Builder withName(String name) {

            personBuilder.name = name;
            return this;

        }

        public Builder withLastName(String lastname) {

            personBuilder.lastname = lastname;
            return this;

        }

        public Builder withSex(String sex) {

            personBuilder.sex = sex;
            return this;

        }

        public Builder withAge(Integer age) {

            personBuilder.age = age;
            return this;

        }

        public PersonBuilder build() {
            return personBuilder;
        }

    }

}
