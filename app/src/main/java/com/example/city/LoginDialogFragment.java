package com.example.city;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class LoginDialogFragment extends DialogFragment implements CityPicker.OnSelectingListener {
	private CityPicker cityPicker;

	@Override
	public void selected(boolean selected) {

	}

	public interface LoginInputListener {
		void onLoginInputComplete(String username);
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.fragment_login_dialog, null);
		cityPicker = (CityPicker) view.findViewById(R.id.citypicker);
		builder.setView(view).setPositiveButton("确定",
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog, int id)
							{
								LoginInputListener listener = (LoginInputListener) getActivity();
								listener.onLoginInputComplete(cityPicker.getCity_code_string());
							}
						}).setNegativeButton("取消", null);
		return builder.create();
	}
}
