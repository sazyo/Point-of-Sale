public class Foodx {
    private String name;
    private String details;
    private String imagePath;
    private double price;
    private int Quantity;


    public Foodx(String name, String details, String imagePath, double price,int Quantity ) {
        this.name = name;
        this.details = details;
        this.imagePath = imagePath;
        this.price = price;
       this.Quantity= Quantity ;
    }


    public String getName() {
        return name;
    }

    public int  getQuantity() {return Quantity;}

    public String getDetails() {
        return details;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return getName();
    }
}