package com.bignerdranch.android.criminalintent;




import java.util.Date;
import java.util.UUID;

/**
 * 项目名称
 * 创建人
 * 创建时间
 * 说明
 */
public class Crime {
    //陋习随机产生的ID
    private UUID mId;
    //陋习的名称
    private String mTitle;
    //陋习的日期
    private Date mDate;
    //陋习是否被解决
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }
    //获取mId
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
