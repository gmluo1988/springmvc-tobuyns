package cn.gmluo.bebetterme.util;

import cn.gmluo.bebetterme.entity.BeBetter;
import cn.gmluo.bebetterme.enums.*;

/**
 * 获取每日得分方法
 * Created by gmluo on 2018/4/9.
 */
public class GetBeBetterScore {
    /**
     * 获取每天报告计算得分
     * @param beBetter
     * @return
     */
    public int getDayScore(BeBetter beBetter) {
        int score=0;
        score+=getSumDisciplineScore(beBetter);
        score+=getSumImprovementScore(beBetter);
        score+=getSumMyselfScore(beBetter);
        score+=getSumAdditionalScore(beBetter);

        return score;
    }


    public int getDisciplineScore(int value) {
        if (value==1) {
            return DisciplineEnum.Done.getActionScore();
        }else {
            return DisciplineEnum.Fail.getActionScore();
        }
    }

    public int getSumDisciplineScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=getDisciplineScore(beBetter.getCola());
        sumScore+=getDisciplineScore(beBetter.getFattyfood());
        sumScore+=getDisciplineScore(beBetter.getSnacks());
        sumScore+=getDisciplineScore(beBetter.getBadword());
        sumScore+=getDisciplineScore(beBetter.getComplain());
        sumScore+=getDisciplineScore(beBetter.getStayuplate());
        return sumScore;
    }


    public int getImprovementScore(int value) {
        if (value==1) {
            return ImprovementEnum.Done.getActionScore();
        }else {
            return ImprovementEnum.Fail.getActionScore();
        }
    }

    public int getSumImprovementScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=getImprovementScore(beBetter.getReadbook());
        sumScore+=getImprovementScore(beBetter.getLearnskills());
        sumScore+=getImprovementScore(beBetter.getDevelopskills());
        return sumScore;
    }


    public int getKeepScore(int value) {
        if (value==1) {
            return KeepEnum.Keep_1.getActionScore();
        }else if (value==2) {
            return KeepEnum.Keep_2.getActionScore();
        }else if (value==3) {
            return KeepEnum.Keep_3.getActionScore();
        } else {
            return KeepEnum.Keep_0.getActionScore();
        }
    }

    public int getSumMyselfScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=new RunningScore().getRunningScore(beBetter.getRunning());
        sumScore+=getKeepScore(beBetter.getKeep());
        return sumScore;
    }


    public int getAdditionalScore(int value) {
        if (value==1) {
            return AdditionalEnum.Done.getActionScore();
        }else {
            return AdditionalEnum.Fail.getActionScore();
        }
    }

    public int getOtherfoodScore(int value) {
        if (value==1) {
            return OtherfoodEnum.Otherfood_1.getActionScore();
        }else if (value==2) {
            return OtherfoodEnum.Otherfood_2.getActionScore();
        }else if (value==3) {
            return OtherfoodEnum.Otherfood_3.getActionScore();
        } else {
            return OtherfoodEnum.Otherfood_0.getActionScore();
        }
    }

    public int getSumAdditionalScore(BeBetter beBetter) {
        int sumScore=0;
        sumScore+=getAdditionalScore(beBetter.getBreakfast());
        sumScore+=getAdditionalScore(beBetter.getLunch());
        sumScore+=getOtherfoodScore(beBetter.getOtherfood());
        return sumScore;
    }

    public static void main(String[] args) {
        BeBetter beBetter=new BeBetter();
        //正常总结得分
        beBetter.setCola(1);
        beBetter.setFattyfood(1);
        beBetter.setSnacks(1);
        beBetter.setBadword(0);
        beBetter.setComplain(0);
        beBetter.setStayuplate(1);

        beBetter.setReadbook(1);
        beBetter.setLearnskills(0);
        beBetter.setDevelopskills(0);

        beBetter.setRunning(5f);
        beBetter.setKeep(0);

        beBetter.setBreakfast(0);
        beBetter.setLunch(0);
        beBetter.setOtherfood(0);
        //正常总结得分（完美执行）
//        beBetter.setCola(1);
//        beBetter.setFattyfood(1);
//        beBetter.setSnacks(1);
//        beBetter.setBadword(1);
//        beBetter.setComplain(1);
//        beBetter.setStayuplate(1);
//
//        beBetter.setReadbook(1);
//        beBetter.setLearnskills(1);
//        beBetter.setDevelopskills(1);
//
//        beBetter.setRunning(5.5f);
//        beBetter.setKeep(1);
//
//        beBetter.setBreakfast(1);
//        beBetter.setLunch(1);
//        beBetter.setOtherfood(1);


        //没有完成总结的得分
//        beBetter.setCola(0);
//        beBetter.setFattyfood(0);
//        beBetter.setSnacks(0);
//        beBetter.setBadword(0);
//        beBetter.setComplain(0);
//        beBetter.setStayuplate(0);
//
//        beBetter.setReadbook(0);
//        beBetter.setLearnskills(0);
//        beBetter.setDevelopskills(0);
//
//        beBetter.setRunning(0f);
//        beBetter.setKeep(0);
//
//        beBetter.setBreakfast(0);
//        beBetter.setLunch(0);
//        beBetter.setOtherfood(0);


        GetBeBetterScore gs=new GetBeBetterScore();
        int score=gs.getDayScore(beBetter);

        System.out.println(score);
    }

}
