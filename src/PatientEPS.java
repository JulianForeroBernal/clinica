public class PatientEPS extends Patient{
    // own attributes
    private String nameEPS;
    //constructor
    public PatientEPS(String name, int id, int consultCost, String nameEPS) {
        super(name, id, consultCost);
        this.nameEPS = nameEPS;
    }
    // getter and setter
    public String getNameEPS() {
        return nameEPS;
    }
    public void setNameEPS(String nameEPS) {
        this.nameEPS = nameEPS;
    }
    //overwrites
    @Override
    public int calculateFinalCost() {
        double percent;
        int copayment;
        if (this.consultCost >= 300000){
            percent = 0.25;
        }else if(this.consultCost >= 80000){
            percent = 0.2;
        }else {
            percent = 0.3;
        }
        copayment = (int) (this.consultCost - (this.consultCost * percent));
        if(this.isExpensiveConsult()) {
            copayment = (int) (copayment - (copayment * 0.05));
            this.setConsultCost(copayment);
        }else {
            this.setConsultCost(copayment);
        }
        return this.getConsultCost();
    }
    @Override
    public String showData() {
        return super.showData() + "\nnombre EPS: " + this.nameEPS;
    }
}
