package com.empresax.customer.service;

import java.util.List;

public interface IServiceTemplate<T> {

    T saveRecord(T record);

    List<T> fetchAllRecords();

    T updateRecord(T record, final long id);

    T findById(final long id);

    String deleteRecord(final long id);
}
