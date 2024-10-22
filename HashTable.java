import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable(int capacity) {
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    // Получение хеш кода ключа
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Добавление пары ключ значение
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    // Полчение значения по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    // Удаление пары ключ значение по ключу
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].get(i).getKey().equals(key)) {
                    table[index].remove(i);
                    size--;
                    return;
                }
            }
        }
    }

    // Получение количества элементов в таблице
    public int size() {
        return size;
    }

    // Проверка пустоты таблицы
    public boolean isEmpty() {
        return size == 0;
    }

    // Хранения пар ключ значение
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
