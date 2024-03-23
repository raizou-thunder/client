package net.raizou.client.client.command;

public class Command {
    private String name, name2, usage;

    public Command(String name, String name2, String usage) {
        this.name = name;
        this.name2 = name2;
        this.usage = usage;
    }

    public void executeCommand(String[] args) {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return this.name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getUsage() {
        return this.usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
