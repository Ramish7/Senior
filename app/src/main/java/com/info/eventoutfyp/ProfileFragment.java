package com.info.eventoutfyp;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Intent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Text;


public class ProfileFragment extends Fragment  {

    private LinearLayout addressLay;
    private static final int PLACE_PICKER_REQUEST = 1;
    DatabaseReference databaseReference, datref;
    private String venueID, venueMail;
    private LatLng lat;
    private TextView addressView;
    private String placeName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_profile,container,false);
        addressLay = (LinearLayout) view.findViewById(R.id.setAddressLayout);
        addressView = (TextView) view.findViewById(R.id.addressDescription);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        venueID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        datref = FirebaseDatabase.getInstance().getReference("Users").child(venueID);
        venueMail = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        addressLay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                    // building a place picker for owner to set venue address

                    int PLACE_PICKER_REQUEST = 1;
                    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                    startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);

                }catch(Exception e)
                {

                }
            }

        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == getActivity().RESULT_OK) {
                Place place = PlacePicker.getPlace(getContext(), data);
                lat = place.getLatLng();
                databaseReference.child(venueID).child("lat").setValue(lat.latitude);
                databaseReference.child(venueID).child("lon").setValue(lat.longitude);
                databaseReference.child(venueID).child("placeName").setValue(place.getName());
                placeName = (String) place.getName();
                addressView.setText(placeName);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        datref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                addressView.setText((String)dataSnapshot.child("placeName").getValue());

                if(getActivity()!= null) {
                    //sal
                }
            }

            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
