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
            String rsl = input.askStr(question);
            if (!isNumber(rsl)) {
                output.println("Please enter validate data again.");
                continue;
            }
            value = Integer.parseInt(rsl);
            invalid = false;
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

    private boolean isNumber(String value) {
        boolean rsl = true;
        char[] check = value.toCharArray();
        for (char num : check) {
            if (num < 48 || num > 57) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}