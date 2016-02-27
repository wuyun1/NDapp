package com.nongda.jonney;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.nongda.jonney.server.CourseMgr;
import com.nongda.jonney.global.GlobalApp;
import com.nongda.jonney.server.UserService;
import com.nongda.jonney.util.NDWBS;
import com.nongda.jonney.vo.TermInfo;
import com.nongda.jonney.vo.TermList;
import com.nongda.jonney.vo.User;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link kbFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kbFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private View mContent;
    private  TextView txt1;
    private Spinner termSpinner;
    private Spinner weekSpinner;
    private String curtime = "";
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 5:
                    Toast.makeText(kbFragment.this.getActivity(),msg.obj+"",Toast.LENGTH_LONG).show();

                    break;
                case 2:
                    txt1.setText(msg.obj.toString()+"("+termSpinner.getSelectedItem()+" "+weekSpinner.getSelectedItem()+"周)");
                    break;
                case 3:
                    termSpinner.setAdapter((SpinnerAdapter) msg.obj);
                    termSpinner.setSelection(msg.arg1);
                    weekSpinner.setSelection(msg.arg2);
                    curtime = msg.getData().getString("Result");
                    txt1.setText(curtime+"\n正在加载课表");
                    break;
                case 4:
                    txt1.setText(curtime+"\n"+msg.obj);
                    break;
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 2:
                showkb();
                break;
        }
    }

    public kbFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment kbFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static kbFragment newInstance(String param1, String param2) {
        kbFragment fragment = new kbFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mContent!=null) return  mContent;
        // Inflate the layout for this fragment

        mContent = inflater.inflate(R.layout.fragment_kb, container, false);
        initView();
        initDatas();

        return mContent;
    }

    private void initDatas() {
        new Thread(){
            @Override
            public void run() {
                TermList termList = NDWBS.getCTerm();
                String[] terms = new String[termList.list.size()];
                for(int i = 0;i<terms.length;i++){
                    terms[i] = termList.list.get(i).toString();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>( mContent.getContext(),android.R.layout.simple_spinner_item, terms);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Message message = Message.obtain();
                message.what =3;
                message.arg1=termList.curTermindex;
                Bundle data = new Bundle();

                Date beginDate = null;long diffWeeks;
                try {
                    beginDate = new SimpleDateFormat("yyyyMMdd").parse(termList.list.get(termList.curTermindex).getBeginDate());
                    diffWeeks = (new Date().getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24*7);
                } catch (Exception e) {
                    diffWeeks = 0;
                    e.printStackTrace();
                }

                int cweek = 0;
                if(diffWeeks<0&&diffWeeks>=weekSpinner.getCount()) cweek = 0;
                else cweek = (int)diffWeeks;
                message.arg2 = cweek;
                data.putString("Result",terms[termList.curTermindex]+"学期"+weekSpinner.getItemAtPosition(cweek));
                message.setData(data);
                message.obj=adapter;
                handler.sendMessage(message);
            }
        }.start();



    }

    @Override
    public void onStart() {

        super.onStart();
//        Log.v("Tag","kbFragment onStart");
        showkb();
    }

    private void initView() {
        txt1 =  (TextView) mContent.findViewById(R.id.txt_message);
        termSpinner =(Spinner) mContent.findViewById(R.id.term_spinner);
        weekSpinner =(Spinner) mContent.findViewById(R.id.week_spinner);
        termSpinner.setOnItemSelectedListener(this);
        weekSpinner.setOnItemSelectedListener(this);


    }

    void showtipmes(String tip){
//        Log.v("Tag","s"+tip);
        Message message = Message.obtain();
        message.what = 4;
        message.obj = tip;
//        Log.v("Tag","s"+aa.obj);
        handler.sendMessage(message);
    }
    void settermSpinner(String[] arrays,int defindex){
        Message message = Message.obtain();
        message.what = 3;
        message.arg1 = defindex;
        message.obj = arrays;
//        Log.v("Tag","s"+message.obj);
        handler.sendMessage(message);
    }

    private void showkb() {

        if(termSpinner.getAdapter()!=null&&   UserService.isLogined()){
            showtipmes("课表加载中...");
            new Thread(){
                @Override
                public void run() {
                    User user = GlobalApp.getInstance().getUser();
                    CourseMgr courseMgr = NDWBS.getCoursefromStudent(user.getId(),termSpinner.getSelectedItem().toString(),weekSpinner.getSelectedItemPosition()+1+"");
                    Message message = Message.obtain();
                    message.obj = courseMgr;
                    message.what=5;
                    handler.sendMessage(message);
                    showtipmes(courseMgr.result);
//                    showtipmes("kebao");
                }
            }.start();

        }else{

            Message message = new Message();
            message.what = 4;
            message.obj = "请先登录";
            handler.sendMessage(message);

        }


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        showkb();
        //Toast.makeText(kbFragment.this.getActivity(), "你点击的是:"+parent.getSelectedItem(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
