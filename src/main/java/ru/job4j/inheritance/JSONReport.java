package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "{\n"
                + "\t\"name\" : \"" + name + "\",\n"
                + "\t\"body\" : \"" + body + "\"\n"
                + "}";
    }
}

