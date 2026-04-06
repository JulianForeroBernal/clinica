public class ParticularPatient extends Patient{
    //constructor
    public ParticularPatient(String name, int id, int consultCost) {
        super(name, id, consultCost);
    }
    //overwrites
    @Override
    public int calculateFinalCost() {
        int total;
        if (this.consultCost >= 400000){
            total = (int) (this.consultCost - (this.consultCost*(0.15)));
        }else if(this.consultCost >= 200000){
            total = (int) (this.consultCost - (this.consultCost*(0.1)));
        }else if(this.consultCost >= 50000){
            total = (int) (this.consultCost - (this.consultCost*(0.05)));
        }else {
            total = this.consultCost;
        }
        this.setConsultCost(total);
        return  this.getConsultCost();
    }
}
