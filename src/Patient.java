public class Patient {
    // attributes
    protected String name;
    protected int id;
    protected int consultCost;
    protected int finalValue;

    //methods
    // constructor
    public Patient(String name, int id, int consultCost) {
        this.name = name;
        this.id = id;
        this.consultCost = consultCost;
        this.finalValue = 0;
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
    // own methods
    public int calculateFinalCost(){
        return this.getConsultCost();
    }
    public int applyDiscount(int percent){
        return (this.consultCost - (this.consultCost*(percent/100)));
    }
    public int applySurcharge(int percent){
        this.consultCost = this.consultCost + (this.consultCost*(percent/100));
        return this.consultCost;
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
    public String showData(double finalCost){
        return "nombre: " + this.name +
                "id: "+ this.id  +
                "valor original de la consulta: " +this.consultCost;

    }
}
