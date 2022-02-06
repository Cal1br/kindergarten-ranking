package me.cal1br.kindergartenranking.administrator.service;

import me.cal1br.kindergartenranking.administrator.model.AdministratorModel;
import me.cal1br.kindergartenranking.administrator.repository.AdministratorRepository;
import me.cal1br.kindergartenranking.util.exception.InvalidInputException;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

public class AdministratorServiceImpl implements AdministratorService {
    private static final String INVALID_USERNAME_OR_PASSWORD = "Username or password is invalid!";
    private final AdministratorRepository repository;

    public AdministratorServiceImpl(final AdministratorRepository repository) {
        this.repository = repository;
    }

    public String login(final String username, final String password) {
        if (username == null || password == null) {
            throw new InvalidInputException(INVALID_USERNAME_OR_PASSWORD);
        }
        final Optional<AdministratorModel> administratorModel = repository.findUserByUsername(username);
        if (administratorModel.isPresent() && BCrypt.checkpw(password, administratorModel.get().getPassword())) {
            return "loginToken";
        }
        return "login failed";
    }
}
