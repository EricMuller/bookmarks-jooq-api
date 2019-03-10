package com.emu.apps.bookmarks.services.jooq;


import com.emu.apps.bookmarks.services.jooq.tables.pojos.Tag;
import com.emu.apps.bookmarks.services.jooq.tables.records.TagRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class TagJooqRepository implements JooqRepository<TagRecord, Tag> {

    private final DSLContext dslContext;

    @Autowired
    public TagJooqRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }


    @Override
    public List<TagRecord> findAll() {
        return dslContext.selectFrom(Tables.TAG).limit(1000).fetch();
    }


    @Override
    public TagRecord findOne(Long id) {
        return this.dslContext.selectFrom(Tables.TAG)
                .where(Tables.TAG.ID.eq(id))
                .fetchOne();
    }

    @Override
    public TagRecord save(Tag tag) {
        TagRecord record = this.dslContext.newRecord(Tables.TAG, tag);
        record.setUuid(UUID.randomUUID().toString());
        record.store();
        return record;
    }

    @Override
    public TagRecord update(Tag entity) {
        TagRecord record = this.dslContext.newRecord(Tables.TAG, entity);
       record.update();
        return record;
    }


    @Override
    public void delete(Long id) {
        this.dslContext.delete(Tables.TAG)
                .where(Tables.TAG.ID.eq(id))
                .execute();
    }


    @Override
    public boolean exist(Long id) {
        return this.dslContext.selectCount()
                .from(Tables.TAG)
                .where(Tables.TAG.ID.eq(id))
                .fetchOne(0, Integer.class) > 0;
    }

}
