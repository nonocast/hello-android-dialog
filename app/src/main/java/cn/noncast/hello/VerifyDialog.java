package cn.noncast.hello;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import butterknife.ButterKnife;

public class VerifyDialog extends DialogFragment implements DialogInterface {
  private DialogInterface.OnClickListener listener;

  public VerifyDialog(DialogInterface.OnClickListener listener) {
    this.listener = listener;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    final Dialog dialog = new Dialog(getActivity());
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    View view = View.inflate(this.getContext(), R.layout.dialog_verify, null);
    dialog.setContentView(view);

    ButterKnife.bind(this, view);
    return dialog;
  }

  @Override
  public void cancel() {
  }
}
