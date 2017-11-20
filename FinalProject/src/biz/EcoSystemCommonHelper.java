package biz;

import biz.account.Account;
import biz.account.AccountCatalog;
import biz.person.Person;
import biz.person.PersonCatalog;
import biz.role.Role;
import com.github.javafaker.Faker;

public class EcoSystemCommonHelper {
    private static Faker faker = new Faker();

    public static Person fakePerson(PersonCatalog personCatalog) {
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        Person p = personCatalog.newPerson(fName, lName);
        p.setEmail(faker.internet().emailAddress());
        return p;
    }

    public static Account fakeAccount(AccountCatalog accountCatalog, Person p, Role r) {
        Account account = null;
        try {
            account = accountCatalog.newAccount(faker.name().username(), faker.internet().password(), r, p);
        } catch (Exception ignored) {

        }
        return account;
    }
}
