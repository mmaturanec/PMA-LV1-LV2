package com.maturanec.pmalv1;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;


public class StudentFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private EditText editTextIme;
    private EditText editTextPrezime;
    private EditText editTextDatumRodenja;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        CreateNewRecordActivity activity = (CreateNewRecordActivity) getActivity();
        String PictureUri = activity.getMyData();

        if(TextUtils.isEmpty(PictureUri))
        {
            Log.d("test", "Picture URI JE PRAZAN PRI KREACIJI ");
        }
        else
        {
            Log.d("test", "Picture URI JE PROSLIJEDEN: " + PictureUri);

            //ImageView imgView = view.findViewById(R.id.imgView);
            //imgView.setImageURI(Uri.parse(PictureUri));
            /*
            File imgFile = new  File(PictureUri);
            Log.d("test", "FileeeN: " + imgFile);

                Log.d("test", "USLO JE U FILE: " + PictureUri);

                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                ImageView imgView = (ImageView) view.findViewById(R.id.imgView);
                imgView.setImageBitmap(myBitmap);
            sharedViewModel.postaviPitcure(PictureUri);
             */
            String[] projection = new String[]{
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA,
                    MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                    MediaStore.Images.ImageColumns.DATE_TAKEN,
                    MediaStore.Images.ImageColumns.MIME_TYPE
            };
            final Cursor cursor = getContext().getContentResolver()
                    .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null,
                            null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");

// Put it in the image view
            if (cursor.moveToFirst()) {
                final ImageView imageView = (ImageView) view.findViewById(R.id.imgView);
                String imageLocation = cursor.getString(1);
                File imageFile = new File(imageLocation);
                if (imageFile.exists()) {
                    Log.d("tvRowImg", "lOKACIJA SLIKE " + imageLocation);
                    sharedViewModel.postaviPitcure(imageLocation);
                    Bitmap bm = BitmapFactory.decodeFile(imageLocation);
                    imageView.setImageBitmap(bm);
                }
            }

        }

        TextInputEditText txtDatum = view.findViewById(R.id.textDatum);
        ImageView imgView = view.findViewById(R.id.imgView);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intKamera = new Intent(getActivity(), KameraActivity.class);
                startActivity(intKamera);

            }
        });


        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Odaberite datum").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build();
        txtDatum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show(getParentFragmentManager(), "Material_Date_Picker");
                datePicker.addOnPositiveButtonClickListener(selection -> txtDatum.setText(datePicker.getHeaderText()));
            }
        });
        /////////////////////////////
        editTextIme = view.findViewById(R.id.textIme);


        editTextIme.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviPodatak(editable.toString());
            }
        });
        /////////////////////////////
        editTextPrezime = view.findViewById(R.id.textPrezime);
        editTextPrezime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviPrezime(editable.toString());
            }
        });
        editTextDatumRodenja = view.findViewById(R.id.textDatum);
        editTextDatumRodenja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviDatumRodenja(editable.toString());
            }
        });
        return view;
    }
}