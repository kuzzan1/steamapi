package main.riot.domain.team;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-18.
 */
public class TeamMemberInfoDto
{
    @JsonProperty
    private long inviteDate;
        @JsonProperty
        private long joinDate;
        @JsonProperty
        private long playerId;
        @JsonProperty
        private String status;

        public long getInviteDate() {
            return inviteDate;
        }

        public void setInviteDate(long inviteDate) {
            this.inviteDate = inviteDate;
        }

        public long getJoinDate() {
            return joinDate;
        }

        public void setJoinDate(long joinDate) {
            this.joinDate = joinDate;
        }

        public long getPlayerId() {
            return playerId;
        }

        public void setPlayerId(long playerId) {
            this.playerId = playerId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}
