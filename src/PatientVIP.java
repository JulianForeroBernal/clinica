public class PatientVIP extends Patient {
    // own attributes
    private final int fidelityYears;
    //constructor
    public PatientVIP(String name, int id, int consultCost, int fidelityYears) {
        super(name, id, consultCost);
        this.fidelityYears = fidelityYears;
    }
    // getter and setter
    public int getFidelityYears() {
        return fidelityYears;
    }
    //overwrites
    @Override
    public void calculateFinalCost() {
        int total;
        if (this.fidelityYears >= 10){
            total = (int) (this.originalCost - (this.originalCost*0.4));
        } else if (this.fidelityYears >= 5) {
            total = (int) (this.originalCost - (this.originalCost*0.3));
        }else {
            total = (int) (this.originalCost - (this.originalCost*0.2));
        }
        if (this.isExpensiveConsult()) {
            total = 300000;
        }
        this.setConsultCost(total);
    }
    @Override
    public String showData() {
        return super.showData() + "\naños de fidelidad: " + this.getFidelityYears();
    }
}
