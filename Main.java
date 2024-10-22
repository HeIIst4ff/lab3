public class Main {
    public static void main(String[] args) {
        CarPark carPark = new CarPark(10);

        Car car1 = new Car("Toyota", "Camry", 2020);
        carPark.addCar("A1234BC", car1);

        Car car2 = new Car("Honda", "CR-V", 2021);
        carPark.addCar("B5678CD", car2);

        System.out.println("Количество машин: " + carPark.getSize());

        Car foundCar = carPark.findCar("A1234BC");
        System.out.println("Найденая машина: " + foundCar.getMake() + " " + foundCar.getModel() + " (" + foundCar.getYear() + ")"); // Output: Found car: Toyota Camry (2020)

        carPark.removeCar("B5678CD");

        System.out.println("Количество машин: " + carPark.getSize()); 

        foundCar = carPark.findCar("B5678CD");
        System.out.println("Найденая машина: " + foundCar); 
    }
}
