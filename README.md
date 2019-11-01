# Android Dialog

## 基本工作

### Android Logger

Install

```
implementation 'com.orhanobut:logger:2.2.0'
```

Initialize

```
Logger.addLogAdapter(new AndroidLogAdapter());
```

And, Use
```
Logger.d("hello");
```

### Butterknife

Install

```
implementation 'com.jakewharton:butterknife:10.2.0'
annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.0'
```

Initialize

```
ButterKnife.bind(this);
```

### layout

dialog_verify.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:minWidth="480dp"
    android:minHeight="300dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="center"
    android:padding="40dp"
    android:orientation="horizontal">

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="hello world" />
</LinearLayout>
```

### dialog

```java
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
```

### client

MainActivity.java

```java
@OnClick(R.id.button)
public void onButtonClick() {
  VerifyDialog verifyDialog = new VerifyDialog((dialog, which)->{
    Logger.d("callback");
  });
  verifyDialog.show(getSupportFragmentManager(), "verify");
}
```
