package com.empresax.customer.generic;

import java.util.List;

public interface IService <T> {

    T saveRecord(T record);

    List<T> fetchAllRecords();

    T updateRecord(T record, final long id);

    T findById(final long id);

    String deleteRecord(final long id);
}
