package Model;

public abstract class RenewableEnergySource {
    protected String id;
    protected double generatedPower;
    public RenewableEnergySource(String id){
        this.id = id;
        this.generatedPower = 0;
    }
    public String getId() {
        return id;
    }

    public double getGeneratedPower() {
        return generatedPower;
    }
    public abstract void generatePower();

    @Override
    public String toString() {
        return  "Energy source ID: " +id + "| Power: " +
                generatedPower+ "KW";
    }
    }


