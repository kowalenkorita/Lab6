//На прямой гоночной трассе стоит N автомобилей,
// для каждого из которых известны начальное положение и скорость.
// Определить, сколько произойдет обгонов.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Lab6_2 {
    public static void main(String[] args) {
        int number_of_cars = 4;
        int lenght_of_road = new Random().nextInt(100) + 109;
        System.out.println("Длина дороги = " + lenght_of_road);
        ArrayList<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < number_of_cars; i++) {
            cars.add(new Car("Номер машины " + i));
        }
        // сортировка текущей позиции
        cars.sort(new CompareCar());

        // запишем, какая машина стоит на каком месте
        int i = 0;
        for (Car car : cars) {
            car.beMoreFirst = i;
            i++;
        }

        // start
        boolean endOfRace = false;
        while (!endOfRace) {
            endOfRace = true;
            for (Car car : cars) {
                if (car.currentPosition + car.speed <= lenght_of_road) {
                    car.currentPosition = car.currentPosition + car.speed;
                    endOfRace = false;
                } else
                    car.currentPosition = lenght_of_road; // this auto finish race
            }
            cars.sort(new CompareCar());
        }
        // посчитаем, какая машина на каком месте
        int count = 0;
        i = 0;
        for (Car car : cars) {
            if (i > car.beMoreFirst) {
                count = count + (i - car.beMoreFirst);
            }
            i++;
        }
        System.out.println("Ответ = " + count);
    }
}

class Car {
    String name;
    int firstPosition;
    int speed;
    int currentPosition;
    int beMoreFirst; // сколько машин опережает эту машина на старте

    Car(String name) {
        super();
        this.name = name;
        this.firstPosition = new Random().nextInt(11);
        this.speed = new Random().nextInt(7) + 1;
        this.currentPosition = this.firstPosition;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + " Скорость " + speed + " Позиция " + currentPosition;
    }
}

class CompareCar implements Comparator<Car> {

    @Override
    public int compare(Car с1, Car с2) {
        return Integer.compare(с1.currentPosition, с2.currentPosition);
    }
}
