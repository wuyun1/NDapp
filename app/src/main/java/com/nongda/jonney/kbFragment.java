package com.nongda.jonney;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nongda.jonney.server.CourseMgr;
import com.nongda.jonney.global.GlobalApp;
import com.nongda.jonney.server.UserService;
import com.nongda.jonney.util.NDWBS;
import com.nongda.jonney.vo.User;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link kbFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kbFragment extends Fragment {
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
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 2:
                    txt1.setText(msg.obj.toString());
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




    }

    @Override
    public void onStart() {

        super.onStart();
//        Log.v("Tag","kbFragment onStart");
        showkb();
    }

    private void initView() {
        txt1 =  (TextView) mContent.findViewById(R.id.txt_message);


    }

    void showtipmes(String tip){
        Log.v("Tag","s"+tip);
        Message aa = Message.obtain();
        aa.what = 2;
        aa.obj = tip;
        Log.v("Tag","s"+aa.obj);
        handler.sendMessage(aa);
    }

    private void showkb() {

        if(UserService.isLogined()){
            new Thread(){
                @Override
                public void run() {
//                    User user = GlobalApp.getInstance().getUser();
//                    CourseMgr courseMgr = NDWBS.getCoursefromStudent(user.getId(),"2016上","11");
                    showtipmes(NDWBS.getCTerm().toString());
//                    txt1.setText(courseMgr.result);
                }
            }.start();

        }else{

            Message message = new Message();
            message.what = 2;
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

}
