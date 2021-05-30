package com.soccer.mongo.repositories;

import com.soccer.mongo.models.Player;
import com.soccer.mongo.models.PlayerPosition;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
  List<Player> findByPositionAndIsAvailable(PlayerPosition playerPosition, boolean isAvailable);

  List<Player> findDistinctNameByPositionIn(List<PlayerPosition> playerPositions);

  List<Player> findByBirthDateIsBetween(Date fromDate, Date toDate);

  Player findFirstByOrderByBirthDateDesc();
}
