import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C15_FakerClass {

    @Test
    public void fakerClassTest(){

        Faker faker = new Faker();

        String fName = faker.name().firstName();
        System.out.println("fName = " + fName);
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.number().digit() = " + faker.number().digit());
        System.out.println("faker.number().numberBetween(10, 20) = " + faker.number().numberBetween(10, 20));
        System.out.println("faker.book().author() = " + faker.book().author());
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());

        System.out.println("Faker.instance().name().fullName() = " + Faker.instance().name().fullName());


    }
}
