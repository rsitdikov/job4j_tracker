package ru.job4j.oop.profession;

public class Engineer extends Profession {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Work[] planWork(Work[] works) {
        return null;
    }

    public Work doWork(Work work) {
        return null;
    }

    public String[] createReport(Work[] works) {
        return null;
    }
}
