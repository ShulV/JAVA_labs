package com.company;
//import java.io.*;// подключение библиотеки ввода-вывода на java
import java.util.Scanner;//консольный ввод
// lab work №7,8,9 Shulpov Victor PI-92
/*
Поля класса:
•	Название (строка)
•	Цена (целое)
•	Цвет (строка)
•	Количество оборотов двигателя в минуту (целое)
•	Скорость (целое)
•	Количество бензина (целое)
Функции:
•	Инициализация
•	Установка параметров автомобиля
•	Вывод данных машины
•	Запуск двигателя
•	Остановка двигателя
•	Добавление скорости
•	Уменьшить скорость
*/
class Point {
    public int x;
    public int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
};
abstract class Vehicle
{
    public int x;
    public int y;
    public Point getPosition()
    {
        return new Point(this.x, this.y);
    }
    abstract public void Move(int x, int y, int z);//абстрактный метод, который определяется в наследнике
};

class NegativeNumberException extends Exception{
    final private int number;
    public int getNumber(){return number;}
    public NegativeNumberException(String message, int num){
        super(message);
        System.out.println("конструктор исключения NegativeNumberException: " + message);
        number=num;
    }
}
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner in = new Scanner(System.in/*, "Cp866"*/);
        System.out.println(
                "Показать лабу №:\n"+
                "7-9 - введите 1\n" +
                "10 - введите 2\n" +
                "11 - введите 3\n" +
                "12 - введите 4\n");
        String choice = in.next();
        System.out.println(choice);
        switch (choice){
            case "1":{
                try{
                    System.out.println("count=" + Car.getCount());
                    Car[] car = new Car[3];//МАССИВ ОБЪЕКТОВ
                    Engine bmw_engine = new Engine(0, 4395, 625, 8);
                    car[0] = new Car("BMW X6", 3500000, "BLACK", 0, 22, bmw_engine); //инициализируем поля объекта);
                    car[0].displayDataCar();
                    GasStation gasStation = new GasStation();
                    //возврат целочисленного значения из метода через вспомогательный класс;
                    int liters = gasStation.getCurrentBenzine(car[0]);
                    System.out.println("\tлитры:\t"+liters);
                    Car bmw = new Car();
                    System.out.println("После создания двух объектов count=" + Car.getCount());
                }
                catch(Exception ex)
                {
                    System.out.println("вызов исключения");
                }
            }
            case "2": {
                Engine bmw_engine = new Engine(0, 4395, 625, 8);
                Car bmw = new Car("BMW X6", 3500000, "BLACK", 0, 22, 300, bmw_engine);
                try {
                    bmw.startEngine();
                    for (int i = 0; i < 10; i++) {
                        bmw.addSpeed(40);
                    }
                }
                catch (NegativeNumberException ex){
                    System.out.println(
                            "Поймали исключение Exception: слишком большая скорость!\n" +
                                    "ex.getMessage() = " + ex.getMessage());
                }

            }
            case "3": {
                final int N=3,M=4;
                Car[] car = new Car[N];
                ////////////////////////////
                Car[][] d_car_array = new Car[N][];//зубчатый массив
                for (int i = 0; i < N; i++)
                {
                    d_car_array[i] = new Car[i];
                    for (int j = 0; j < i; j++) //матрица не прямоугольная
                    {
                        d_car_array[i][j] = new Car();
                    }

                }

                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < d_car_array[i].length; j++)
                    {
                        d_car_array[i][j] = new Car();
                        System.out.print("Car[" + i + "][" + j + ']' + ' ');
                    }
                    System.out.println();
                }

            }
            case "4": {
                TaxiCar taxi_car = new TaxiCar("Solaris");
                taxi_car.displayDataCar();
                taxi_car.callTaxi("Проспект ленина 119");
                TaxiCar taxi_car2 = new TaxiCar("Solaris", 777);
                taxi_car2.addBenzine(10,2);
                taxi_car2.displayDataCar();
                System.out.println("x=" + taxi_car2.x + " y=" + taxi_car2.y);
                taxi_car2.Move(2000, 222, 0);
                System.out.println("x=" + taxi_car2.x + " y=" + taxi_car2.y);
                //интерфейс
                System.out.println("\nИНТЕРФЕЙС\n");
                taxi_car2.Beep();
                IBeep i_taxi_vaz = new TaxiCar("ВАЗ");
                i_taxi_vaz.Beep();
                IBeep i_car_vaz = new Car("ВАЗ");
                i_car_vaz.Beep();
                Car car = new Car("car");
                car.Beep();

                //мелкое клонирование
                System.out.println("\nКЛОНИРОВАНИЕ\n");
                Engine engine1 = new Engine(0, 4395, 625, 8);
                Car car1 = new Car("BMW X6", 3500000, "BLACK", 0, 0, engine1);
                Engine engine2 = new Engine(0, 3395, 425, 4);
                Car car2 = new Car("BMW X3", 1500000, "RED", 0, 0, engine2);
                System.out.println("произвели мелкое клонирование");
                car2 = (Car)car1.clone();
                car2.displayDataCar();
                System.out.println("Данные двигателя car2");
                car2.engine.DisplayEngineData();
                System.out.println("Установили для двигателя car1 EnginePower");
                car1.engine.setEnginePower(100000000);
                System.out.println("Данные двигателя car2 (при мелком клонировании не создали новый объект, который был полем класса)");
                car2.engine.DisplayEngineData();
                //глубокое клонирование
                Engine _engine1 = new Engine(0, 4444, 444, 4);
                TaxiCar _taxi_car1 = new TaxiCar("taxi 4", 4444444, "color 4", 0, 0, 444, _engine1);
                Engine _engine2 = new Engine(0, 2222, 222, 2);
                TaxiCar _taxi_car2 = new TaxiCar("taxi 2", 1500000, "color 2", 0, 0, 222, _engine2);
                System.out.println("произвели глубокое клонирование");
                _taxi_car2 = (TaxiCar)_taxi_car1.clone();
                _taxi_car2.displayDataCar();
                System.out.println("Данные двигателя _taxi_car2");
                _taxi_car2.engine.DisplayEngineData();
                System.out.println("Установили для двигателя _taxi_car2 EnginePower");
                _taxi_car1.engine.setEnginePower(100000000);
                System.out.println("Данные двигателя _taxi_car2 (при глубоком клонировании создали новый объект, который был полем класса)");
                _taxi_car2.engine.DisplayEngineData();
                System.out.println("Данные двигателя _taxi_car1");
                _taxi_car1.engine.DisplayEngineData();

            }
        }

    }
}
//ДОПОЛНИТЕЛЬНЫЙ КЛАСС
class GasStation{
    public int getCurrentBenzine(Car car){
        return car.addBenzine(0);
    }
}
class Engine implements  Cloneable{
    private int engineRPM; //количество оборотов в минуту
    private int capacity; //объем см куб
    private int enginePower; //мощность Л.С.
    private int quantityOfCylinders; //количество цилиндров

