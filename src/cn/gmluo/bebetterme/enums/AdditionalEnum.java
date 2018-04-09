package cn.gmluo.bebetterme.enums;

/**
 * Additional points（加分项）
 * 早餐、午餐完成分值设置
 * Breakfast        做早饭(0:没做到，1：做到了)
 * Lunch            做午饭(0:没做到，1：做到了)
 * Created by gmluo on 2018/4/9.
 */
public enum AdditionalEnum {
    Fail(0), Done(3), ;

    private int actionScore;

    private AdditionalEnum(int actionScore) {
        this.actionScore = actionScore;
    }

    public int getActionScore() {
        return actionScore;
    }

    public void setActionScore(int actionScore) {
        this.actionScore = actionScore;
    }
}
