package cn.gmluo.bebetterme.enums;

/**
 * Change myself（改变自我）
 * 完成keep分值设置
 * Keep    keep训练(0:没完成，1：完成了1组...以此类推)
 * Created by gmluo on 2018/4/9.
 */
public enum KeepEnum {

    Keep_0(0),
    Keep_1(3),
    Keep_2(6),
    Keep_3(9);

    private int actionScore;

    private KeepEnum(int actionScore){
        this.actionScore=actionScore;
    }

    public int getActionScore() {
        return actionScore;
    }

    public void setActionScore(int actionScore) {
        this.actionScore = actionScore;
    }

}
