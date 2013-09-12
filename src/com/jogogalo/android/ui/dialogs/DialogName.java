package com.jogogalo.android.ui.dialogs;

import com.android.jogogalo.*;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DialogName extends DialogFragment implements OnClickListener {

	private EditText textName;

	private static DialogName dialog = new DialogName();

	public static DialogName getInstance() {
		return dialog;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder builder_dialog = new AlertDialog.Builder(
				getActivity());

		LayoutInflater inflater = getActivity().getLayoutInflater();

		View view = inflater.inflate(R.layout.dialog_name, null);

		textName = (EditText) view.findViewById(R.id.name);

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
			EditNameDialog activity = (EditNameDialog) getActivity();
			activity.onFinishDialog(textName.getText().toString());
			break;

		case DialogInterface.BUTTON_NEUTRAL:
			this.dismiss();
			break;

		default:
			break;
		}

	}

}
