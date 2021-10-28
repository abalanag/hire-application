<h2 align="center">HIRE APPLICATION</h2>
<p align="center">An application for hiring vehicles that can manage orders, create orders and update them.</p>

### Technology Stack
    - Java SE 16

### Setup and Running
- You will need to download and [install](https://jdk.java.net/16/) Java JDK 16
- Clone repository 'https://github.com/abalanag/hire-application'
  - You can clone the repository using [github Desktop](https://docs.github.com/en/desktop/contributing-and-collaborating-using-github-desktop/adding-and-cloning-repositories/cloning-and-forking-repositories-from-github-desktop)
  - Through [command line](https://docs.github.com/en/desktop/contributing-and-collaborating-using-github-desktop/adding-and-cloning-repositories/cloning-and-forking-repositories-from-github-desktop) 'gh repo clone https://github.com/abalanag/hire-application'
  - Or through [web browser](https://docs.github.com/en/desktop/contributing-and-collaborating-using-github-desktop/adding-and-cloning-repositories/cloning-and-forking-repositories-from-github-desktop)
- To run the application you will need to run the file hire-application.jar in the command line
  - You will open the command line and type 'cd' followed by the location of the application and after that '& java -jar hire-application.jar' for example 'cd C:\Java\hire-application & java -jar hire-application.jar'

### Operating the application
- When you will open the application you will see a message that will request you to choose an option, you will have available 4 options:
  - '1. For managing vehicle renting type '1'' - If you chose this option you will receive another message that will ask you to type '1' for renting a vehicle or to type '2' to return a vehicle;
    - Renting vehicle option (Option 1) will guide you through a series of questions needed for renting a vehicle:
      - Choosing the type of vehicle - you will need to choose one type from the list that will be printed;
      - Giving the renting date - the date should have the format dd/MM/yyyy;
      - Giving the customer name
      - Giving the customer's phone number
    - Returning a vehicle (Option 2) - this method will allow you to close order by returning a vehicle
      - Typing the order number - you will need to choose 1 order number from the list that was printed
      - Evaluating the rented object status - if it was damaged or not
      - Evaluating the fuel level of the rented object - If, at the return, the vehicle tank is full
  - '3. For showing all orders type 3' - it will you show all orders
  - '4. For closing the application type 4' - it will close the application

### How to add new types of vehicles
- At this moment, the only type of available vehicles are cars. If you would like to add a new type, you would need to create a new class in the package vehicle.
- All new vehicles should extend the class Vehicle and implement all the abstract methods that are in that class.
- This is all you will need to do to add a new vehicle.

### How to add a new type of renting object
- If you would like to add a new type of object for renting, you will need first to create the parent class, the class that will define all the child classes. For example, if you will add hotel rooms for hire, you will need to define the parent class, this class will be Building.
- The parent class will need to implement the interface Rentable and you will need to implement all the classes from this interface.
- Next step will be to create the Class that will store the parent class (Building). For this one, I will advise you to use the parent name followed by order (for example BuildingOrder). in this way it will be easier to follow the code :D
- The class that you will use for storing the data will need to extend the abstract class Order, in this case, you will need again to implement all the methods.
- Ok, so everything is set us. You will have only one thing to do to have everything finished. You will need to create a new function in the main menu that will allow you to create new types of hiring objects. For that you will need to follow these steps:  
  - In the application class, you will need to create a new case. For this, you can easily copy everything that was written in the vehicle order case. Now you will need to modify something to have everything ready. For renting an object, you will need to make the following changes:
    - You will need to create a new instance for the Order object, and you will need to replace the type that was passed, from Vehicle to the new type(for example Hotel). This is very important to do because you will tell what type will replace the generic one. I prepared an example down below:
    - `final Order<Vehicle> newOrder = new VehicleOrder(new Date(), new Customer(), new Car());` to `final Order<Buildin> buildinOrder = new VehicleOrder(new Date(), new Customer(), new Hotel());`
    - After that you will need to change everywhere the old reference name with the new one in order for all the methods to be called with the help of the new reference. For example for this method `newOrder.receiveHiredObject().setType(carTypeInput);` you will change it to `buildingOrder.receiveHiredObject().setType(carTypeInput);`
    - And this is all, now you can create orders for different types of objects.
  - Now let's make the remaining changes so that we can close orders by return the new object. For that you will need to make the following changes:
    - First, you will create a new instance for order, and again you will need to replace the given type. Example `Order<Vehicle> order = null;` to `Order<Building> newBuildingOrder = null;`
    - You will need to replace the name reference with the new one;
    - And in the end, if your new object doesn't have a property fuel, you can remove the call of the method that is checking the fuel level.
    - ⚠️Be careful, do not remove the try-catch. If the user selects the wrong order, will be thrown ClassCastException