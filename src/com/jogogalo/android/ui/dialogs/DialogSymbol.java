package com.jogogalo.android.ui.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListView;

import com.android.jogogalo.R;
import com.jogogalo.android.ui.UIStartGame;

public class DialogSymbol implements OnClickListener {

    String items[];
    private Context mContext;

    public DialogSymbol(Context mContext) {
        this.mContext = mContext;
    }

    public AlertDialog create() {

        AlertDialog.Builder builder_dialog = new AlertDialog.Builder(mContext);

        items = mContext.getResources().getStringArray(R.array.symbol_array);

        // Create layout to dialog
        builder_dialog.setTitle(R.string.title_dialog_select_symbol);
        builder_dialog.setSingleChoiceItems(items, -1, null);
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
                ListView list = ((AlertDialog) dialog).getListView();
                Object checkedItem = list.getAdapter().getItem(list.getCheckedItemPosition());
                ((UIStartGame) mContext).onFinishDialogSymbol((String) checkedItem);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                dialog.dismiss();
                break;

            default:
                break;
        }

    }

}
