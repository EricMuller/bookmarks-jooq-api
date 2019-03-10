package com.emu.apps.bookmarks.services.jooq;

import org.jooq.Record;

import java.util.List;

public interface JooqRepository<T extends Record, P> {
    List<T> findAll();

    T findOne(Long id);

    T save(P p);

    T update(P entity);

    void delete(Long id);

    boolean exist(Long id);
}
