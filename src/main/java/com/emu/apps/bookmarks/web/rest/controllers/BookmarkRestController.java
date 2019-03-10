package com.emu.apps.bookmarks.web.rest.controllers;

import com.emu.apps.bookmarks.services.jdbc.repositories.BookmarkJdbcRepository;
import com.emu.apps.bookmarks.web.rest.BookmarkRestApi;
import com.emu.apps.bookmarks.web.rest.dtos.BookmarkDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookmarkRestController implements BookmarkRestApi {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private final BookmarkJdbcRepository bookmarkRepository;

    @Autowired
    public BookmarkRestController(BookmarkJdbcRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public String test() {
        return "OK";
    }

    @Override
    public BookmarkDto getBookmark(@PathVariable("id") long id) {
        logger.info("Get Bookmark");
        return bookmarkRepository.getBookmark(id);
    }

    @Override
    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public List <BookmarkDto> getBookmarks() {
        return bookmarkRepository.getBookmarks();
    }
} 