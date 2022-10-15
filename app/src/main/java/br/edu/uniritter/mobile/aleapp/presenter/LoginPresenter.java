package br.edu.uniritter.mobile.aleapp.presenter;

import android.content.Intent;

import br.edu.uniritter.mobile.aleapp.R;
import br.edu.uniritter.mobile.aleapp.model.User;
import br.edu.uniritter.mobile.aleapp.repository.UserRepository;
import br.edu.uniritter.mobile.aleapp.view.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter{
    private LoginPresenterContract.view view;

    public LoginPresenter(LoginPresenterContract.view view) {
        this.view = view;
    }

    @Override
    public void checkLogin(String login, String password) {
        UserRepository repo  = UserRepository.getInstance(view.getActivity(), null);
        User u = repo.getUserByUserLogin(login);
        if (u == null || ! u.getPassword().equals(password)) {
            view.message("Usuário ou senha Inválido");
        } else {
            u.setPassword("trocada");
            validLogin(u);
        }
    }

    @Override
    public void validLogin(User user) {
        Intent intent = new Intent(view.getActivity(), MainActivity.class);
        //intent.putExtra("userId", user.getId());
        intent.putExtra("userObj", user);
        view.getActivity().startActivity(intent);
    }
}
