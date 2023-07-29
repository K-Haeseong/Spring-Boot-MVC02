package hello.upload.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {

    private final Map<Long, Item> store= new HashMap<>();
    private Long sequence = 0L;

    // 상세페이지 보여주기 위함
    public Item findById(Long id) {
        return store.get(id);
    }

    public Item save(Item item) {
        item.setItemId(++sequence);
        return store.put(item.getItemId(), item);
    }
}
