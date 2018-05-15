package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * 项目名称
 * 创建人
 * 创建时间
 * 说明
 */
public class CrimeFragment extends Fragment {
    private Crime mCrime;
    //首先处EditText
    private EditText mTitleFiled;
    //处理Button组件
    private Button mDateButton;
    //第三步处理CheckBox组件
    private CheckBox mSolvedCheckBox;
    private static final String ARG_CRIME_ID = "crime_id";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime,container,false);
        //获取EditText
        mTitleFiled = view.findViewById(R.id.crime_title);
        mTitleFiled.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //获取Button
        mDateButton = view.findViewById(R.id.crime_data);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);//设置按钮不可点击，禁用按钮
        //获取CheckBox
        mSolvedCheckBox = view.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return view;
    }
    public static CrimeFragment newInstance(UUID crimeId){
        Bundle arg = new Bundle();
        arg.putSerializable(ARG_CRIME_ID,crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(arg);
        return fragment;

    }
}
