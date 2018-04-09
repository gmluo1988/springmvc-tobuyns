package cn.gmluo.bebetterme.enums;

/**
 * Change myself（改变自我）(暂未使用)
 * 完成跑步公里数分值设置
 * Created by gmluo on 2018/4/9.
 */
public enum RunningEnum {
    Run_5(10),
    Run_6(12),
    Run_7(14),
    Run_8(16),
    Run_9(18),
    Run_10(25),
    Run_11(30),
    Run_12(35),
    Run_13(40),
    Run_14(45),
    Run_15(60),
    Run_16(70),
    Run_17(80),
    Run_18(90),
    Run_19(100),
    Run_20(150);

    private int actionScore;

    private RunningEnum(int actionScore){
        this.actionScore=actionScore;
    }

    public int getActionScore() {
        return actionScore;
    }

    public void setActionScore(int actionScore) {
        this.actionScore = actionScore;
    }
}
