package com.empresax.customer.generic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController<T> {

	public ResponseEntity<List<T>> getAll();

	public ResponseEntity<T> getById(final @PathVariable long id);

	public ResponseEntity<T> create(final @RequestBody T customer);

	public ResponseEntity<T> update(final @RequestBody T customer, final @PathVariable long id);

	public ResponseEntity<String> deletetById(final @PathVariable long id);
}
