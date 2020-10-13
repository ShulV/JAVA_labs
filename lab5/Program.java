import java.util.Scanner;//консольный ввод
public class Program{
	public static void main(String[] args) {
	
	//System.out.println("Hi, Kate!");
	Car bmw_x6 = new Car();
	Engine bmw_engine = new Engine();
	bmw_x6.init("BMW X6", 1200000, "Red", 0, 0, bmw_engine);
	bmw_x6.displayDataCar();
	bmw_x6.readCarData();
	bmw_x6.displayDataCar();
	}
}



class Engine{
	
}

class Car {
	Scanner in = new Scanner(System.in);

	String name;
	int price;
	String color;
	int speed;
	int benzine;
	Engine engine;
	void init(String name, int price, String color, int speed, int benzine, Engine engine){
		this.name = name;
		this.price = price;
		this.color = color;
		this.speed = speed;
		this.benzine = benzine;
		this.engine = engine;
		System.out.println("Car initialized!");
	}
	void readCarData(){
		System.out.println("ENTER CAR DATA:");
		System.out.print("\tname:\t");
		this.name = in.nextLine();
		System.out.print("\tprice:\t");
		this.price = in.nextInt();
		in.nextLine();//очистка потока
		System.out.print("\tcolor:\t");
		this.color = in.nextLine();
		/*System.out.print("\tengineRPM:\t");
		this.engineRPM = in.nextInt();
		System.out.print("\tcapacity:\t");
		this.capacity = in.nextInt();
		System.out.print("\tengine power:\t");
		this.engine = in.nextInt();
		*/
		System.out.print("\tspeed:\t");
		this.speed = in.nextInt();
		in.nextLine();//очистка потока
		System.out.print("\tbenzine:\t");
		this.benzine = in.nextInt();
		in.nextLine();//очистка потока

	}
	void displayDataCar(){
		System.out.println("\tCar data");
		System.out.println("\t\tName:\t" + this.name);
		System.out.println("\t\tPrice:\t" + this.price);
		System.out.println("\t\tColor:\t" + this.color);
		//
		System.out.println("\t\tBenzine:\t" + this.benzine);
		System.out.println("\t\tSpeed:\t" + this.speed);
	}
	void addBenzine(int liters){
	
	}
	void startEngine(){
	
	}
	void stopEngine(){
	
	}
	void addSpeed(int speed){
	
	}
	void reduceSpeed(int speed){
	
	}
}
/*
         javac Car.java - компилируем программа (идЄт проверка синтаксиса, семантики, найдутс€ ошибки, если они есть)
		 в случае удачной компил€ции создает файл Car.class (байт код)

		 java Car - запускает консольную программу
*/
