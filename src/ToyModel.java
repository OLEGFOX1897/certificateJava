

class ToyModel implements ItoyModels {
    private int id;
    private int quantityToy;
    private String nameToy;
    private double dropProbability;

    public ToyModel(int id, String name, int quantity, double dropProbability) {
        this.id = id;
        this.nameToy = name;
        this.quantityToy = quantity;
        this.dropProbability = dropProbability;
    }

    public int getQuantityToy() {
        return quantityToy;
    }

    public void setQuantityToy(int quantityToy) {
        this.quantityToy = quantityToy;
    }

    public String getNameToy() {
        return nameToy;
    }

    public int getId() {
        return id;
    }

    public double getDropProbability() {
        return dropProbability;
    }

    @Override
    public String getStringNameToy() {
        return "ID: " + getId() + " Наименование: " + getNameToy() + " Количество: " + getQuantityToy();
    }
}
