package tacos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "taco") // MongoDB 컬렉션 이름 (선택)
public class Taco {

    @Id
    private String id;  // ObjectId는 String 타입으로 매핑

    private String name;

    private Date createdAt = new Date();

    private List<String> ingredients; // 자동으로 Array 형태로 저장됨
}
