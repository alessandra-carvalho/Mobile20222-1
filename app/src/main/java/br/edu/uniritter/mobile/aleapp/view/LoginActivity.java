package br.edu.uniritter.mobile.aleapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import br.edu.uniritter.mobile.aleapp.R;
import br.edu.uniritter.mobile.aleapp.presenter.LoginPresenter;
import br.edu.uniritter.mobile.aleapp.presenter.LoginPresenterContract;
import br.edu.uniritter.mobile.aleapp.repository.UserRepository;

public class LoginActivity extends AppCompatActivity implements LoginPresenterContract.view {

    private LoginPresenterContract.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "onCreate: antes do getInstance" );
        UserRepository.getInstance(this, null);
        Log.e("TAG", "onCreate: depois do getInstance "+UserRepository.getInstance(this, null).getUsers().size());

        setContentView(R.layout.activity_login);

        //this.presenter = new LoginPresenter(this);
        //trocando a presenter, com o mesmo contrato
        this.presenter = new LoginPresenter(this);

        findViewById(R.id.buttonLogin).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.checkLogin(
                                ((TextView) findViewById(R.id.edLogin)).getText().toString(),
                                ((TextView) findViewById(R.id.edPassword)).getText().toString()
                        );
                    }
                }
        );
    }

    @Override
    public void message(String msg) {
        Snackbar.make(this,findViewById(R.id.edPassword),
                       msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }


}