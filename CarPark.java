import java.util.LinkedList;

public class CarPark {
    private LinkedList<Entry<String, Car>>[] table;
    private int size;

    public CarPark(int capacity) {
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    // Метод для получения хэш-кода номера
    private int hash(String number) {
        return Math.abs(number.hashCode()) % table.length;
    }

    // Метод для добавления автомобиля
    public void addCar(String number, Car car) {
        int index = hash(number);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<String, Car> entry : table[index]) {
            if (entry.getKey().equals(number)) {
                // Если номер уже есть, заменить автомобиль
                entry.setValue(car);
                return;
            }
        }
        table[index].add(new Entry<>(number, car));
        size++;
    }

    // Метод для поиска автомобиля по номеру
    public Car findCar(String number) {
        int index = hash(number);
        if (table[index] != null) {
            for (Entry<String, Car> entry : table[index]) {
                if (entry.getKey().equals(number)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    // Метод для удаления автомобиля по номеру
    public void removeCar(String number) {
        int index = hash(number);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].get(i).getKey().equals(number)) {
                    table[index].remove(i);
                    size--;
                    return;
                }
            }
        }
    }

    // Метод для получения количества автомобилей
    public int getSize() {
        return size;
    }

    // Метод для проверки пустоты автопарка
    public boolean isEmpty() {
        return size == 0;
    }

    // Внутренний класс для хранения пар "номер-автомобиль"
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

// Класс для представления автомобиля
class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Геттеры для свойств автомобиля
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }



    // сеттеры
    public void setMake(String make) {
        this.make = make;
    }

    public void SetModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }
}