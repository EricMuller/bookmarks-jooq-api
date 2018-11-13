package com.emu.apps.bookmarks.services.jdbc.repositories;

import com.emu.apps.bookmarks.web.rest.dtos.BookmarkDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookmarkJdbcRepository {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private static final RowMapper<BookmarkDto> BOOKMARK_DTO_ROW_MAPPER = (rs, rowNum) -> new BookmarkDto(rs.getLong("id"), rs.getString("title"), rs.getString("url"), rs.getString("description"));

    @Autowired
    protected JdbcTemplate jdbc;

    public BookmarkDto getBookmark(long id) {
        return jdbc.queryForObject("SELECT * FROM bookmarks WHERE id=?", BOOKMARK_DTO_ROW_MAPPER, id);
    }

    public List<BookmarkDto> getBookmarks(long[] ids) {
        String inIds = StringUtils.arrayToCommaDelimitedString(ObjectUtils.toObjectArray(ids));
        return jdbc.query("SELECT * FROM bookmarks WHERE id IN (" + inIds + ")", BOOKMARK_DTO_ROW_MAPPER);
    }

    @Transactional(readOnly=true)
    public List<BookmarkDto> getBookmarks() {
        return jdbc.query("SELECT * FROM bookmarks", BOOKMARK_DTO_ROW_MAPPER);
    }



} 