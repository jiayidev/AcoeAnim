package dev.brian.acoeanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgWrite;
    private TextView txtDaily, txtDailyShow, txtWeekly, txtWeeklyShow, txtMonthly, txtMonthlyShow, txtDown, txtDownShow;
    private boolean isFold = true; // 卫星按钮展开状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI(); // 初始化界面
        initAnimation(); // 初始化动画
    }

    /**
     * 初始化界面
     */
    private void initUI() {
        imgWrite = (ImageView) this.findViewById(R.id.daily_write_imageview);
        txtDaily = (TextView) this.findViewById(R.id.daily_dialy_textview);
        txtDailyShow = (TextView) this.findViewById(R.id.daily_dialy_show_textview);
        txtWeekly = (TextView) this.findViewById(R.id.daily_weekly_textview);
        txtWeeklyShow = (TextView) this.findViewById(R.id.daily_weekly_show_textview);
        txtMonthly = (TextView) this.findViewById(R.id.daily_monthly_textview);
        txtMonthlyShow = (TextView) this.findViewById(R.id.daily_monthly_show_textview);
        txtDown = (TextView) findViewById(R.id.daily_down_textview);
        txtDownShow = (TextView) findViewById(R.id.daily_down_show_textview);

        // 绑定事件
        this.imgWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFold) {
                    txtDaily.startAnimation(dailyUnfoldAnimation);
                    txtWeekly.startAnimation(weeklyUnfoldAnimation);
                    txtMonthly.startAnimation(monthlyUnfoldAnimation);
                    txtDown.startAnimation(downlyUnfoldAnimation);
                } else {
                    txtDaily.startAnimation(dailyFoldAnimation);
                    txtWeekly.startAnimation(weeklyFoldAnimation);
                    txtMonthly.startAnimation(monthlyFoldAnimation);
                    txtDown.startAnimation(downlyFoldAnimation);
                }
                isFold = !isFold;
                if (isFold) {
                    imgWrite.setBackgroundResource(R.drawable.write_daily_fold_icon);
                } else {
                    imgWrite.setBackgroundResource(R.drawable.write_daily_unfold_icon);
                }
            }
        });
    }

    private Animation dailyUnfoldAnimation, dailyFoldAnimation, weeklyUnfoldAnimation,
            weeklyFoldAnimation, monthlyUnfoldAnimation, monthlyFoldAnimation,
            downlyUnfoldAnimation, downlyFoldAnimation;

    /**
     * 初始化动画
     */
    private void initAnimation() {
        // 展开日报，展开结束时，在停留点显示控件
        dailyUnfoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                -1.05f);
        dailyUnfoldAnimation.setDuration(500);
        dailyUnfoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                txtDailyShow.setVisibility(View.VISIBLE);
            }
        });
        // 收起日报，开始动画时，隐藏起始点控件
        dailyFoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                -1.05f,
                Animation.RELATIVE_TO_SELF,
                0f);
        dailyFoldAnimation.setDuration(500);
        dailyFoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtDailyShow.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });
        // 展开周报
        weeklyUnfoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                -1.05f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f);
        weeklyUnfoldAnimation.setDuration(500);
        weeklyUnfoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                txtWeeklyShow.setVisibility(View.VISIBLE);
            }
        });
        // 收起周报
        weeklyFoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                -1.05f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f);
        weeklyFoldAnimation.setDuration(500);
        weeklyFoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtWeeklyShow.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });

        // 展开月报
        monthlyUnfoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                1.05f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f);
        monthlyUnfoldAnimation.setDuration(500);
        monthlyUnfoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                txtMonthlyShow.setVisibility(View.VISIBLE);
            }
        });
        // 收起月报
        monthlyFoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                1.05f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f);
        monthlyFoldAnimation.setDuration(500);
        monthlyFoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtMonthlyShow.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });


        // 展开下
        downlyUnfoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                1.05f);
        downlyUnfoldAnimation.setDuration(500);
        downlyUnfoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                txtDownShow.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // 收缩下
        downlyFoldAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                1.05f,
                Animation.RELATIVE_TO_SELF,
                0f);
        downlyFoldAnimation.setDuration(500);
        downlyFoldAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                txtDownShow.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
