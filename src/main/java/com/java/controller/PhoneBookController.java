package com.java.controller;

import com.java.entity.PhoneBook;
import com.java.entity.R;
import com.java.service.PhoneBookService;
import com.java.util.PinYinUtil;
import com.java.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-20 14:33
 */
@RestController
@RequestMapping("/phoneBook")
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    /**
     * 查询电话簿信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadAll")
    public R loadAll() throws Exception {

        Map<String, Object> map = new LinkedHashMap<>();//比hashmap起来有顺序
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '#'};
        for (int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]);//将char类型转换成string类型，即首字母
            List<PhoneBook> phoneBooks = phoneBookService.loadByInitial(letter);//根据首字母获取个人信息
            if (phoneBooks.size() > 0) {//有个人信息才放入map中
                map.put(letter, phoneBooks);
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", map);//误将"data"写成date.导致不易发现的坑....?
        return R.ok(resultMap);
    }

    /**
     * 添加或者修改联系人
     *
     * @param phoneBook
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public R save(@RequestBody PhoneBook phoneBook) throws Exception {
        int resultTotal = 0;
        String initial = String.valueOf(PinYinUtil.getPinYin(phoneBook.getName()).charAt(0)).toUpperCase();//得到大写字母
        if (StringUtil.isAlpha(initial)) {
            phoneBook.setInitial(initial);
        } else {
            phoneBook.setInitial("#");
        }
        if (phoneBook.getId() == null) {
            resultTotal = phoneBookService.add(phoneBook);//添加
        } else {
            resultTotal = phoneBookService.update(phoneBook);//更新
        }
        if (resultTotal > 0) {
            return R.ok();
        } else {
            return R.error(-1, "保存失败，请联系管理员");
        }
    }

    @RequestMapping("/findById")
    public R findById(Integer id) throws Exception {
        PhoneBook phoneBook = phoneBookService.findById(id);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("phoneBook", phoneBook);
        return R.ok(resultMap);
    }

    @RequestMapping("/delete")
    public R delete(Integer id) throws Exception {
        int resultTotal = phoneBookService.delete(id);
        if (resultTotal > 0) {
            return R.ok();
        } else {
            return R.error(-1, "删除失败，请联系管理员");
        }

    }

}


