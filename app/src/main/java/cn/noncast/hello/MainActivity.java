package cn.noncast.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
  }

  @OnClick(R.id.button)
  public void onButtonClick() {
    VerifyDialog verifyDialog = new VerifyDialog((dialog, which) -> {
      Logger.d("callback");
    });
    verifyDialog.show(getSupportFragmentManager(), "verify");
  }
}
