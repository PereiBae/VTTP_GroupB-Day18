package vttp.groupb.ssf.Day18.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import vttp.groupb.ssf.Day18.models.CarPark;

@Repository
public class CarParkRepository {

    @Autowired
    @Qualifier("redis-Object")
    private RedisTemplate<String, Object> redisTemplate;

    public void save(CarPark carPark) {
        System.out.println("Saving " + carPark);
        redisTemplate.opsForValue().set(String.valueOf(carPark.getId()),carPark);
    }

}
