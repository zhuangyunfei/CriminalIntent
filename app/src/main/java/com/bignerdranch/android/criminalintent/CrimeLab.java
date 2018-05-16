package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 项目名称
 * 创建人
 * 创建时间
 * 说明 构造单例类
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    //创建一个空的List来保存Crime的对象
    private List<Crime> mCrimes ;
    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        //存入100个Crime对象
        /*for (int i = 0;i<100;i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }*/
    }
    public List<Crime> getCrimes(){
        return mCrimes;
    }
    public Crime getCrime(UUID id){
        //查找具体的陋习
        for (Crime crime:mCrimes){
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
    public void addCrime(Crime crime){
        mCrimes.add(crime);
    }
}
