public class Patient {
    // attributes
    protected String name;
    protected int id;
    protected int consultCost;
    protected int originalCost;

    //methods
    // constructor
    public Patient(String name, int id, int consultCost) {
        this.name = name;
        this.id = id;
        this.consultCost = consultCost;
        this.originalCost = consultCost;
    }
    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsultCost() {
        return consultCost;
    }

    public void setConsultCost(int consultCost) {
        this.consultCost = consultCost;
    }
    public int getOriginalCost() {
        return originalCost;
    }
    public void setOriginalCost(int originalCost) {
        this.originalCost = originalCost;
    }
    // own methods
    public void calculateFinalCost(){
    }
    public void applyDiscount(int percent){
        this.setConsultCost(this.getConsultCost() - (this.getConsultCost()*(percent/100)));
    }
    public void applySurcharge(int percent){
        this.setConsultCost(this.getConsultCost() + (this.getConsultCost()*(percent/100)));
    }
    public boolean isExpensiveConsult(){
        /*if(this.consultCost > 300000){
            return true;
        }else {
            return false;
        }
        se puede hacer más corto de la forma en que está abajo
        */
        return this.consultCost > 300000;
    }
    public String showData(){
        return "nombre: " + this.name +
                "\nid: " + this.id + " " +
                "\nvalor original de la consulta: " +this.originalCost +
                "\nvalor final de la consulta: " + this.getConsultCost();
    }
}
