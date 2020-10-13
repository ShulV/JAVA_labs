/*
–еализовать работу автомобил€ на примере классов (ассоциаци€).
ѕол€ структуры:
Х	Ќазвание (строка)
Х	÷ена (целое)
Х	÷вет (строка)
Х	 оличество оборотов двигател€ в минуту (целое)
Х	—корость (целое)
Х	 оличество бензина (целое)
‘ункции:
Х	»нициализаци€
Х	”становка параметров автомобил€
Х	¬ывод данных машины
Х	«апуск двигател€
Х	ќстановка двигател€
Х	ƒобавление скорости
Х	”меньшить скорость
*/
import java.util.Scanner;//консольный ввод
public class Program{
	public static void main(String[] args) {
	
	Car bmw_x6 = new Car();
	Engine bmw_engine = new Engine();
	bmw_engine.init(0, 4395, 625, 8);
	bmw_x6.init("BMW X6", 3500000, "BLACK", 0, 0, bmw_engine); //инициализируем пол€ объекта
	bmw_x6.displayDataCar();
	bmw_x6.readCarData();
	bmw_x6.displayDataCar();
	bmw_x6.startEngine(); //пытаемс€ завести двигатель
	bmw_x6.displayDataCar();
	bmw_x6.addBenzine(10); //добавл€ем бензин
	bmw_x6.displayDataCar();
	bmw_x6.startEngine(); //снова пытаемс€ завести двигатель
	bmw_x6.displayDataCar();
	for (int i = 0; i < 4; i++) {
		bmw_x6.addSpeed(i * 5); //добавл€ем скорость
		bmw_x6.displayDataCar();
	}
	for (int i = 0; i < 4; i++) {
		bmw_x6.reduceSpeed(i * 5); //убавл€ем скорость
		bmw_x6.displayDataCar();
	}

	bmw_x6.stopEngine(); //останавливаем двигатель
	bmw_x6.displayDataCar();
	}
}



class Engine{
	private int engineRPM; //количество оборотов в минуту
	private int capacity; //объем см куб
	private int enginePower; //мощность Ћ.—.
	private int quantityOfCylinders; //количество цилиндров

	public void init(int engineRPM, int capacity, int enginePower, int quantityOfCylinders){
		this.engineRPM = engineRPM;
		this.capacity = capacity;
		this.enginePower = enginePower;
		this.quantityOfCylinders = quantityOfCylinders;
	}
	public void setEngineRPM(int engineRPM){
		this.engineRPM = engineRPM;
	}
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	public void setEnginePower(int enginePower){
		this.enginePower = enginePower;
	}
	public void setQuantityOfCylinders(int quantityOfCylinders){
		this.quantityOfCylinders = quantityOfCylinders;
	}
	public int getEngineRPM(){
		return this.engineRPM;	
	}
	public int getCapacity(){
		return this.capacity;
	}
	public int getEnginePower(){
		return this.enginePower;
	}
	public int getQuantityOfCylinders(){
		return this.quantityOfCylinders;
	}
	
}

class Car {
	Scanner in = new Scanner(System.in);

	private String name;
	private int price;
	private String color;
	private int speed;
	private int benzine;
	private Engine engine;
	public void init(String name, int price, String color, int speed, int benzine, Engine engine){
		this.name = name;
		this.price = price;
		this.color = color;
		this.speed = speed;
		this.benzine = benzine;
		this.engine = engine;
		System.out.println("Car initialized!");
	}
	public void readCarData(){
		System.out.println("ENTER CAR DATA:");
		
		System.out.print("\tname:\t");
		this.name = in.nextLine();


		System.out.print("\tprice:\t");
		this.price = in.nextInt();
		in.nextLine();//очистка потока
		
		System.out.print("\tcolor:\t");
		this.color = in.nextLine();

		System.out.print("\tengineRPM:\t");
		this.engine.setEngineRPM(in.nextInt());
		in.nextLine();//очистка потока
		
		System.out.print("\tcapacity:\t");
		this.engine.setCapacity(in.nextInt());
		in.nextLine();//очистка потока
		
		System.out.print("\tengine power:\t");
		this.engine.setEnginePower(in.nextInt());
		in.nextLine();//очистка потока
		
		System.out.print("\tquantity of cylinders:\t");
		this.engine.setQuantityOfCylinders(in.nextInt());
		in.nextLine();//очистка потока

		System.out.print("\tspeed:\t");
		this.speed = in.nextInt();
		in.nextLine();//очистка потока

		System.out.print("\tbenzine:\t");
		this.benzine = in.nextInt();
		in.nextLine();//очистка потока
	}
	public void displayDataCar(){
		System.out.println("\n\tCAR DATA");
		System.out.println("\t\tName:\t" + this.name);
		System.out.println("\t\tPrice:\t" + this.price);
		System.out.println("\t\tColor:\t" + this.color);
		System.out.println("\t\tEngineRPM:\t" + this.engine.getEngineRPM());
		System.out.println("\t\tCapacity:\t" + this.engine.getCapacity());
		System.out.println("\t\tEngine Power:\t" + this.engine.getEnginePower());
		System.out.println("\t\tQuanity of cylinders:\t" + this.engine.getQuantityOfCylinders());
		System.out.println("\t\tBenzine:\t" + this.benzine);
		System.out.println("\t\tSpeed:\t" + this.speed);
	}
	public void addBenzine(int liters){
	System.out.println(liters + "lit. benzine added!");
	this.benzine += liters;
	}
	public void startEngine(){
		if (this.benzine > 0) {
			this.engine.setEngineRPM(800);
			System.out.println("Engine started!");
		}
		else {
			System.out.println("No benzine. Engine didn't start!");
		}
	}
	public void stopEngine(){
		if (this.engine.getEngineRPM() > 0) {
			this.engine.setEngineRPM(0);
			System.out.println("Engine stopped!");
		}
		else {
			System.out.println("Engine stopped already!");
		}
	}
	public void addSpeed(int speed){
		if (this.engine.getEngineRPM() > 0) {
			this.speed += speed;
			System.out.println("Car speeded up!");
		}
		else {
			System.out.println("Engine isn't starting. Car didn't speed up!");
		}
	}
	public void reduceSpeed(int speed){
		if (this.speed > 0) {
			this.speed -= speed;
			System.out.println("Car speeded down!");
		}
		else {
			System.out.println("Car is parking. Car didn't speed down!");
		}
	}
}
/*
         javac Car.java - компилируем программа (идЄт проверка синтаксиса, семантики, найдутс€ ошибки, если они есть)
		 в случае удачной компил€ции создает файл Car.class (байт код)

		 java Car - запускает консольную программу
*/
