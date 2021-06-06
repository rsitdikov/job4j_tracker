package ru.job4j.oop.profession;

public class Doctor extends Profession {

    public Diagnose heal(Patient patient) {
        Diagnose hl = new Diagnose();
        String dgn = patient.getHealth() > 80 ? "healthy" : "ill";
        hl.setDiagnosis(dgn);
        return hl;
    }
}
