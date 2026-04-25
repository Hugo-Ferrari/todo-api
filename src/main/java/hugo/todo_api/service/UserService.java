package hugo.todo_api.service;

import hugo.todo_api.model.User;
import hugo.todo_api.repository.UserRepository;

import hugo.todo_api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // letra minúscula = objeto

    public User register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username já cadastrado");
        }
        return userRepository.save(user);
    }

    @Autowired
    private JwtUtil jwtUtil;
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }
        return jwtUtil.gerarToken(username);
    }
}