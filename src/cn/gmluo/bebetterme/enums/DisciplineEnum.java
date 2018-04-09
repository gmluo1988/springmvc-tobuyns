package cn.gmluo.bebetterme.enums;

/**
 * self-discipline(自我约束)分值设置
 *
 * Cola                不喝碳酸饮料(0:没做到，1：做到了)
 * Fattyfood           不吃油腻的食物(0:没做到，1：做到了)
 * Snacks              不吃零食(0:没做到，1：做到了)
 * Badword             不说脏话(0:没做到，1：做到了)
 * Complain            不说抱怨的话(0:没做到，1：做到了)
 * Stayuplate          不熬夜(0:没做到，1：做到了)
 *
 * Created by gmluo on 2018/4/9.
 */
public enum DisciplineEnum {

    Fail(-1), Done(3);


    private int actionScore;

    private DisciplineEnum(int actionScore) {
        this.actionScore = actionScore;
    }

    public int getActionScore() {
        return actionScore;
    }

    public void setActionScore(int actionScore) {
        this.actionScore = actionScore;
    }
}
