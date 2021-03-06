package com.iusmob.adklein.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.iusmob.adklein.ad.AdKleinError;
import com.iusmob.adklein.ad.AdKleinRewardVideoAd;
import com.iusmob.adklein.ad.AdKleinRewardVideoAdListener;
import com.iusmob.adklein.demo.DemoConstants;
import com.iusmob.adklein.demo.R;
import com.iusmob.adklein.demo.utils.ToastUtils;

public class RewardVideoAdActivity extends AppCompatActivity implements View.OnClickListener {

    private AdKleinRewardVideoAd rewardVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_video);

        initListener();
        initAd();
    }

    private void initListener() {
        findViewById(R.id.btnLoadAd).setOnClickListener(this);
        findViewById(R.id.btnShowAd).setOnClickListener(this);
    }

    private void initAd() {
        rewardVideo = new AdKleinRewardVideoAd(
                this, DemoConstants.REWARD_VIDEO_ID,
                0, true,
                new AdKleinRewardVideoAdListener() {
                    /**
                     * 广告关闭回调
                     * */
                    @Override
                    public void onAdClose() {
                        ToastUtils.toast(RewardVideoAdActivity.this, "reward onAdClose",
                                Toast.LENGTH_SHORT);
                    }

                    /**
                     * 激励视频播放完毕回调
                     * */
                    @Override
                    public void onVideoComplete() {
                        ToastUtils.toast(RewardVideoAdActivity.this, "reward onVideoComplete",
                                Toast.LENGTH_SHORT);
                    }

                    /**
                     * 激励视频点击跳过回调
                     * */
                    @Override
                    public void onSkippedVideo() {
                        ToastUtils.toast(RewardVideoAdActivity.this, "reward onSkippedVideo",
                                Toast.LENGTH_SHORT);
                    }

                    /**
                     * 激励视频奖励回调
                     * */
                    @Override
                    public void onAdReward() {
                        ToastUtils.toast(RewardVideoAdActivity.this, "reward onAdReward",
                                Toast.LENGTH_SHORT);
                    }

                    /**
                     * 广告加载失败
                     * @param adKleinError 错误描述
                     * */
                    @Override
                    public void onError(AdKleinError adKleinError) {
                        ToastUtils.toast(RewardVideoAdActivity.this,
                                "reward onError " + adKleinError.getErrorCode() + " " + adKleinError.getErrorMsg(),
                                Toast.LENGTH_SHORT);
                    }

                    /**
                     * 广告拉取成功
                     * */
                    @Override
                    public void onAdLoaded() {
                        ToastUtils.toast(RewardVideoAdActivity.this, "reward onAdLoaded",
                                Toast.LENGTH_SHORT);
                    }

                    /**
                     * 广告展示成功
                     * */
                    @Override
                    public void onAdShow() {
                        ToastUtils.toast(RewardVideoAdActivity.this, "reward onAdShow",
                                Toast.LENGTH_SHORT);
                    }

                    /**
                     * 广告点击回调
                     * */
                    @Override
                    public void onAdClicked() {
                        ToastUtils.toast(RewardVideoAdActivity.this, "reward onAdClicked",
                                Toast.LENGTH_SHORT);
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoadAd:
                rewardVideo.load();
                break;
            case R.id.btnShowAd:
                rewardVideo.show();
                break;
            default:
                break;
        }
    }

}
