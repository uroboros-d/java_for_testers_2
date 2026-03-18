package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<Group> groupProvider() {
        var result = new ArrayList<Group>();
        for (var name : List.of("", "name")) {
            for (var header : List.of("", "header")) {
                for (var footer : List.of("", "footer")) {
                    result.add(new Group()
                            .withName(name)
                            .withHeader(header)
                            .withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new Group()
                    .withName(randomString(i * 10))
                    .withHeader(randomString(i * 10))
                    .withFooter(randomString(i * 10)));
        }
        return result;
    }

    public static List<Group> negativeGroupProvider() {
        return new ArrayList<>(List.of(new Group().withName("name'")));
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"name", "name'"})
//    public void canCreateGroup(String name) {
//        int groupCount = app.groups().getCount();
//        app.groups().createGroup(new Group()
//                .withName(name)
//                .withHeader("header")
//                .withFooter("footer"));
//        int newGroupCount = app.groups().getCount();
//        Assertions.assertEquals(groupCount + 1, newGroupCount);
//    }

//    @Test
//    public void canCreateGroupWithEmptyName() {
//        app.groups().createGroup(new Group());
//    }

//    @Test
//    public void canCreateGroupWithNameOnly() {
//        app.groups().createGroup(new Group().withName("nameOnly"));
//    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateGroups(Group group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Comparator<Group> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group
                .withId(newGroups.get(newGroups.size() - 1).id())
                .withHeader("")
                .withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(Group group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(newGroups, oldGroups);
    }
}