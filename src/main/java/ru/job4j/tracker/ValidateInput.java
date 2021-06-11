package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    private final Input input;
    private final Output output;

    public ValidateInput(Output output, Input input) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException moe) {
                output.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                output.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}