package model;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public String map(Animal animal) {
        StringBuilder commandsStr = new StringBuilder();
        List<String> commands = animal.getCommands();
        for (String command : commands) {
            commandsStr.append(command);
            commandsStr.append(", ");
        }
        if (commandsStr.length() > 2) {
            commandsStr.setLength(commandsStr.length() - 2);
        }

        if (animal instanceof Dog) {
            return String.format("%s;%s;%d", animal.getName(), commandsStr, 1);
        } else if (animal instanceof Cat) {
            return String.format("%s;%s;%d", animal.getName(), commandsStr, 2);
        } else if (animal instanceof Hamster) {
            return String.format("%s;%s;%d", animal.getName(), commandsStr, 3);
        } else if (animal instanceof Horse) {
            return String.format("%s;%s;%d", animal.getName(), commandsStr, 4);
        } else if (animal instanceof Camel) {
            return String.format("%s;%s;%d", animal.getName(), commandsStr, 5);
        } else if (animal instanceof Donkey) {
            return String.format("%s;%s;%d", animal.getName(), commandsStr, 6);
        } else {
            throw new IllegalArgumentException("Internal error! Object Animal have unknown type");
        }

    }

    public Animal map(String line) {
        String[] lines = line.split(";");
        String[] lineCommands = lines[1].split(", ");
        List<String> listCommands = new ArrayList<>();
        for (String command : lineCommands) {
            listCommands.add(command);
        }
        try {
            Animal animal =  new Cat(lines[0], listCommands);
            return animal;
        } catch (NumberFormatException e) {
            System.out.println("Invalid format of data in animals.scv file!");
        }
        return null;
    }
}