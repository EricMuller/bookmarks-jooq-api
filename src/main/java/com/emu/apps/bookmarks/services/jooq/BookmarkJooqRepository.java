package com.emu.apps.bookmarks.services.jooq;


import com.emu.apps.bookmarks.services.jooq.tables.pojos.Bookmark;
import com.emu.apps.bookmarks.services.jooq.tables.pojos.Tag;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookmarkJooqRepository {

    private final DSLContext dslContext;

    @Autowired
    public BookmarkJooqRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }


    public Iterable<Bookmark> findAll() {
        return dslContext.selectFrom(Tables.BOOKMARK).limit(1000).fetch().into(Bookmark.class);
    }

}
