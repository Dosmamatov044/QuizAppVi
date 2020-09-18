package com.example.quizappvi.ui.fragments;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.TargetApi;
import android.app.ApplicationErrorReport;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.quizappvi.BuildConfig;
import com.example.quizappvi.R;
import com.example.quizappvi.ui.SettingsViewModel;

import java.io.PrintWriter;
import java.io.StringWriter;

import hotchemi.android.rate.AppRate;


public class SettingsFragment extends Fragment {
   Button rateUs;
   Button leaveFeedback;
    Button share;
    private SettingsViewModel mViewModel;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);

    }








    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        share = view.findViewById(R.id.share);
      leaveFeedback=view.findViewById(R.id.leaveFeedback);
  rateUs=view.findViewById(R.id.rateUs);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);


            }


        });


        rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppRate();
            }
        });


leaveFeedback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendFeedback();
    }
});

    }


    public  void AppRate(){

        AppRate.with(getContext()).setInstallDays(0).setLaunchTimes(0).setRemindInterval(0).monitor();

        AppRate.showRateDialogIfMeetsConditions(getActivity());



    }




    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void sendFeedback() {
        try {
            int i = 3 / 0;
        } catch (Exception e) {
            ApplicationErrorReport report = new ApplicationErrorReport();
            report.packageName = report.processName = getContext().getPackageName();
            report.time = System.currentTimeMillis();
            report.type = ApplicationErrorReport.TYPE_NONE;
            report.systemApp = false;

            ApplicationErrorReport.CrashInfo crash = new ApplicationErrorReport.CrashInfo();
            crash.exceptionClassName = e.getClass().getSimpleName();
            crash.exceptionMessage = e.getMessage();

            StringWriter writer = new StringWriter();
            PrintWriter printer = new PrintWriter(writer);
            e.printStackTrace(printer);

            crash.stackTrace = writer.toString();

            StackTraceElement stack = e.getStackTrace()[0];
            crash.throwClassName = stack.getClassName();
            crash.throwFileName = stack.getFileName();
            crash.throwLineNumber = stack.getLineNumber();
            crash.throwMethodName = stack.getMethodName();

            report.crashInfo = crash;

            try
            {
                if (applicationExist("com.google.android.feedback"))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setClassName("com.google.android.feedback", "com.google.android.feedback.FeedbackActivity");
                    intent.putExtra(Intent.EXTRA_BUG_REPORT, report);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "burrowsapps@gmail.com" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, getContext().getApplicationInfo().loadLabel(getContext().getPackageManager()).toString()+"("+getContext().getPackageManager().getPackageInfo(getContext().getApplicationInfo().packageName, 0).versionName+")"+" Contact Form | Device: "+Build.MANUFACTURER+" "+Build.DEVICE+"("+Build.MODEL+") API: "+Build.VERSION.SDK_INT);
                    intent.setType("plain/html");
                    startActivity(intent);
                }
            } catch (Exception e2) { }
        }
    }

    private boolean applicationExist(String uri)
    {
        PackageManager pm = getContext().getPackageManager();
        boolean exists = false;
        try
        {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            exists = true;
        }
        catch (Exception e) { }

        return exists;
    }
}



