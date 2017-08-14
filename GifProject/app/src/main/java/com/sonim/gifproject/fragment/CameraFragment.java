package com.sonim.gifproject.fragment;


import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.sonim.gifproject.activity.DashboardActivity;
import com.sonim.gifproject.util.CameraPreview;
import com.sonim.gifproject.R;

public class CameraFragment extends Fragment {
    Camera mCamera;
    boolean mPreviewRunning;
    SurfaceView mSurfaceView;
    SurfaceHolder mSurfaceHolder;
    CameraPreview mPreview;
    Context mContext;
    ImageView switchCameraIv;


    private final String TAG = "CameraFragment";

    public CameraFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        switchCameraIv = view.findViewById(R.id.switchCameraIv);
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(mContext, mCamera);
        FrameLayout preview = view.findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        switchCameraIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreview.cameraChange((DashboardActivity)mContext);
            }
        });
        return view;
    }
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

}
