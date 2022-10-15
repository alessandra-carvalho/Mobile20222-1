package br.edu.uniritter.mobile.aleapp.presenter;

import android.app.Activity;

import br.edu.uniritter.mobile.aleapp.model.User;

public class LoginPresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
    }

    public interface presenter {
        public void checkLogin(String login, String password);
        public void validLogin(User user);

    }
}
