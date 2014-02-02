package br.com.thejcs.stahp.server.entity;

import br.com.thejcs.stahp.server.persistence.model.Match;
import br.com.thejcs.stahp.server.persistence.model.MatchPlayer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class MatchEntity {

    private String id;

    private String status;

    private PlayerEntity creator;

    private List<PlayerEntity> playerEntities;

    public MatchEntity() {
        playerEntities = new ArrayList<PlayerEntity>();
    }

    public MatchEntity(Match match) {
        this.id = match.getId();
        this.status = match.getStatus().name();
        this.creator = new PlayerEntity(match.getCreator());

        playerEntities = new ArrayList<PlayerEntity>();
        for(MatchPlayer matchPlayer: match.getPlayers()) {
            playerEntities.add(new PlayerEntity(matchPlayer.getPlayer()));
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PlayerEntity> getPlayerEntities() {
        return playerEntities;
    }

    public void setPlayerEntities(List<PlayerEntity> playerEntities) {
        this.playerEntities = playerEntities;
    }
}