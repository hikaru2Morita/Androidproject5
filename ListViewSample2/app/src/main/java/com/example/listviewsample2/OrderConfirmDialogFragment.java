package com.example.listviewsample2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_btn_nu, new DialogButtonClickListener());

        AlertDialog dialog = builder.create();
        return dialog;
    }
    public class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which) {
            String msg= "";
            switch(which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg =getString(R.string.dialog_toast_ok);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg= getString(R.string.dialog_toast_ng);
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    msg=getString(R.string.dialog_toast_nu);
                    break;
            }
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }

    }




}