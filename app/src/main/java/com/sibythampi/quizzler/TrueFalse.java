package com.sibythampi.quizzler;

/**
 * Created by test on 26-12-2017.
 */

public class TrueFalse {
    private int questionid;
    private boolean truefalse;
    public TrueFalse(int a,boolean r)
    {
        questionid=a;
        truefalse=r;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public boolean isTruefalse() {
        return truefalse;
    }

    public void setTruefalse(boolean truefalse) {
        this.truefalse = truefalse;
    }
}
