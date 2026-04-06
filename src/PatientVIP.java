public class PatientVIP extends Patient {
    // own attributes
    private int fidelityYears;
    //constructor
    public PatientVIP(String name, int id, int consultCost) {
        super(name, id, consultCost);
    }
    // getter and setter
    public int getFidelityYears() {
        return fidelityYears;
    }

    public void setFidelityYears(int fidelityYears) {
        this.fidelityYears = fidelityYears;
    }
    //overwrites

    @Override
    public int calculateFinalCost() {
        int total;
        if (this.fidelityYears >= 10){
            total = (int) (this.consultCost - (this.consultCost*0.4));
        } else if (this.fidelityYears >= 5) {
            total = (int) (this.consultCost - (this.consultCost*0.3));
        }else {
            total = (int) (this.consultCost - (this.consultCost*0.2));
        }
        if (this.isExpensiveConsult()) {
            total = 300000;
        }
        this.setConsultCost(total);
        return this.getConsultCost();
    }
}
