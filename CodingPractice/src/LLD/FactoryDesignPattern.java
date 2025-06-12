package LLD;
interface Vehicle
{
    public void start();
}
class Car implements Vehicle
{
    public void start()
    {
        System.out.println("Car started");
    }
}
class Bike implements Vehicle
{
    @Override
    public void start() {
        System.out.println("Bike started");
    }
}
class VehicleFactory
{
    public static Vehicle GetVehicle(String type)
    {
        if(type.equals("Car"))
        {
        return new Car();
        }
        else if(type.equals("Bike"))
        {
        return new Bike();
        }
        return null;
    }
}
public class FactoryDesignPattern {

    public static void  main(String[] args)
    {
        Vehicle car = VehicleFactory.GetVehicle("Car");
        Vehicle bike = VehicleFactory.GetVehicle("Bike");
        car.start();
        bike.start();
    }

}
