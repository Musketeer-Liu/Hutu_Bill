package service;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

import java.util.List;

public class SpendService {
    public SpendPage getSpendPage() {
        RecordDAO dao = new RecordDAO();
        List<Record> thisMonthRecords = dao.listThisMonth();
        List<Record> toDayRecords = dao.listToday();

        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();
        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        int monthBudget = new ConfigService().getIntBudget();
        for(Record record: thisMonthRecords) {
            monthSpend += record.getSpend();
        }
        for(Record record: toDayRecords) {
            todaySpend += record.getSpend();
        }
        avgSpendPerDay = monthSpend / thisMonthTotalDay;
        dayAvgAvailable = monthAvailable  / monthLeftDay;
        usagePercentage = monthSpend * 100 / monthBudget;

        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay, usagePercentage);
    }
}
