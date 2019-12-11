package service;

import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Date;

/**
 * 记一笔业务类只有一个方法 add
 */
public class RecordService {
    RecordDAO recordDao = new RecordDAO();
    public void add(int spend, Category c, String comment, Date date) {
        Record r = new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;
        recordDao.add(r);
    }
}
