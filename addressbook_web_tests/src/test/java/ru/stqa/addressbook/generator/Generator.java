package ru.stqa.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.Contact;
import ru.stqa.addressbook.model.Group;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

import static ru.stqa.addressbook.tests.TestBase.randomFile;

public class Generator {

    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-c"})
    int count;

    public static void main(String[] args) {
        var generator = new Generator();
        JCommander.newBuilder()
                        .addObject(generator)
                        .build()
                        .parse(args);
        generator.run();
    }

    private void run() {
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных" + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<Group>();
        for (int i = 0; i < count; i++) {
            result.add(new Group()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    private Object generateContacts() {
        var result = new ArrayList<Contact>();
        for (int i = 0; i < count; i++) {
            result.add(new Contact()
                    .withLastname(CommonFunctions.randomString(i * 10))
                    .withFirstname(CommonFunctions.randomString(i * 10))
                    .withAddress(CommonFunctions.randomString(i * 10))
                    .withPhoto(randomFile("src/test/resources/images")));
        }
        return result;
    }

    private void save(Object data) {
        if("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных" + format);
        }
    }
}
