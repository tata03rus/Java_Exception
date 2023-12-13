public class PersonBuilder {

    private Person person;
    public PersonBuilder() {
        person = new Person();
    }

    public Person build(){
        return person;
    }

    public PersonBuilder setName(String name) {
        person.name = name;
        return this;
    }

    public PersonBuilder setLastname(String lastname) {
        person.lastname = lastname;
        return this;
    }

    public PersonBuilder setFatherName(String fatherName) {
        person.fatherName = fatherName;
        return this;
    }

    public PersonBuilder setDateOfBirtday(String dateOfBirtday) {
        person.dateOfBirtday = dateOfBirtday;
        return this;
    }

    public PersonBuilder setNumber(Long number) {
        person.number = number;
        return this;
    }

    public PersonBuilder setGender(String gender) {
        person.gender = gender;
        return this;
    }
}