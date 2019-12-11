package gui.page;

public class SpendPage {
    public String monthSpend;
    public String todaySpend;
    public String avgSpendPerDay;
    public String monthAvailable;
    public String dayAvgAvailable;
    public String monthLeftDay;
    public int usagePercentage;
    public boolean isOverSpend = false;

    public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay,
                     int monthAvailable, int dayAvgAvailable,
                     int monthLeftDay, int usagePercentage) {
        this.monthSpend = "￥" + monthSpend;
        this.todaySpend = "￥" + todaySpend;
        this.avgSpendPerDay = "￥" + avgSpendPerDay;
        if (monthAvailable < 0) {
            isOverSpend = true;
        }
        if (!isOverSpend) {
            this.monthAvailable = "￥" + monthAvailable;
            this.dayAvgAvailable = "￥" + dayAvgAvailable;
        } else {
            this.monthAvailable = "超支" + (0 - monthAvailable);
            this.dayAvgAvailable = "￥0";
        }
        this.monthLeftDay = monthLeftDay + "天";
        this.usagePercentage = usagePercentage;
    }
}
