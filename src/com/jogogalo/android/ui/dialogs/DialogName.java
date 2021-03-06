package com.jogogalo.android.ui.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.android.jogogalo.R;
import com.jogogalo.android.ui.UIStartGame;

public class DialogName implements OnClickListener {

    private Context mContext;
    private EditText mEditText;

    public DialogName(Context mContext) {
        this.mContext = mContext;
    }

    public AlertDialog create() {

        AlertDialog.Builder builder_dialog = new AlertDialog.Builder(mContext);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(R.layout.dialog_name, null);

        mEditText = (EditText) view.findViewById(R.id.name);

        // Create layout to dialog
        builder_dialog.setView(view);
        builder_dialog.setTitle(R.string.title_dialog_name);
        // Remove button back
        builder_dialog.setCancelable(false);
        builder_dialog.setPositiveButton(R.string.ok, this);
        builder_dialog.setNegativeButton(R.string.cancel, this);

        return builder_dialog.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int button_id) {

        switch (button_id) {
            case DialogInterface.BUTTON_POSITIVE:
                ((UIStartGame) mContext).onFinishDialogName(mEditText.getText().toString());
                break;

            case DialogInterface.BUTTON_NEUTRAL:
                dialog.dismiss();
                break;

            default:
                break;
        }

    }

}
