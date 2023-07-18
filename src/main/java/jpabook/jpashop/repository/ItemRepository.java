package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository  {
    private final EntityManager em;

    public void save(Item item){
        if(item.getId()==null){
            em.persist(item); //완전히 새로 생성하는 객체
        }else{
            em.merge(item); //이미 DB에 등록된것을 가져오는 것
        }
    }
    public Item findOne(Long id){
        return em.find(Item.class,id);
    }
    public List<Item> findAll(){
        return em.createQuery("select i from Item i",Item.class).getResultList();
    }
}
