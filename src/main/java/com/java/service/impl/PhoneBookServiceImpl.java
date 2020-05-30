package com.java.service.impl;

import com.java.entity.PhoneBook;
import com.java.mapper.PhoneBookMapper;
import com.java.service.PhoneBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-22 15:43
 */
@Service("phoneBookService")
public class PhoneBookServiceImpl implements PhoneBookService {

    @Resource
    private PhoneBookMapper phoneBookMapper;

    @Override
    public List<PhoneBook> loadByInitial(String initial) {
        return phoneBookMapper.loadByInitial(initial);
    }

    @Override
    public Integer add(PhoneBook phoneBook) {
        return phoneBookMapper.add(phoneBook);
    }

    @Override
    public PhoneBook findById(Integer id) {
        return phoneBookMapper.findById(id);
    }

    @Override
    public Integer update(PhoneBook phoneBook) {
        return phoneBookMapper.update(phoneBook);
    }

    @Override
    public Integer delete(Integer id) {
        return phoneBookMapper.delete(id);
    }


}
