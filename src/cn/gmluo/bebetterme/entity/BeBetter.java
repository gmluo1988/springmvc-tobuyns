package cn.gmluo.bebetterme.entity;

import java.sql.Date;

/**
 * 1.数据实例层设计
 * Created by gmluo on 2018/4/9.
 */
public class BeBetter {
    /**
     * 主键
     */
    private int id;
    /**
     * Date 日期（时间戳）
     */
    private Date dataChange_LastTime;
    private Date dataChange_CreateTime;

    /**
     * self-discipline(自我约束)实例 Cola 不喝碳酸饮料 Fattyfood 不吃油腻的食物 Snacks 不吃零食 Badword
     * 不说脏话 Complain 不说抱怨的话 Stayuplate 不熬夜
     */
    private int cola;
    private int fattyfood;
    private int snacks;
    private int badword;
    private int complain;
    private int stayuplate;

    /**
     * self-improvement（自我提高） Readbook 阅读书籍 Learningskills 学习相关技能 Developskills
     * 拓展技能
     */
    private int readbook;
    private int learnskills;
    private int developskills;

    /**
     * Change myself（改变自我） Running 跑步 Keep keep训练
     */
    private float running;
    private int keep;

    /**
     * Additional points（加分项） Breakfast 做早饭 Lunch 做午饭 Otherfood 做甜品或者其他食物
     */
    private int breakfast;
    private int lunch;
    private int otherfood;

    /**
     * 每日得分 Score 每日得分
     */
    private int Score;


    /**
     * 无参构造方法
     */
    public BeBetter() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataChange_LastTime() {
        return dataChange_LastTime;
    }

    public void setDataChange_LastTime(Date dataChange_LastTime) {
        this.dataChange_LastTime = dataChange_LastTime;
    }

    public Date getDataChange_CreateTime() {
        return dataChange_CreateTime;
    }

    public void setDataChange_CreateTime(Date dataChange_CreateTime) {
        this.dataChange_CreateTime = dataChange_CreateTime;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }

    public int getFattyfood() {
        return fattyfood;
    }

    public void setFattyfood(int fattyfood) {
        this.fattyfood = fattyfood;
    }

    public int getSnacks() {
        return snacks;
    }

    public void setSnacks(int snacks) {
        this.snacks = snacks;
    }

    public int getBadword() {
        return badword;
    }

    public void setBadword(int badword) {
        this.badword = badword;
    }

    public int getComplain() {
        return complain;
    }

    public void setComplain(int complain) {
        this.complain = complain;
    }

    public int getStayuplate() {
        return stayuplate;
    }

    public void setStayuplate(int stayuplate) {
        this.stayuplate = stayuplate;
    }

    public int getReadbook() {
        return readbook;
    }

    public void setReadbook(int readbook) {
        this.readbook = readbook;
    }

    public int getLearnskills() {
        return learnskills;
    }

    public void setLearnskills(int learnskills) {
        this.learnskills = learnskills;
    }

    public int getDevelopskills() {
        return developskills;
    }

    public void setDevelopskills(int developskills) {
        this.developskills = developskills;
    }

    public float getRunning() {
        return running;
    }

    public void setRunning(float running) {
        this.running = running;
    }

    public int getKeep() {
        return keep;
    }

    public void setKeep(int keep) {
        this.keep = keep;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    public int getOtherfood() {
        return otherfood;
    }

    public void setOtherfood(int otherfood) {
        this.otherfood = otherfood;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "BeBetter [id=" + id + ", dataChange_LastTime="
                + dataChange_LastTime + ", dataChange_CreateTime="
                + dataChange_CreateTime + ", cola=" + cola + ", fattyfood="
                + fattyfood + ", snacks=" + snacks + ", badword=" + badword
                + ", complain=" + complain + ", stayuplate=" + stayuplate
                + ", readbook=" + readbook + ", learnskills=" + learnskills
                + ", developskills=" + developskills + ", running=" + running
                + ", keep=" + keep + ", breakfast=" + breakfast + ", lunch="
                + lunch + ", otherfood=" + otherfood + ", Score=" + Score + "]";
    }

}
