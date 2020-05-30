package com.java.service;

import com.java.entity.PhoneBook;

import java.util.List;

/**
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-22 15:42
 */
public interface PhoneBookService {

    public List<PhoneBook> loadByInitial(String initial);

    Integer add(PhoneBook phoneBook);

    PhoneBook findById(Integer id);

    Integer update(PhoneBook phoneBook);

    Integer delete(Integer id);
}
