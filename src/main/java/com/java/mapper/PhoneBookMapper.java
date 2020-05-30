package com.java.mapper;

import com.java.entity.PhoneBook;

import java.util.List;

/**
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-22 14:59
 */
public interface PhoneBookMapper {

    /**
     * 根据姓名首字母查询电话簿记录
     *
     * @param initial
     * @return
     */
    List<PhoneBook> loadByInitial(String initial);

    /*
    添加信息
     */
    Integer add(PhoneBook phoneBook);

    /**
     * 根据ID查询联系人
     *
     * @param id
     * @return
     */
    PhoneBook findById(Integer id);

    /**
     * 修改信息
     *
     * @param phoneBook
     * @return
     */
    Integer update(PhoneBook phoneBook);

    Integer delete(Integer id);


}
