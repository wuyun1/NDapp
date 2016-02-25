package com.nongda.jonney;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String url = "http://www.jycoder.com/json/Image/1.jpg";
    private long available_time = 0;
    private static final int GOTO_MAIN_ACTIVITY = 0;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    //将获得的数据通过Intent传送给MainActivity
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    //注意，intent传递图片时，图片对象大小不应该超过40K
                    startActivity(intent);
                    //启动MainActivity后销毁自身
                    finish();
                    break;

                default:
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        available_time = System.currentTimeMillis();
        new FetchDataTask().execute(url);

    }


    public class FetchDataTask extends AsyncTask<String, Void, Bitmap> {

        //执行前调用
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //执行后台任务
        @Override
        protected Bitmap doInBackground(String... strings) {
//            Bitmap bitmap=null;
//            try {
            //通过传入的图片地址，获取图片
//                HttpURLConnection connection= (HttpURLConnection) (new URL(strings[0])).openConnection();
//                InputStream is=connection.getInputStream();
//                bitmap= BitmapFactory.decodeStream(is);

//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Object aa = CacheMgr.getDrawableFromURL(url, -1, null, false);
//            System.out.println(aa);
            return null;
        }

        //任务完成时调用
        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);

            handler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000);


        }
    }
}
