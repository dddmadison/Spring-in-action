package tacos.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import tacos.User;
// 변경됨

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