    //конструктор без парам
    public Engine(){
        this.engineRPM = 0;
        this.capacity = 0;
        this.enginePower = 0;
        this.quantityOfCylinders = 0;
    }
    //конструктор с 1 парам
    public Engine(int engineRPM){
        this.engineRPM = engineRPM;
        this.capacity = 0;
        this.enginePower = 0;
        this.quantityOfCylinders = 0;
    }
    //конструктор со всеми парам
    public Engine(int engineRPM, int capacity, int enginePower, int quantityOfCylinders){
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
    public void DisplayEngineData(){
        System.out.println("\t\tEngineRPM:\t" + getEngineRPM());
        System.out.println("\t\tCapacity:\t" + getCapacity());
        System.out.println("\t\tEngine Power:\t" + getEnginePower());
        System.out.println("\t\tQuantity of cylinders:\t" + getQuantityOfCylinders());
    }
    public Object clone() throws CloneNotSupportedException // перегрузка интерфейса клонирования
    {
        try
        {
            return (Engine)super.clone();
        }
        catch(CloneNotSupportedException e)
        {

        }
        return this;
    }



}

class Car extends Vehicle implements IBeep, Cloneable{
    Scanner in = new Scanner(System.in/*, "Cp866"*/);
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "Cp866"));
    protected String name;//тип String
    protected int benzine;
    protected int price;
    protected String color;//тип StringB
    protected int speed;
    public Engine engine;
    protected int max_speed;
    private static int count;
    public static int getCount(){
        return count;
    }
    public Car(){

            count++;

    }
    public Car(String name){
        this.name = name.toLowerCase();//ОБРАБОТКА СТРОК
        this.price = 0;
        this.color = "";
        this.speed =0;
        this.benzine = 0;
        this.engine = null;
        this.max_speed = 0;
        System.out.println("Car initialized!");
    }
    public Car(String name, int price, String color, int speed, int benzine, Engine engine){
        this.name = name.toLowerCase();//ОБРАБОТКА СТРОК
        this.price = price;
        this.color = color.toLowerCase();//ОБРАБОТКА СТРОК
        this.speed = speed;
        this.benzine = benzine;
        this.engine = engine;
        this.max_speed = 0;
        System.out.println("Car initialized!");
    }
    public Car(String name, int price, String color, int speed, int benzine, int max_speed, Engine engine){
        this.name = name.toLowerCase();//ОБРАБОТКА СТРОК
        this.price = price;
        this.color = color.toLowerCase();//ОБРАБОТКА СТРОК
        this.speed = speed;
        this.benzine = benzine;
        this.engine = engine;
        this.max_speed = max_speed;
        System.out.println("Car initialized!");
    }
    public void readCarData(){
        System.out.println("ENTER CAR DATA:");

        System.out.print("\tname:\t");
        this.name = in.nextLine().toLowerCase();//ОБРАБОТКА СТРОК


        System.out.print("\tprice:\t");
        this.price = in.nextInt();
        in.nextLine();//очистка потока

        System.out.print("\tcolor:\t");
        this.color = in.nextLine().toLowerCase();//ОБРАБОТКА СТРОК

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
            //System.out.println("\t\tEngineRPM:\t" + this.engine.getEngineRPM());
            //System.out.println("\t\tCapacity:\t" + this.engine.getCapacity());
            //System.out.println("\t\tEngine Power:\t" + this.engine.getEnginePower());
            //System.out.println("\t\tQuantity of cylinders:\t" + this.engine.getQuantityOfCylinders());
            System.out.println("\t\tBenzine:\t" + this.benzine);
            System.out.println("\t\tSpeed:\t" + this.speed);


    }
    public int addBenzine(int liters){
        System.out.println(liters + "lit. benzine added!");
        this.benzine += liters;
        return this.benzine;
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
    public void addSpeed(int speed) throws NegativeNumberException {
        if (this.engine.getEngineRPM() > 0) {
            if (this.speed + speed > this.max_speed) {
                throw new NegativeNumberException("Бросили исключение", 1);
            }
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
    public void Beep()
    {
        System.out.println("Default beep! (Car)");
    }
    @Override
    public void Move(int x, int y, int z) {
        this.x += x;
        this.y += y;
    }
    public Object clone() throws CloneNotSupportedException
    {
        try
        {
            return (Car) super.clone();
        }
        catch(CloneNotSupportedException e)
        {

        }
        return this;


    }
}

//производный класс
class TaxiCar extends Car{
    private int code_name;
    //вызов конструктора базового класса
    public TaxiCar(String name){
        super(name);
    }
    //перегрузка метода базового класса (с вызовом базового класса)
    public TaxiCar(String name, int code_name){
        super(name);
        this.code_name = code_name;
    }
    public TaxiCar(String name, int price, String color, int speed, int benzine, int max_speed, Engine engine) {
        super(name, price, color, speed, benzine, max_speed, engine);
    }
    //перегрузка метода базового класса (без вызова базового класса)
    public int addBenzine(int liters, int work_bonus){
        System.out.println(liters + work_bonus + "lit. benzine added!");
        this.benzine += liters + work_bonus;
        return this.benzine;
    }

    public void callTaxi(String address){
        System.out.printf("По адресу %s приехала машина %s", address, this.name);
    }

    public void Beep()
    {
        System.out.println("Default beep! (Taxi)");
    }

    public Object clone() throws CloneNotSupportedException
    {
        try
        {
            TaxiCar new_taxi_car=(TaxiCar) super.clone();
            new_taxi_car.engine=(Engine)engine.clone();  // клонирование поля engine (Engine)) !

            return new_taxi_car;
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println();
        }
        return this;


    }

}

//интерфейс гудка (подачи звукового сигнала)
interface IBeep
{
    default void Beep()
    {
        System.out.println("Default beep!");
    }
}


