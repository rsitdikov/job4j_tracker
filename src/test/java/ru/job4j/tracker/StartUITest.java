package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
            new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "=== Show all Items ===" + ln
                + "Хранилище еще не содержит заявок" + ln
                + "Menu:" + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "FIX", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
                + "=== Find items by name ====" + ln
                + "Заявки с именем: FIX не найдены." + ln
                + "Menu:" + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindId() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "100", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
                + "=== Find item by id ====" + ln
                + "Заявка с введенным id: 100 не найдена." + ln
                + "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                )
        );
    }
}