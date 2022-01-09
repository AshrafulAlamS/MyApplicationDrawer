package com.fooddrop.myapplicationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class CheckLocationActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    private FusedLocationProviderClient mFusedLocationClient;

    protected Location mLastLocation;

    private String mLatitudeLabel;
    private String mLongitudeLabel;
    private TextView mLatitudeText;
    private TextView mLongitudeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_location);

        mLatitudeLabel = getResources().getString(R.string.latitude_label);
        mLongitudeLabel = getResources().getString(R.string.longitude_label);
        mLatitudeText = findViewById(R.id.tv_latitude);
        mLongitudeText = findViewById(R.id.tv_longitude);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!checkPermission()){
            requestPermissions();
        }else {
            getLastLocation();
        }
    }

    @SuppressWarnings("MissingPermission")
    private void getLastLocation(){
        mFusedLocationClient.getLastLocation()
                .addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if(task.isSuccessful() && task.getResult() != null){
                            mLastLocation = task.getResult();

                            mLatitudeText.setText(String.format(Locale.ENGLISH, "%s: %f",
                                    mLatitudeLabel,
                                    mLastLocation.getLatitude()));
                            mLongitudeText.setText(String.format(Locale.ENGLISH, "%s: %f",
                                    mLongitudeLabel,
                                    mLastLocation.getLongitude()));
                        }else {
                            Log.w(TAG, "onComplete: getLastLocation:exception", task.getException());
                            showSnackbar(getString(R.string.no_location_detected));
                        }
                    }
                });
    }

    private void showSnackbar(final String text){
        View container = findViewById(R.id.main_activity_container);
        if (container != null){
            Snackbar.make(container, text, Snackbar.LENGTH_LONG).show();
        }
    }

    private void showSnackbar(final int mainTextStringId, final int actionStringId,
                              View.OnClickListener listener){
        Snackbar.make(findViewById(android.R.id.content),getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show();
    }

    /**
     * Return the current state of the permissions needed.
     */
    private boolean checkPermission(){
        int permissionState = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    private void startLocationPermissionRequest(){
        ActivityCompat.requestPermissions(CheckLocationActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSIONS_REQUEST_CODE);
    }

    private void requestPermissions(){
        boolean shouldProvideRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if(shouldProvideRationale){
            Log.i(TAG, "requestPermission: Display permission rationale to provide additional context.");

            showSnackbar(R.string.permission_rationale, android.R.string.ok, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Request permission
                    startLocationPermissionRequest();
                }
            });
        } else {
            Log.i(TAG, "requestPermission: ");
            startLocationPermissionRequest();
        }
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResults){
        Log.i(TAG, "onRequestPermissionsResult: ");
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE){
            if (grantResults.length <= 0){
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                Log.i(TAG, "User interaction was cancelled.");
            }else if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // Permission granted.
                getLastLocation();
            } else {
                // Permission denied.

                // Notify the user via a SnackBar that they have rejected a core permission for the
                // app, which makes the Activity useless. In a real app, core permissions would
                // typically be best requested during a welcome-screen flow.

                // Additionally, it is important to remember that a permission might have been
                // rejected without asking the user for permission (device policy or "Never ask
                // again" prompts). Therefore, a user interface affordance is typically implemented
                // when permissions are denied. Otherwise, your app could appear unresponsive to
                // touches or interactions which have required permissions.

                showSnackbar(R.string.permission_denied_explanation, R.string.settings, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Build intent that displays the App settings screen.
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null);
                        intent.setData(uri);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}