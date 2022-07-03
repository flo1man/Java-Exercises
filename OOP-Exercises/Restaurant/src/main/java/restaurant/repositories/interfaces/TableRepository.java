package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

public interface TableRepository<T> extends Repository<Table> {
    T byNumber(int number);
}
